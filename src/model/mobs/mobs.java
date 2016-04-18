package model.mobs;

import model.interactions.Interactions;

public abstract class Mobs {
	
	private String name;
	private int hp;
	private String description;
	private int xpos;
	private int ypos;
	
	
	public Mobs(String name, int hp, String description, int x, int y){
		this.name = name;
		this.hp = hp;
		this.description = description;
		this.xpos = x;
		this.ypos = y;
	}
	public int getXpos(){
		return this.xpos;
	}
	public int getYpos(){
		return this.ypos;
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
	}
	
	public abstract String getDescription();
	
	public abstract boolean canBeAttacked();
	
	public abstract String action(String a);
}