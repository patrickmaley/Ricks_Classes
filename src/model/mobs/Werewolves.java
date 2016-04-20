package model.mobs;

import model.interactions.Interactions;
import model.player.Player;

public class Werewolves extends Mobs{

	private int hp;
	private String name;
	private String description;
	private double attackPower;
	
	public Werewolves(String name, int hp, int x, int y) {
		super(name, hp, "It's a werewolf, it looks pretty friendly with its massive teeth, huge claws, "
				+  "and all of that. We should go pet it or something.", x, y);
		this.attackPower = 20;
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
		if(command.compareTo("talk") == 0){
			return "Wuf Wuf grrrrrr";
		}
		else if(command.compareTo("attack")==0){
			//figure out how were doing attacks
		}
		else if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		
		return "";
	}
	private int x = 0;

	@Override
	public void move() {
		if (x == 0) {
			if (this.getRoom().getNextRoom("north") != null && !this.getRoom().getNextRoom("north").getMobsPresent()) {
				this.setYpos(this.getYpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("north"));
				this.getRoom().setMobsPresent(true);
				x++;
			}
		} else if (x == 1) {
			if (this.getRoom().getNextRoom("south") != null && !this.getRoom().getNextRoom("south").getMobsPresent()) {
				this.setYpos(this.getYpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("south"));
				this.getRoom().setMobsPresent(true);
				x = 0;
			}
		}		
	}

}