package model.items;
import java.util.Random;
public class Spellbook extends Item{
	//create spell when creating spellbooks 
	private Spell mySpell;
	public Spellbook(Spell s){
		super("Spellbook", "Tool");
		this.mySpell=s;
	}
	public Spell getSpell(){
	return this.mySpell;
}
	@Override
	public void use() {
		String name = this.mySpell.getName();
		double power = this.mySpell.getAttackPower();
		System.out.println("You now know how to use "+ name);
		System.out.println("It does this much damage: " + power + " hp");
	}
}
