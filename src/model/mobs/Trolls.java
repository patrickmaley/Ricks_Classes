
package model.mobs;

import model.interactions.Interactions;
import model.player.Player;

public class Trolls extends Mobs{

	private double attackPower;
	
	public Trolls() {
		super("Troll", 100, "A big, hairy, stupid, looking troll. It would be wise to avoid it before it "
				+ "sees you and smashes you.");
		this.attackPower = 25;
	}
	
	public String getForLookDescription(){
		return "Oh great whats that smell coming from over there. Uh oh you might wanna take a look at that roll behind you? IS it friendly or dangerous?";
	}

	public double getAttackPower(){
		return this.attackPower;
	}

	@Override
	public boolean canBeAttacked() {
		return true;
	}
	

	@Override
	public String action(String command, Player p) {
		if(command.compareTo("talk")==0){
			return "";
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		
		return "";
	}
	private int x = 0;

	@Override
	public void move() {
		if(this.getRoom().getPlayerPresent()){
			return;
		}
		if(x == 8){
			x = 0;
		}
		if(x == 0){
			if(this.getRoom().getNextRoom("north") != null && !this.getRoom().getNextRoom("north").getMobsPresent()){
				this.setYpos(this.getYpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("north"));
				this.getRoom().setMobsPresent(true);
				x++;
			}
		}
		else if(x == 1){
			if(this.getRoom().getNextRoom("south") != null && !this.getRoom().getNextRoom("south").getMobsPresent()){
				this.setYpos(this.getYpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("south"));
				this.getRoom().setMobsPresent(true);
				x++;
			}
		}
		else if(x == 2){
			if(this.getRoom().getNextRoom("east") != null && !this.getRoom().getNextRoom("east").getMobsPresent()){
				this.setXpos(this.getXpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("east"));
				this.getRoom().setMobsPresent(true);
				x++;
			}
		}
		else if(x == 3){
			if(this.getRoom().getNextRoom("west") != null && !this.getRoom().getNextRoom("west").getMobsPresent()){
				this.setXpos(this.getXpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("west"));
				this.getRoom().setMobsPresent(true);
				x++;
			}
		}
		else if(x == 4){
			if(this.getRoom().getNextRoom("south") != null && !this.getRoom().getNextRoom("south").getMobsPresent()){
				this.setYpos(this.getYpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("south"));
				this.getRoom().setMobsPresent(true);
				x++;
			}
		}
		else if(x == 5){
			if(this.getRoom().getNextRoom("north") != null && !this.getRoom().getNextRoom("north").getMobsPresent()){
				this.setYpos(this.getYpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("north"));
				this.getRoom().setMobsPresent(true);
				x++;
			}
		}
		else if(x == 6){
			if(this.getRoom().getNextRoom("west") != null && !this.getRoom().getNextRoom("west").getMobsPresent()){
				this.setXpos(this.getXpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("west"));
				this.getRoom().setMobsPresent(true);
				x++;
			}
		}
		else if(x == 7){
			if(this.getRoom().getNextRoom("east") != null && !this.getRoom().getNextRoom("east").getMobsPresent()){
				this.setXpos(this.getXpos() + 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("east"));
				this.getRoom().setMobsPresent(true);
				x++;
			}
		}
	}

}