package model.mobs;

import java.util.Random;

import model.interactions.Interactions;
import model.player.Player;

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
	public String action(String command, Player p) {
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
			else{
				return "I once belonged to a house, but then I took a spell to the knee :(";
			}
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		else{
			return "You shouldn't be here.";
		}
		}

	@Override
	public void move() {
		if(this.getRoom().getPlayerPresent()){
			return;
		}
		Random rand = new Random();
		int x = rand.nextInt(4);
		if(x == 0){
			if(this.getRoom().getNextRoom("north") != null && !this.getRoom().getNextRoom("north").getMobsPresent()){
				this.setYpos(this.getYpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.getRoom().removeMobsInRoom(this);
				this.setCurrentRoom(this.getRoom().getNextRoom("north"));
				this.getRoom().setMobsInRoom(this);
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 1){
			if(this.getRoom().getNextRoom("south") != null && !this.getRoom().getNextRoom("south").getMobsPresent()){
				this.setYpos(this.getYpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.getRoom().removeMobsInRoom(this);
				this.setCurrentRoom(this.getRoom().getNextRoom("south"));
				this.getRoom().setMobsInRoom(this);
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 2){
			if(this.getRoom().getNextRoom("east") != null && !this.getRoom().getNextRoom("east").getMobsPresent()){
				this.setXpos(this.getXpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.getRoom().removeMobsInRoom(this);
				this.setCurrentRoom(this.getRoom().getNextRoom("east"));
				this.getRoom().setMobsInRoom(this);
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 3){
			if(this.getRoom().getNextRoom("west") != null && !this.getRoom().getNextRoom("west").getMobsPresent()){
				this.setXpos(this.getXpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.getRoom().removeMobsInRoom(this);
				this.setCurrentRoom(this.getRoom().getNextRoom("west"));
				this.getRoom().setMobsInRoom(this);
				this.getRoom().setMobsPresent(true);
			}
		}
	}
}