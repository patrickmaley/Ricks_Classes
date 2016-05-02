package model.mobs;

import model.interactions.Interactions;
import model.player.Player;

public class Lupin extends Mobs{

	private String house;
	
	public Lupin() {
		super("Lupin", 100, "Look its Lupin, I bet if you offer him a bone he'll turn into a werewolf!");
		this.house = "Gryffindor";
	}
	
	public String getForLookDescription(){
		return "Oh yeah it seems like Lupin is here!";
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
			this.setHp(this.getHp()-x);
		}
		if(this.getHp() <= 0){
			this.getRoom().removeMobsInRoom(this);
			Werewolves a = new Werewolves();
			a.setCurrentRoom(this.getRoom());
			this.getRoom().setMobsInRoom(a);
		}
	}
	@Override
	public String action(String command, Player p) {
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		if(command.compareTo("attack") == 0){
			return "You should really watch where you point that thing...";
		}
		if(command.compareTo("talk")==0){
			return ""; // what does lupin say?
		}
		return "";
	}

	@Override
	public void move() {		
	}

}