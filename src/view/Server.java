package view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

import model.map.Map;
import model.player.Player;
import model.player.PlayerList;



public class Server {
	public static final int SERVER_PORT = 4012;
	private static ServerSocket sock;
	private static List<ObjectOutputStream> clients = Collections.synchronizedList(new ArrayList<ObjectOutputStream>());
	private static Map serverMap = Map.setMap();
	private static PlayerList playerList = PlayerList.setList();
	
	private ArrayList<Player> loggedOnPlayers = new ArrayList<Player>();
	/**
	 * This is the main method which runs everything
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		sock = new ServerSocket(SERVER_PORT);
		System.out.println("Server started on port " + SERVER_PORT);

		while (true) {
			Socket s = sock.accept();

			ObjectInputStream is = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());

			clients.add(os);
			ClientHandler c = new ClientHandler(is, clients);
			c.start();

			System.out.println("Accepted a new connection from " + s.getInetAddress());
		}
	}
	

	public static Map getServerMap() {
		return serverMap;
	}
	public static void setServerMap(Map serverMap) {
		Server.serverMap = serverMap;
	}
	
	public static PlayerList getPlayerList() {
		return playerList;
	}
	public static void setPlayerList(PlayerList players) {
		playerList = players;
	}
	
	public void addPlayer(Player player) {
		this.loggedOnPlayers.add(player);
	}
	public void removePlayer(Player player) {
		if(this.loggedOnPlayers.contains(player))	
			this.loggedOnPlayers.remove(player);
	}
	
	public  ArrayList<Player> getLoggedOnPlayers() {
		return this.loggedOnPlayers;
	}
}


class ClientHandler extends Thread {

	private ObjectInputStream input;
	private List<ObjectOutputStream> clients;
	/**
	 * 
	 * @param input
	 * @param clients
	 */
	public ClientHandler(ObjectInputStream input, List<ObjectOutputStream> clients) {
		this.input = input;
		this.clients = clients;
	}

	@Override
	/**
	 * constantly updates the drawing panel on all of the different clients drawing panels
	 */
	public void run() {
		while (true) {
			Player player = null;
			Map map =  null;
			try {
				player = (Player) input.readObject();
				map = (Map) input.readObject();
				Server.setServerMap(map);
				Player returningPlayer = null;
				
				//Only for new players
				if(player.getGameName() == null && !Server.getPlayerList().getCurrentList().containsKey(player.getUsername())){
					Server.getPlayerList().newPlayer(player);
					returningPlayer = Server.getPlayerList().getCurrentList().get(player.getUsername());
				}else{
					Server.getPlayerList().getCurrentList().replace(player.getUsername(), player);
					returningPlayer = Server.getPlayerList().getCurrentList().get(player.getUsername());
					
				}
				writeObjectToClients(returningPlayer);
				writeObjectToClients(map);
			} catch (IOException e) {
				/* Client left -- clean up and let the thread die */
				this.cleanUp();
				return;
			} catch (ClassNotFoundException e) {
				/* This one is probably a bug though */
				e.printStackTrace();
				this.cleanUp();
				return;
			}
			//System.out.println("Received the object " + player.getUsername()+ " from a client");
		}
	}
	
	private void writeObjectToClients(Object s) {
		synchronized (clients) {
			Set<ObjectOutputStream> closed = new HashSet<>();
			for (ObjectOutputStream client : clients) {
				System.out.println("Writing the Player" + s + " to a client.");
				try {
					client.writeObject(s);
					client.reset();
				} catch (IOException e) {
					/*
					 * If we can't write to the client, their socket was closed.
					 * Lets remove it from the list.
					 */
					closed.add(client);
				}
			}
			/* Remove closed connections from the list */
			clients.removeAll(closed);
		}
	}

	private void cleanUp() {
		/*
		 * Don't forget to close those sockets. Not an issue here, but you WILL
		 * run out eventually if you neglect this.
		 */
		try {
			this.input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
