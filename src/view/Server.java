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
import model.player.PlayerList;


/**
 * 
 * @author Sahil Dalal and Patrick Maley
 *
 *This is the server class that allows clients to connect to it and then now when they draw both clients will see the changes made to the drawing panel
 */
public class Server {

	public static final int SERVER_PORT = 4007;

	private static ServerSocket sock;
	private static List<ObjectOutputStream> clients = Collections.synchronizedList(new ArrayList<>());
	//private static Vector<Map> serverObjects = new Vector<NetPaintObjects>();
	private static Map serverMap = Map.setMap();
	private PlayerList playerList = PlayerList.setList();
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

			/* Save the output stream so we can broadcast to them */
			clients.add(os);
			/* Start a thread to listen for input from this client. */
			ClientHandler c = new ClientHandler(is, clients);
			c.start();

			System.out.println("Accepted a new connection from " + s.getInetAddress());
		}
	}
	

	public static Map getServerMap() {
		return serverMap;
	}
	public void setServerMap(Map serverMap) {
		this.serverMap = serverMap;
	}
}

/**
 * 
 * @author Sahil Dalal and Patrick Maley
 * This is the Client class. We put it in the NetPaintGui class for ease of use. The client class allows for clients to connect to the server and draw on the panel
 *
 */
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

			Map s = null;
			try {
				if(input.readObject() == null){
					s = Server.getServerMap();
				}else{
					s =  (Map) input.readObject();
				}
				
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
			System.out.println("Received the String " + s + " from a client");

			this.writeStringToClients(s);
		}
	}
	
	private void writeStringToClients(Map s) {
		synchronized (clients) {
			Set<ObjectOutputStream> closed = new HashSet<>();
			for (ObjectOutputStream client : clients) {
				System.out.println("Writing the NetPaintObject " + s + " to a client.");
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
