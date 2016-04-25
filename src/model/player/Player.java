package model.player;

import model.room.*;
import model.interactions.*;
import model.map.*;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import model.items.Inventory;
import model.items.Spell;

public class Player implements Serializable{

	private String username;
	private String password;
	private String gameName;
 	private ArrayList<Spell> knownSpells;
	private Inventory inventory;
	private Interactions interaction;
	private GenericRoom currentRoom;
	private double HP;
	private String house;
	private Map playerMap;
	private boolean isDead;
	private String description;
	
	
	public Player(String username, char[] password) throws NoSuchAlgorithmException, NoSuchProviderException{
		this.password = getSecurePassword(password.toString());
		this.username = username;
		this.knownSpells = new ArrayList<Spell>();
		this.inventory = new Inventory();
		this.HP = 100;
		this.playerMap = Map.setMap(null);
		this.currentRoom = playerMap.getMapArray()[9][0];
		this.currentRoom.setPlayerPresent(true, this);
		this.interaction = new Interactions(this);
		this.isDead = false;
	}
	
	//Returns the username of the player
	public String getUsername(){
		return this.username;
	}
	
	//Sets the gameName of the player
	public void setGameName(String gameName){
		this.gameName = gameName;
	}
	
	//Sets the house of the player
	public void setHouse(String houseName){
		this.house = houseName;
	}
	
	//Returns the description of the player
	public String getDescription(){
		return this.description;
	}
	
	//Sets the player description
	public void setDescription(String des){
		this.description = des;
	}
	
	//Returns true if the password is correct. False otherwise.
	public boolean checkPassword(char[] other) throws NoSuchAlgorithmException, NoSuchProviderException{
		if (password.compareTo(getSecurePassword(other.toString())) == 0){
			return true;
		}
		return false;
	}
	
	//Returns the in gameName of the player
	public String getGameName(){
		return this.gameName;
	}
	
	//Returns the current HP of the player
	public double getHP(){
		return this.HP;
	}
	
	//Decreases the HP of the player by a given amount
	public void decreaseHP(double amount){
		if (HP - amount <= 0){
			HP = 0;
			isDead = true;
			resetPlayerData();
		}
		else{
			HP = HP - amount;
		}
	}
	
	//Increases the HP of the player by a given amount
	public void increaseHP(double amount){
		HP = HP + amount;
	}
	
	//Adds a new spell to the spellbook
	public void addKnownSpells(Spell s){
		knownSpells.add(s);
	}
	
	//Removes a known spell from the spellbook if it exists already
	public void removeKnownSpells(Spell s){
		if(knownSpells.contains(s)){
			knownSpells.remove(s);
		}
	}
	
	//Returns the current spellbook
	public ArrayList<Spell> getKnownSpells(){
		return this.knownSpells;
	}
	
	public String getKnownSpellsToString(){
		String toReturn = "";
		for(int i=0;i<this.knownSpells.size();i++){
			toReturn += this.knownSpells.get(i).getName() + " ";
		}
		return toReturn;
	}
	//Returns the user's house
	public String getHouse(){
		return this.house;
	}
	
	//Returns the current room the player is in
	public GenericRoom getRoom(){
		return this.currentRoom;
	}
	
	//Changes the player's current location after they move
	public void setCurrentRoom(GenericRoom location){
		this.currentRoom.setPlayerPresent(false, this);
		this.currentRoom = location;
		this.currentRoom.setPlayerPresent(true, this);
	}
	
	//Returns true if the player died. Returns false otherwise.
	public boolean getIsDead(){
		return this.isDead;
	}
	
	//Call this method if the player is dead to reset all of the game data.
	//Keeps the username, password, house, and gameName
	public void resetPlayerData(){
		this.knownSpells = new ArrayList<Spell>();
		this.inventory = new Inventory();
		this.HP = 100;
		this.interaction= new Interactions(this);
		this.playerMap = Map.setMap(null);
		this.setCurrentRoom(Map.setMap(null).getEntrance());
		this.isDead = false;
	}
	
	//Returns the current player map
	public Map getPlayerMap(){
		return this.playerMap;
	}
	
	//Sets the player map to the map given
	public void setPlayerMap(Map m){
		this.playerMap = m;
	}
	
	//Allows the player to perform an action in the game
	public String performAction(String s){
		return this.interaction.performAction(s);
	}
	
	//Makes the user's password secure
	private static String getSecurePassword(String passwordToHash){
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

	//Returns the current inventory of the player
	public Inventory getInventory() {
		return this.inventory;
	}
     
}
