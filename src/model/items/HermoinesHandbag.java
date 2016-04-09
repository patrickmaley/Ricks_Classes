package model.items;

import model.Player;

public class HermoinesHandbag extends Item {
	private String description;
	public HermoinesHandbag() {
		super("Hermoines Handbag");
		description = "This enchanment charm, known as Hermoines Handbag, will double the size of your inventory. Plus you will look pretty";
	}

	@Override
	public String use(Player p) {
		String returner = "The size of your inventory has been increased by 5";
		Inventory temp = p.getInventory();
		temp.changeInventorySize(this);
		temp.drop(this);
		return returner;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

}
