package test;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.junit.Test;

import model.items.AvadaKedvra;
import model.items.Expelliarumus;
import model.items.SectumSempra;
import model.items.Spell;
import model.map.Map;
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
	
	@Test
	public void testPlayerGetters() throws NoSuchAlgorithmException, NoSuchProviderException {
		//Initial list, map, and a GenericRoom
		PlayerList current = PlayerList.setList();
		Map currMap = Map.setMap(null);
		GenericRoom nextRoom = RoomFactory.designRoom(RoomType.NPC);
		
		//Usable players
		Player player1 = new Player("Lee", password1);
		Player player2 = new Player("Luna", password2);
		Player player3 = new Player("Neville", password3);
		
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

		//Tests username, password, descritpion, and gameName
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
		player1.addKnownSpells(spell1);
		assertEquals(1, player1.getKnownSpells().size());
		player1.addKnownSpells(spell2);
		assertEquals(2, player1.getKnownSpells().size());
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
		
		//Tests inventory
		assertNotEquals(player1.getInventory(), player2.getInventory());

	}

}
