package model.mobs;

import model.interactions.Interactions;

public class Centaurs extends Mobs{

	private int hp;
	private String name;
	private String description;
	private double attackPower;
	
	public Centaurs(String name, int hp, int x, int y) {
		super(name, hp, "It's a centaurs, half man, half horse, fully majestic.", x, y);
		this.attackPower = 17;
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
			return "";
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