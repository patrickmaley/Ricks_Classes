package model.items;

import model.mobs.mobs;

public class Crucio extends Spell {
	public Crucio() {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}
	private static String name = "Crucio";
	private static double attackPower= 50;
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
