package model.items;

import model.mobs.mobs;

public class Imperio extends Spell {
	public Imperio() {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}
	private static String name = "Imperio";
	private static double attackPower= 40;
	@Override
	public boolean canAttack(mobs m) {
		if(m.getName().equals("Dementor")){
			return false;
		}
		else{
			return true;
		}
	}
	
}
