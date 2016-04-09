package model.items;

import model.mobs.mobs;

public class SectumSempra extends Spell {
	private static String name = "Sectum Sempra";
	private static double attackPower= 80;
	public SectumSempra() {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean canAttack(mobs m) {
		if(m.getName().equals("Dementor")){
			return false;
		}
		else if (m.getName().equals("Snape")){
			return false;
		}
		else{
			return true;
		}
	}

}
