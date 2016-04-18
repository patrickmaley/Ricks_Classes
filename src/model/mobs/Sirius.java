package model.mobs;

import model.interactions.Interactions;

public class Sirius extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Sirius(String name, int hp, int x, int y) {
		super("Sirius Black", hp, "It's that convict Sirius Black! I wonder how he escaped from Azkaban? "
				+ "He was sent there for murdering innocent people!", x, y);
		this.house = "Gryffindor";
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean canBeAttacked() {
		return false;
	}

	public String getHouse() {
		return this.house;
	}

	@Override
	public String action(String command) {
		//TODO: talk over him having multiple forms
		if(command.compareTo("talk")==0){
			//maybe add in dog form to change things.
		}
		if(command.compareTo("attack")==0){
			return "";
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		return null;
	}

}