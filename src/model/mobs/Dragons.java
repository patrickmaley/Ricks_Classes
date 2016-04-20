package model.mobs;

import model.interactions.Interactions;
import model.player.Player;

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
	public String action(String command, Player p) {
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		p.decreaseHP(this.attackPower);
		return "The dragon attacks you! Better run away before it kills you!";
	}

	@Override
	public void move() {
	}

}