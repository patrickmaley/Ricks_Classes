package model.items;

import model.player.Player;

public class DependencyInjectionSword extends Item {
	private static String description;
	private static double attackPoints;
	public DependencyInjectionSword() {
		super("DependencyInjection Sword");
		attackPoints = 0;
		description = "The mighty DependcyInjection sword the deadliest weapon of them all ";
		// TODO Auto-generated constructor stub
	}

	@Override
	public String use(Player p) {
		String returner = "LOL you actually though this weapon did something didn't you!!";
		return returner;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
