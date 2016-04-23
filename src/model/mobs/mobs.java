package model.mobs;

import java.io.Serializable;

import model.interactions.Interactions;
import model.player.Player;
import model.room.GenericRoom;

public abstract class Mobs implements Serializable{
	
	private String name;
	private int hp;
	private String description;
	private int xpos;
	private int ypos;
	private GenericRoom currentRoom;
	private double attackPower;

	
	public Mobs(String name, int hp, String description, int x, int y){
		this.name = name;
		this.hp = hp;
		this.description = description;
		this.xpos = x;
		this.setYpos(y);
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
	public int getHp(){
		return this.hp;
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
	
	public abstract String getDescription();
	
	public abstract boolean canBeAttacked();
	
	public abstract String action(String a, Player p);
	
}