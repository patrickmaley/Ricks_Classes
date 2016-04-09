package model.mobs;

import model.interactions.Interactions;

public class Hagrid extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Hagrid(String name, int hp) {
		super("Hagrid", hp);
		this.house = "none";
		this.description = "It's Hagrid, the nice half-giant. If you need some help he is probably a good"
				+ " person to ask";
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
