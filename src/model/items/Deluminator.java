package model.items;

import model.player.Player;

public class Deluminator extends Item {
	boolean hasLight = false;
	public Deluminator() {
		super("Deluminator","The deluminator will allow you to blind everyone in the room you are in, and they will be surrounded by darkness");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String use(Player p, String maybe) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
