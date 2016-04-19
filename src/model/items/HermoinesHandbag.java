package model.items;

import model.player.Player;

public class HermoinesHandbag extends Item {
	public HermoinesHandbag() {
		super("Hermoines Handbag","This enchanment charm, known as Hermoines Handbag, will double the size of your inventory. Plus you will look pretty");
	}

	@Override
	public String use(Player p, String notNeeded) {
		String returner = "The size of your inventory has been increased by 5";
		Inventory temp = p.getInventory();
		temp.changeInventorySize(this);
		temp.drop(this.getName().toLowerCase());
		return returner;
	}

}
