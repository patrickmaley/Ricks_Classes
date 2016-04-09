package model.mobs;

import model.interactions.Interactions;

public abstract class Mobs {
	
	private String name;
	private int hp;
	private String description;

	
	public Mobs(String name, int hp){
		this.name = name;
		this.hp = hp;
	}
	
	public int getHp(){
		return this.hp;
	}
	
	public String getName(){
		return this.name;
	}
		
	public abstract String getDescription();
	
	public abstract boolean canBeAttacked();
	
	public abstract String action(String a);

	public abstract String getHouse();
}
