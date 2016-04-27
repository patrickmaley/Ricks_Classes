package test;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import model.items.*;
import model.map.Map;

import org.junit.Test;
import model.mobs.*;
import model.player.Player;
import model.room.GenericRoom;

public class MobsTest {
	public Map map;
	public Player p;
	GenericRoom[][] arrayMap;
	public void setup(){
		map =  Map.setMap();
		char[] a = {'a','b','c'};
		try {
			p = new Player("Joe", a);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arrayMap = map.getMapArray();
		p.setGameName("joe");
	}
	@Test
	public void AddOrdinaryWiztest() {
		setup();
		GenericRoom[][] arrayMap = map.getMapArray();
		OrdinaryWizards malfoy = new OrdinaryWizards("Malfoy", "Slytherin");
		assertEquals("Malfoy", malfoy.getName());
		assertEquals(100, malfoy.getHp(),.01);
		assertEquals("Slytherin", malfoy.getHouse());
		arrayMap[0][0].setMobsInRoom(malfoy);
		malfoy.setCurrentRoom(arrayMap[0][0]);
		malfoy.getRoom().getRoomDescription();
		malfoy.action("talk", p);
		malfoy.action("look", p);
		malfoy.move();
		//assertEquals("Piss off!", malfoy.action());
		assertFalse(malfoy.canBeAttacked());
		OrdinaryWizards ron = new OrdinaryWizards("Ron", "Gryffindor");
		assertEquals("Ron", ron.getName());
		assertEquals(100, ron.getHp(),.01);
		assertEquals("Gryffindor", ron.getHouse());
		ron.action("talk", p);
		arrayMap[0][1].setMobsInRoom(ron);
		ron.setCurrentRoom(arrayMap[0][1]);
		for(int i=0; i<50; i++){
			ron.move();
		}
		//assertEquals("Hey what can I help with?", ron.action());
		OrdinaryWizards cedric = new OrdinaryWizards("Cedric", "Hufflepuff");
		assertEquals("Cedric", cedric.getName());
		assertEquals(100, cedric.getHp(),.01);
		assertEquals("Hufflepuff", cedric.getHouse());
		cedric.action("talk", p);
		arrayMap[2][2].setMobsInRoom(cedric);
		cedric.setCurrentRoom(arrayMap[9][0]);
		for(int i=0; i<50; i++){
			cedric.move();
		}
		//assertEquals("Our ghost is the Fat Friar", cedric.action());
		OrdinaryWizards luna = new OrdinaryWizards("Luna", "Ravenclaw");
		assertEquals("Luna", luna.getName());
		assertEquals(100, luna.getHp(),.01);
		assertEquals("Ravenclaw", luna.getHouse());
		luna.action("talk", p);
		arrayMap[9][1].setMobsInRoom(luna);
		luna.setCurrentRoom(arrayMap[5][0]);
		luna.move();
		luna.move();
		luna.move();
		luna.move();
		luna.move();
		luna.action("", p);
		//assertEquals("I'm smarter than you!", luna.action());
		OrdinaryWizards groundskeep = new OrdinaryWizards("Keeper", "");
		assertEquals("Keeper", groundskeep.getName());
		assertEquals(100, groundskeep.getHp(),.01);
		assertEquals("I once belonged to a house, but then I took a spell to the knee :(", groundskeep.action("talk", p));
		assertEquals(groundskeep.getDescription(), groundskeep.action("look", null));
	}

	@Test
	public void testSnape(){
		setup();
		Snape snape = new Snape();
		assertEquals("Professor Snape", snape.getName());
		assertEquals(100, snape.getHp(),.01);
		assertEquals("Slytherin" , snape.getHouse());
		arrayMap[0][0].setMobsInRoom(snape);
		snape.setCurrentRoom(arrayMap[0][0]);
		assertEquals("Here take this potion a student made. Hopefully it works right.\nProfessor Snape drops a healing potion", snape.action("talk", p));
		assertEquals(snape.getDescription(), snape.action("look", p));
		assertFalse(snape.canBeAttacked());
		assertEquals(snape.action("", p), "Get out!");
		snape.getDescription();
	}
	
	@Test
	public void testBellatrix(){
		setup();
		Bellatrix bellatrix = new Bellatrix();
		assertEquals("Bellatrix", bellatrix.getName());
		assertEquals(100, bellatrix.getHp(),.01);
		assertEquals("Slytherin" , bellatrix.getHouse());
		assertEquals(35,bellatrix.getAttackPower(), 0);
		arrayMap[7][0].setMobsInRoom(bellatrix);
		bellatrix.setCurrentRoom(arrayMap[7][0]);
		bellatrix.decreaseHP(51);
		bellatrix.decreaseHP(.1);
		bellatrix.decreaseHP(.1);
		bellatrix.decreaseHP(.1);
		bellatrix.decreaseHP(.1);
		bellatrix.decreaseHP(.1);
		bellatrix.decreaseHP(.1);
		bellatrix.decreaseHP(.1);
		bellatrix.decreaseHP(.1);
		bellatrix.decreaseHP(.1);
		assertTrue(bellatrix.canBeAttacked());
		assertEquals(bellatrix.action("look", p), bellatrix.getDescription());
		assertEquals(bellatrix.action("", p), "...");
	}

	
	@Test
	public void testDementor(){
		setup();
		Dementor demon = new Dementor();
		demon.setCurrentRoom(arrayMap[9][1]);
		demon.move();
		arrayMap[2][0].setMobsInRoom(demon);
		demon.setCurrentRoom(arrayMap[9][1]);
		assertEquals("Dementor", demon.getName());
		assertEquals(100, demon.getHp(),.01);
		assertEquals(100, demon.getAttackPower(), 0);
		for(int i=0; i<100; i++){
			demon.move();
		}
		assertTrue(demon.canBeAttacked());
		assertEquals(demon.action("look", p), demon.getDescription());
		assertEquals(demon.action("...", p),demon.action("talk", p));
	}
	
	@Test
	public void testDragons(){
		setup();
		Dragons drag = new Dragons();
		assertEquals("Dragon", drag.getName());
		assertEquals(300, drag.getHp(),.01);
		assertEquals(45, drag.getAttackPower(), 0);
		assertTrue(drag.canBeAttacked());
		assertEquals(drag.action("look", p), drag.getDescription());
		drag.action("", p);
		drag.move();
	}
	
	@Test
	public void testDumbledore(){
		setup();
		Dumbledore dumbledore = new Dumbledore();
		dumbledore.move();
		assertEquals("Head Master Dumbledore", dumbledore.getName());
		assertEquals(1000, dumbledore.getHp(),.01);
		assertEquals("Gryffindor" , dumbledore.getHouse());
		assertFalse(dumbledore.canBeAttacked());
		assertEquals(dumbledore.action("look", p), dumbledore.getDescription());
		dumbledore.action("talk", p);
		//System.out.print(p.getKnownSpells().toString()); Checked, it works
		dumbledore.action("talk", p);
		dumbledore.action("", p);
	}
	
	@Test
	public void testHagrid(){
		setup();
		Hagrid hagrid = new Hagrid();
		hagrid.move();
		arrayMap[9][1].setMobsInRoom(hagrid);
		hagrid.setCurrentRoom(arrayMap[9][1]);
		assertEquals("Hagrid", hagrid.getName());
		assertEquals(100, hagrid.getHp(),.01);
		assertFalse(hagrid.canBeAttacked());
		assertEquals(hagrid.action("look", p), hagrid.getDescription());
		hagrid.action("talk", p);
		p.addKnownSpells(new Crucio());
		p.addKnownSpells(new AvadaKedvra());
		p.addKnownSpells(new PetrificusTotalus());
		p.addKnownSpells(new SectumSempra());
		p.addKnownSpells(new Stupefy());
		p.addKnownSpells(new Expulso());
		hagrid.action("talk", p);
		hagrid.action("", p);
	}
	
	@Test
	public void testLupin(){
		setup();
		Lupin lupin = new Lupin();
		lupin.move();
		arrayMap[9][1].setMobsInRoom(lupin);
		lupin.setCurrentRoom(arrayMap[9][1]);
		assertEquals("Lupin", lupin.getName());
		assertEquals(100, lupin.getHp(),.01);
		lupin.decreaseHP(50);
		lupin.decreaseHP(100);
		assertEquals("Gryffindor" , lupin.getHouse());
		assertTrue(lupin.canBeAttacked());
		assertEquals(lupin.getDescription(), lupin.action("look", p));
		lupin.action("talk", p);
		lupin.action("", p);
	}
	
	@Test
	public void testMcGonagall(){
		McGonagall mcgonagall = new McGonagall();
		assertEquals("Professor McGonagall", mcgonagall.getName());
		assertEquals(100, mcgonagall.getHp(),.01);
		assertEquals("Gryffindor" , mcgonagall.getHouse());
		//assertEquals("Get. Out.", snape.action());
		assertFalse(mcgonagall.canBeAttacked());
		mcgonagall.getDescription();
	}
	
	@Test
	public void testSirius(){
		setup();
		Sirius sirius = new Sirius();
		arrayMap[8][1].setMobsInRoom(sirius);
		sirius.setCurrentRoom(arrayMap[8][1]);
		for(int i=0; i<100; i++){
			sirius.move();
		}
		assertEquals("Sirius Black", sirius.getName());
		assertFalse(sirius.isPadfoot());
		assertEquals(sirius.action("look", p),sirius.getDescription());
		assertEquals(100, sirius.getHp(),.01);
		assertEquals("Gryffindor" , sirius.getHouse());
		sirius.action("talk", p);
		assertTrue(sirius.isPadfoot());
		sirius.action("look", p);
		//assertEquals("Get. Out.", snape.action());
		assertFalse(sirius.canBeAttacked());
		sirius.getDescription();
	}
	
	@Test
	public void testSpiders(){
		setup();
		Spiders spid = new Spiders();
		arrayMap[5][2].setMobsInRoom(spid);
		spid.setCurrentRoom(arrayMap[5][2]);
		for(int i=0; i<100; i++){
			spid.move();
		}
		assertEquals("Spider a.k.a Erics favorite", spid.getName());
		assertEquals(50, spid.getHp(),.01);
		assertEquals(10, spid.getAttackPower(), 0);
		assertTrue(spid.canBeAttacked());
		assertEquals(spid.action("look", p), spid.getDescription());
		spid.action("", p);
		spid.action("talk", p);
	}
	
	@Test
	public void testTrolls(){
		setup();
		Trolls trogdor = new Trolls();
		arrayMap[8][1].setMobsInRoom(trogdor);
		trogdor.setCurrentRoom(arrayMap[8][1]);
		for(int i=0; i<20; i++){
			trogdor.move();
		}
		assertEquals("Troll", trogdor.getName());
		assertEquals(100, trogdor.getHp(),.01);
		assertEquals(25, trogdor.getAttackPower(), 0);
		assertTrue(trogdor.canBeAttacked());
		assertEquals(trogdor.getDescription(), trogdor.action("look", p));
		trogdor.decreaseHP(50);
		assertTrue(trogdor.getHp() == 50);
	}
	
	@Test
	public void testWerewolves(){
		setup();
		Werewolves wuf = new Werewolves();
		arrayMap[8][1].setMobsInRoom(wuf);
		wuf.setCurrentRoom(arrayMap[4][0]);
		for(int i=0; i<20; i++){
			wuf.move();
		}
		assertEquals("Werewolf", wuf.getName());
		assertEquals(75, wuf.getHp(),.01);
		assertEquals(20, wuf.getAttackPower(), 0);
		assertTrue(wuf.canBeAttacked());
		assertEquals(wuf.getDescription(), wuf.action("look", p));
		wuf.action("", p);
		wuf.action("talk", p);
	}
}