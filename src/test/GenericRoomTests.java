package test;

import static org.junit.Assert.*;



import org.junit.Test;

import model.room.GenericRoom;
import model.room.MobRoom;
import model.room.NPCRoom;
import model.room.OutdoorGroundsRoom;
import model.room.RoomFactory;
import model.room.RoomType;
import model.room.Stairs;

public class GenericRoomTests {
	
	//Test initial creation for rooms
	@Test
	public void testRoomMethodConstructors() {
		GenericRoom outside = RoomFactory.designRoom(RoomType.OUTDOORS);//new OutdoorGroundsRoom();
		GenericRoom mobRoom = RoomFactory.designRoom(RoomType.MOB);// new MobRoom("Unicorns");
		GenericRoom stairs = RoomFactory.designRoom(RoomType.STAIRS);//new Stairs();
		GenericRoom attachedRoom = RoomFactory.designRoom(RoomType.NPC);//new NPCRoom("McGonagals office");
		GenericRoom stairs2 = RoomFactory.designRoom(RoomType.STAIRS);//new Stairs();
	
	
		
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
		
		GenericRoom northRoom = RoomFactory.designRoom(RoomType.MOB);// new MobRoom("Dining Hall");
		GenericRoom southRoom = RoomFactory.designRoom(RoomType.NPC);//new NPCRoom("Hermoine Shrine");
		GenericRoom eastRoom = new Stairs();
		GenericRoom westRoom = new OutdoorGroundsRoom();
		
		GenericRoom testRoom = RoomFactory.designRoom(RoomType.OUTDOORS);//new OutdoorGroundsRoom(northRoom,southRoom , eastRoom ,westRoom);
		testRoom.setNorthRoom(northRoom);
		testRoom.setSouthRoom(southRoom);
		testRoom.setEastRoom(eastRoom);
		testRoom.setWestRoom(westRoom);
		assertEquals(testRoom.getNorthRoom(), northRoom);
		assertEquals(testRoom.getSouthRoom(), southRoom);
		assertEquals(testRoom.getEastRoom(), eastRoom);
		assertEquals(testRoom.getWestRoom(), westRoom);
		
		GenericRoom testRoom1 = RoomFactory.designRoom(RoomType.NPC);// new NPCRoom(northRoom,southRoom , eastRoom ,westRoom, "Harrys Pad");
		testRoom1.setNorthRoom(northRoom);
		testRoom1.setSouthRoom(southRoom);
		testRoom1.setEastRoom(eastRoom);
		testRoom1.setWestRoom(westRoom);
		assertEquals(testRoom1.getNorthRoom(), northRoom);
		assertEquals(testRoom1.getSouthRoom(), southRoom);
		assertEquals(testRoom1.getEastRoom(), eastRoom);
		assertEquals(testRoom1.getWestRoom(), westRoom);
		
		GenericRoom testRoom2 = RoomFactory.designRoom(RoomType.MOB);// new MobRoom(northRoom,southRoom , eastRoom ,westRoom, "Cave");
		testRoom2.setNorthRoom(northRoom);
		testRoom2.setSouthRoom(southRoom);
		testRoom2.setEastRoom(eastRoom);
		testRoom2.setWestRoom(westRoom);
		assertEquals(testRoom2.getNorthRoom(), northRoom);
		assertEquals(testRoom2.getSouthRoom(), southRoom);
		assertEquals(testRoom2.getEastRoom(), eastRoom);
		assertEquals(testRoom2.getWestRoom(), westRoom);
		
		assertTrue(testRoom2.getNorthRoom() != null);
		assertTrue(testRoom2.getSouthRoom() != null);
		assertTrue(testRoom2.getEastRoom() != null);
		assertTrue(testRoom2.getWestRoom() != null);
		
		//GenericRoom testRoom3 = new Stairs(northRoom,southRoom , eastRoom ,westRoom);
		GenericRoom testRoom3 = RoomFactory.designRoom(RoomType.STAIRS);
		testRoom3.setNorthRoom(northRoom);
		testRoom3.setSouthRoom(southRoom);
		testRoom3.setEastRoom(eastRoom);
		testRoom3.setWestRoom(westRoom);
		assertEquals(testRoom3.getNorthRoom(), northRoom);
		assertEquals(testRoom3.getSouthRoom(), southRoom);
		assertEquals(testRoom3.getEastRoom(), eastRoom);
		assertEquals(testRoom3.getWestRoom(), westRoom);
	}

