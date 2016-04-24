package model.mobs;

import model.interactions.Interactions;
import model.items.DependencyInjectionSword;
import model.player.Player;

public class McGonagall extends Mobs{

	private String house;
	
	public McGonagall() {
		super("Professor McGonagall", 100, "Its Professor McGonagall! We're lucky we caught her in her human form. Maybe "
				+ "she could teach us how to transform into an animal.");
		this.house = "Gryffindor";
	}
	
	public String getForLookDescription(){
		return " Professor McGonagall looks like shes been waiting for you!";
	}
	
	@Override
	public boolean canBeAttacked() {
		return false;
	}

	public String getHouse() {
		return this.house;
	}

	@Override
	public String action(String command, Player p) {
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		if(command.compareTo("talk") == 0){
			this.getRoom().additemsInRoom(new DependencyInjectionSword());
			return "You wouldn't have to come to me as often"
					+ " if you would just use dependency injection. Take this"
					+ "to help yourself out.\nProfessor McGonagall drops a DependencyInjectionSword";//what should she say?
		}
		return "";
	}

	@Override
	public void move() {		
	}

}