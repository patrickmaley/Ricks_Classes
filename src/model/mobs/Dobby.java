package model.mobs;

import model.interactions.Interactions;

public class Dobby extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Dobby(String name, int hp) {
		super("Dobby", hp);
		this.house = "none";
		this.description = "Oh look its that house elf Dobby. Best watch your back he's a sneaky"
				+ " son of a bitch.";
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean canBeAttacked() {
		return false;
	}


	@Override
	public String getHouse() {
		// TODO Auto-generated method stub
		return this.house;
	}

	@Override
	public String action(String a) {
		// TODO Auto-generated method stub
		return null;
	}

}
