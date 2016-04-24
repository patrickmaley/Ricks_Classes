package model.mobs;

import model.interactions.Interactions;
import model.player.Player;

public class Bellatrix extends Mobs{

	private String house;
	private double attackPower;
	
	public Bellatrix(String name, int hp, int x, int y) {
		super("Bellatrix", hp, "Oh no it's that crazy bitch Bellatrix!", x, y);
		this.house = "Slytherin";
		this.attackPower = 35;
	}
	
	
	public double getAttackPower(){
		return this.attackPower;
	}

	@Override
	public boolean canBeAttacked() {
		return true;
	}

	public String getHouse() {
		return this.house;
	}

	@Override
	public void decreaseHP(double x){
		if(this.canBeAttacked()){
			this.setHp(this.getHp()-x);;
		}
		if(this.getHp() < 50){
			if(this.getRoom().getNextRoom("south") != null && !this.getRoom().getNextRoom("south").getMobsPresent()){
				this.setYpos(this.getYpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.getRoom().removeMobsInRoom(this);
				this.setCurrentRoom(this.getRoom().getNextRoom("south"));
				this.getRoom().setMobsInRoom(this);
				this.getRoom().setMobsPresent(true);
			}
			else if(this.getRoom().getNextRoom("north") != null && !this.getRoom().getNextRoom("north").getMobsPresent()){
				this.setYpos(this.getYpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.getRoom().removeMobsInRoom(this);
				this.setCurrentRoom(this.getRoom().getNextRoom("north"));
				this.getRoom().setMobsInRoom(this);
				this.getRoom().setMobsPresent(true);
			}
		}
		if(this.getHp() < 0){
			this.getRoom().removeMobsInRoom(this);
			this.getRoom().setMobsPresent(false);
		}
	}
	@Override
	public String action(String command, Player p) {
		if(command.compareTo("talk")==0){
			return "Have you come here to die?";
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}		
		return "...";
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub		
	}

}