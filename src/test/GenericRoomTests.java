package test;

import static org.junit.Assert.*;



import org.junit.Test;

import model.room.GenericRoom;
import model.room.MobRoom;
import model.room.NPCRoom;
import model.room.OutdoorGroundsRoom;
import model.room.Stairs;

public class GenericRoomTests {
	
	//Test initial creation for rooms
	@Test
	public void testRoomMethodConstructors() {
		GenericRoom outside = new OutdoorGroundsRoom();
		GenericRoom mobRoom = new MobRoom("Unicorns");
		GenericRoom stairs = new Stairs();
		GenericRoom attachedRoom = new NPCRoom("McGonagals office");
		GenericRoom stairs2 = new Stairs();
		
		assertEquals(outside.getNorthRoom(), null);
		assertEquals(outside.getSouthRoom(), null);
		assertEquals(outside.getEastRoom(), null);
		assertEquals(outside.getWestRoom(), null);
		
		outside.setSouthRoom(attachedRoom);
		outside.setNorthRoom(mobRoom);
		outside.setEastRoom(stairs);
		outside.setWestRoom(stairs2);
		
		assertEquals(outside.getNorthRoom(), mobRoom);
		assertEquals(outside.getSouthRoom(), attachedRoom);
		assertEquals(outside.getEastRoom(), stairs);
		assertEquals(outside.getWestRoom(), stairs2);
		
		GenericRoom northRoom = new MobRoom("Dining Hall");
		GenericRoom southRoom = new NPCRoom("Hermoine Shrine");
		GenericRoom eastRoom = new Stairs();
		GenericRoom westRoom = new OutdoorGroundsRoom();
		
		GenericRoom testRoom = new OutdoorGroundsRoom(northRoom,southRoom , eastRoom ,westRoom);
		assertEquals(testRoom.getNorthRoom(), northRoom);
		assertEquals(testRoom.getSouthRoom(), southRoom);
		assertEquals(testRoom.getEastRoom(), eastRoom);
		assertEquals(testRoom.getWestRoom(), westRoom);
		
		GenericRoom testRoom1 = new NPCRoom(northRoom,southRoom , eastRoom ,westRoom, "Harrys Pad");
		assertEquals(testRoom1.getNorthRoom(), northRoom);
		assertEquals(testRoom1.getSouthRoom(), southRoom);
		assertEquals(testRoom1.getEastRoom(), eastRoom);
		assertEquals(testRoom1.getWestRoom(), westRoom);
		
		GenericRoom testRoom2 = new MobRoom(northRoom,southRoom , eastRoom ,westRoom, "Cave");
		assertEquals(testRoom2.getNorthRoom(), northRoom);
		assertEquals(testRoom2.getSouthRoom(), southRoom);
		assertEquals(testRoom2.getEastRoom(), eastRoom);
		assertEquals(testRoom2.getWestRoom(), westRoom);
		
		assert(testRoom2.getNorthRoom() != null);
		assert(testRoom2.getSouthRoom() != null);
		assert(testRoom2.getEastRoom() != null);
		assert(testRoom2.getWestRoom() != null);
		
		GenericRoom testRoom3 = new Stairs(northRoom,southRoom , eastRoom ,westRoom);
		assertEquals(testRoom3.getNorthRoom(), northRoom);
		assertEquals(testRoom3.getSouthRoom(), southRoom);
		assertEquals(testRoom3.getEastRoom(), eastRoom);
		assertEquals(testRoom3.getWestRoom(), westRoom);
	}

	@Test
	public void testGetter(){
		GenericRoom northRoom = new MobRoom("Dining Hall");
		GenericRoom southRoom = new NPCRoom("Hermoine Shrine");
		GenericRoom eastRoom = new Stairs();
		GenericRoom westRoom = new OutdoorGroundsRoom();
		
		GenericRoom testRoom1 = new NPCRoom(northRoom,southRoom , eastRoom ,westRoom, "Harrys Pad");
		assertEquals(testRoom1.getNorthRoom(), northRoom);
		assertEquals(testRoom1.getSouthRoom(), southRoom);
		assertEquals(testRoom1.getEastRoom(), eastRoom);
		assertEquals(testRoom1.getWestRoom(), westRoom);
		
		GenericRoom nextRoom = testRoom1.getNextRoom("n");
		assert(nextRoom== northRoom);
		GenericRoom nextRoom2 = testRoom1.getNextRoom("s");
		assert(nextRoom2 == southRoom);
		GenericRoom nextRoom3 = testRoom1.getNextRoom("e");
		assert(nextRoom3 == eastRoom);
		GenericRoom nextRoom4 = testRoom1.getNextRoom("w");
		assert(nextRoom4 == westRoom);
		GenericRoom nextRoom5 = testRoom1.getNextRoom("north");
		assert(nextRoom5 != northRoom);
		GenericRoom nextRoom6 = testRoom1.getNextRoom("south");
		assert(nextRoom6 == southRoom);
		GenericRoom nextRoom7 = testRoom1.getNextRoom("east");
		assert(nextRoom7 == eastRoom);
		GenericRoom nextRoom8 = testRoom1.getNextRoom("west");
		assert(nextRoom8 == westRoom);
		
	}
}