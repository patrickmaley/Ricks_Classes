package model.mobs;

import model.interactions.Interactions;

public class Lupin extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Lupin(String name, int hp) {
		super("Lupin", hp);
		this.house = "Gryffindor";
		this.description = "Look its Lupin, I bet if you offer him a bone he'll turn into a werewolf!";
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
