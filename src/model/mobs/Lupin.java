package model.mobs;

import model.interactions.Interactions;
import model.player.Player;

public class Lupin extends Mobs{

	private String house;
	
	public Lupin(String name, int hp, int x, int y) {
		super("Lupin", hp, "Look its Lupin, I bet if you offer him a bone he'll turn into a werewolf!", x, y);
		this.house = "Gryffindor";
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
		if(this.getHp() < 0){
			this.getRoom().removeMobsInRoom(this);
			this.getRoom().setMobsInRoom(new Werewolves("Lupin", 100, this.getXpos(), this.getYpos()));
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