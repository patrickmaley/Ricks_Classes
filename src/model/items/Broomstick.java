package model.items;

import model.player.Player;

public class Broomstick extends Item {
	private String description;
	public Broomstick() {
		super("Broomstick");
		description = "It's the Nimbus 2016!! You can use this to travel to any room you have already visited";
	}

	@Override
	public String use(Player p) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		return description;
	}

}
