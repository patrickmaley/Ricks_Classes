package model.mobs;

import model.interactions.Interactions;

public class Centaurs extends Mobs {

	private int hp;
	private String name;
	private String description;
	private double attackPower;

	public Centaurs(String name, int hp, int x, int y) {
		super(name, hp, "It's a centaurs, half man, half horse, fully majestic.", x, y);
		this.attackPower = 17;
	}

	public double getAttackPower() {
		return this.attackPower;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean canBeAttacked() {
		return true;
	}

	@Override
	public String action(String command) {
		if (command.compareTo("talk") == 0) {
			return "";
		}
		if (command.compareTo("attack") == 0) {
			return "";
		}
		if (command.compareTo("look") == 0) {
			return this.getDescription();
		}
		return null;
	}

	@Override
	public void move() {
		int x = 0;
		if (x == 0) {
			if (this.getRoom().getNextRoom("north") != null && this.getRoom().getNextRoom("north").getMobsPresent()) {
				this.setYpos(this.getYpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("north"));
				this.getRoom().setMobsPresent(true);
				x++;
			}
		} else if (x == 1) {
			if (this.getRoom().getNextRoom("south") != null && this.getRoom().getNextRoom("south").getMobsPresent()) {
				this.setYpos(this.getYpos() - 1);
				this.getRoom().setMobsPresent(false);
				this.setCurrentRoom(this.getRoom().getNextRoom("south"));
				this.getRoom().setMobsPresent(true);
				x = 0;
			}
		}
	}

}