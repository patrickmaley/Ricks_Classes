package model.items;

import model.player.Player;

public class NeverEndingBook extends Item{
	private String bookText;
	private String description;
	public NeverEndingBook() {
		super("Neverending Book");
		description = "Ahh the never ending book ... thats all you get";
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
