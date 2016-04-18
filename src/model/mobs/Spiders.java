package model.mobs;

import model.interactions.Interactions;

public class Spiders extends Mobs{

	private int hp;
	private String name;
	private String description;
	private double attackPower;
	
	public Spiders(String name, int hp, int x, int y) {
		super(name, hp, "Oh look its just your average spider, you know: 6 feet long and venemous.", x, y);
		this.attackPower = 10;
	}

	public double getAttackPower(){
		return this.attackPower;
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
	public String action(String command) {
		if(command.compareTo("talk")==0){
			return "Spider sounds";
		}
		if(command.compareTo("attack")==0){
			//figure out attacks
			return "";
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}		return null;
	}

}