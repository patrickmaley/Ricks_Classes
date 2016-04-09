package model.mobs;

import model.interactions.Interactions;

public class Bellatrix extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Bellatrix(String name, int hp) {
		super("Bellatrix", hp);
		this.house = "Slytherin";
		this.description = "Oh no it's that crazy bitch Bellatrix!";
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
