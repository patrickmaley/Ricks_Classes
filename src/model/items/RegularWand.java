package model.items;

import model.Player;

public class RegularWand  extends Item {
	private int attackPower;
	private String description;
	public RegularWand() {
		super("Regular Wand");
		attackPower = 0;
		description = "This ordinary wand will allow you to start using all those spells you have learned. Congratulation and you it carefully, as you"
				+ "must remember that the wand chooses the wizrd";
		// TODO Auto-generated constructor stub
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
