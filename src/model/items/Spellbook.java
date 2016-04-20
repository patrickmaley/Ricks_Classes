package model.items;
import java.io.Serializable;
import java.util.Random;
import model.player.Player;
public class Spellbook extends Item{
	private Spell mySpell;
	private String spell;
	public Spellbook(Spell s){
		super("Spellbook", "With this you will gain knowledge. You learn how to perform a spell");
		this.mySpell=s;
	}
	public Spell getSpell(){
	return this.mySpell;
}
	@Override
	public String use(Player p, String notNeeded) {
		String returner = "";
		String name = this.mySpell.getName();
		double power = this.mySpell.getAttackPower();
		p.addKnownSpells(mySpell);
		returner="You now know how to use "+ name + "\n"+ "It does this much damage: " + power + " AP";
		return returner;
	}
}
