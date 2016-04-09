package model;

import java.util.ArrayList;

public class Player {

	private String username;
	private char[] password;
	private String gamename;
 	private ArrayList<Spell> knownSpells;
	private Inventory inventory;
	private int HP;
	
	public Player(String username, char[] password, String gamename){
		this.username = username;
		this.password = password;
		this.gamename = gamename;
		this.knownSpells = new ArrayList<Spell>();
		this.inventory = new Inventory();
		this.HP = 100;
	}
	
	//Returns the username of the player
	public String getUsername(){
		return this.username;
	}
	
	//Returns the password of the player
	public char[] getPassword(){
		return this.password;
	}
	
	//Returns the in game name of the player
	public String getGamename(){
		return this.gamename;
	}
	
	//Returns the current HP of the player
	public int getHP(){
		return this.HP;
	}
	
	//Decreases the HP of the player by a given amount
	public void decreaseHP(int amount){
		if (HP - amount <= 0){
			HP = 0;
		}
		else{
			HP = HP - amount;
		}
	}
	
	//Increases the HP of the player by a given amount
	public void increaseHP(int amount){
		if (HP + amount == 100){
			HP = 100;
		}
		else{
			HP = HP + amount;
		}
	}
}
