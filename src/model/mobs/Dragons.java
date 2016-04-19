package model.mobs;

import model.interactions.Interactions;

public class Dragons extends Mobs{

	private int hp;
	private String name;
	private String description;
	private double attackPower;
	
	public Dragons(String name, int hp, int x, int y) {
		super(name, hp,  "Oh shit! It's a mother fucking dragon! Wait whats that stuck in its teeth?"
				+ " It's the Elder Wand! A worthy prize for someone who defeats this monster.", x, y);
		this.attackPower = 45;
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
		if(command.compareTo("look")  == 0){
			return this.getDescription();
		}
		if(command.compareTo("talk") == 0){
			return "The dragon roars and launches at you!";
		}
		if(command.compareTo("attack") == 0){
			//figure out how much hp to remove?
			return "The dragon doesn't take kindly to intruders";
		}
		return null;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}