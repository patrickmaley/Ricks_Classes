package model.items;

import model.Player;

public class HealingPotion extends Item {
	private static String description;
	private static double healingPoints = 10;
	public HealingPotion() {
		super("Healing Potion");
		description = "Let me heal you. Its pretty self explanatory what I am";
		// TODO Auto-generated constructor stub
	}
	@Override
	public String use(Player p) {
		String returner="";
		double playerHP = p.getHP();
		if(playerHP >= 100){
			returner= "Cannot heal you nothing to heal";
		}
		else{
			p.increaseHP(healingPoints);
			returner= "Added 10 health points to you";
			p.getInventory().drop(this);
		}
		return returner;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

}
