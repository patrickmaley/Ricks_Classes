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
import java.util.Timer;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.items.Inventory;
import model.items.Item;
import model.map.Map;
import model.mobs.Mobs;
import model.player.Player;
import model.player.PlayerList;
import model.room.GenericRoom;


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
	
	private static  ArrayList<Player> loggedOnPlayers = new ArrayList<Player>();
	
	
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
			Server.setServerMap(test);
			PlayerList players = (PlayerList) ois.readObject();
			Server.playerList = players;
			
			ois.close();
			fis.close();
			System.out.println("Using an old savedServer File");
		} catch (Exception exception) {
			System.out.println("Creating a new savedServer File");
			//exception.printStackTrace();
		}
		
		if(Server.serverMap == null){
			Server.serverMap = Map.setMap();
		}
		
		if(playerList == null){
			Server.playerList = PlayerList.setList();
			
			
		}
		

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new moveTask(serverMap), 10000, 60000); 
        
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
		ArrayList<Player> copyPlayersLoggedOn = loggedOnPlayers;
		for (Player player2 : copyPlayersLoggedOn) {
			if(player2.getUsername().compareTo(player.getUsername())== 0){
				copyPlayersLoggedOn.remove(player2);
			}
		}
		Server.setLoggedOnPlayers(copyPlayersLoggedOn);
	}
	
	public static ArrayList<Player> getLoggedOnPlayers() {
		return loggedOnPlayers;
	}
	
	public static void setLoggedOnPlayers(ArrayList<Player> playersLoggedOnCopy) {
		loggedOnPlayers = playersLoggedOnCopy;
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
				Map map = Map.setMap();
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
			try {
				String name = (String) input.readObject();
				char[] pass = (char[]) input.readObject();
				Player savePlayer = (Player) input.readObject();
				String[] commandsd = (String[]) input.readObject();
				Player player = null;
				String playerText = "";
				
				//Updates player in playerlist
				if(savePlayer != null){
					if(commandsd ==null){
						savePlayer = Server.getPlayerList().getCurrentList().get(savePlayer.getUsername());
						playerText+="The deal was accepted";
						}
					else{
						Player oldPlayer = Server.getPlayerList().getCurrentList().get(savePlayer.getUsername());
						oldPlayer = Server.getPlayerList().getCurrentList().put(savePlayer.getUsername(), savePlayer);
						oldPlayer = Server.getPlayerList().getCurrentList().get(savePlayer.getUsername());
						savePlayer.setPlayerMap(Server.getServerMap());
						savePlayer.updateMap(Server.getServerMap());
					}
					//Updates all of players rooms they are not in.
					Map map = Server.getServerMap();
					GenericRoom[][] mapArray = map.getMapArray();
					GenericRoom[][] playerMapArray = savePlayer.getPlayerMap().getMapArray();
					for (int i = 0; i < mapArray.length; i++) {
						for (int j = 0; j < mapArray[i].length; j++) {
							if(savePlayer.getRoom().getRoomDescription().compareTo(mapArray[i][j].getRoomDescription()) == 0){
								savePlayer.setRoom(mapArray[i][j]);
							}else{
								playerMapArray[i][j] = mapArray[i][j];
							}
						}
					}
					savePlayer.getPlayerMap().setMapArray(playerMapArray);
					
				}

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
							playerText += "Room Chat: " + savePlayer.getUsername().toString() + ": ";
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
							playerText += "Playe rs on server: ";
							ArrayList<Player> playersOnServer = Server.getLoggedOnPlayers();
							for (Player logPlayer : playersOnServer) {
								playerText += logPlayer.getUsername() + " ";
							}
							playerText += "\n";
							break;
						case "quit":
							Server.removePlayer(savePlayer);
							break;
						//Not implemented yet
						case "look":
							playerText += "Players on server: ";
							playerText += "\n";
							break;
						
						case "command":
							for (int i = 1; i < commandsd.length; i++) {
								playerText += commandsd[i] + " ";
							}
							playerText = savePlayer.performAction(playerText);
						
							break;
						case "take":
							String itemDesired="";
							for(int i=1;i<commandsd.length-1;i++){
								itemDesired+=commandsd[i] + " ";
							}
							itemDesired = itemDesired.trim();
							String playerUserName = commandsd[commandsd.length-1].trim();
							ArrayList<Player> playersLoggedOn = savePlayer.getRoom().getPlayersInRoom();
							PlayerList playerList = Server.getPlayerList();
							Player toGetFrom = null;
							for(int i =0;i<playersLoggedOn.size();i++){
								if(playersLoggedOn.get(i).getUsername().compareTo(playerUserName)==0){
									toGetFrom = playerList.getPlayer(playerUserName);
									break;
								}
							}
							if(toGetFrom!=null){
								Inventory desiredFrom = toGetFrom.getInventory();
								Item desired = desiredFrom.getItem(itemDesired);
								if(desired!=null){
									playerText+= "Take " + itemDesired+ " " + toGetFrom.getUsername()+ " " + savePlayer.getUsername();
								}
								else{
									playerText+= toGetFrom.getUsername() + " does not have the following item. Therefore you cannot get it from them.";
								}
							}
							else{
								playerText+= playerUserName + " isnt logged in or is not in the room therefore you cannot take an item from them.";
							}
							break;
						case "give":
							String itemDesiredForGive="";
							for(int i=1;i<commandsd.length-1;i++){
								itemDesiredForGive+=commandsd[i] + " ";
							}
							itemDesiredForGive = itemDesiredForGive.trim();
							String playerGivingToUserName = commandsd[commandsd.length-1].trim();
							ArrayList<Player> playersLoggedOnGive = savePlayer.getRoom().getPlayersInRoom();
							PlayerList playerListGive = Server.getPlayerList();
							Player toGiveTo=null;
							for(int i =0;i<playersLoggedOnGive.size();i++){
								if(playersLoggedOnGive.get(i).getUsername().compareTo(playerGivingToUserName)==0){
									toGiveTo = playerListGive.getPlayer(playerGivingToUserName);
									break;
								}
							}
							if(toGiveTo!=null){
								Inventory desiredFrom = savePlayer.getInventory();
								Item desired2 = desiredFrom.getItem(itemDesiredForGive);
								if(desired2!=null){
									playerText+= "Give " + itemDesiredForGive+ " " + savePlayer.getUsername()+ " " +  toGiveTo.getUsername();
								}
								else{
									playerText+= " You do not have the following item. Therefore you cannot get it from them.";
								}
							}
							else{
								playerText+= playerGivingToUserName + " isnt logged on or is not in the room therefore you cannot give an item to them.";
							}
							break;
						case "giving":
							String itemGiving = commandsd[2];
							System.out.println(itemGiving);
							String playerGivingUserName = commandsd[3];
							ArrayList<Player> playersLoggedOn2 = savePlayer.getRoom().getPlayersInRoom();
							PlayerList playerList2 = Server.getPlayerList();
							Player givingUp = playerList2.getPlayer(playerGivingUserName);
							if(commandsd[1].compareTo("Accepted")==0){
								Item givingUpTo = givingUp.getInventory().getItem(itemGiving);
								savePlayer.getInventory().add(givingUpTo);
								givingUp.getInventory().drop(itemGiving);
								givingUp.getRoom().removeItemInRoom(givingUpTo);
								playerText+= "YES TO DEAL " + givingUp.getUsername() + " " + savePlayer.getUsername();
							}
							else{
								playerText+= "NO TO DEAL " + givingUp.getUsername()+ " "+ savePlayer.getUsername();
							}
							break;
						case "trade":
							String itemTrade = commandsd[2];
							System.out.println(itemTrade);
							String playerWantingUserName = commandsd[3];
							ArrayList<Player> playersLoggedOn1 =savePlayer.getRoom().getPlayersInRoom();
							PlayerList playerList1 = Server.getPlayerList();
							Player wanting = playerList1.getPlayer(playerWantingUserName);
							if(commandsd[1].compareTo("Accepted")==0){
								System.out.println(wanting.getUsername());
								System.out.println(savePlayer.getUsername());
								Item giving = savePlayer.getInventory().getItem(itemTrade);
								wanting.getInventory().add(giving);
								savePlayer.getInventory().drop(itemTrade);
								savePlayer.getRoom().removeItemInRoom(giving);
								playerText+= "YES TO DEAL " + wanting.getUsername() + " " + savePlayer.getUsername();
							}
							else{
								playerText+= "NO TO DEAL " + wanting.getUsername()+ " "+ savePlayer.getUsername();
							}
							break;
						default: break;
					}
					
				}
				
				//Update the server map
				if(savePlayer != null){
					Map map = Server.getServerMap();
					GenericRoom[][] mapArray = Server.getServerMap().getMapArray();
					for (int i = 0; i < mapArray.length; i++) {
						for (int j = 0; j < mapArray[i].length; j++) {
							if(savePlayer.getRoom().getRoomDescription().compareTo(mapArray[i][j].getRoomDescription()) == 0){
								mapArray[i][j] = savePlayer.getRoom();
							}
						}
					}
					map.setMapArray(mapArray);
				    Server.setServerMap(savePlayer.getPlayerMap());
				}
				
				//Checks to see if the players name and password are in the hash map.
				if(name.compareTo("") != 0 && pass.length > 0){
					if(Server.getPlayerList().getCurrentList().size() > 0  && Server.getPlayerList().getCurrentList().containsKey(name)){
						Player foundPlayer = Server.getPlayerList().getCurrentList().get(name);
						try {
							if(foundPlayer.checkPassword(pass)){
								Server.addPlayer(foundPlayer);
								writePlayerToClients(foundPlayer);
								System.out.println("Password Authentication works");
							}else{
								System.out.println("Password Authentication failed");
								writePlayerToClients(savePlayer);
							}
						} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
							e.printStackTrace();
						}
					//If not in hashmap, create a new player
					}else{
						
						try {
							player = new Player(name, pass);
						} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						player.setPlayerMap(Server.getServerMap());
					
						player.setCurrentRoom(Server.getServerMap().getMapArray()[9][0]);
						player.getRoom().setPlayerPresent(true, player);
						Server.addPlayer(player);
						Server.getPlayerList().getCurrentList().put(player.getUsername(), player);
						writePlayerToClients(player);
					}
				}else{
					writePlayerToClients(savePlayer);
				}
				writePlayerToClients(playerText);
				Server.saveState();
				savePlayer = null;
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
					client.flush();
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
	
//	private void closeAllClients() {
//		synchronized (clients) {
//			Set<ObjectOutputStream> closed = new HashSet<>();
//			for (ObjectOutputStream client : clients) {
//				//System.out.println("Writing the Player" + s + " to a client.");
//				closed.add(client);
//				
//			}
//			/* Remove closed connections from the list */
//			clients.removeAll(closed);
//		}
//	}
//	
//		 
		 
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