package model.mobs;

import model.interactions.Interactions;
import model.items.Broomstick;
import model.items.HealingPotion;
import model.player.Player;

public class Hagrid extends Mobs{

	private int hp;
	private String name;
	private String description;
	private int counter = 0;
	
	public Hagrid(String name, int hp, int x, int y) {
		super("Hagrid", hp, "It's Hagrid, the nice half-giant. If you need some help he is probably a good"
				+ " person to ask", x , y);
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean canBeAttacked() {
		return false;
	}

	@Override
	public String action(String command, Player p) {
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		if(command.compareTo("talk") == 0){
			if(p.getKnownSpells().size() < 5){
				return "Come back when you've grown up a little and know more.";//get what hagrid should be saying;
			}	
			this.getRoom().getitemsInRoom(new Broomstick());
			return "Here, this should help you get around a little bit quicker!\nHagrid drops a Broomstick!";
		}
		return null;
	}

	@Override
	public void move() {
	}

}