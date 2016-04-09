package model.items;

import model.mobs.mobs;

public class PetrificusTotalus extends Spell {
	private static String name = "Petrificus Totalus";
	private static double attackPower= 15;
	public PetrificusTotalus() {
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
