package model.mobs;

import java.util.Random;

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
		if(this.getRoom().getPlayerPresent()){
			return;
		}
		Random rand = new Random();
		int x = rand.nextInt(4);
		if(x == 0){
			if(this.getRoom().getNextRoom("north") != null && this.getRoom().getNextRoom("north").getMobsPresent()){
				this.setYpos(this.getYpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("north"));
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 1){
			if(this.getRoom().getNextRoom("south") != null){
				this.setYpos(this.getYpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("south"));
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 2){
			if(this.getRoom().getNextRoom("east") != null){
				this.setXpos(this.getXpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("east"));
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 3){
			if(this.getRoom().getNextRoom("west") != null){
				this.setXpos(this.getXpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("west"));
				this.getRoom().setMobsPresent(true);
			}
		}		
	}

}