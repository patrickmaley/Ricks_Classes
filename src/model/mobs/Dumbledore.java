package model.mobs;

import java.util.ArrayList;

import model.interactions.Interactions;
import model.items.ExpectoPatronum;
import model.items.Spell;
import model.player.Player;

public class Dumbledore extends Mobs{

	private String house;
	private Spell mySpell = new ExpectoPatronum();

	public Dumbledore() {
		super("Head Master Dumbledore", 1000, "Its head master Dumbledore, I wonder what he could teach us?");
		this.house = "Gryffindor";
	}
	public String getForLookDescription(){
		return " Head Master Dumbledore looks like hes been waiting for you!";
	}
	@Override
	public boolean canBeAttacked() {
		return false;
	}

	public String getHouse() {
		return this.house;
	}

	@Override
	public String action(String command, Player p) {
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}

		if(command.compareTo("talk") == 0){
			ArrayList a = p.getKnownSpells();
			if(!a.contains(mySpell)){
				p.addKnownSpells(mySpell);
				return "Ahh here to get more knowledge?\n Here learn this new spell to help you in your journeys.\n"
						+ "Professor Dumbledore teaches you teh Expecto Patronum spell!";
			}
			return "Ahh here to get more knowledge? Sorry you already know what I can teach you";
		}
		return "Is that all?";
	}

	@Override
	public void move() {		
	}

}