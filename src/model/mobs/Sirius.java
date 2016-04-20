package model.mobs;

import java.util.Random;

import model.interactions.Interactions;
import model.player.Player;

public class Sirius extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	private boolean isPadfoot = false;
	
	public Sirius(String name, int hp, int x, int y) {
		super("Sirius Black", hp, "It's that convict Sirius Black! I wonder how he escaped from Azkaban? "
				+ "He was sent there for murdering innocent people!", x, y);
		this.house = "Gryffindor";
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean canBeAttacked() {
		return false;
	}

	public String getHouse() {
		return this.house;
	}

	public boolean isPadfoot(){
		return this.isPadfoot;
	}
	@Override
	public String action(String command, Player p) {
		//TODO: talk over him having multiple forms
		if(command.compareTo("talk")==0){
			//maybe add in dog form to change things.
			if(this.isPadfoot()){
				isPadfoot = false;
				return "woof woof";
			}
			else{
				isPadfoot = true;
				return "We've all got both light and dark inside us. What matters is the part"
						+ " we choose to act on. That's who we really are.";
			}
		}
		if(command.compareTo("look") == 0){
			if(this.isPadfoot()){
				isPadfoot = false;
				return "Oh look! A dog!";
			}
			return this.getDescription();
		}
		return "";
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
				this.getRoom().removeMobsInRoom(this);
				this.setCurrentRoom(this.getRoom().getNextRoom("north"));
				this.getRoom().setMobsInRoom(this);
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 1){
			if(this.getRoom().getNextRoom("south") != null){
				this.setYpos(this.getYpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.getRoom().removeMobsInRoom(this);
				this.setCurrentRoom(this.getRoom().getNextRoom("south"));
				this.getRoom().setMobsInRoom(this);
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 2){
			if(this.getRoom().getNextRoom("east") != null){
				this.setXpos(this.getXpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.getRoom().removeMobsInRoom(this);
				this.setCurrentRoom(this.getRoom().getNextRoom("east"));
				this.getRoom().setMobsInRoom(this);
				this.getRoom().setMobsPresent(true);
			}
		}
		else if(x == 3){
			if(this.getRoom().getNextRoom("west") != null){
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