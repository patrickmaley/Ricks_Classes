package test;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.junit.Test;

import model.items.AvadaKedvra;
import model.items.BassilskFang;
import model.items.Broomstick;
import model.items.ButterBeer;
import model.items.DependencyInjectionSword;
import model.items.ElderWand;
import model.items.Expelliarumus;
import model.items.HermoinesHandbag;
import model.items.Horcrux;
import model.items.MaurdersMap;
import model.items.PhoenixTears;
import model.items.RegularWand;
import model.items.RessurectionStone;
import model.items.SectumSempra;
import model.items.Spell;
import model.items.SwordOfGryffindor;
import model.map.Map;
import model.mobs.Snape;
import model.player.Player;
import model.player.PlayerList;
import model.room.GenericRoom;
import model.room.RoomFactory;
import model.room.RoomType;

public class PlayerTest {

	//Usable passwords
	private char[] password1 = new char[] {'1'};
	private char[] password2 = new char[] {'2', '2'};
	private char[] password3 = new char[] {'3', '3', '3'};
	
	//Some items
	private RessurectionStone ressurectionStone = new RessurectionStone();
	private MaurdersMap maurdersMap = new MaurdersMap();
	private DependencyInjectionSword depSword = new DependencyInjectionSword();
	private HermoinesHandbag hermoinesHandbag = new HermoinesHandbag();
	private RegularWand regularWand = new RegularWand();
	private BassilskFang bassilskFang = new BassilskFang();
	private SwordOfGryffindor swordOfGryffindor = new SwordOfGryffindor();
	private ButterBeer beer = new ButterBeer();
	private Broomstick broomstick = new Broomstick();
	private PhoenixTears phoenixTears = new PhoenixTears();
	private ElderWand elderWand = new ElderWand();
	private Horcrux horcrux = new Horcrux();
	
	//A mob to test talk
	private Snape snape = new Snape();
	
	@Test
	public void testPlayerGetters() throws NoSuchAlgorithmException, NoSuchProviderException {
		//Initial list, map, and a GenericRoom
		PlayerList current = PlayerList.setList();
		Map currMap = Map.setMap();
		GenericRoom nextRoom = RoomFactory.designRoom(RoomType.NPC);
		
		//Usable players
		Player player1 = new Player("Lee", password1);
		Player player2 = new Player("Luna", password2);
		Player player3 = new Player("Neville", password3);
		
		player1.setPlayerMap(currMap);
		player2.setPlayerMap(currMap);
		player3.setPlayerMap(currMap);
		player1.setCurrentRoom(currMap.getEntrance().getNorthRoom());
		player2.setCurrentRoom(currMap.getEntrance().getNorthRoom());
		player3.setCurrentRoom(currMap.getEntrance().getNorthRoom());
		
		//Usable spells
		Spell spell1 = new AvadaKedvra();
		Spell spell2 = new Expelliarumus();
		Spell spell3 = new SectumSempra();
		
		//Tests map getters and setters
		assertEquals(player1.getPlayerMap(), currMap);
		currMap.getEntrance().getNorthRoom().setIsVisible(true);
		assertEquals(player1.getPlayerMap(), currMap);
		player1.setPlayerMap(currMap);
		assertEquals(player1.getPlayerMap(), currMap);

		//Tests username, password, description, and gameName
		player1.setGameName("Doris");
		player2.setGameName("Debbie");
		player3.setGameName("THEBOMB.COM");
		player1.setDescription("I am fucking amazing");
		assertEquals("I am fucking amazing", player1.getDescription());
		assertEquals("Lee", player1.getUsername());
		assertEquals(true, player1.checkPassword(password1));
		assertNotEquals(player1.getUsername(), player2.getUsername());
		assertEquals(false, player1.checkPassword(password2));
		assertEquals(true, player2.checkPassword(password2));
		assertEquals("Doris", player1.getGameName());
		assertNotEquals("Debbie", player1.getGameName());
		
		//Tests spellbook
		player1.addKnownSpells(spell2);
		assertEquals(1, player1.getKnownSpells().size());
		player1.addKnownSpells(spell1);
		assertEquals(2, player1.getKnownSpells().size());
		assertEquals(spell1, player1.strongestSpell());
		player1.removeKnownSpells(spell1);
		assertEquals(1, player1.getKnownSpells().size());
		player1.removeKnownSpells(spell3);
		assertEquals(1, player1.getKnownSpells().size());
		
		//Tests house getter
		player1.setHouse("Gryffindor");
		player2.setHouse("Ravenclaw");
		player3.setHouse("Gryffindor");
		assertEquals("Gryffindor", player1.getHouse());
		assertNotEquals("Gryffindor", player2.getHouse());
		
		//Tests playerList
		assertEquals(0, current.getCurrentList().size());
		current.newPlayer(player1);
		assertEquals(1, current.getCurrentList().size());
		current.newPlayer(player2);
		assertEquals(2, current.getCurrentList().size());
		current.newPlayer(player3);
		assertEquals(3, current.getCurrentList().size());
		current.newPlayer(player3);
		assertEquals(3, current.getCurrentList().size());
		assertEquals(player1, current.getPlayer(player1.getUsername()));
		assertEquals(null, current.getPlayer("yoyoyo"));
		
		//Tests HP getter, decrease, and increase
		assertEquals(100, player3.getHP(), .0001);
		player3.decreaseHP(50);
		assertEquals(50, player3.getHP(), .0001);
		player3.increaseHP(25);
		assertEquals(75, player3.getHP(), .0001);
		player3.decreaseHP(75);
		assertEquals(100, player3.getHP(), .0001);
		assertFalse(player3.getIsDead());
		assertEquals(100, player3.getHP(), .0001);
		player3.increaseHP(100);
		assertEquals(200, player3.getHP(), .0001);
		
		//Tests map and room
		assertEquals(currMap.getMapArray()[9][0], player1.getRoom());
		player1.setCurrentRoom(nextRoom);
		assertNotEquals(currMap.getEntrance(), player1.getRoom());
		assertEquals(nextRoom, player1.getRoom());
		player3.updateMap(player3.getPlayerMap());
		player3.setRoom(player3.getRoom());
		
		//Tests inventory
		assertNotEquals(player1.getInventory(), player2.getInventory());
		player1.getInventory().add(ressurectionStone);
		player1.getInventory().add(regularWand);
		assertEquals(regularWand, player1.strongestItem());
		player1.getInventory().add(swordOfGryffindor);
		player1.getInventory().add(bassilskFang);
		assertEquals(swordOfGryffindor, player1.strongestItem());
		player1.getInventory().drop("sword of gryffindor");
		assertEquals(bassilskFang, player1.strongestItem());
	}
	
	
	public Map map;
	public Player p;
	GenericRoom[][] arrayMap;
	public void setup(){
		map =  Map.setMap();
		char[] a = {'a','b','c'};
		try {
			p = new Player("Kevin", a);
		} catch (NoSuchAlgorithmException e) {
		} catch (NoSuchProviderException e) {
		}
		arrayMap = map.getMapArray();
		p.setGameName("kevin");
	}
	
