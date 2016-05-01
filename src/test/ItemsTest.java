package test;
import model.player.Player;
import model.room.GenericRoom;
import model.items.*;
import model.map.Map;
import model.mobs.Bellatrix;
import model.mobs.Dementor;
import model.mobs.OrdinaryWizards;
import model.mobs.Snape;
import model.mobs.Spiders;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.junit.Test;
public class ItemsTest {
	
	public Map map;
	public Player p;
	GenericRoom[][] arrayMap;
	public void setup(){
		map =  Map.setMap();
		char[] a = {'a','b','c'};
		try {
			p = new Player("Joe", a);
		} catch (NoSuchAlgorithmException e) {
		} catch (NoSuchProviderException e) {
		}
		arrayMap = map.getMapArray();
		p.setGameName("player");
		arrayMap[5][1].setPlayerPresent(true, p);
		p.setCurrentRoom(arrayMap[5][1]);
		p.addKnownSpells(avadaKedvra);
	}
	
private String get = "get";
private String look = "look";
private String commands = "commands";
private String who = "who";
private String say = "say";
private String tell = "tell";
private String info = "score";
private String give = "give";
private String take = "take";
private String inventory = "inventory";
private String drop = "drop";
private String use = "use";
private String quit = "quit";
// all the things in the models.item package
private Spell avadaKedvra = new AvadaKedvra();
private Spell expelliarumus = new Expelliarumus();
private Spell expectoPatronum = new ExpectoPatronum();
private Spell imperio = new Imperio();
private Spell crucio = new Crucio();
private Spell expluso= new Expulso();
private Spell incendio = new Incendio();
private Spell petrificusTotalus = new PetrificusTotalus();
private Spell sectumSempra = new SectumSempra();
private Spell stupefy = new Stupefy();
private Spellbook sbOne = new Spellbook(avadaKedvra);
private Spellbook sbTwo = new Spellbook(expelliarumus);
private Spellbook sbThree = new Spellbook(expectoPatronum);
private Spellbook sbFour = new Spellbook(imperio);
private Spellbook sbFive = new Spellbook(crucio);
private Spellbook sbSix = new Spellbook(expluso);
private Spellbook sbSeven = new Spellbook(incendio);
private Spellbook sbEight = new Spellbook(petrificusTotalus);
private Spellbook sbNine = new Spellbook(sectumSempra);
private Spellbook sbTen = new Spellbook(stupefy);
private BassilskFang bassilskFang = new BassilskFang();
private Broomstick broomstick = new Broomstick();
private PhoenixTears phoenixTears = new PhoenixTears();
private ElderWand elderWand = new ElderWand();
private Horcrux horcrux = new Horcrux();
private MaurdersMap maurdersMap = new MaurdersMap();
private NeverEndingBook neverEndingBook = new NeverEndingBook(); 
private RegularWand regularWand = new RegularWand();
private SwordOfGryffindor swordOfGryffindor = new SwordOfGryffindor();
private HermoinesHandbag hermoinesHandbag = new HermoinesHandbag();
private RessurectionStone ressurectionStone = new RessurectionStone();
private ButterBeer butterBeer = new ButterBeer();
private HealingPotion healingPotion = new HealingPotion();
private DependencyInjectionSword dependencyInjectionSword = new DependencyInjectionSword();
private Snape snape = new Snape();
private Dementor dementor = new Dementor(); 
private Bellatrix bellatrix = new Bellatrix();
private OrdinaryWizards ordinaryWizard = new OrdinaryWizards("ordinary", "syltherin"); 

@Test
public void testSpells(){
	avadaKedvra.putInBook();
	assertEquals(avadaKedvra.getAttackPower(), 100,.01);
	assertTrue(avadaKedvra.getStatus());
	assertEquals(avadaKedvra.getName(), "Avada Kedvra");
	assertTrue(avadaKedvra.canAttack(snape));
	assertFalse(avadaKedvra.canAttack(dementor));
	//
	expelliarumus.putInBook();
	assertEquals(expelliarumus.getAttackPower(), 15,.01);
	assertTrue(expelliarumus.getStatus());
	assertEquals(expelliarumus.getName(), "Expelliarumus");
	assertTrue(expelliarumus.canAttack(snape));
	assertFalse(expelliarumus.canAttack(dementor));
	//
	expectoPatronum.putInBook();
	assertEquals(expectoPatronum.getAttackPower(), 100,.01);
	assertTrue(expectoPatronum.getStatus());
	assertEquals(expectoPatronum.getName(), "Expecto Patronum");
	assertFalse(expectoPatronum.canAttack(snape));
	assertTrue(expectoPatronum.canAttack(dementor));
	//
	imperio.putInBook();
	assertEquals(imperio.getAttackPower(), 40,.01);
	assertTrue(imperio.getStatus());
	assertEquals(imperio.getName(), "Imperio");
	assertTrue(imperio.canAttack(snape));
	assertFalse(imperio.canAttack(dementor));
	//
	crucio.putInBook();
	assertEquals(crucio.getAttackPower(), 50,.01);
	assertTrue(crucio.getStatus());
	assertEquals(crucio.getName(), "Crucio");
	assertTrue(crucio.canAttack(snape));
	assertFalse(crucio.canAttack(dementor));
	//
	expluso.putInBook();
	assertEquals(expluso.getAttackPower(), 20,.01);
	assertTrue(expluso.getStatus());
	assertEquals(expluso.getName(), "Expulso");
	assertTrue(expluso.canAttack(snape));
	assertFalse(expluso.canAttack(dementor));
	//
	incendio.putInBook();
	assertEquals(incendio.getAttackPower(), 10,.01);
	assertTrue(incendio.getStatus());
	assertEquals(incendio.getName(), "Incendio");
	assertTrue(incendio.canAttack(snape));
	assertFalse(incendio.canAttack(dementor));
	//
	petrificusTotalus.putInBook();
	assertEquals(petrificusTotalus.getAttackPower(), 15,.01);
	assertTrue(petrificusTotalus.getStatus());
	assertEquals(petrificusTotalus.getName(), "Petrificus Totalus");
	assertTrue(petrificusTotalus.canAttack(snape));
	assertFalse(petrificusTotalus.canAttack(dementor));
	//
	sectumSempra.putInBook();
	assertEquals(sectumSempra.getAttackPower(), 80,.01);
	assertTrue(sectumSempra.getStatus());
	assertEquals(sectumSempra.getName(), "Sectum Sempra");
	assertFalse(sectumSempra.canAttack(snape));
	assertFalse(sectumSempra.canAttack(dementor));
	assertTrue(sectumSempra.canAttack(ordinaryWizard));
	//
	stupefy.putInBook();
	assertEquals(stupefy.getAttackPower(), 30,.01);
	assertTrue(stupefy.getStatus());
	assertEquals(stupefy.getName(), "Stupefy");
	assertTrue(stupefy.canAttack(snape));
	assertFalse(stupefy.canAttack(dementor));
	//
	assertEquals(sbOne.getSpell(), avadaKedvra);
}	

@Test
public void testItems(){
	setup();	
	Spiders spid = new Spiders();
	arrayMap[5][1].setMobsInRoom(spid);
	
	
	spid.setCurrentRoom(arrayMap[5][1]);
	assertEquals(broomstick.getName(), "Broomstick");
	String d1 = broomstick.getDescription();
	System.out.println(d1);
	//
	assertEquals(bassilskFang.getName(), "Bassilsk Fang");
	String d2 = bassilskFang.getDescription();
	bassilskFang.use(this.p, "");
	System.out.println(d2);
	//
	assertEquals(maurdersMap.getName(), "Maurders Map");
	String m1 = maurdersMap.getForLookDescription();
	System.out.println(m1);
	//
	assertEquals(butterBeer.getName(), "Butter Beer");
	String d3 = butterBeer.getDescription();
	System.out.println(d3);
	//
	assertEquals(phoenixTears.getName(), "Phoenix Tears");
	String d4 = phoenixTears.getDescription();
	System.out.println(d4);
	//
	assertEquals(elderWand.getName(), "Elder Wand");
	String d5 = elderWand.getDescription();
	elderWand.use(p, "avada kedvra");
	System.out.println(d5);
	//
	assertEquals(healingPotion.getName(), "Healing Potion");
	String d6 = healingPotion.getDescription();
	System.out.println(d6);
	//
	assertEquals(hermoinesHandbag.getName(), "Hermoines Handbag");
	String d7 = hermoinesHandbag.getDescription();
    System.out.println(d7);
	//
	assertEquals(horcrux.getName(), "Horcrux");
	String d8 = horcrux.getDescription();
	System.out.println(d8);
	//
	assertEquals(maurdersMap.getName(), "Maurders Map");
	String d9 = maurdersMap.getDescription();
	System.out.println(d9);
	//
	assertEquals(neverEndingBook.getName(), "Neverending Book");
	String d10 = neverEndingBook.getDescription();
	System.out.println(d10);
	//
	Spiders spid1 = new Spiders();
	arrayMap[5][1].setMobsInRoom(spid1);
	
	
	spid1.setCurrentRoom(arrayMap[5][1]);
	assertEquals(regularWand.getName(), "Regular Wand");
	String d11 = regularWand.getDescription();
	regularWand.use(p, "avada kedvra");
	System.out.println(d11);
	//
	assertEquals(ressurectionStone.getName(), "Ressurection Stone");
	String d12 = ressurectionStone.getDescription();
	System.out.println(d12);
	//
	assertEquals(sbOne.getName(), "Spellbook");
	String d13 = sbOne.getDescription();
	System.out.println(d13);
	//
	assertEquals(dependencyInjectionSword.getName(), "DependencyInjection Sword");
	String d14 = dependencyInjectionSword.getDescription();
	System.out.println(d14);
	//
	assertEquals(swordOfGryffindor.getName(), "Sword of Gryffindor");
	String d15 = swordOfGryffindor.getDescription();
	System.out.println(d15);
	//
	for(int i=0; i<100; i++){
		broomstick.use(p, "");
	}

}

@Test 
public void testInventory() throws NoSuchAlgorithmException, NoSuchProviderException{
	char [] password = new char ['p'];
	Player p = new Player("Player", password);
	p.setGameName("fucktard");
	Inventory inventory = p.getInventory();
	assertFalse(inventory.drop("horcrux"));
	inventory.add(horcrux);
	inventory.add(sbOne);
	inventory.add(hermoinesHandbag);
	inventory.add(healingPotion);
	inventory.add(elderWand);
	assertFalse(inventory.add(swordOfGryffindor));
	String usingSpellBook=sbOne.use(p, null);
	System.out.println(usingSpellBook);
	inventory.drop("horcrux");
	assertEquals(null, inventory.getItem("horcrux"));
	hermoinesHandbag.use(p,null);
	assertTrue(inventory.add(broomstick));
	assertTrue(inventory.add(butterBeer));
	System.out.println(inventory.toString());
	String usinghP = healingPotion.use(p,null);
	System.out.println(usinghP);
	p.decreaseHP(10);
	usinghP = healingPotion.use(p, null);
	System.out.println(usinghP);
	String usingbBeer = butterBeer.use(p,null);
	System.out.println(usingbBeer);
	inventory.add(dependencyInjectionSword);
	System.out.println(dependencyInjectionSword.use(p,null));
	assertTrue(inventory.add(ressurectionStone));
	System.out.println(ressurectionStone.use(p,null));
}

@Test 
public void testItemsWithCommands() throws NoSuchAlgorithmException, NoSuchProviderException{
	setup();
	
	 Spiders spider = new Spiders();
	 arrayMap[5][1].setMobsInRoom(spider);
	 spider.setCurrentRoom(arrayMap[5][1]);
	 p.setCurrentRoom(arrayMap[5][1]);
	 p.getInventory().add(this.regularWand);
	 System.out.println(p.performAction("use regular wand"));
	 System.out.println(p.performAction("drop regular wand"));
	 p.getInventory().add(this.swordOfGryffindor);
	 p.getInventory().add(this.bassilskFang);
	 p.getInventory().add(this.butterBeer);
	 p.getInventory().add(this.phoenixTears);
	 p.getInventory().add(this.horcrux);
	 System.out.println(p.performAction(info));
	 System.out.println(p.performAction("use horcrux"));
	 System.out.println(p.performAction("use sword of griffyndor"));
	 System.out.println(p.performAction("use bassilsk fang"));
	 System.out.println(p.performAction("use butter beer"));
	 System.out.println(p.performAction("use phoenix tears"));
	 System.out.println(p.performAction("drop butter beer"));
	 p.getInventory().add(elderWand);
	 System.out.println(p.performAction("use elder wand"));
	 System.out.println(p.performAction(info));
	 System.out.println(p.performAction(commands));
	 p.getInventory().add(healingPotion);
	 p.getInventory().add(neverEndingBook);
	 System.out.println(spider.getDescription());
	 System.out.println(p.performAction("look Spider"));
	 System.out.println(p.performAction("use healing potion"));
	 System.out.println(p.performAction("use never ending book"));
	 System.out.println(p.performAction(info));
	 System.out.println(p.getRoom().getRoomDescription());
	 System.out.println(p.performAction("drop bassilsk fang"));
	 System.out.println(p.getInventory().getInventorySize());
	 System.out.println(p.getInventory().add(this.broomstick));
	 System.out.println(p.performAction("use broomstick"));
	 p.performAction("look");	 
	 p.performAction("up");
	 p.performAction("down");
	 p.performAction("north");
	 p.performAction("south");
	 p.performAction("east");
	 p.performAction("west");
	 p.performAction("take potion");
	 p.performAction("inventory");
	 p.performAction("use dependency");
	 p.performAction("who");
	 p.performAction("say");
	 p.performAction("tell");
	 p.performAction("give");
}

@Test
public void testUseMaurdersMap(){
	setup();
	p.setPlayerMap(map);
	String allRoomStrings = "";
	GenericRoom[][] allRooms = arrayMap;
	for (int i = 0; i < allRooms.length; i++) {
		for (int j = 0; j < allRooms[0].length; j++) {
			allRoomStrings += allRooms[i][j].getTitle() + "\n";
			allRoomStrings += allRooms[i][j].getItemsToString() + "\n";
		}
	}
	System.out.println(allRoomStrings);
	String mapString = maurdersMap.use(p, null);
	//assertEquals(mapString, allRoomStrings);
}

@Test
public void testForLookDescriptions(){
	System.out.println(ressurectionStone.getForLookDescription());
	System.out.println(phoenixTears.getForLookDescription());
	System.out.println(neverEndingBook.getForLookDescription());
	System.out.println(horcrux.getForLookDescription());
	System.out.println(hermoinesHandbag.getForLookDescription());
	System.out.println(dependencyInjectionSword.getForLookDescription());
	System.out.println(butterBeer.getForLookDescription());
	System.out.println(broomstick.getForLookDescription());
	System.out.println(sbOne.getForLookDescription());
	System.out.println(bassilskFang.getForLookDescription());
	System.out.println(healingPotion.getForLookDescription());
	System.out.println(swordOfGryffindor.getForLookDescription());
	System.out.println(elderWand.getForLookDescription());
	System.out.println(regularWand.getForLookDescription());
}

@Test
public void testAttackItems(){
	setup();
	p.setPlayerMap(map);
	arrayMap[5][1].setPlayerPresent(false, p);
	p.setCurrentRoom(arrayMap[9][0]);
	p.addKnownSpells(expelliarumus);
	arrayMap[9][0].setPlayerPresent(true, p);
	System.out.println(swordOfGryffindor.use(p, ""));
	System.out.println(bassilskFang.use(p, ""));
	System.out.println(regularWand.use(p, "expelliarumus"));
	
	arrayMap[9][0].setMobsInRoom(bellatrix);
	bellatrix.setCurrentRoom(arrayMap[9][0]);
	System.out.println(swordOfGryffindor.use(p, ""));
	System.out.println(bassilskFang.use(p, ""));
	System.out.println(regularWand.use(p, "expelliarumus"));
	arrayMap[9][0].removeMobsInRoom(bellatrix);
	bellatrix.setCurrentRoom(arrayMap[5][1]);
	
	arrayMap[9][0].setMobsInRoom(snape);
	snape.setCurrentRoom(arrayMap[9][0]);
	System.out.println(swordOfGryffindor.use(p, ""));
	System.out.println(bassilskFang.use(p, ""));
	System.out.println(regularWand.use(p, "expelliarumus"));
}
}
