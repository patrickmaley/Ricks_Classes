package model.items;

import model.player.Player;

public class HealingPotion extends Item {
	private static double healingPoints = 10;
	public HealingPotion() {
		super("Healing Potion","Let me heal you. Its pretty self explanatory what I am");
		// TODO Auto-generated constructor stub
	}
	@Override
	public String use(Player p, String notNeeded) {
		String returner="";
		double playerHP = p.getHP();
		if(playerHP >= 100){
			returner= "Cannot heal you nothing to heal";
		}
		else{
			p.increaseHP(healingPoints);
			returner= "Added 10 health points to you";
			p.getInventory().drop(this.getName().toLowerCase());
		}
		return returner;
	}
	public String getForLookDescription(){
		return "Hey there is a healing potion in here.";
	}
}
