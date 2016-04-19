
package model.mobs;

import model.interactions.Interactions;

public class Dumbledore extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Dumbledore(String name, int hp, int x, int y) {
		super("Head Master Dumbledore", hp, "Its head master Dumbledore, I wonder what he could teach us?", x, y);
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
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		if(command.compareTo("attack") == 0){
			return "I will not harm a student!";
		}
		if(command.compareTo("talk") == 0){
			return "Ahh here to get more knowledge?";
		}
		return null;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}