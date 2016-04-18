package test;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import model.*;
import model.player.Player;

import org.junit.Test;

public class CommandsTest {

	@Test
	public void testCommands() throws NoSuchAlgorithmException, NoSuchProviderException {
		char [] password = new char ['p'];
		Player p = new Player("Player", password,"hi","gryffindor");
		System.out.println(p.performAction("commands"));
		System.out.println(p.performAction("use elder wand avada kedvra"));		
		
	}

}
