package model.mobs;

import model.interactions.Interactions;

public class Dementor extends Mobs{

	private int hp;
	private String name;
	private String description;
	private double attackPower;
	
	public Dementor(String name, int hp, int x, int y) {
		super(name, hp, "Oh snap it's a dementor. I wonder why its this far from Azkaban. Best have your"
				+ " Expecto Patronum spell ready or it will eat your soul straight out your face.", x, y);
		this.attackPower = 100;
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
		//Should dementors be silent
		if(command.compareTo("talk")==0){
			return "";
		}
		if(command.compareTo("attack")==0){
			//figure out attacks
			return "";
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}		return null;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}