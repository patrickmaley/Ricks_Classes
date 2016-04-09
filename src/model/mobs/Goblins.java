package model.mobs;

import model.interactions.Interactions;

public class Goblins extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Goblins(String name, int hp) {
		super(name, hp);
		this.house = "none";
		this.description = "Look at that greedy goblin... His pockets are overflowing with gold that he"
				+ " probably swindled some poor wizard out of.";
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean canBeAttacked() {
		return true;
	}
	
	@Override
	public String getHouse() {
		return this.house;
	}

	@Override
	public String action(String a) {
		// TODO Auto-generated method stub
		return null;
	}

}
