package model.items;

import model.mobs.mobs;

public class AvadaKedvra extends Spell {
	public AvadaKedvra() {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}
	private static String name = "Avada Kedvra";
	private static double attackPower= 100;
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
