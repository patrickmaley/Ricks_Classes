package model.items;

import model.player.Player;

public class SwordOfGryffindor  extends Item {
	private String description;
	private static double attackPower;
	public SwordOfGryffindor() {
		super("Sword of Gryffindor");
		attackPower = 50;
		description = "The sword of the great Godric Griffyndor. Only a true hero can use this";
		// TODO Auto-generated constructor stub
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
