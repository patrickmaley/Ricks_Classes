package test;
import model.player.Player;
import model.items.*;
import model.mobs.Dementor;
import model.mobs.OrdinaryWizards;
import model.mobs.Snape;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.junit.Test;
public class ItemsTest {
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
private Snape snape = new Snape("Snape", 0, 0, 0);
private Dementor dementor = new Dementor("Dementor", 0, 0, 0); 
private OrdinaryWizards ordinaryWizard = new OrdinaryWizards("ordinary", 0, "syltherin", 0, 0); 
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
}	
@Test
public void testItems(){
	assertEquals(broomstick.getName(), "Broomstick");
	String d1 = broomstick.getDescription();
	System.out.println(d1);
	//
	assertEquals(bassilskFang.getName(), "Bassilsk Fang");
	String d2 = bassilskFang.getDescription();
	System.out.println(d2);
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
	assertEquals(regularWand.getName(), "Regular Wand");
	String d11 = regularWand.getDescription();
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
}
@Test 
public void testInventory() throws NoSuchAlgorithmException, NoSuchProviderException{
	char [] password = new char ['p'];
	Player p = new Player("Player", password,"hi","gryffindor");
	Inventory inventory = p.getInventory();
	inventory.add(horcrux);
	inventory.add(sbOne);
	inventory.add(hermoinesHandbag);
	inventory.add(healingPotion);
	inventory.add(elderWand);
	String usingSpellBook=sbOne.use(p, null);
	System.out.println(usingSpellBook);
	assertFalse(inventory.add(broomstick));
	inventory.drop("horcrux");
	assertEquals(null, inventory.getItem("horcrux"));
	hermoinesHandbag.use(p,null);
	assertTrue(inventory.add(broomstick));
	assertTrue(inventory.add(butterBeer));
	System.out.println(inventory.toString());
	String usinghP = healingPotion.use(p,null);
	System.out.println(usinghP);
	String usingbBeer = butterBeer.use(p,null);
	System.out.println(usingbBeer);
	inventory.add(dependencyInjectionSword);
	System.out.println(dependencyInjectionSword.use(p,null));
	assertTrue(inventory.add(ressurectionStone));
	System.out.println(ressurectionStone.use(p,null));
}
}
