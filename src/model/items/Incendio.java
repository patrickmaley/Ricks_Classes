package model.items;

import model.mobs.Mobs;

public class Incendio extends Spell {
	private static String name = "Incendio";
	private static double attackPower= 10;
	public Incendio() {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canAttack(Mobs m) {
		if(m.getName().equals("Dementor")){
			return false;
		}
		else{
			return true;
		}
	}

}
