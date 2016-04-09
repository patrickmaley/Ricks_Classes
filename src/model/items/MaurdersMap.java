package model.items;

import model.Player;

public class MaurdersMap extends Item {
	private static String description;
	public MaurdersMap() {
		super("Maurders Map");
		description = "Before you use this I better hear you say, I solemny swear I'm up to no good. Thats right and then the entire map"
				+ "will become visible to you";
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
