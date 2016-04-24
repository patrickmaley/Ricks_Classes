package model.mobs;

import java.util.Random;

import model.interactions.Interactions;
import model.player.Player;

public class Spiders extends Mobs{

	private double attackPower;
	
	public Spiders() {
		super("Spider a.k.a Erics favorite", 50, "Oh look its just your average spider, you know: 6 feet long and venemous.");
		this.attackPower = 10;
	}
	public String getForLookDescription(){
		return "Hey its rons biggest fear";
	}
	
	public double getAttackPower(){
		return this.attackPower;
	}


	@Override
	public boolean canBeAttacked() {
		return true;
	}


	@Override
	public String action(String command, Player p) {
		if(command.compareTo("talk")==0){
			return "";
		}

		if(command.compareTo("look") == 0){
			return this.getDescription();
		}		
		return "";
	}

	@Override
	public void move() {
		Random rand = new Random();
		int x = rand.nextInt(4);
		if(x == 0){
			if(this.getRoom().getNextRoom("north") != null && !this.getRoom().getNextRoom("north").getMobsPresent()){
				this.setYpos(this.getYpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("north"));
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 1){
			if(this.getRoom().getNextRoom("south") != null && !this.getRoom().getNextRoom("south").getMobsPresent()){
				this.setYpos(this.getYpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("south"));
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 2){
			if(this.getRoom().getNextRoom("east") != null && !this.getRoom().getNextRoom("east").getMobsPresent()){
				this.setXpos(this.getXpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("east"));
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 3){
			if(this.getRoom().getNextRoom("west") != null && !this.getRoom().getNextRoom("west").getMobsPresent()){
				this.setXpos(this.getXpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("west"));
				this.getRoom().setMobsPresent(true);
			}
		}
	}	
}