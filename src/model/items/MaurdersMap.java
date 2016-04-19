package model.items;

import model.player.Player;

public class MaurdersMap extends Item {
	public MaurdersMap() {
		super("Maurders Map","Before you use this I better hear you say, I solemny swear I'm up to no good. Thats right and then the entire map"
				+ "will become visible to you");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String use(Player p, String notNeeded) {
		return "Not functional yet part of the wow factor";
	}
}
