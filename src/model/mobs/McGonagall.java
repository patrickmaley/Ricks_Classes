package model.mobs;

import model.interactions.Interactions;

public class McGonagall extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public McGonagall(String name, int hp) {
		super("Professor McGonagall", hp);
		this.house = "Gryffindor";
		this.description = "Its Professor McGonagall! We're lucky we caught her in her human form. Maybe "
				+ "she could teach us how to transform into an animal.";
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
