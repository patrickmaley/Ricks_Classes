package model.mobs;

import model.interactions.Interactions;

public class Goblins extends Mobs{

	private int hp;
	private String name;
	private String description;
	private double attackPower;
	
	public Goblins(String name, int hp, int x, int y) {
		super(name, hp, "Look at that greedy goblin... His pockets are overflowing with gold that he"
				+ " probably swindled some poor wizard out of.", x, y);
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
			return "Do you have any gold for me to \"keep safe\"?";
		}
		if(command.compareTo("attack")==0){
			//figure out attacks
			return "Fine I'll get your gold after I kill you!";
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		return null;
	}

}