package model.mobs;

import model.interactions.Interactions;

public class Snape extends Mobs {

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Snape(String name, int hp) {
		super("Professor Snape", hp);
		this.house = "Slytherin";
		this.description = "Oh its Professor Snape. It would probably be wise to not piss him off...";
	}

	public String getHouse(){
		return this.house;
	}
	
	@Override
	public boolean canBeAttacked() {
		return false;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String action(String a) {
		// TODO Auto-generated method stub
		return null;
	}

}
