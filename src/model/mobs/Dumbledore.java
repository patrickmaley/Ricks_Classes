package model.mobs;

import model.interactions.Interactions;

public class Dumbledore extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Dumbledore(String name, int hp) {
		super("Head Master Dumbledore", hp);
		this.house = "Gryffindor";
		this.description = "Its head master Dumbledore, I wonder what he could teach us?";
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
		return this.house;
	}

	@Override
	public String action(String a) {
		// TODO Auto-generated method stub
		return null;
	}

}
