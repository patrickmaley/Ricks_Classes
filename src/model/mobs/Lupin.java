package model.mobs;

import model.interactions.Interactions;

public class Lupin extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Lupin(String name, int hp, int x, int y) {
		super("Lupin", hp, "Look its Lupin, I bet if you offer him a bone he'll turn into a werewolf!", x, y);
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
			return "You should really watch where you point that thing...";
		}
		if(command.compareTo("talk")==0){
			return ""; // what does lupin say?
		}
		return null;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}