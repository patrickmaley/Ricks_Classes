package model.items;

import model.mobs.Mobs;

public class Stupefy extends Spell{
	private static String name = "Stupefy"; 
	private static double attackPower= 30;
	public Stupefy() {
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
