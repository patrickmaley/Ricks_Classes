package model.mobs;

import model.interactions.Interactions;
import model.items.ElderWand;
import model.player.Player;

public class Dragons extends Mobs{

	private int hp;
	private String name;
	private double attackPower;
	
	public Dragons() {
		super("Dragon", 300,  "Oh shit! It's a mother fucking dragon! Wait what's that stuck in its teeth?"
				+ " It's the Elder Wand! A worthy prize for someone who defeats this monster.");
		this.attackPower = 45;
	}

	public String getForLookDescription(){
		return "Crap a dragon is with you in the room. Look at it there maybe something special for you.";
	}
	
	public double getAttackPower(){
		return this.attackPower;
	}

	@Override
	public boolean canBeAttacked() {
		return true;
	}
	
	@Override
	public void decreaseHP(double x){
		if(this.canBeAttacked()){
			this.hp -= x;
		}
		if(this.hp <= 0){
			this.getRoom().additemsInRoom(new ElderWand());
			this.getRoom().removeMobsInRoom(this);
			this.getRoom().setMobsPresent(false);
		}
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