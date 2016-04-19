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
	
<<<<<<< HEAD
	//If uniqueInstance is null it creates a new PlayerList. Otherwise it returns
	//the PlayerList stored in uniqueInstance
	public static PlayerList setList() throws NoSuchAlgorithmException, NoSuchProviderException{
=======
	public static PlayerList setList() {
>>>>>>> bdac22f1b581562e5584a56525ac904a377a0b2a
		if (uniqueInstance == null){
			try {
				uniqueInstance = new PlayerList();
			} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
