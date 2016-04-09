package model.items;

import model.Player;

public class InvisibilityCloak extends Item {
	private String description;
	public InvisibilityCloak() {
		super("Invisibility Cloak");
		description = "This will hide you from everyone including death. Say hello to the invisibility cloak. Oh wait shit where did it go!!??";
	}

	@Override
	public String use(Player p) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

}
