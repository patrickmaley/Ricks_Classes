package model.mobs;

import model.interactions.Interactions;

public class Bellatrix extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
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
	public String getDescription() {
		return this.description;
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
			this.hp -= x;
		}
		if(this.hp < 50){
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
	}
	@Override
	public String action(String command) {
		if(command.compareTo("talk")==0){
			return "Have you come here to die?";
		}
		if(command.compareTo("attack")==0){
			//figure out attacks
			return "Oh finally something to do!";
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