package model.items;

import model.player.Player;

public class PhoenixTears extends Item {
	public PhoenixTears() {
		super("Phoenix Tears","Phoenix tears have magical healing powers. Compared to the ressurection stone this will reset your health back to 100 it will not add 100 to your health");
	}

	@Override
	public String use(Player p, String notNeeded) {
		double currentHP =p.getHP();
		double healthThatWillBeAdded = 100.00-currentHP;
		p.increaseHP(healthThatWillBeAdded);
		p.getInventory().drop(this.getName().toLowerCase());
		return ("Phoenix Tears has added " + healthThatWillBeAdded + " hp to your health resetting you to 100");		
	}
	public String getForLookDescription(){
		return "Phoenix tears have healing powers. And there are some right here in a jar for you.";
	}
}
