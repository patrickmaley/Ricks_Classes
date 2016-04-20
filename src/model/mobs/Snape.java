package model.mobs;

import model.interactions.Interactions;
import model.items.HealingPotion;
import model.player.Player;

public class Snape extends Mobs {

	private int hp;
	private String name;
	private String house;
	private String description;
	
	public Snape(String name, int hp, int x, int y) {
		super("Professor Snape", hp, "Oh its Professor Snape. It would probably be wise to not piss him off...", x, y);
		this.house = "Slytherin";
	}

	public String getHouse(){
		return this.house;
	}
	
	@Override
	public boolean canBeAttacked() {
		return false;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String action(String command, Player p) {
		if(command.compareTo("talk")==0){
			this.getRoom().getitemsInRoom(new HealingPotion());
			return "Here take this potion a student made. Hopefully it works right.\nProfessor Snape drops a "
					+ "healing potion";
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		return "Get out!";
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}