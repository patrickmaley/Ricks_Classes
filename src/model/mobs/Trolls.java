package model.mobs;

import model.interactions.Interactions;

public class Trolls extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Trolls(String name, int hp) {
		super(name, hp);
		this.house = "none";
		this.description = "A big, hairy, stupid, looking troll. It would be wise to avoid it before it "
				+ "sees you and smashes you.";
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
