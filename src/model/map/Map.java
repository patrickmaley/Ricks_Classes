package model.map;

import java.io.Serializable;

import model.room.GenericRoom;
import model.room.RoomFactory;
import model.room.RoomType;

public class Map implements Serializable{
	private static Map uniqueInstance = null;
	private GenericRoom mapStart;
	
	//Implement singleton to only use one map
	private Map(){
		
		createMap();
	}
	
	public static Map setMap() {
	      if(uniqueInstance == null) {
	    	  uniqueInstance = new Map();
	      }
	      return uniqueInstance;
	}
	
	private void createMap() {
		//Create first 10 rooms
		/*	+ - - - - -
		 *  + - - - - -
		 *  + - - - - -
		 *  + - - - - -
		 *  + - - - - -
		 *  + - - - - -
		 *  + - - - - -
		 *  + - - - - -
		 *  + - - - - -
		 *  + - - - - -
		 */
		GenericRoom outdoorRoomOne = RoomFactory.designRoom(RoomType.OUTDOORS);
		GenericRoom outdoorRoomTwo = RoomFactory.designRoom(RoomType.OUTDOORS);
		GenericRoom outdoorRoomThree = RoomFactory.designRoom(RoomType.OUTDOORS);
		GenericRoom npcRoomOneHagridsHat = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom outdoorRoomFour = RoomFactory.designRoom(RoomType.OUTDOORS);
		GenericRoom outdoorRoomFive = RoomFactory.designRoom(RoomType.OUTDOORS);
		GenericRoom mobRoomOneHallway = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom mobRoomTwoDiningHall = RoomFactory.designRoom(RoomType.OUTDOORS);
		GenericRoom stairsRoomOne = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom mobRoomThreeCastleEntrance = RoomFactory.designRoom(RoomType.MOB);
		
		//Set map entrance
		mapStart = outdoorRoomOne;
		
		//Connect first 10 rooms
		outdoorRoomOne.setSouthRoom(outdoorRoomTwo);
		outdoorRoomTwo.setSouthRoom(outdoorRoomThree);
		outdoorRoomThree.setSouthRoom(npcRoomOneHagridsHat);
		npcRoomOneHagridsHat.setSouthRoom(outdoorRoomFour);
		outdoorRoomFour.setSouthRoom(outdoorRoomFive);
		outdoorRoomFive.setSouthRoom(mobRoomOneHallway);
		mobRoomOneHallway.setSouthRoom(mobRoomTwoDiningHall);
		mobRoomTwoDiningHall.setSouthRoom(stairsRoomOne);
		stairsRoomOne.setSouthRoom(mobRoomThreeCastleEntrance);
		
		//set Title and Description of 10 rooms
		outdoorRoomOne.setTitle("Beyond the Whomping Willow");
		outdoorRoomOne.setRoomDescription("A tree sets off in the distance. The branches appear fragile, but you know how fierce they can be. Turning away, "
				+ " you remember that you left something behind in the common room of Hogswart. There are two ways to go east or south.");
		
		outdoorRoomOne.setTitle("The Scenic Route");
		outdoorRoomTwo.setRoomDescription("");
	}
	
	public GenericRoom getEntrance() {
	      
	      return mapStart;
	}
	
}