package model.map;

import java.io.Serializable;

import model.room.GenericRoom;
import model.room.RoomFactory;
import model.room.RoomType;

public class Map implements Serializable{
	private static Map uniqueInstance = null;
	private GenericRoom mapStart;
	private GenericRoom[][] mapArray = new GenericRoom[10][6];
	
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
		
		//set Title and Description of 10 rooms
		//Room 0,0
		outdoorRoomOne.setTitle("Beyond the Whomping Willow");
		outdoorRoomOne.setRoomDescription("A tree sets off in the distance."
				+ " The branches appear fragile, but you know how fierce they can be. Turning away, "
				+ " you remember that you left something behind in the common room of Hogswart."
				+ " There are two ways to go east or south.");
		outdoorRoomOne.setLookDownDescription("The grassy knoll leads down into a clearing."
				+ " The grass near the Whomping Willow is still smuldering.");
		outdoorRoomOne.setLookUpDescription(" Bright colors flash along the horizon."
				+ " The sky begins to turn bright red. This shit is getting real");
		mapArray[0][0] = outdoorRoomOne;
		
		// Room 1,0
		outdoorRoomTwo.setTitle("The Scenic Route");
		outdoorRoomTwo.setRoomDescription("Walking down the side of a hill. You see the quidditch arena in the distance. "
				+ " The small dots are whirling back and forth gliding through the air."
				+ " Other students are milling about on the field practicing their spells."
				+ " There are only two ways to go north or south.");
		outdoorRoomTwo.setLookDownDescription(" The path to the quidditch arena has been worn down. "
				+ " Mudding footsteps line the path heading in both directions.");
		outdoorRoomTwo.setLookUpDescription(" A sole figure is floating in the sky. It's cloack is whirling behind it. "
				+ "Legless as it flies around the castle.");
		mapArray[1][0] = outdoorRoomTwo;
		
		// Room 2,0
		outdoorRoomThree.setTitle("The Quidditch Field");
		outdoorRoomThree.setRoomDescription(" As you approach the field, the HufflePuff and Ravenclaw players have been locked in a dead heat."
				+ " On one side of the field, there are massive stands for each of the four House. "
				+ " On the ends of the field, the three rings for each time team dwarf your height."
				+ " In the distance to the east, the Forbidden Forest looms."
				+ " To the south, you see smoke coming from Hagrids.");
		outdoorRoomThree.setLookDownDescription(" The bottom of the quidditch pitch is everything you'd expect.");
		outdoorRoomThree.setLookUpDescription(" The sky is full of players zipping across the sky.");
		mapArray[2][0] = outdoorRoomThree;
		
		// Room 3,0
		npcRoomOneHagridsHat.setTitle("Hagrids Hut");
		npcRoomOneHagridsHat.setRoomDescription(" Large billowing smoke exits the massive hut. "
				+ " You slowing approach. A low key shrieking can be heard  from within. "
				+ " A massive bon fire crackles on the side of the hut. Some unicorn meet is cooking."
				+ " Hagrid doesn't seem to be here..."
				+ " To the east of Hagrid's Hut, you hear a loud scream come from the Forbidden Forest."
				+ " South of the Hut is the outdoor grounds to Hogwarts.");
		npcRoomOneHagridsHat.setLookDownDescription(" Pieces of wood lie about. ");
		npcRoomOneHagridsHat.setLookUpDescription(" Any light in this area is suffocated by the Forbidden Forest.");
		mapArray[3][0] = npcRoomOneHagridsHat;
		
		// Room 4,0
		outdoorRoomFour.setTitle("The Open Field");
		outdoorRoomFour.setRoomDescription(" You see an open field."
				+ " It seems strangely desolate... "
				+ " Mudding steps are seen everywhere. "
				+ " Like people left in a panic."
				+ " The only way to go is south.");
		outdoorRoomFour.setLookDownDescription(" A lone pair of steps gain your attention. They seem to change as they go along"
				+ " Steps of a man becoming... wider... and longer. You see the imprint of claws begin to take root in the mud."
				+ " This is unsettling.");
		outdoorRoomFour.setLookUpDescription(" As the sky turns black, you see a flame shoot across it. It came from the castle.");
		mapArray[4][0] = outdoorRoomFour;
		
