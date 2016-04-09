package model.items;

import model.mobs.Mobs;

public class SectumSempra extends Spell {
	private static String name = "Sectum Sempra";
	private static double attackPower= 80;
	public SectumSempra() {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean canAttack(Mobs m) {
		if(m.getName().equals("Dementor")){
			return false;
		}
		else if (m.getName().equals("Professor Snape")){
			return false;
		}
		else{
			return true;
		}
	}

}
