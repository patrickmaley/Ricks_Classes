package model.mobs;

import model.interactions.Interactions;

public class Werewolves extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Werewolves(String name, int hp) {
		super(name, hp);
		this.house = "none";
		this.description = "It's a werewolf, it looks pretty friendly with its massive teeth, huge claws, "
				+  "and all of that. We should go pet it or something.";
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
