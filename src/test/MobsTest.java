package test;

import static org.junit.Assert.*;
import model.items.*;
import org.junit.Test;
import model.mobs.*;
import model.mobs.OrdinaryWizards;

public class MobsTest {
	@Test
	public void AddOrdinaryWiztest() {
		Mobs malfoy = new OrdinaryWizards("Malfoy", 100, "Slytherin");
		assertEquals("Malfoy", malfoy.getName());
		assertEquals(100, malfoy.getHp());
		assertEquals("Slytherin", malfoy.getHouse());
		//assertEquals("Piss off!", malfoy.action());
		assertFalse(malfoy.canBeAttacked());
		Mobs ron = new OrdinaryWizards("Ron", 100, "Gryffindor");
		assertEquals("Ron", ron.getName());
		assertEquals(100, ron.getHp());
		assertEquals("Gryffindor", ron.getHouse());
		//assertEquals("Hey what can I help with?", ron.action());
		Mobs cedric = new OrdinaryWizards("Cedric", 100, "Hufflepuff");
		assertEquals("Cedric", cedric.getName());
		assertEquals(100, cedric.getHp());
		assertEquals("Hufflepuff", cedric.getHouse());
		//assertEquals("Our ghost is the Fat Friar", cedric.action());
		Mobs luna = new OrdinaryWizards("Luna", 100, "Ravenclaw");
		assertEquals("Luna", luna.getName());
		assertEquals(100, luna.getHp());
		assertEquals("Ravenclaw", luna.getHouse());
		//assertEquals("I'm smarter than you!", luna.action());
		Mobs groundskeep = new OrdinaryWizards("Keeper", 50, null);
		assertEquals("Keeper", groundskeep.getName());
		assertEquals(50, groundskeep.getHp());
		assertEquals(null, groundskeep.getHouse());
		//assertEquals("I once belonged to a house, but then I took a spell to the knee :(", groundskeep.action());
		groundskeep.getDescription();
	}

	@Test
	public void testSnape(){
		Mobs snape = new Snape("Snape", 250);
		assertEquals("Professor Snape", snape.getName());
		assertEquals(250, snape.getHp());
		assertEquals("Slytherin" , snape.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(snape.canBeAttacked());
		snape.getDescription();
	}
	
	@Test
	public void testBellatrix(){
		Mobs bellatrix = new Bellatrix("", 250);
		assertEquals("Bellatrix", bellatrix.getName());
		assertEquals(250, bellatrix.getHp());
		assertEquals("Slytherin" , bellatrix.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertTrue(bellatrix.canBeAttacked());
		bellatrix.getDescription();
	}
	
	@Test
	public void testCentaurs(){
		Mobs cent = new Centaurs("Cent", 250);
		assertEquals("Cent", cent.getName());
		assertEquals(250, cent.getHp());
		assertEquals("none" , cent.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertTrue(cent.canBeAttacked());
		cent.getDescription();
	}
	
	@Test
	public void testDementor(){
		Mobs demon = new Dementor("Demon", 100);
		assertEquals("Demon", demon.getName());
		assertEquals(100, demon.getHp());
		assertEquals("none" , demon.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertTrue(demon.canBeAttacked());
		demon.getDescription();
	}
	
	@Test
	public void testDobby(){
		Mobs dobby = new Dobby("", 50);
		assertEquals("Dobby", dobby.getName());
		assertEquals(50, dobby.getHp());
		assertEquals("none" , dobby.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(dobby.canBeAttacked());
		dobby.getDescription();
	}
	
	@Test
	public void testDragons(){
		Mobs drag = new Dragons("drag", 500);
		assertEquals("drag", drag.getName());
		assertEquals(500, drag.getHp());
		assertEquals("none" , drag.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertTrue(drag.canBeAttacked());
		drag.getDescription();
	}
	
	@Test
	public void testDumbledore(){
		Mobs dumbledore = new Dumbledore("", 250);
		assertEquals("Head Master Dumbledore", dumbledore.getName());
		assertEquals(250, dumbledore.getHp());
		assertEquals("Gryffindor" , dumbledore.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(dumbledore.canBeAttacked());
		dumbledore.getDescription();
	}
	
	@Test
	public void testGiants(){
		Mobs big = new Giants("Big", 300);
		assertEquals("Big", big.getName());
		assertEquals(300, big.getHp());
		assertEquals("none" , big.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertTrue(big.canBeAttacked());
		big.getDescription();
	}
	
	@Test
	public void testGoblins(){
		Mobs gob = new Goblins("Gob", 100);
		assertEquals("Gob", gob.getName());
		assertEquals(100, gob.getHp());
		assertEquals("none" , gob.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertTrue(gob.canBeAttacked());
		gob.getDescription();
	}
	
	@Test
	public void testHagrid(){
		Mobs hagrid = new Hagrid("Hagrid", 300);
		assertEquals("Hagrid", hagrid.getName());
		assertEquals(300, hagrid.getHp());
		assertEquals("none" , hagrid.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(hagrid.canBeAttacked());
		hagrid.getDescription();
	}
	
	@Test
	public void testLupin(){
		Mobs lupin = new Lupin("Lupin", 200);
		assertEquals("Lupin", lupin.getName());
		assertEquals(200, lupin.getHp());
		assertEquals("Gryffindor" , lupin.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(lupin.canBeAttacked());
		lupin.getDescription();
	}
	
	@Test
	public void testMcGonagall(){
		Mobs mcgonagall = new McGonagall("Professor McGonagall", 200);
		assertEquals("Professor McGonagall", mcgonagall.getName());
		assertEquals(200, mcgonagall.getHp());
		assertEquals("Gryffindor" , mcgonagall.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(mcgonagall.canBeAttacked());
		mcgonagall.getDescription();
	}
	
	@Test
	public void testSirius(){
		Mobs sirius = new Sirius("Sirius", 100);
		assertEquals("Sirius Black", sirius.getName());
		assertEquals(100, sirius.getHp());
		assertEquals("Gryffindor" , sirius.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(sirius.canBeAttacked());
		sirius.getDescription();
	}
	
	@Test
	public void testSpiders(){
		Mobs spid = new Spiders("Spid", 100);
		assertEquals("Spid", spid.getName());
		assertEquals(100, spid.getHp());
		assertEquals("none" , spid.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertTrue(spid.canBeAttacked());
		spid.getDescription();
	}
	
	@Test
	public void testTrolls(){
		Mobs trogdor = new Trolls("Trogdor", 350);
		assertEquals("Trogdor", trogdor.getName());
		assertEquals(350, trogdor.getHp());
		assertEquals("none" , trogdor.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertTrue(trogdor.canBeAttacked());
		trogdor.getDescription();
	}
	
	@Test
	public void testWerewolves(){
		Mobs wuf = new Werewolves("Wuf", 100);
		assertEquals("Wuf", wuf.getName());
		assertEquals(100, wuf.getHp());
		assertEquals("none" , wuf.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertTrue(wuf.canBeAttacked());
		wuf.getDescription();
	}
}
