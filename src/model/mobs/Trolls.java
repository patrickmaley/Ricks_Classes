
package model.mobs;

import model.interactions.Interactions;

public class Trolls extends Mobs{

	private int hp;
	private String name;
	private String description;
	private double attackPower;
	
	public Trolls(String name, int hp, int x, int y) {
		super(name, hp, "A big, hairy, stupid, looking troll. It would be wise to avoid it before it "
				+ "sees you and smashes you.", x, y);
		this.attackPower = 25;
	}

	public double getAttackPower(){
		return this.attackPower;
	}
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean canBeAttacked() {
		return true;
	}
	

	@Override
	public String action(String command) {
		if(command.compareTo("talk")==0){
			return "";
		}
		if(command.compareTo("attack")==0){
			//figure out attacks
			return "";
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		
		return null;
	}

}