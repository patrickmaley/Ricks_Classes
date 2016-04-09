package model.mobs;

import model.interactions.Interactions;

public class Centaurs extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Centaurs(String name, int hp) {
		super(name, hp);
		this.house = "none";
		this.description = "It's a centaurs, half man, half horse, fully majestic.";
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
