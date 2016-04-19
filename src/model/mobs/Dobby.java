package model.mobs;

import model.interactions.Interactions;

public class Dobby extends Mobs{

	private int hp;
	private String name;
	private String description;
	
	public Dobby(String name, int hp, int x, int y) {
		super("Dobby", hp, "Oh look its that house elf Dobby. Best watch your back he's a sneaky"
				+ " son of a bitch.", x, y);
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
	public String action(String command) {
		if(command.compareTo("talk")==0){
			return "What can Dobby do for you?";
		}
		if(command.compareTo("attack")==0){
			return "Why do you want to hurt Dobby?";
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		return null;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}