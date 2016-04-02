package test;
import model.items.*;
import static org.junit.Assert.*;
import org.junit.Test;
public class ItemsTest {
@Test
public void testItemandInventory(){
	Spell aK = new Spell("Avada Kedvra", 100);
	Spellbook one = new Spellbook(aK);
	assertEquals(one.getName(), "Spellbook");
	assertEquals(one.getType(), "Tool");
	Spell getting = one.getSpell();
	assertEquals(getting, aK);
	one.use();
	Spell e = new Spell("Expelliarumus", 50);
	Spell eP = new Spell("Expecto Patronum", 100);
	Spell i = new Spell("Imperio", 75);
	Spell c = new Spell("Crucio", 75);
	Spell r= new Spell("Expulso", 40);
	Spellbook two = new Spellbook(e);
	Spellbook three = new Spellbook(eP);
	Spellbook four = new Spellbook(i);
	Spellbook five = new Spellbook(c);
	Spellbook six = new Spellbook(r);
	Inventory inven = Inventory.getInstance();
	assertTrue(inven.add(one));
	assertTrue(inven.add(two));
	assertTrue(inven.add(three));
	assertTrue(inven.add(four));
	assertTrue(inven.add(five));
	String s =inven.toString();
	System.out.println(s);
	assertFalse(inven.add(six));
	inven.drop(five);
	assertTrue(inven.add(six));
}
	
}
