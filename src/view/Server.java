package view;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.map.Map;
import model.player.Player;
import model.player.PlayerList;


/**
 * 
 * @author Sahil Dalal and Patrick Maley
 *
 *This is the server class that allows clients to connect to it and then now when they draw both clients will see the changes made to the drawing panel
 */
public class Server {

	public static final int SERVER_PORT = 4008;
	private static ServerSocket sock;
	private static List<ObjectOutputStream> clients = Collections.synchronizedList(new ArrayList<ObjectOutputStream>());
	private static Map serverMap;
	private static PlayerList playerList;
	private static final String SAVED_SERVER = "savedServer";
	private static final int SERVER_KEY = 123450;
	//private static final String SAVED_PLAYERLIST_LOCATION = "savedPlayer";
	
	private static ArrayList<Player> loggedOnPlayers = new ArrayList<Player>();
	
	
	/**
	 * This is the main method which runs everything
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		sock = new ServerSocket(SERVER_PORT);
		System.out.println("Server started on port " + SERVER_PORT);
		try {
			// FileInputStream lets us read in data from a file.
			FileInputStream fis = new FileInputStream(SAVED_SERVER);
			
			// ObjectInputStream decorates a FileInputStream and adds functionality to read Objects.
			ObjectInputStream ois = new ObjectInputStream(fis);
			Map test =(Map) ois.readObject();
			Server.serverMap = Map.setMap(test);
			PlayerList players = (PlayerList) ois.readObject();
			Server.playerList = players;
			
			ois.close();
			fis.close();
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		if(Server.serverMap == null){
			Server.serverMap = Map.setMap(null);
		}
		
		if(playerList == null){
			Server.playerList = PlayerList.setList();
			
			
		}
		
		while(true) {
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
	
	public static void addPlayer(Player player) {
		loggedOnPlayers.add(player);
	}
	public static void removePlayer(Player player) {
		if(loggedOnPlayers.contains(player))	
			loggedOnPlayers.remove(player);
	}
	
	public static ArrayList<Player> getLoggedOnPlayers() {
		return loggedOnPlayers;
	}
	
	public static  void saveState(){
		// Save the data by creating a FileOuputStream to the file name above, then decorate it with an ObjectOuputStream
		// then write out the StudentCollection instance to the file.
			try {
				// FileOutputStream lets us write data to a file.
				FileOutputStream fos = new FileOutputStream(SAVED_SERVER);
				// ObjectOutputStream decorates a FileOutputStream and adds functionality to write Objects.
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				// Write out the collection as binary
				// Also note that we are writing out only model classes, never write out view elements!
				Map map = Server.getServerMap();
				oos.writeObject(map);
			    //oos.writeObject(Server.getServerMap());
				PlayerList pl = Server.getPlayerList();
				oos.writeObject(pl);
				oos.close();
				oos.flush();
				fos.close();
				fos.flush();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
	  }
	
	public static boolean shutDownKey(int test){
		if(Server.SERVER_KEY % 10 == test % 10){
			return true;
		}
		return false;
	}
}


class ClientHandler extends Thread {

	private ObjectInputStream input;
	private List<ObjectOutputStream> clients;
	private PlayerList test = PlayerList.setList();
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
			String playerText = "";
			//Map map =  null;
			try {
				String name = (String) input.readObject();
				char[] pass = (char[]) input.readObject();
				Player savePlayer = (Player) input.readObject();
				//System.out.println("Username" + savePlayer.getUsername());
				System.out.println("Servers map " + Server.getServerMap().toString());
				Map saveMap = (Map) input.readObject();
				if(saveMap != null)
					System.out.println("Server gets map " + saveMap.toString());
				String[] commandsd = (String[]) input.readObject();
				//PlayerList testList = Server.getPlayerList();
				if(commandsd != null){
					switch(commandsd[0]){
						case "shutdown":
							if(Server.shutDownKey(Integer.parseInt(commandsd[1]))){
										Server.saveState();
										//closeAllClients();
										System.exit(1);
							}
							break;
						case "say": 
							playerText += savePlayer.getUsername().toString() + ": ";
							for (int i = 1; i < commandsd.length; i++) {
								playerText += commandsd[i] + " ";
							}
							playerText += "\n";
							break;
						case "ooc": 
							playerText += "Global Chat: Player Name:" + savePlayer.getUsername().toString() + ": ";
							for (int i = 1; i < commandsd.length; i++) {
								playerText += commandsd[i] + " ";
							}
							playerText += "\n";
							break;
						case "tell":
							playerText += "Tell: To: " + commandsd[1] + " From: " + savePlayer.getUsername().toString() + ": ";
							for (int i = 2; i < commandsd.length; i++) {
								playerText += commandsd[i] + " ";
							}
							playerText += "\n";
							break;
						case "who":
							playerText += "Players on server: ";
							ArrayList<Player> playersOnServer = Server.getLoggedOnPlayers();
							for (Player logPlayer : playersOnServer) {
								playerText += logPlayer.getUsername() + " ";
							}
							playerText += "\n";
							break;
						case "quit":
							Server.removePlayer(savePlayer);
							break;
						default: break;
					}
					
				}
				if(savePlayer != null){
					Player oldPlayer = Server.getPlayerList().getCurrentList().get(savePlayer.getUsername());
					//System.out.println("Old room" + oldPlayer.getRoom());
					
					oldPlayer = Server.getPlayerList().getCurrentList().put(savePlayer.getUsername(), savePlayer);
					//System.out.println("New room" + oldPlayer.getRoom());
					oldPlayer = Server.getPlayerList().getCurrentList().get(savePlayer.getUsername());
					//System.out.println("New room" + oldPlayer.getRoom());
				}
				if(saveMap != null){
					Server.setServerMap(saveMap);
					Server.getServerMap().setMap(saveMap);
					System.out.println("Servers new map" + saveMap.toString());
					
				}
				//Checks to see if the players name and password are in the hash map.
				if(name != null && pass != null){
					if(Server.getPlayerList().getCurrentList().size() > 0  && Server.getPlayerList().getCurrentList().containsKey(name)){
						Player foundPlayer = Server.getPlayerList().getCurrentList().get(name);
						try {
							if(foundPlayer.checkPassword(pass)){
								Server.addPlayer(foundPlayer);
								writePlayerToClients(foundPlayer);
								writePlayerToClients(Server.getServerMap());
								System.out.println("Password Authentication works");
							}else{
								System.out.println("Password Authentication failed");
								writePlayerToClients(savePlayer);
								writePlayerToClients(Server.getServerMap());
							}
						} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
							e.printStackTrace();
						}
					}else{
						JTextField gameName = new JTextField();
						JTextField houseName = new JTextField();
						JTextArea characterDescription = new JTextArea();
						characterDescription.setPreferredSize(new Dimension(100, 150));
						characterDescription.setLineWrap(true);
						characterDescription.setWrapStyleWord(true);
						final JComponent[] inputs = new JComponent[] {
								new JLabel("Please enter your game name:"),
								gameName,
								new JLabel("Please enter your house name"),
								houseName,
								new JLabel("Please enter your character description"),
								characterDescription
						};
						
						JOptionPane optionPane = new JOptionPane(inputs);
						
						JDialog dialog = optionPane.createDialog("Character Information");
						
						dialog.setAlwaysOnTop(true);
						dialog.setModal(true);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
						try {
							player = new Player(name, pass);
						} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						player.setGameName(gameName.getText());
						player.setHouse(houseName.getText());
						player.setDescription(characterDescription.getText());
						Server.addPlayer(player);
						Server.getPlayerList().getCurrentList().put(player.getUsername(), player);
						writePlayerToClients(player);
						writePlayerToClients(Server.getServerMap());
					}
				}else{
					writePlayerToClients(savePlayer);
					writePlayerToClients(Server.getServerMap());
				}
				writePlayerToClients(playerText);
				Server.saveState();
				savePlayer = null;
				saveMap = null;
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
	
	private void writePlayerToClients(Object s) {
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
	
	private void closeAllClients() {
		synchronized (clients) {
			Set<ObjectOutputStream> closed = new HashSet<>();
			for (ObjectOutputStream client : clients) {
				//System.out.println("Writing the Player" + s + " to a client.");
				closed.add(client);
				
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
			Server.saveState();
			this.input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}