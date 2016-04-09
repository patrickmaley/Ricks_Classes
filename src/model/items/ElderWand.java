package model.items;

import model.Player;

public class ElderWand extends Item {
	private static double attackPower = 30.00;
	private String description;
	public ElderWand() {
		super("Elder Wand");
		description = "With this you will be one step closer to mastering death. The ultimate weapon"
				+ "this Elder Wand will add 30 attack points to all the spells you can use making you"
				+ "a beast!!";
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
