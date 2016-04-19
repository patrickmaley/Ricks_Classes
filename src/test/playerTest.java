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

public class playerTest {

	private char[] password1 = new char[] {'1'};
	private char[] password2 = new char[] {'2', '2'};
	private char[] password3 = new char[] {'3', '3', '3'};
	
	@Test
	public void testPlayerGetters() throws NoSuchAlgorithmException, NoSuchProviderException {
		PlayerList current = PlayerList.setList();
		Map currMap = Map.setMap();
		GenericRoom nextRoom = RoomFactory.designRoom(RoomType.NPC);
		
		Player player1 = new Player("Lee", password1, "Doris", "Gryffindor");
		Player player2 = new Player("Luna", password2, "Debbie", "Ravenclaw");
		Player player3 = new Player("Neville", password3, "Kevin", "Gryffindor");
		
		Spell spell1 = new AvadaKedvra();
		Spell spell2 = new Expelliarumus();
		Spell spell3 = new SectumSempra();
		
		assertEquals(0, current.getCurrentList().size());
		current.newPlayer(player1);
		assertEquals(1, current.getCurrentList().size());
		current.newPlayer(player2);
		assertEquals(2, current.getCurrentList().size());
		current.newPlayer(player3);
		assertEquals(3, current.getCurrentList().size());
		current.newPlayer(player3);
		assertEquals(3, current.getCurrentList().size());

		assertEquals("Lee", player1.getUsername());
		assertEquals(true, player1.checkPassword(password1));
		assertNotEquals(player1.getUsername(), player2.getUsername());
		assertEquals(false, player1.checkPassword(password2));
		assertEquals(true, player2.checkPassword(password2));
		assertEquals("Doris", player1.getGameName());
		assertNotEquals("Debbie", player1.getGameName());
		
		player1.addKnownSpells(spell1);
		assertEquals(1, player1.getKnownSpells().size());
		player1.addKnownSpells(spell2);
		assertEquals(2, player1.getKnownSpells().size());
		player1.removeKnownSpells(spell1);
		assertEquals(1, player1.getKnownSpells().size());
		player1.removeKnownSpells(spell3);
		assertEquals(1, player1.getKnownSpells().size());
		
		assertEquals("Gryffindor", player1.getHouse());
		assertNotEquals("Gryffindor", player2.getHouse());
		
		assertEquals(100, player3.getHP(), .0001);
		player3.decreaseHP(50);
		assertEquals(50, player3.getHP(), .0001);
		player3.increaseHP(25);
		assertEquals(75, player3.getHP(), .0001);
		player3.decreaseHP(100);
		assertEquals(0, player3.getHP(), .0001);
		assertTrue(player3.getIsDead());
		player3.resetPlayerData();
		assertFalse(player3.getIsDead());
		assertEquals(100, player3.getHP(), .0001);
		player3.increaseHP(100);
		assertEquals(200, player3.getHP(), .0001);
		
		assertEquals(currMap.getEntrance(), player1.getRoom());
		player1.setCurrentRoom(nextRoom);
		assertNotEquals(currMap.getEntrance(), player1.getRoom());
		assertEquals(nextRoom, player1.getRoom());
		
		assertNotEquals(player1.getInventory(), player2.getInventory());

	}

}
