package model.items;

import model.player.Player;

public class Broomstick extends Item {
	public Broomstick() {
		super("Broomstick","It's the Nimbus 2016!! You can use this to travel to any room you have already visited");
	}

	@Override
	public String use(Player p, String maybe) {
		return null;
	}

}
