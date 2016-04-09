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
		//South connection
		outdoorRoomOne.setSouthRoom(outdoorRoomTwo);
		outdoorRoomTwo.setSouthRoom(outdoorRoomThree);
		outdoorRoomThree.setSouthRoom(npcRoomOneHagridsHat);
		npcRoomOneHagridsHat.setSouthRoom(outdoorRoomFour);
		outdoorRoomFour.setSouthRoom(outdoorRoomFive);
		outdoorRoomFive.setSouthRoom(mobRoomOneHallway);
		mobRoomOneHallway.setSouthRoom(mobRoomTwoDiningHall);
		mobRoomTwoDiningHall.setSouthRoom(stairsRoomOne);
		stairsRoomOne.setSouthRoom(mobRoomThreeCastleEntrance);
		
		//North connection
		outdoorRoomTwo.setNorthRoom(outdoorRoomTwo);
		outdoorRoomThree.setNorthRoom(outdoorRoomTwo);
		npcRoomOneHagridsHat.setNorthRoom(outdoorRoomThree);
		outdoorRoomFour.setNorthRoom(npcRoomOneHagridsHat);
		outdoorRoomFive.setNorthRoom(outdoorRoomFour);
		mobRoomOneHallway.setNorthRoom(outdoorRoomFive);
		mobRoomTwoDiningHall.setNorthRoom(mobRoomOneHallway);
		stairsRoomOne.setNorthRoom(mobRoomTwoDiningHall);
		mobRoomThreeCastleEntrance.setNorthRoom(stairsRoomOne);
		
		outdoorRoomThree.setTitle("");
		outdoorRoomThree.setRoomDescription("");
		//set Title and Description of 10 rooms
		//Room 0,0
		outdoorRoomOne.setTitle("Beyond the Whomping Willow");
		outdoorRoomOne.setRoomDescription("A tree sets off in the distance."
				+ " The branches appear fragile, but you know how fierce they can be. Turning away, "
				+ " you remember that you left something behind in the common room of Hogswart."
				+ " There are two ways to go east or south.");
		
		// Room 1,0
		outdoorRoomTwo.setTitle("The Scenic Route");
		outdoorRoomTwo.setRoomDescription("Walking down the side of a hill. You see the quidditch arena in the distance. "
				+ " The small dots are whirling back and forth gliding through the air."
				+ " Other students are milling about on the field practicing their spells."
				+ " There are only two ways to go north or south.");
		
		// Room 2,0
		outdoorRoomThree.setTitle("The Quidditch Field");
		outdoorRoomThree.setRoomDescription(" As you approach the field, the HufflePuff and Ravenclaw players have been locked in a dead heat."
				+ " On one side of the field, there are massive stands for each of the four House. "
				+ " On the ends of the field, the three rings for each time team dwarf your height."
				+ " In the distance to the east, the Forbidden Forest looms."
				+ " To the south, you see smoke coming from Hagrids.");
		
		// Room 3,0
		npcRoomOneHagridsHat.setTitle("Hagrids Hut");
		npcRoomOneHagridsHat.setRoomDescription(" Large billowing smoke exits the massive hut. "
				+ " You slowing approach. A low key shrieking can be heard  from within. "
				+ " A massive bon fire crackles on the side of the hut. Some unicorn meet is cooking."
				+ " Hagrid doesn't seem to be here..."
				+ " To the east of Hagrid's Hut, you hear a loud scream come from the Forbidden Forest."
				+ " South of the Hut is the outdoor grounds to Hogwarts.");
		
		// Room 4,0
		outdoorRoomFour.setTitle("The Open Field");
		outdoorRoomFour.setRoomDescription(" You see an open field."
				+ " It seems strangely desolate... "
				+ " Mudding steps are seen everywhere. "
				+ " Like people left in a panic."
				+ " The only way to go is south.");
		
		//Room 5,0
		outdoorRoomFive.setTitle("The Scorched Remains");
		outdoorRoomFive.setRoomDescription(" You saw the smoke as you approached."
				+ " It was the scorched remains of a body. "
				+ " There are no signs of who it is."
				+ " What happened here..."
				+ " To the south you see the entrance hallway of Hogwarts, it is the only way to go.");
		
		//Room 6, 0
		mobRoomOneHallway.setTitle("The Entrance Hallway");
		mobRoomOneHallway.setRoomDescription(" Scattered about the entrance to school are the robes of other students. Papers..."
				+ " Wands... shoes are strewn about."
				+ " Something just happened."
				+ " The entrance is a grand door. Upon further examination, you see burn marks on it. "
				+ " The strong scent of smoke that you smelled outside remains."
				+ " The dining hall is the only room connected to the great entrance and it is south.");
		
		//Room 7, 0
		mobRoomTwoDiningHall.setTitle("The Dining Hall");
		mobRoomTwoDiningHall.setRoomDescription(" The instuctors chairs are seen in the background. Disturbingly vacant at this time..."
				+ " The drinks and food are still set on the tables. The food has barely been touched."
				+ " Exits to the east and south are present. ");
		
		//Room 8, 0
		stairsRoomOne.setTitle("The Stairway ");
		stairsRoomOne.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" Dependency Injection \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south to the castle entrance or east to... more stairs huehuehuehue");
		
		//Room 9, 0
		mobRoomThreeCastleEntrance.setTitle("The Castle Entrance ");
		mobRoomThreeCastleEntrance.setRoomDescription(" The grand entrance to the castle is more majestic than you remembered. "
				+ " Vin Diesel sits atop in his bronze statue. You remember his famous wizard, Melchior. "
				+ " Your resolve to figure out what happen grows. "
				+ " The entrance leads east to a hallway. ");
		
		//Create second column 10 rooms
		/*	- + - - - - 
		 *  - + - - - - 
		 *  - + - - - - 
		 *  - + - - - - 
		 *  - + - - - - 
		 *  - + - - - - 
		 *  - + - - - - 
		 *  - + - - - - 
		 *  - + - - - - 
		 *  - + - - - -
		 */
		
		GenericRoom twoMobRoomOneHallway = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom twoMobRoomTwoRoomOfRequirement = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom twoMobRoomThreeForbiddenForest = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom twoMobRoomFourForbiddenForest  = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom twoNPCRoomOneHarryRonShrine = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom twoMobRoomFiveBoysRoom = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom twoStairsOne = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom twoStairsTwo = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom twoStairsThree = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom twoMobRoomSixHallway = RoomFactory.designRoom(RoomType.MOB);
		
		//First Column East Connection with second column
		outdoorRoomOne.setEastRoom(twoMobRoomOneHallway); 
		outdoorRoomThree.setEastRoom(twoMobRoomThreeForbiddenForest);
		npcRoomOneHagridsHat.setEastRoom(twoMobRoomFourForbiddenForest);
		mobRoomTwoDiningHall.setEastRoom(twoStairsTwo);
		stairsRoomOne.setEastRoom(twoStairsThree);
		mobRoomThreeCastleEntrance.setEastRoom(twoMobRoomSixHallway);
		
		//Second Column West Connection with first
		twoMobRoomOneHallway.setWestRoom(outdoorRoomOne); 
		twoMobRoomThreeForbiddenForest.setWestRoom(outdoorRoomThree);
		twoMobRoomFourForbiddenForest.setWestRoom(npcRoomOneHagridsHat);
		twoStairsTwo.setWestRoom(mobRoomTwoDiningHall);
		twoStairsThree.setWestRoom(stairsRoomOne);
		twoMobRoomSixHallway.setWestRoom(mobRoomThreeCastleEntrance);
		 
		//Second Column South Connections
		twoMobRoomOneHallway.setSouthRoom(twoMobRoomTwoRoomOfRequirement);
		twoMobRoomThreeForbiddenForest.setSouthRoom(twoMobRoomFourForbiddenForest);
		twoNPCRoomOneHarryRonShrine.setSouthRoom(twoMobRoomFiveBoysRoom);
		twoStairsOne.setSouthRoom(twoStairsTwo);
		twoStairsTwo.setSouthRoom(twoStairsThree);
		twoStairsThree.setSouthRoom(twoMobRoomSixHallway);
		
		//Second Column North Connections
		twoMobRoomTwoRoomOfRequirement.setNorthRoom(twoMobRoomOneHallway);
		twoMobRoomFourForbiddenForest.setNorthRoom(twoMobRoomThreeForbiddenForest);
		twoMobRoomFiveBoysRoom.setNorthRoom(twoNPCRoomOneHarryRonShrine);
		twoStairsTwo.setNorthRoom(twoStairsOne);
		twoStairsThree.setNorthRoom(twoStairsTwo);
		twoMobRoomSixHallway.setNorthRoom(twoStairsThree);
		
	
		
		//Room 0, 1
		twoMobRoomOneHallway.setTitle("Spooky Hallway");
		twoMobRoomOneHallway.setRoomDescription(" These back hallways have always been a little spooky."
				+ " It doesn't help that they are the darkest placec in the castle."
				+ " I wish there was some way to light it up..."
				+ " There is only one mysterious way to the south...");
		
		//Room 1, 1
		twoMobRoomTwoRoomOfRequirement.setTitle("The RoR");
		twoMobRoomTwoRoomOfRequirement.setRoomDescription(" This room is full of trinkets. "
				+ "Piled as high as you can imagine there are many items for the taking."
				+ " I should be careful though, some of the items are cursed. "
				+ " I also wish I had more time to search through the mess..."
				+ " ");
		
		//Room 2, 1
		twoMobRoomThreeForbiddenForest.setTitle("Centaurs, Brah");
		twoMobRoomThreeForbiddenForest.setRoomDescription(" You're beginning to think this was a bad idea to go this way."
				+ " Yep, it was. In the distance, you see a group of centaurs. The dark underbrush provides concealment. They slowing"
				+ " start to head the other way.");
		
		//Room 3, 1
		twoMobRoomFourForbiddenForest.setTitle(" Spiders abound");
		twoMobRoomFourForbiddenForest.setRoomDescription(" The forest begins to thicken. "
				+ "More and more leaves seems to be sticking to your robe."
				+ " Your movement begins to slow. "
				+ " You start to notice a clear dark substance attaching itself to you and "
				+ " whatever else it touches. You suddenly come the realization. You look up."
				+ " Thousands of eyes seem to be peering bck at you. It is the den of spiders."
				+ " You should go back from whence you came!");
		
		//Room 4, 1
		twoNPCRoomOneHarryRonShrine.setTitle("Harry and Ron's Shrine");
		twoNPCRoomOneHarryRonShrine.setRoomDescription("What a weird room. Nothing of great importance seems to be here."
				+ " You should go back to where you were.");
		
		//Room 5, 1
		twoMobRoomFiveBoysRoom.setTitle("The Little Boys Room");
		twoMobRoomFiveBoysRoom.setRoomDescription("This is the boys room."
				+ " Definitely not haunted.");
		
		//Room 6,1
		twoStairsOne.setTitle("The Stairway ");
		twoStairsOne.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" CinDiesel \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south to the castle entrance or east to... more stairs huehuehuehue");
		
		//Room 7, 1
		twoStairsTwo.setTitle("The Stairway ");
		twoStairsTwo.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" CSC 335 Class Code \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south to more stairs or east");
		
		//Room 8, 1
		twoStairsThree.setTitle("The Stairway ");
		twoStairsThree.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" CSC 345 Red Black Tree \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south or east");
		
		//Room 9, 1
		twoMobRoomSixHallway.setTitle("The Entrance Hallway");
		twoMobRoomSixHallway.setRoomDescription(" The scorch marks at the entrance door continue here."
				+ " This hallway is unusually dark. Old, armored knights line the hallways. "
				+ " Their shining armor helps your vision somewhat. The hallway leads north or east.");
		
		//Create third column 10 rooms
				/*	- - + - - - 
				 *  - - + - - - 
				 *  - - + - - -  
				 *  - - + - - -  
				 *  - - + - - -  
				 *  - - + - - -  
				 *  - - + - - -  
				 *  - - + - - -  
				 *  - - + - - -  
				 *  - - + - - - 
				 */
		
		GenericRoom threeMobRoomOneJointBedRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeMobRoomTwoHallway = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeStairsOne = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom threeMobRoomThreeThirdFloor = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeMobRoomFourBoysRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeMobRoomFiveEmptyRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeStairsTwo = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom threeMobRoomSixGriffindorCommonRoom= RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeMobRoomSevenSlytherinCommonRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeMobRoomEightHufflepuffCommonRoom = RoomFactory.designRoom(RoomType.MOB);
		
		//Second Column east connection with third column
		twoMobRoomOneHallway.setEastRoom(threeMobRoomOneJointBedRoom);
		twoMobRoomTwoRoomOfRequirement.setEastRoom(threeMobRoomTwoHallway);
		twoMobRoomFiveBoysRoom.setEastRoom(threeMobRoomFiveEmptyRoom);
		twoStairsOne.setEastRoom(threeStairsTwo);
		twoStairsTwo.setEastRoom(threeMobRoomSixGriffindorCommonRoom);
		twoStairsThree.setEastRoom(threeMobRoomSevenSlytherinCommonRoom);
		twoMobRoomSixHallway.setEastRoom(threeMobRoomEightHufflepuffCommonRoom);
		
		//Third Column west connection with second column
		threeStairsTwo.setWestRoom(twoStairsOne);
		threeMobRoomOneJointBedRoom.setWestRoom(twoMobRoomOneHallway);
		threeMobRoomTwoHallway.setWestRoom(twoMobRoomTwoRoomOfRequirement);
		threeMobRoomFiveEmptyRoom.setWestRoom(twoMobRoomFiveBoysRoom);
		threeMobRoomSixGriffindorCommonRoom.setWestRoom(twoStairsTwo);
		threeMobRoomSevenSlytherinCommonRoom.setWestRoom(twoStairsThree);
		threeMobRoomEightHufflepuffCommonRoom.setWestRoom(twoMobRoomSixHallway);
		
		//Third Column set south connection
		threeMobRoomOneJointBedRoom.setSouthRoom(threeMobRoomTwoHallway);
		threeMobRoomTwoHallway.setSouthRoom(threeStairsOne);
		threeStairsOne.setSouthRoom(threeMobRoomThreeThirdFloor);
		threeMobRoomFiveEmptyRoom.setSouthRoom(threeStairsTwo);
		
		//Third Column set North connection
		threeStairsTwo.setNorthRoom(threeMobRoomFiveEmptyRoom);
		threeMobRoomThreeThirdFloor.setNorthRoom(threeStairsOne);
		threeStairsOne.setNorthRoom(threeMobRoomTwoHallway);
		threeMobRoomTwoHallway.setNorthRoom(threeMobRoomOneJointBedRoom);
		
		//Room 0,2
		threeMobRoomOneJointBedRoom.setTitle("The BedRooms");
		threeMobRoomOneJointBedRoom.setRoomDescription("The bed sheets and blankets are everywhere."
				+ " Blood is on the walls. "
				+ " There are so many questions. I hope I have an answer."
				+ " The room can be exited to the east, south or west.");
		
		//Room 1,2
		threeMobRoomTwoHallway.setTitle("Spooky Hallway");
		threeMobRoomTwoHallway.setRoomDescription("Did I mention how dark and spooky these hallways were?"
				+ " Candle lights line both sides of the hallway. "
				+ " The light coming off them is nothing. "
				+ " The flames sway back and forth. Like somethings breathing is causing it."
				+ " You feel a slight wind as you continue along the hallway."
				+ " This hallway can go in all four directions.");
		
		//Room 2, 2
		threeStairsOne.setTitle("The Stairway ");
		threeStairsOne.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" Sahil was here \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south or east");
		
		//Room 3, 2
		threeMobRoomThreeThirdFloor.setTitle("Third Floor Entrance");
		threeMobRoomThreeThirdFloor.setRoomDescription( "You enter the room. Immediately, you are asked to"
				+ "input your credit card information to the Kickstarter for the sequel to this game."
				+ " Or you could just exit to the north.");
		
		//Room 4, 2
		threeMobRoomFourBoysRoom.setTitle("Boys Room");
		threeMobRoomFourBoysRoom.setRoomDescription(" The room is untouched. Everything is clean."
				+ " Wow so clean. Much sparkle. Wow.");
		
		//Room 5, 2
		threeMobRoomFiveEmptyRoom.setTitle("Empty Room");
		threeMobRoomFiveEmptyRoom.setRoomDescription(" This is an empty room with an empty description.");
		
		//Room 6, 2
		threeStairsTwo.setTitle("The Stairway ");
		threeStairsTwo.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" For he who is worthy, they shall wield the Dependency Injection Staff of Jeremy \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south or east");
		
		//Room 7, 2
		threeMobRoomSixGriffindorCommonRoom.setTitle("Griffindor Common Room");
		threeMobRoomSixGriffindorCommonRoom.setRoomDescription(" A group of students huddle in the corner."
				+ " They are visibly shaken and in shock. "
				+ " They can't tell you what has happened."
				+ " As if something has a spell over them."
				+ " You can leave the room from the west, north and east.");
		
		//Room 8, 2
		threeMobRoomSevenSlytherinCommonRoom.setTitle("Slytherin Common Room");
		threeMobRoomSevenSlytherinCommonRoom.setRoomDescription(" The crest of Slytherin is seen as you enter the room."
				+ " Everything is neat and where you would expect it. Nothing is strewn on the floor."
				+ " I'm pretty sure these are the bad guys."
				+ " You can go east or west.");
		
		//Room 9, 2
		threeMobRoomEightHufflepuffCommonRoom.setTitle("Hufflepuff Common Room");
		threeMobRoomEightHufflepuffCommonRoom.setRoomDescription(" Hufflepuff things are in HufflePuffs room."
				+ " What a weird name...");
		
		
}
	
	public GenericRoom getEntrance() {

	      return mapStart;
	}
	
}