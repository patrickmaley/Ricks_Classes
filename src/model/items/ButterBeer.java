package model.items;

import model.player.Player;

public class ButterBeer extends Item{
	private String drinkingTheBeer;
	public ButterBeer() {
		super("Butter Beer","Ohhhh yeah I know you'll love this ice, cold, refreshing, BUTTER BEER!!!!!!!");
		drinkingTheBeer = "Ahhh, you now feel completely refreshed. Now it didnt help you in anyway,"
				+ " but you gotta admit you feel better know don't you? Don't you? Even if you don't, you enjoyed it "
				+ "have fun with the rest of the game!";
	}

	@Override
	public String use(Player p, String notNeeded) {
		return drinkingTheBeer;
	}
	public String getForLookDescription(){
		return "Oh yeah we got butterbeer in here!!";
	}
}