		//Room 5,0
		outdoorRoomFive.setTitle("The Scorched Remains");
		outdoorRoomFive.setRoomDescription(" You saw the smoke as you approached."
				+ " It was the scorched remains of a body. "
				+ " There are no signs of who it is."
				+ " What happened here..."
				+ " To the south you see the entrance hallway of Hogwarts, it is the only way to go.");
		outdoorRoomFive.setLookDownDescription(" Charred pink fabric lines the ground. Who was this...");
		outdoorRoomFive.setLookUpDescription(" A smokey mist flies over your head.");
		mapArray[5][0] = outdoorRoomFive;
		
		//Room 6, 0
		mobRoomOneHallway.setTitle("The Entrance Hallway");
		mobRoomOneHallway.setRoomDescription(" Scattered about the entrance to school are the robes of other students. Papers..."
				+ " Wands... shoes are strewn about."
				+ " Something just happened."
				+ " The entrance is a grand door. Upon further examination, you see burn marks on it. "
				+ " The strong scent of smoke that you smelled outside remains."
				+ " The dining hall is the only room connected to the great entrance and it is south.");
		mobRoomOneHallway.setLookDownDescription(" You see bloody splotches of fur. What kind of animal was this?");
		mobRoomOneHallway.setLookUpDescription(" The entrance arches remind you of when you first came here many years ago.");
		mapArray[6][0] = mobRoomOneHallway;
		
		//Room 7, 0
		mobRoomTwoDiningHall.setTitle("The Dining Hall");
		mobRoomTwoDiningHall.setRoomDescription(" The instuctors chairs are seen in the background. Disturbingly vacant at this time..."
				+ " The drinks and food are still set on the tables. The food has barely been touched."
				+ " Exits to the east and south are present. ");
		mobRoomTwoDiningHall.setLookDownDescription(" Mom's spaghetti lines the floor.");
		mobRoomTwoDiningHall.setLookUpDescription(" Floating chandeliers with candles line the ceiling. "
				+ " The candles blow back and forth as if... something is breathing.");
		mapArray[7][0] = mobRoomTwoDiningHall;
		
