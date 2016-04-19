package model.mobs;

import model.interactions.Interactions;

public class Hagrid extends Mobs{

	private int hp;
	private String name;
	private String description;
	
	public Hagrid(String name, int hp, int x, int y) {
		super("Hagrid", hp, "It's Hagrid, the nice half-giant. If you need some help he is probably a good"
				+ " person to ask", x , y);
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean canBeAttacked() {
		return false;
	}

	@Override
	public String action(String command) {
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		if(command.compareTo("talk") == 0){
			return "";//get what hagrid should be saying;
		}
		if(command.compareTo("attack")==0){
			return "Finna get an ass whooping!"; //what is he gonna say?
		}
		return null;
	}

}