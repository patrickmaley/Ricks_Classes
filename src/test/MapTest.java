package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.map.Map;
import model.room.GenericRoom;

public class MapTest {

	@Test
	public void test() {
		GenericRoom testRoom = null;
		
		Map mapOne = Map.setMap();
		GenericRoom firstRoom = mapOne.getEntrance();
		assertTrue(firstRoom != null);
		System.out.println(firstRoom.getRoomDescription());
		
		//Traverse through the map and hit the first 30 rooms
		assertTrue(testRoom == null);
		
		testRoom = firstRoom.getSouthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getSouthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getEastRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getSouthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getWestRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getSouthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getSouthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getSouthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getSouthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getSouthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getSouthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getEastRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getEastRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getWestRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getNorthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getEastRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getWestRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getNorthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getEastRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getWestRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getNorthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getEastRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getNorthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getWestRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getNorthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		testRoom = testRoom.getSouthRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
		
		
		testRoom = testRoom.getEastRoom();
		assertTrue(testRoom != null);
		System.out.println(testRoom.getRoomDescription());
	}

}
