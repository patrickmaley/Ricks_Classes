package model.items;

import model.mobs.Mobs;

public class ExpectoPatronum extends Spell {
	private static String name = "Expecto Patronum";
	private static double attackPower= 100;
	public ExpectoPatronum() {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canAttack(Mobs m) {
		if(m.getName().equals("Dementor")){
			return true;
		}
		else{
			return false;
		}
	}

}
