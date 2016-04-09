package model.mobs;

import model.interactions.Interactions;

public class Giants extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Giants(String name, int hp) {
		super(name, hp);
		this.house = "none";
		this.description = "Its like a giant person... Oh wait nevermind its just a giant... With a giant club..."
				+ " Good thing it's slow!";
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
