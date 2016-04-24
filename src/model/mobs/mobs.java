package model.mobs;

import java.io.Serializable;

import model.interactions.Interactions;
import model.player.Player;
import model.room.GenericRoom;

public abstract class Mobs implements Serializable{
	
	private String name;
	private double hp;
	private String description;
	private int xpos;
	private int ypos;
	private GenericRoom currentRoom;
	private double attackPower;

	
	public Mobs(String name, int hp, String description){
		this.name = name;
		this.hp = hp;
		this.description = description;
	}
	public double getAttackPower(){
		return this.attackPower;
	}
	public int getXpos(){
		return this.xpos;
	}
	public int getYpos(){
		return this.ypos;
	}
	public void setXpos(int xpos){
		this.xpos = xpos;
	}
	public void setYpos(int ypos) {
		this.ypos = ypos;
	}
	public double getHp(){
		return this.hp;
	}
	public void setHp(double x){
		this.hp = x;
	}
	public String getDescription(){
		return this.description;
	}
	public String getName(){
		return this.name;
	}
		
	public void decreaseHP(double x){
		if(this.canBeAttacked()){
			this.hp -= x;
		}
		if(this.hp < 0){
			this.getRoom().removeMobsInRoom(this);
			this.getRoom().setMobsPresent(false);
		}
	}
	//Returns the current room the player is in
	public GenericRoom getRoom(){
		return this.currentRoom;
	}
	
	//Changes the player's current location after they move
	public void setCurrentRoom(GenericRoom location){
		this.currentRoom = location;
	}
	
	public abstract void move();
		
	public abstract boolean canBeAttacked();
	
	public abstract String action(String a, Player p);
	
	public abstract String getForLookDescription();

	
}