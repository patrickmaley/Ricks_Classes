package test;

import static org.junit.Assert.*;
import model.items.*;
import org.junit.Test;
import model.mobs.*;

public class MobsTest {
	@Test
	public void AddOrdinaryWiztest() {
		OrdinaryWizards malfoy = new OrdinaryWizards("Malfoy", 100, "Slytherin",0,0);
		assertEquals("Malfoy", malfoy.getName());
		assertEquals(100, malfoy.getHp());
		assertEquals("Slytherin", malfoy.getHouse());
		//assertEquals("Piss off!", malfoy.action());
		assertFalse(malfoy.canBeAttacked());
		OrdinaryWizards ron = new OrdinaryWizards("Ron", 100, "Gryffindor", 0, 1);
		assertEquals("Ron", ron.getName());
		assertEquals(100, ron.getHp());
		assertEquals("Gryffindor", ron.getHouse());
		//assertEquals("Hey what can I help with?", ron.action());
		OrdinaryWizards cedric = new OrdinaryWizards("Cedric", 100, "Hufflepuff", 0, 2);
		assertEquals("Cedric", cedric.getName());
		assertEquals(100, cedric.getHp());
		assertEquals("Hufflepuff", cedric.getHouse());
		//assertEquals("Our ghost is the Fat Friar", cedric.action());
		OrdinaryWizards luna = new OrdinaryWizards("Luna", 100, "Ravenclaw", 0 , 3);
		assertEquals("Luna", luna.getName());
		assertEquals(100, luna.getHp());
		assertEquals("Ravenclaw", luna.getHouse());
		//assertEquals("I'm smarter than you!", luna.action());
		OrdinaryWizards groundskeep = new OrdinaryWizards("Keeper", 50,null, 0, 4);
		assertEquals("Keeper", groundskeep.getName());
		assertEquals(50, groundskeep.getHp());
		assertEquals(null, groundskeep.getHouse());
		//assertEquals("I once belonged to a house, but then I took a spell to the knee :(", groundskeep.action());
		groundskeep.getDescription();
	}

