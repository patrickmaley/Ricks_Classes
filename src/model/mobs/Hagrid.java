package model.mobs;

import model.interactions.Interactions;
import model.items.Broomstick;
import model.items.HealingPotion;
import model.player.Player;

public class Hagrid extends Mobs{
	
	public Hagrid() {
		super("Hagrid",100, "It's Hagrid, the nice half-giant. If you need some help he is probably a good"
				+ " person to ask");
	}

	@Override
	public boolean canBeAttacked() {
		return false;
	}
	
	public String getForLookDescription(){
		return "Do you hear that?? I should not have said. I should not have said. Looks like your favorite friend is here.";
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
			this.getRoom().additemsInRoom(new Broomstick());
			return "Here, this should help you get around a little bit quicker!\nHagrid drops a Broomstick!";
		}
		return "";
	}

	@Override
	public void move() {
	}

}