		//Room 8, 0
		stairsRoomOne.setTitle("The Stairway ");
		stairsRoomOne.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" Dependency Injection \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south to the castle entrance or east to... more stairs huehuehuehue");
		stairsRoomOne.setLookDownDescription(" The stairs glide along as you move up them.");
		stairsRoomOne.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[8][0] = stairsRoomOne;
		
		//Room 9, 0
		mobRoomThreeCastleEntrance.setTitle("The Castle Entrance ");
		mobRoomThreeCastleEntrance.setRoomDescription(" The grand entrance to the castle is more majestic than you remembered. "
				+ " Vin Diesel sits atop in his bronze statue. You remember his famous wizard, Melchior. "
				+ " Your resolve to figure out what happen grows. "
				+ " The entrance leads east to a hallway. ");
		mobRoomThreeCastleEntrance.setLookDownDescription(" Etched in stone: \"Cindiesel was here\"");
		mobRoomThreeCastleEntrance.setLookUpDescription(" The heros of Hogwarts line the arches in memory of their great deeds.");
		mapArray[9][0] = mobRoomThreeCastleEntrance;
		
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
		twoMobRoomOneHallway.setLookDownDescription(" Slime lines the ground. It's getting everywhere.");
		twoMobRoomOneHallway.setLookUpDescription(" On the roof and walls, spiderwebs line the hallway.");
		mapArray[0][1] = twoMobRoomOneHallway;
		
		//Room 1, 1
		twoMobRoomTwoRoomOfRequirement.setTitle("The RoR");
		twoMobRoomTwoRoomOfRequirement.setRoomDescription(" This room is full of trinkets. "
				+ "Piled as high as you can imagine there are many items for the taking."
				+ " I should be careful though, some of the items are cursed. "
				+ " I also wish I had more time to search through the mess..."
				+ " ");
		twoMobRoomTwoRoomOfRequirement.setLookDownDescription(" A trinket shoots past your feet!");
		twoMobRoomTwoRoomOfRequirement.setLookUpDescription(" Goblins line piles of rubbish. They throw pieces at you. \"Get out\"");
		mapArray[1][1] = twoMobRoomTwoRoomOfRequirement;
		
		//Room 2, 1
		twoMobRoomThreeForbiddenForest.setTitle("Centaurs, Brah");
		twoMobRoomThreeForbiddenForest.setRoomDescription(" You're beginning to think this was a bad idea to go this way."
				+ " Yep, it was. In the distance, you see a group of centaurs. The dark underbrush provides concealment. They slowing"
				+ " start to head the other way.");
		twoMobRoomThreeForbiddenForest.setLookDownDescription(" Centaur footprints line the forest floor.");
		twoMobRoomThreeForbiddenForest.setLookUpDescription(" An arrow whizzes past your face. Definitely a bad idea.");
		mapArray[2][1] = twoMobRoomThreeForbiddenForest;
		
		//Room 3, 1
		twoMobRoomFourForbiddenForest.setTitle(" Spiders abound");
		twoMobRoomFourForbiddenForest.setRoomDescription(" The forest begins to thicken. "
				+ "More and more leaves seems to be sticking to your robe."
				+ " Your movement begins to slow. "
				+ " You start to notice a clear dark substance attaching itself to you and "
				+ " whatever else it touches. You suddenly come the realization. You look up."
				+ " Thousands of eyes seem to be peering bck at you. It is the den of spiders."
				+ " You should go back from whence you came!");
		twoMobRoomFourForbiddenForest.setLookDownDescription(" Millions of eight legged freaks line the forest floor.");
		twoMobRoomFourForbiddenForest.setLookUpDescription(" Lurking in the trees, you begin to see branches moving."
				+ " Those aren't branches...");
		mapArray[3][1] = twoMobRoomFourForbiddenForest;
		
		//Room 4, 1
		twoNPCRoomOneHarryRonShrine.setTitle("Harry and Ron's Shrine");
		twoNPCRoomOneHarryRonShrine.setRoomDescription("What a weird room. Nothing of great importance seems to be here."
				+ " You should go back to where you were.");
		twoNPCRoomOneHarryRonShrine.setLookDownDescription(" The floor is so sparkly.");
		twoNPCRoomOneHarryRonShrine.setLookUpDescription(" The ceiling is so sparkly.");
		mapArray[4][1] = twoNPCRoomOneHarryRonShrine;
		
		//Room 5, 1
		twoMobRoomFiveBoysRoom.setTitle("The Little Boys Room");
		twoMobRoomFiveBoysRoom.setRoomDescription("This is the boys room."
				+ " Definitely not haunted.");
		twoMobRoomFiveBoysRoom.setLookDownDescription(" In one of the stalls, a massive club has broking the door in half. "
				+ " Only a giant could pick this up.");
		twoMobRoomFiveBoysRoom.setLookUpDescription( "It's not haunted, but there is a huge hole in the ceiling and the walls.");
		mapArray[5][1] = twoMobRoomFiveBoysRoom;
		
		//Room 6,1
		twoStairsOne.setTitle("The Stairway ");
		twoStairsOne.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" CinDiesel \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south to the castle entrance or east to... more stairs huehuehuehue");
		twoStairsOne.setLookDownDescription(" The stairs glide along as you move up them.");
		twoStairsOne.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[6][1] = twoStairsOne;
		
		//Room 7, 1
		twoStairsTwo.setTitle("The Stairway ");
		twoStairsTwo.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" CSC 335 Class Code \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south to more stairs or east");
		twoStairsTwo.setLookDownDescription(" The stairs glide along as you move up them.");
		twoStairsTwo.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[7][1] = twoStairsTwo;
		
		//Room 8, 1
		twoStairsThree.setTitle("The Stairway ");
		twoStairsThree.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" CSC 345 Red Black Tree \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south or east");
		twoStairsThree.setLookDownDescription(" The stairs glide along as you move up them.");
		twoStairsThree.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[8][1] = twoStairsThree;
		
		//Room 9, 1
		twoMobRoomSixHallway.setTitle("The Entrance Hallway");
		twoMobRoomSixHallway.setRoomDescription(" The scorch marks at the entrance door continue here."
				+ " This hallway is unusually dark. Old, armored knights line the hallways. "
				+ " Their shining armor helps your vision somewhat. The hallway leads north or east.");
		twoMobRoomSixHallway.setLookDownDescription(" Metal swords hit the ground. And soon you hear footsteps.");
		twoMobRoomSixHallway.setLookUpDescription(" The ceiling is actually pretty normal here. Thank goodness.");
		mapArray[9][1] = twoMobRoomSixHallway;
		
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
		threeMobRoomOneJointBedRoom.setLookDownDescription(" You see the bodies of other students. You recognize some of their faces...");
		threeMobRoomOneJointBedRoom.setLookUpDescription(" You see a wizard cloak floating through the air.");
		mapArray[0][2] = threeMobRoomOneJointBedRoom;
		
		//Room 1,2
		threeMobRoomTwoHallway.setTitle("Spooky Hallway");
		threeMobRoomTwoHallway.setRoomDescription("Did I mention how dark and spooky these hallways were?"
				+ " Candle lights line both sides of the hallway. "
				+ " The light coming off them is nothing. "
				+ " The flames sway back and forth. Like somethings breathing is causing it."
				+ " You feel a slight wind as you continue along the hallway."
				+ " This hallway can go in all four directions.");
		threeMobRoomTwoHallway.setLookDownDescription(" You see a student writhin in pain...like a dementor is sucking away their soul.");
		threeMobRoomTwoHallway.setLookUpDescription(" Flying above you, you see a dementor floating about.");
		mapArray[1][2] = threeMobRoomTwoHallway;
		
		//Room 2, 2
		threeStairsOne.setTitle("The Stairway ");
		threeStairsOne.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" Sahil was here \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south or east");
		threeStairsOne.setLookDownDescription(" The stairs glide along as you move up them.");
		threeStairsOne.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[2][2] = threeStairsOne;
		
		//Room 3, 2
		threeMobRoomThreeThirdFloor.setTitle("Third Floor Entrance");
		threeMobRoomThreeThirdFloor.setRoomDescription( "You enter the room. Immediately, you are asked to"
				+ "input your credit card information to the Kickstarter for the sequel to this game."
				+ " Or you could just exit to the north.");
		threeMobRoomThreeThirdFloor.setLookDownDescription(" This is where the sequel will begin.");
		threeMobRoomThreeThirdFloor.setLookUpDescription(" This is where the prequel will begin.");
		mapArray[3][2] = threeMobRoomThreeThirdFloor;
		
		//Room 4, 2
		threeMobRoomFourBoysRoom.setTitle("Boys Room");
		threeMobRoomFourBoysRoom.setRoomDescription(" The room is untouched. Everything is clean."
				+ " Wow so clean. Much sparkle. Wow.");
		threeMobRoomFourBoysRoom.setLookDownDescription("A troll breaks through the floor. It is massive. It hasn't noticed you yet.");
		threeMobRoomFourBoysRoom.setLookUpDescription(" There is nothing to help you here.");
		mapArray[4][2] = threeMobRoomFourBoysRoom;
		
		//Room 5, 2
		threeMobRoomFiveEmptyRoom.setTitle("Empty Room");
		threeMobRoomFiveEmptyRoom.setRoomDescription(" This is an empty room with an empty description.");
		threeMobRoomFiveEmptyRoom.setLookDownDescription(" Empty floor for an empty room.");
		threeMobRoomFiveEmptyRoom.setLookUpDescription(" Empty ceiling for an empty room.");
		mapArray[5][2] = threeMobRoomFiveEmptyRoom;
		
		//Room 6, 2
		threeStairsTwo.setTitle("The Stairway ");
		threeStairsTwo.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" For he who is worthy, they shall wield the Dependency Injection Staff of Jeremy \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go south or east");
		threeStairsTwo.setLookDownDescription(" The stairs glide along as you move up them.");
		threeStairsTwo.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[6][2] = threeStairsTwo;
		
		//Room 7, 2
		threeMobRoomSixGriffindorCommonRoom.setTitle("Griffindor Common Room");
		threeMobRoomSixGriffindorCommonRoom.setRoomDescription(" A group of students huddle in the corner."
				+ " They are visibly shaken and in shock. "
				+ " They can't tell you what has happened."
				+ " As if something has a spell over them."
				+ " You can leave the room from the west, north and east.");
		threeMobRoomSixGriffindorCommonRoom.setLookDownDescription(" Their wands line up in front of them as if someone was hoping they would grab one.");
		threeMobRoomSixGriffindorCommonRoom.setLookUpDescription(" A wizard you have never seen before sits in the air and stares at you.");
		mapArray[7][2] = threeMobRoomSixGriffindorCommonRoom;
		
		//Room 8, 2
		threeMobRoomSevenSlytherinCommonRoom.setTitle("Slytherin Common Room");
		threeMobRoomSevenSlytherinCommonRoom.setRoomDescription(" The crest of Slytherin is seen as you enter the room."
				+ " Everything is neat and where you would expect it. Nothing is strewn on the floor."
				+ " I'm pretty sure these are the bad guys."
				+ " You can go east or west.");
		threeMobRoomSevenSlytherinCommonRoom.setLookDownDescription(" Green fabric lines the walls. Old rustic furniture  takes up most of the room."
				+ " This shit is straight up evil.");
		threeMobRoomSevenSlytherinCommonRoom.setLookUpDescription(" Old statues line the ceiling. Green is everywhere.");
		mapArray[8][2] = threeMobRoomSevenSlytherinCommonRoom;
		
		//Room 9, 2
		threeMobRoomEightHufflepuffCommonRoom.setTitle("Hufflepuff Common Room");
		threeMobRoomEightHufflepuffCommonRoom.setRoomDescription(" Hufflepuff things are in HufflePuffs room."
				+ " What a weird name...");
		threeMobRoomEightHufflepuffCommonRoom.setLookDownDescription(" The floor is engraved with past leaders of HufflePuff."
				+ " A majestic rug lines the floor in front of the fire place.");
		threeMobRoomEightHufflepuffCommonRoom.setLookUpDescription(" The walls are lined with circular windows. "
				+ " Magical sunlight enters the room and lights it up.");
		mapArray[9][2] = threeMobRoomEightHufflepuffCommonRoom;
		
		//Create fourth column 10 rooms
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
		
		GenericRoom fourStairsOne = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom fourMobRoomOneLibary = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fourMobRoomTwoRavenClawCommonRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fourStairsTwo = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom fourMobRoomThreeEmptyRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fourMobRoomFourGirlsRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fourMobRoomFiveHermionesShrine = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fourNPCRoomOneMcgonagalsRoom= RoomFactory.designRoom(RoomType.NPC);
		GenericRoom fourStairsThree = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom fourNPCRoomTwoProfessorTrudeauxRoom = RoomFactory.designRoom(RoomType.NPC);
		
		//Third Column east connection with fourth column
		threeMobRoomOneJointBedRoom.setEastRoom(fourStairsOne);
		threeMobRoomTwoHallway.setEastRoom(fourMobRoomOneLibary);
		threeStairsOne.setEastRoom(fourMobRoomTwoRavenClawCommonRoom);
		threeMobRoomFourBoysRoom.setEastRoom(fourMobRoomThreeEmptyRoom);
		threeMobRoomFiveEmptyRoom.setEastRoom(fourMobRoomFourGirlsRoom);
		threeMobRoomSixGriffindorCommonRoom.setEastRoom(fourNPCRoomOneMcgonagalsRoom);
		threeMobRoomSevenSlytherinCommonRoom.setEastRoom(fourStairsThree);
		threeMobRoomEightHufflepuffCommonRoom.setEastRoom(fourNPCRoomTwoProfessorTrudeauxRoom);
		
		//Fourth Column west connection with third column
		fourStairsOne.setWestRoom(threeMobRoomOneJointBedRoom);
		fourMobRoomOneLibary.setWestRoom(threeMobRoomTwoHallway);
		fourMobRoomTwoRavenClawCommonRoom.setWestRoom(threeStairsOne);
		fourMobRoomThreeEmptyRoom.setWestRoom(threeMobRoomFourBoysRoom);
		fourMobRoomFourGirlsRoom.setWestRoom(threeMobRoomFiveEmptyRoom);
		fourNPCRoomOneMcgonagalsRoom.setWestRoom(threeMobRoomSixGriffindorCommonRoom);
		fourStairsThree.setWestRoom(threeMobRoomSevenSlytherinCommonRoom);
		fourNPCRoomTwoProfessorTrudeauxRoom.setWestRoom(threeMobRoomEightHufflepuffCommonRoom);
	
		//Fourth Column set south connection
		fourMobRoomTwoRavenClawCommonRoom.setSouthRoom(fourStairsTwo);
		fourStairsTwo.setSouthRoom(fourMobRoomThreeEmptyRoom);
		fourMobRoomFourGirlsRoom.setSouthRoom(fourMobRoomFiveHermionesShrine);
		
		//Fourth Column set North connection
		fourStairsTwo.setNorthRoom(fourMobRoomTwoRavenClawCommonRoom);
		fourMobRoomThreeEmptyRoom.setNorthRoom(fourStairsTwo);
		fourMobRoomFiveHermionesShrine.setNorthRoom(fourMobRoomFourGirlsRoom);
		
	
		
		

		//Room 0,3
		fourStairsOne.setTitle("The Stairway ");
		fourStairsOne.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" WELCOME TO CSC 335!!!! \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go west or North");
		
		//Room 1,3
		fourMobRoomOneLibary.setTitle("Old Main Library");
		fourMobRoomOneLibary.setRoomDescription(" Old manuscripts and books are scatter all about. Scanning the room, pages sprinkle from shelves half burnt."
				+ " \"Fantastic Beasts a..\" flashes before your face. Peering around a dusted bookcase, a tail creeps around the corner and out of sight."
				+ " Beads of water drip along your cheek. "
				+ " Smuldering pages can be heard in the background."
				+ " Grasping your wand, you turn the corner."
				+ " Gone."
				+ " You can only go back the way you came.");
		
		//Room 2, 3
		fourMobRoomTwoRavenClawCommonRoom.setTitle("Ravenclaw Common Room");
		fourMobRoomTwoRavenClawCommonRoom.setRoomDescription(" As you enter the room, a shout echoes from behind you."
				+ " \"AVADA.. \" "
				+ " Immediately you seize the door and slam it shut. "
				+ " Casting a spell to seal the door. "
				+ " South is the only way out.");
		
		//Room 3, 3
		fourStairsTwo.setTitle("The Stairway ");
		fourStairsTwo.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" Netpaint for Dummies. \""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go west or North");
	
		//Room 4, 3
		fourMobRoomThreeEmptyRoom.setTitle("Empty Room");
		fourMobRoomThreeEmptyRoom.setRoomDescription(" The room is untouched. Everything is clean."
			+ " Wow so clean. Much sparkle. Wow."
			+ " It's also empty."
			+ " The only way out is west and north.");
		
		//Room 5, 3
		fourMobRoomFourGirlsRoom.setTitle("The Girls Room");
		fourMobRoomFourGirlsRoom.setRoomDescription(" The girls room is untouched. The beds and stands remain intact."
				+ " Whatever is happening hasn't been here yet."
				+ " The only way out are west and south.");
		
		//Room 6, 3
		fourMobRoomFiveHermionesShrine.setTitle("Hermione's Shrine ");
		fourMobRoomFiveHermionesShrine.setRoomDescription(" You've read about this place in all your course."
				+ " The fabled shrine of the smartest student to ever go to Hogswarts. "
				+ " Something appears to be lodged in her hand. I wonder what it is."
				+ " The only exit is north.");
		
		//Room 7, 3
		fourNPCRoomOneMcgonagalsRoom.setTitle("McGonagals Office");
		fourNPCRoomOneMcgonagalsRoom.setRoomDescription(" As you enter the room, a torrent of wind pushes you on your back. Behind the desk, a wand points at you"
				+ " \"WHO GOES THERE?\"");
		
		//Room 8, 3
		fourStairsThree.setTitle("The Stairway ");
		fourStairsThree.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " You're eyes glaze upon the figure. The caption of the painting states, \" THIS IS 335!\""
				+ " You don't quite understand the picture, but it is magnificent."
				+ " The stairs go west or North");
	
		//Room 9, 3
		fourNPCRoomTwoProfessorTrudeauxRoom.setTitle("Professor Trudeaux's Room");
		fourNPCRoomTwoProfessorTrudeauxRoom.setRoomDescription(" Stacks of paper clog the room. Old formulas and spells it seems."
				+ " The floor is covered in from the outside. "
				+ " There may be something I can learn from these stacks."
				+ " The only exit is west.");
	}

	
	public GenericRoom getEntrance() {
	      return mapStart;
	}
	
	public GenericRoom[][] getMapArray() {
	      return this.mapArray;
	}
	
}