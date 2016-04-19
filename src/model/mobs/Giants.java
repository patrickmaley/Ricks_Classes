package model.mobs;

import model.interactions.Interactions;

public class Giants extends Mobs{

	private int hp;
	private String name;
	private String description;
	private double attackPower;
	
	public Giants(String name, int hp, int x, int y) {
		super(name, hp, "Its like a giant person... Oh wait nevermind its just a giant... With a giant club..."
				+ " Good thing it's slow!", x, y);
		this.attackPower = 25;
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
			//figure out what giants say
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