package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;

public class playerTest {

	private char[] password1 = new char[] {'1'};
	private char[] password2 = new char[] {'2', '2'};
	private char[] password3 = new char[] {'3', '3', '3'};
	
	@Test
	public void testPlayerGetters() {
		Player player1 = new Player("Lee", password1, "Doris", null);
		Player player2 = new Player("Luna", password2, "Debbie", null);
		Player player3 = new Player("Neville", password3, "Kevin", null);
		
		assertEquals("Lee", player1.getUsername());
		assertNotEquals(player1.getUsername(), player2.getUsername());
		assertEquals(player1.getPassword(), password1);
		assertNotEquals(player1.getPassword(), password2);
		assertEquals("Doris", player1.getGamename());
		assertNotEquals("Debbie", player1.getGamename());
		
		assertEquals(100.00, player3.getHP());
		player3.decreaseHP(50);
		assertEquals(50.00, player3.getHP());
		player3.increaseHP(25);
		assertEquals(75.00, player3.getHP());
		player3.decreaseHP(100);
		assertEquals(0.00, player3.getHP());
		player3.increaseHP(100);
		assertEquals(100.00, player3.getHP());
	}

}
