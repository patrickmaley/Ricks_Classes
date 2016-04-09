package model.player;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;

public class PlayerList implements Serializable {
	
	private static PlayerList uniqueInstance = null;
	private ArrayList<Player> validPlayers;

	private PlayerList() throws NoSuchAlgorithmException, NoSuchProviderException{
		createList();
	}
	
	public static PlayerList setList() throws NoSuchAlgorithmException, NoSuchProviderException{
		if (uniqueInstance == null){
			uniqueInstance = new PlayerList();
		}
		return uniqueInstance;
	}
	
	private void createList() throws NoSuchAlgorithmException, NoSuchProviderException{
		validPlayers = new ArrayList<Player>();
		setDefaultPlayers();
	}
	
	public ArrayList<Player> getCurrentList(){
		return validPlayers;
	}
	
	public void newPlayer(Player p){
		if (!validPlayers.contains(p)){
			validPlayers.add(p);
		}
	}
	
	private void setDefaultPlayers() throws NoSuchAlgorithmException, NoSuchProviderException{
		validPlayers.add(new Player("Johnny", new char[] {'1'}, "ComeAtMeBro", "Gryffindor"));
		validPlayers.add(new Player("Timmy", new char[] {'2', '2'}, "TTurner", "Hufflepuff"));
	}
	
}
