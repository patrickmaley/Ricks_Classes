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
	
	public static PlayerList setList() {
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
	
	private void createList() throws NoSuchAlgorithmException, NoSuchProviderException{
		validPlayers = new TreeMap<String, Player>();
		setDefaultPlayers();
	}
	
	public TreeMap<String, Player> getCurrentList(){
		return validPlayers;
	}
	
	public void newPlayer(Player p){
		if (!validPlayers.containsKey(p.getUsername())){
			validPlayers.put(p.getUsername(), p);
		}
	}
	
	private void setDefaultPlayers() throws NoSuchAlgorithmException, NoSuchProviderException{
		validPlayers.put("Johnny", new Player("Johnny", new char[] {'1'}, "ComeAtMeBro", "Gryffindor"));
		validPlayers.put("Timmy", new Player("Timmy", new char[] {'2', '2'}, "TTurner", "Hufflepuff"));
	}
	
}
