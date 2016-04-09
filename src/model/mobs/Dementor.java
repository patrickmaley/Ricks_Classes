package model.mobs;

import model.interactions.Interactions;

public class Dementor extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Dementor(String name, int hp) {
		super(name, hp);
		this.house = "none";
		this.description = "Oh snap it's a dementor. I wonder why its this far from Azkaban. Best have your"
				+ " Expecto Patronum spell ready or it will eat your soul straight out your face.";
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
