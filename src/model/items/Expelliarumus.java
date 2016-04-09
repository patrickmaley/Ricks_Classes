package model.items;

import model.mobs.mobs;

public class Expelliarumus extends Spell {
	private static String name = "Expelliarumus";
	private static double attackPower = 15;
	public Expelliarumus() {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}

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
