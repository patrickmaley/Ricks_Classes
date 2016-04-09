package model.items;

import model.player.Player;

public class ButterBeer extends Item{
	private String description;
	private String drinkingTheBeer;
	public ButterBeer() {
		super("Butter Beer");
		drinkingTheBeer = "Ahhh, you now feel completely refreshed. Now it didnt help you in anyway,"
				+ " but you gotta admit you feel better know don't you? Don't you? Even if you don't, you enjoyed it "
				+ "have fun with the rest of the game!";
		description = "Ohhhh yeah I know you'll love this ice, cold, refreshing, BUTTER BEER!!!!!!!";
	}

	@Override
	public String use(Player p) {
		return drinkingTheBeer;
	}

	@Override
	public String getDescription() {
		return description;
	}
	

}
