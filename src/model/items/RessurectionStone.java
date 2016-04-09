package model.items;

import model.player.Player;

public class RessurectionStone  extends Item {
	private double hpIncreaser = 100.00;
	private String description;
	public RessurectionStone() {
		super("Ressurection Stone");
		description = "Ah the Ressurection stone with this you can double your health, the equivalent of a new life";
	}

	@Override
	public String use(Player p) {
		String returner = "Your HP has now been increased by 100 giving you another life";
		p.increaseHP(hpIncreaser);
		Inventory temp = p.getInventory();
		temp.drop(this);
		return returner;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

}
