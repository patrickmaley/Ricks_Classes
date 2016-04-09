package model;
import model.items.*;
import model.room.*;
import model.interactions.*;
import model.mobs.*;
import model.map.*;
import java.util.ArrayList;

public class Player {

	private String username;
	private char[] password;
	private String gamename;
 	private ArrayList<Spell> knownSpells;
	private Inventory inventory;
	private Interactions interaction;
	private String house;
	private double HP ;
	public Player(String username, char[] password, String gamename, String house){
		this.username = username;
		this.password = password;
		this.gamename = gamename;
		this.knownSpells = new ArrayList<Spell>();
		this.inventory = new Inventory();
		this.HP = 100;
		this.interaction= new Interactions(this);
		this.house=house;
	}
	//Returns the username of the player
	public void addKnownSpells(Spell s){
		knownSpells.add(s);
	}
	public void removeKnownSpells(Spell s){
		if(knownSpells.contains(s)){
			knownSpells.remove(s);
		}
	}
	public String getUsername(){
		return this.username;
	}
	//Returns the house of the player
	public String getHouse(){
		return this.house;
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
	public double getHP(){
		return this.HP;
	}
	//Returns the inventory of the player
	public Inventory getInventory(){
		return this.inventory;
	}
	
	//Decreases the HP of the player by a given amount
	public void decreaseHP(double amount){
		if (HP - amount <= 0){
			HP = 0;
		}
		else{
			HP = HP - amount;
		}
	}
	
	//Increases the HP of the player by a given amount
	public void increaseHP(double amount){
			HP = HP + amount;
	}
	public void performAction(String s){
		this.interaction.performAction(s);
	}
	
}
