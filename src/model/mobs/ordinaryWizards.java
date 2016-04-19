package model.mobs;

import java.util.Random;

import model.interactions.Interactions;

public class OrdinaryWizards extends Mobs{

	private String name;
	private int hp;
	private String house;
	private String description;
	
	public OrdinaryWizards(String name, int hp, String house, int x, int y) {
		super(name, hp, "This is " + name + " just an ordinary wizard minding their own business.", x , y);
		this.house = house;
	}

	public String getHouse(){
		if(this.house == null){
			return null;
		}
		return this.house;
	}

	@Override
	public boolean canBeAttacked() {
		return false;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String action(String command) {
		if(command.compareTo("talk")==0){
			if(house.compareTo("Gryffindor")==0){
				return "Hey what can I help with?";
			}
			if(house.compareTo("Slytherin")==0){
				return "Piss off!";
			}
			if(house.compareTo("Hufflepuff")==0){
				return "Our ghost is the Fat Friar";
			}
			if(house.compareTo("Ravenclaw")==0){
				return "I'm gonna be the smarterest wizard evar!";
			}
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		return null;
	}

	@Override
	public void move() {
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