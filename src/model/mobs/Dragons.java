package model.mobs;

import model.interactions.Interactions;

public class Dragons extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Dragons(String name, int hp) {
		super(name, hp);
		this.house = "none";
		this.description = "Oh shit! It's a mother fucking dragon! Wait whats that stuck in its teeth?"
				+ " It's the Elder Wand! A worthy prize for someone who defeats this monster.";
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