	@Test
	public void testGetter(){
//		GenericRoom northRoom = new MobRoom("Dining Hall");
//		GenericRoom southRoom = new NPCRoom("Hermoine Shrine");
//		GenericRoom eastRoom = new Stairs();
//		GenericRoom westRoom = new OutdoorGroundsRoom();
		
		GenericRoom northRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom southRoom = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom eastRoom = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom westRoom = RoomFactory.designRoom(RoomType.OUTDOORS);
		
		
		GenericRoom testRoom1 = RoomFactory.designRoom(RoomType.NPC);
		testRoom1.setNorthRoom(northRoom);
		testRoom1.setSouthRoom(southRoom);
		testRoom1.setEastRoom(eastRoom);
		testRoom1.setWestRoom(westRoom);
		//GenericRoom testRoom1 = new NPCRoom(northRoom,southRoom , eastRoom ,westRoom, "Harrys Pad");
		assertEquals(testRoom1.getNorthRoom(), northRoom);
		assertEquals(testRoom1.getSouthRoom(), southRoom);
		assertEquals(testRoom1.getEastRoom(), eastRoom);
		assertEquals(testRoom1.getWestRoom(), westRoom);
		
		GenericRoom nextRoom = testRoom1.getNextRoom("n");
		assertTrue(nextRoom== northRoom);
		GenericRoom nextRoom2 = testRoom1.getNextRoom("s");
		assertTrue(nextRoom2 == southRoom);
		GenericRoom nextRoom3 = testRoom1.getNextRoom("e");
		assertTrue(nextRoom3 == eastRoom);
		GenericRoom nextRoom4 = testRoom1.getNextRoom("w");
		assertTrue(nextRoom4 == westRoom);
		GenericRoom nextRoom5 = testRoom1.getNextRoom("north");
		assertTrue(nextRoom5 == northRoom);
		GenericRoom nextRoom6 = testRoom1.getNextRoom("south");
		assertTrue(nextRoom6 == southRoom);
		GenericRoom nextRoom7 = testRoom1.getNextRoom("east");
		assertTrue(nextRoom7 == eastRoom);
		GenericRoom nextRoom8 = testRoom1.getNextRoom("west");
		assertTrue(nextRoom8 == westRoom);
		
		
		
	}
	
	@Test
	public void testNextRoomNull(){
		GenericRoom testRoom1 = RoomFactory.designRoom(RoomType.NPC);
	
		testRoom1.setNorthRoom(null);
		testRoom1.setSouthRoom(null);
		testRoom1.setEastRoom(null);
		testRoom1.setWestRoom(null);
		
		GenericRoom nextRoom = testRoom1.getNextRoom("n");
		assertTrue(nextRoom == null);
		GenericRoom nextRoom2 = testRoom1.getNextRoom("s");
		assertTrue(nextRoom2 == null);
		GenericRoom nextRoom3 = testRoom1.getNextRoom("e");
		assertTrue(nextRoom3 == null);
		GenericRoom nextRoom4 = testRoom1.getNextRoom("w");
		assertTrue(nextRoom4 == null);
		GenericRoom nextRoom5 = testRoom1.getNextRoom("north");
		assertTrue(nextRoom5 == null);
		GenericRoom nextRoom6 = testRoom1.getNextRoom("south");
		assertTrue(nextRoom6 == null);
		GenericRoom nextRoom7 = testRoom1.getNextRoom("east");
		assertTrue(nextRoom7 == null);
		GenericRoom nextRoom8 = testRoom1.getNextRoom("west");
		assertTrue(nextRoom8 == null);
		GenericRoom nextRoom9 = testRoom1.getNextRoom("h");
		assertTrue(nextRoom9 == null);
	}
	
	
	@Test
	public void testSetTitleDescription(){
		GenericRoom testRoom1 = RoomFactory.designRoom(RoomType.NPC);
	
		String testString = "Harry peered into the darkness";
		String testTitle = "You're a wizard";
		
		testRoom1.setTitle(testTitle);
		testRoom1.setRoomDescription(testString);
		
		assertTrue(testRoom1.getTitle().compareTo(testTitle) == 0);
		assertTrue(testRoom1.getRoomDescription().compareTo(testString) == 0);
	}
	
	@Test
	public void testGettersAndSetters(){
		GenericRoom testRoom1 = RoomFactory.designRoom(RoomType.NPC);
	
		String testString = "Harry peered into the darkness";
		String testTitle = "You're a wizard";
		
		testRoom1.setMobsPresent(true);
		assertTrue(testRoom1.getMobsPresent());
		
		testRoom1.setPlayerPresent(true);
		assertTrue(testRoom1.getPlayerPresent());
		
		testRoom1.setLookDownDescription(testString);
		testRoom1.setLookUpDescription(testTitle);
		assertTrue(testRoom1.getLookDownDescription() != null);
		assertTrue(testRoom1.getLookUpDescription() != null);
	}
	
}