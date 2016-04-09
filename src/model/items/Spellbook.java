package model.items;
import java.util.Random;
import model.player.Player;
public class Spellbook extends Item{
	private Spell mySpell;
	private String spell;
	private String description;
	public Spellbook(Spell s){
		super("Spellbook");
		this.mySpell=s;
		description = "With this you will gain knowledge. You learn how to perform a spell";
	}
	public Spell getSpell(){
	return this.mySpell;
}
	@Override
	public String use(Player p) {
		String returner = "";
		String name = this.mySpell.getName();
		double power = this.mySpell.getAttackPower();
		p.addKnownSpells(mySpell);
		returner="You now know how to use "+ name + "\n"+ "It does this much damage: " + power + " AP";
		return returner;
	}
	@Override
	public String getDescription() {
		return null;
	}
}
