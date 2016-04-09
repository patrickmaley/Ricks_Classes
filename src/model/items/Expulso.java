package model.items;

import model.mobs.mobs;

public class Expulso extends Spell {
	public Expulso() {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}
	private static String name = "Expulso";
	private static double attackPower= 20;
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
