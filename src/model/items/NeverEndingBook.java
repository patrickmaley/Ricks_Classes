package model.items;

import model.player.Player;

public class NeverEndingBook extends Item{
	private String bookText;
	public NeverEndingBook() {
		super("Neverending Book","Ahh the never ending book ... thats all you get");
	}

	@Override
	public String use(Player p, String notNeeded) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
