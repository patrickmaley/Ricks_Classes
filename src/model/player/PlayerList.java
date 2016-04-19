package model.player;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.TreeMap;

public class PlayerList implements Serializable {
	
	private static PlayerList uniqueInstance = null;
	private TreeMap<String, Player> validPlayers;

	private PlayerList() throws NoSuchAlgorithmException, NoSuchProviderException{
		createList();
	}
	
	//If uniqueInstance is null it creates a new PlayerList. Otherwise it returns
	//the PlayerList stored in uniqueInstance
	public static PlayerList setList() throws NoSuchAlgorithmException, NoSuchProviderException{
		if (uniqueInstance == null){
			uniqueInstance = new PlayerList();
		}
		return uniqueInstance;
	}
	
	//Creates a new PlayerList and sets the default Player accounts
	private void createList() throws NoSuchAlgorithmException, NoSuchProviderException{
		validPlayers = new TreeMap<String, Player>();
	}
	
	//Returns the current TreeMap of valid players
	public TreeMap<String, Player> getCurrentList(){
		return validPlayers;
	}
	
	//Puts the new player into the current tree if their username does not
	//already exist
	public void newPlayer(Player p){
		if (!validPlayers.containsKey(p.getUsername())){
			validPlayers.put(p.getUsername(), p);
		}
	}
	
}