	@Test
	public void testSnape(){
		Snape snape = new Snape("Snape", 250, 0, 0);
		assertEquals("Professor Snape", snape.getName());
		assertEquals(250, snape.getHp());
		assertEquals("Slytherin" , snape.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(snape.canBeAttacked());
		snape.getDescription();
	}
	
	@Test
	public void testBellatrix(){
		Bellatrix bellatrix = new Bellatrix("", 250, 0,0);
		assertEquals("Bellatrix", bellatrix.getName());
		assertEquals(250, bellatrix.getHp());
		assertEquals("Slytherin" , bellatrix.getHouse());
		assertEquals(35,bellatrix.getAttackPower(), 0);
		//assertEquals("Get. Out.", snape.action());
		assertTrue(bellatrix.canBeAttacked());
		bellatrix.getDescription();
	}
	
	@Test
	public void testCentaurs(){
		Centaurs cent = new Centaurs("Cent", 250, 0, 0);
		assertEquals("Cent", cent.getName());
		assertEquals(250, cent.getHp());
		assertEquals(17, cent.getAttackPower(), 0);
		assertTrue(cent.canBeAttacked());
		cent.getDescription();
		cent.decreaseHP(50);
		assertEquals(200, cent.getHp());
	}
	
	@Test
	public void testDementor(){
		Dementor demon = new Dementor("Demon", 100, 0,0);
		assertEquals("Demon", demon.getName());
		assertEquals(100, demon.getHp());
		assertEquals(100, demon.getAttackPower(), 0);
		//assertEquals("Get. Out.", snape.action());
		assertTrue(demon.canBeAttacked());
		demon.getDescription();
	}
	
	@Test
	public void testDobby(){
		Dobby dobby = new Dobby("", 50, 0, 0);
		assertEquals("Dobby", dobby.getName());
		assertEquals(50, dobby.getHp());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(dobby.canBeAttacked());
		dobby.getDescription();
	}
	
	@Test
	public void testDragons(){
		Dragons drag = new Dragons("drag", 500, 0,0);
		assertEquals("drag", drag.getName());
		assertEquals(500, drag.getHp());
		assertEquals(45, drag.getAttackPower(), 0);
		assertTrue(drag.canBeAttacked());
		drag.getDescription();
	}
	
	@Test
	public void testDumbledore(){
		Dumbledore dumbledore = new Dumbledore("", 250, 0,0);
		assertEquals("Head Master Dumbledore", dumbledore.getName());
		assertEquals(250, dumbledore.getHp());
		assertEquals("Gryffindor" , dumbledore.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(dumbledore.canBeAttacked());
		dumbledore.getDescription();
	}
	
	@Test
	public void testGiants(){
		Giants big = new Giants("Big", 300,0,0);
		assertEquals("Big", big.getName());
		assertEquals(300, big.getHp());
		assertEquals(25, big.getAttackPower(), 0);
		assertTrue(big.canBeAttacked());
		big.getDescription();
	}
	
	@Test
	public void testGoblins(){
		Goblins gob = new Goblins("Gob", 100, 0, 0);
		assertEquals("Gob", gob.getName());
		assertEquals(100, gob.getHp());
		assertEquals(10, (gob).getAttackPower(), 0);
		assertEquals(0, gob.getXpos());
		assertEquals(0, gob.getYpos());
		//assertEquals("Get. Out.", snape.action());
		assertTrue(gob.canBeAttacked());
		gob.getDescription();
	}
	
	@Test
	public void testHagrid(){
		Hagrid hagrid = new Hagrid("Hagrid", 300,0,0);
		assertEquals("Hagrid", hagrid.getName());
		assertEquals(300, hagrid.getHp());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(hagrid.canBeAttacked());
		hagrid.getDescription();
	}
	
	@Test
	public void testLupin(){
		Lupin lupin = new Lupin("Lupin", 200,0,0);
		assertEquals("Lupin", lupin.getName());
		assertEquals(200, lupin.getHp());
		assertEquals("Gryffindor" , lupin.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(lupin.canBeAttacked());
		lupin.getDescription();
	}
	
	@Test
	public void testMcGonagall(){
		McGonagall mcgonagall = new McGonagall("Professor McGonagall", 200,0,0);
		assertEquals("Professor McGonagall", mcgonagall.getName());
		assertEquals(200, mcgonagall.getHp());
		assertEquals("Gryffindor" , mcgonagall.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(mcgonagall.canBeAttacked());
		mcgonagall.getDescription();
	}
	
	@Test
	public void testSirius(){
		Sirius sirius = new Sirius("Sirius", 100,0,0);
		assertEquals("Sirius Black", sirius.getName());
		assertEquals(100, sirius.getHp());
		assertEquals("Gryffindor" , sirius.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(sirius.canBeAttacked());
		sirius.getDescription();
	}
	
	@Test
	public void testSpiders(){
		Spiders spid = new Spiders("Spid", 100,0,0);
		assertEquals("Spid", spid.getName());
		assertEquals(100, spid.getHp());
		assertEquals(10, spid.getAttackPower(), 0);
		assertTrue(spid.canBeAttacked());
		spid.getDescription();
	}
	
	@Test
	public void testTrolls(){
		Trolls trogdor = new Trolls("Trogdor", 350,0,0);
		assertEquals("Trogdor", trogdor.getName());
		assertEquals(350, trogdor.getHp());
		assertEquals(25, trogdor.getAttackPower(), 0);
		assertTrue(trogdor.canBeAttacked());
		trogdor.getDescription();
	}
	
	@Test
	public void testWerewolves(){
		Werewolves wuf = new Werewolves("Wuf", 100,0,0);
		assertEquals("Wuf", wuf.getName());
		assertEquals(100, wuf.getHp());
		assertEquals(20, wuf.getAttackPower(), 0);
		assertTrue(wuf.canBeAttacked());
		wuf.getDescription();
	}
}