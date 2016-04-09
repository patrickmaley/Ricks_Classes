package model;
import model.items.*;
import model.room.*;
import model.interactions.*;
import model.mobs.*;
import model.map.*;
import java.util.ArrayList;

import model.items.Inventory;
import model.items.Spell;

public class Player {

	private String username;
	private char[] password;
	private String gameName;
 	private ArrayList<Spell> knownSpells;
	private Inventory inventory;
	private Interactions interaction;
	private int HP;
	public Player(String username, char[] password, String gamename){
		this.username = username;
		this.password = password;
		this.gamename = gamename;
		this.knownSpells = new ArrayList<Spell>();
		this.inventory = Inventory.getInstance();
		this.HP = 100;
		this.interaction= new Interactions(this);
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
	public String getGameName(){
		return this.gameName;
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
	
	public void performAction(String s){
		this.interaction.performAction(s);
	}
	
}
