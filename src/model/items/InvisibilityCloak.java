package model.items;

import model.player.Player;

public class InvisibilityCloak extends Item {
	public InvisibilityCloak() {
		super("Invisibility Cloak","This will hide you from everyone including death. Say hello to the invisibility cloak. Oh wait shit where did it go!!??");
	}

	@Override
	public String use(Player p, String notNeeded) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
