package model.mobs;

import model.interactions.Interactions;

public class Spiders extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Spiders(String name, int hp) {
		super(name, hp);
		this.house = "none";
		this.description = "Oh look its just your average spider, you know: 6 feet long and venemous.";
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
