package model.mobs;

import model.interactions.Interactions;

public class Snape extends Mobs {

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Snape(String name, int hp, int x, int y) {
		super("Professor Snape", hp, "Oh its Professor Snape. It would probably be wise to not piss him off...", x, y);
		this.house = "Slytherin";
	}

	public String getHouse(){
		return this.house;
	}
	
	@Override
	public boolean canBeAttacked() {
		return false;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String action(String command) {
		if(command.compareTo("talk")==0){
			return "Here take this potion a student made. Hopefully it works right.";
		}
		if(command.compareTo("attack")==0){
			return "So you want a short life I see";
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