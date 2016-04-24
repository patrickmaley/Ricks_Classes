package model.items;

import model.player.Player;

public class DependencyInjectionSword extends Item {
	private static double attackPoints;
	public DependencyInjectionSword() {
		super("DependencyInjection Sword", "The mighty DependcyInjection sword the deadliest weapon of them all ");
		attackPoints = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String use(Player p, String notNeeded) {
		String returner = "LOL you actually though this weapon did something didn't you!!";
		return returner;
	}
	public String getForLookDescription(){
		return "Oh no way the dependency injection is in here";
	}


}
