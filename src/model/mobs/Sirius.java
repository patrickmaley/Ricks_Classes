package model.mobs;

import model.interactions.Interactions;

public class Sirius extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Sirius(String name, int hp) {
		super("Sirius Black", hp);
		this.house = "Gryffindor";
		this.description = "It's that convict Sirius Black! I wonder how he escaped from Azkaban? "
				+ "He was sent there for murdering innocent people!";
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
