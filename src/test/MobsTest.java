package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.mobs.Snape;
import model.mobs.mobs;
import model.mobs.ordinaryWizards;

public class MobsTest {

	@Test
	public void AddOrdinaryWiztest() {
		mobs malfoy = new ordinaryWizards("Malfoy", 100, "Slytherin");
		assertEquals("Malfoy", malfoy.getName());
		assertEquals(100, malfoy.getHp());
		assertEquals("Slytherin", malfoy.getHouse());
		assertEquals("Piss off!", malfoy.action());
		assertFalse(malfoy.canBeAttacked());
		mobs ron = new ordinaryWizards("Ron", 100, "Gryffindor");
		assertEquals("Ron", ron.getName());
		assertEquals(100, ron.getHp());
		assertEquals("Gryffindor", ron.getHouse());
		assertEquals("Hey what can I help with?", ron.action());
		mobs cedric = new ordinaryWizards("Cedric", 100, "Hufflepuff");
		assertEquals("Cedric", cedric.getName());
		assertEquals(100, cedric.getHp());
		assertEquals("Hufflepuff", cedric.getHouse());
		assertEquals("Our ghost is the Fat Friar", cedric.action());
		mobs luna = new ordinaryWizards("Luna", 100, "Ravenclaw");
		assertEquals("Luna", luna.getName());
		assertEquals(100, luna.getHp());
		assertEquals("Ravenclaw", luna.getHouse());
		assertEquals("I'm smarter than you!", luna.action());
		mobs groundskeep = new ordinaryWizards("Keeper", 50, null);
		assertEquals("Keeper", groundskeep.getName());
		assertEquals(50, groundskeep.getHp());
		assertEquals(null, groundskeep.getHouse());
		assertEquals("I once belonged to a house, but then I took a spell to the knee :(", groundskeep.action());

	}

	@Test
	public void testSnape(){
		mobs snape = new Snape("Snape", 250);
		assertEquals("Snape", snape.getName());
		assertEquals(250, snape.getHp());
		assertEquals("Slytherin" , snape.getHouse());
		assertEquals("Get. Out.", snape.action());
		assertFalse(snape.canBeAttacked());
	}
}
