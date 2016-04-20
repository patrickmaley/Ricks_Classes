package model.mobs;

import model.interactions.Interactions;
import model.items.DependencyInjectionSword;
import model.player.Player;

public class McGonagall extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public McGonagall(String name, int hp, int x, int y) {
		super("Professor McGonagall", hp, "Its Professor McGonagall! We're lucky we caught her in her human form. Maybe "
				+ "she could teach us how to transform into an animal.", x, y);
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

	@Override
	public String action(String command, Player p) {
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		if(command.compareTo("talk") == 0){
			this.getRoom().getitemsInRoom(new DependencyInjectionSword());
			return "You wouldn't have to come to me as often"
					+ " if you would just use dependency injection. Take this"
					+ "to help yourself out.\nProfessor McGonagall drops a DependencyInjectionSword";//what should she say?
		}
		return null;
	}

	@Override
	public void move() {		
	}

}