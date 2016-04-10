package model.items;

import model.player.Player;

public class BassilskFang extends Item {
	private static double attackPower;
	private static String description;
	public BassilskFang() {
		super("Bassilsk Fang");
		attackPower= 15;
		description = "This is right out of the mouth of the Bassilsk. Using this will do unimaginable pain to your opponent";
	}
	@Override
	public String use(Player p) {
		return null;
		
	}
	@Override
	public String getDescription() {
		return description;
	}

}