	@Test
	public void testInteractions(){
		setup();
		p.setPlayerMap(map);
		p.setGameName("hayyy");
		p.setDescription("I go up to bales of hay and I'm like HAAAAY BALES!");
		p.setCurrentRoom(p.getPlayerMap().getMapArray()[9][0]);
		
		//Test directions and look
		p.performAction("west");
		p.performAction("look");
		p.performAction("east");
		p.performAction("look");
		p.performAction("east");
		p.performAction("look");
		p.performAction("west");
		p.performAction("look");
		p.performAction("north");
		p.performAction("look");
		p.performAction("south");
		p.performAction("look");
		p.performAction("east");
		p.performAction("look");
		p.performAction("east");
		p.performAction("look");
		p.performAction("east");
		p.performAction("look");
		p.performAction("north");
		p.performAction("look");
		p.performAction("east");
		p.performAction("look");
		p.performAction("east");
		p.performAction("look");
		p.performAction("east");
		p.performAction("look");
		p.performAction("south");
		p.performAction("look");
		
		//test using items when they are not in inventory
		p.performAction("use elder");
		p.performAction("use regular");
		p.performAction("use sword");
		p.performAction("use bassilsk");
		p.performAction("use butter");
		p.performAction("use healing");
		p.performAction("use hermoines");
		p.performAction("use horcrux");
		p.performAction("use phoenix");
		p.performAction("use maurders");
		p.performAction("use never");
		p.performAction("use ressurection");
		p.performAction("use broomstick");
		p.performAction("use blahh");
		
		//test using items in inventory
		p.performAction("attack");
		p.getInventory().add(ressurectionStone);
		p.getInventory().add(maurdersMap);
		p.getInventory().add(depSword);
		p.getInventory().add(hermoinesHandbag);
		p.getRoom().additemsInRoom(swordOfGryffindor);
		p.getRoom().additemsInRoom(bassilskFang);
		p.performAction("take sword of gryffindor");
		p.performAction("take bassilsk fang");
		p.performAction("use hermoines handbag");
		p.performAction("use ressurection stone");
		p.performAction("use maurders map");
		p.performAction("use dependency injection sword");
		p.performAction("attack");
		p.performAction("drop dependency injection sword");
		p.performAction("take butterbeer");
		p.getRoom().additemsInRoom(horcrux);
		p.performAction("look horcrux");
		p.getRoom().additemsInRoom(phoenixTears);
		p.performAction("take horcrux");
		p.performAction("take phoenix tears");
		
		//test talk, quit, and shutdown
		p.performAction("talk yo yo yo");
		p.getRoom().setMobsInRoom(snape);
		p.performAction("look snape");
		p.performAction("talk snape");
		p.performAction("talk lupin");
		p.performAction("quit");
		p.performAction("shutdown");
	}

}
