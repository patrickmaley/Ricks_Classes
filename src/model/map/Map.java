package model.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import model.items.AvadaKedvra;
import model.items.BassilskFang;
import model.items.Broomstick;
import model.items.ButterBeer;
import model.items.Crucio;
import model.items.DependencyInjectionSword;
import model.items.ElderWand;
import model.items.ExpectoPatronum;
import model.items.Expelliarumus;
import model.items.Expulso;
import model.items.HealingPotion;
import model.items.HermoinesHandbag;
import model.items.Horcrux;
import model.items.Imperio;
import model.items.Incendio;
import model.items.Item;
import model.items.MaurdersMap;
import model.items.NeverEndingBook;
import model.items.PetrificusTotalus;
import model.items.PhoenixTears;
import model.items.RegularWand;
import model.items.RessurectionStone;
import model.items.SectumSempra;
import model.items.Spell;
import model.items.Spellbook;
import model.items.Stupefy;
import model.items.SwordOfGryffindor;
import model.mobs.*;
import model.room.GenericRoom;
import model.room.RoomFactory;
import model.room.RoomType;

public class Map implements Serializable {
	private static Map uniqueInstance = null;
	private GenericRoom mapStart;
	private GenericRoom[][] mapArray = new GenericRoom[10][6];

	// 0 to 2 as second
	// 0 to 9 as first
	// Implement singleton to only use one map
	private Map() {
		createMap();
		generateItems();
		generateMobs();
	}

	public static Map setMap() {
		if (uniqueInstance == null) {
			uniqueInstance = new Map();
		}
		return uniqueInstance;
	}

	private void createMap() {
		// Create first 10 rooms
		/*
		 * + - - - - - + - - - - - + - - - - - + - - - - - + - - - - - + - - - -
		 * - + - - - - - + - - - - - + - - - - - + - - - - -
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

		// Create second column 10 rooms
		/*
		 * - + - - - - - + - - - - - + - - - - - + - - - - - + - - - - - + - - -
		 * - - + - - - - - + - - - - - + - - - - - + - - - -
		 */

		GenericRoom twoMobRoomOneHallway = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom twoMobRoomTwoRoomOfRequirement = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom twoMobRoomThreeForbiddenForest = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom twoMobRoomFourForbiddenForest = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom twoNPCRoomOneHarryRonShrine = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom twoMobRoomFiveBoysRoom = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom twoStairsOne = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom twoStairsTwo = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom twoStairsThree = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom twoMobRoomSixHallway = RoomFactory.designRoom(RoomType.MOB);

		// Create third column 10 rooms
		/*
		 * - - + - - - - - + - - - - - + - - - - - + - - - - - + - - - - - + - -
		 * - - - + - - - - - + - - - - - + - - - - - + - - -
		 */

		GenericRoom threeMobRoomOneJointBedRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeMobRoomTwoHallway = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeStairsOne = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom threeMobRoomThreeThirdFloor = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeMobRoomFourBoysRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeMobRoomFiveEmptyRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeStairsTwo = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom threeMobRoomSixGriffindorCommonRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeMobRoomSevenSlytherinCommonRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom threeMobRoomEightHufflepuffCommonRoom = RoomFactory.designRoom(RoomType.MOB);

		// Create fourth column 10 rooms
		/*
		 * - - + - - - - - + - - - - - + - - - - - + - - - - - + - - - - - + - -
		 * - - - + - - - - - + - - - - - + - - - - - + - - -
		 */

		GenericRoom fourStairsOne = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom fourMobRoomOneLibary = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fourMobRoomTwoRavenClawCommonRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fourStairsTwo = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom fourMobRoomThreeEmptyRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fourMobRoomFourGirlsRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fourMobRoomFiveHermionesShrine = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fourNPCRoomOneMcgonagalsRoom = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom fourStairsThree = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom fourNPCRoomTwoProfessorTrudeauxRoom = RoomFactory.designRoom(RoomType.NPC);

		// Create fifth column 10 rooms
		/*
		 * - + - - - - - + - - - - - + - - - - - + - - - - - + - - - - - + - - -
		 * - - + - - - - - + - - - - - + - - - - - + - - - -
		 */
		GenericRoom fiveCommonGroundOne = RoomFactory.designRoom(RoomType.OUTDOORS);
		GenericRoom fiveHoneydukes = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom fiveAstronomyTower = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fiveOutdoorGroundsOne = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom fiveRavenclawGirlsRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fiveQuidditchPitch = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fiveVoldemortsShrine = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom fiveSlytherinBoysRoom = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom fiveSlytherinEmptyRoom = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom fiveSlytherinGirlsRoom = RoomFactory.designRoom(RoomType.NPC);

		// Create fifth column 10 rooms
		/*
		 * - + - - - - - + - - - - - + - - - - - + - - - - - + - - - - - + - - -
		 * - - + - - - - - + - - - - - + - - - - - + - - - -
		 */
		GenericRoom sixShriekingShack = RoomFactory.designRoom(RoomType.OUTDOORS);
		GenericRoom sixHogsmeadeVillage = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom sixZonksJokeShop = RoomFactory.designRoom(RoomType.NPC);
		GenericRoom sixOutdoorGroundsOne = RoomFactory.designRoom(RoomType.OUTDOORS);
		GenericRoom sixOutdoorGroundsTwo = RoomFactory.designRoom(RoomType.OUTDOORS);
		GenericRoom sixOutdoorGroundsThree = RoomFactory.designRoom(RoomType.OUTDOORS);
		GenericRoom sixSnapesRoom = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom sixStairs = RoomFactory.designRoom(RoomType.STAIRS);
		GenericRoom sixDumbledoresOffice = RoomFactory.designRoom(RoomType.MOB);
		GenericRoom sixPensieveRoom = RoomFactory.designRoom(RoomType.NPC);

		// Set map entrance
		mapStart = outdoorRoomOne;

		// Connect first 10 rooms
		// South connection
		outdoorRoomOne.setSouthRoom(outdoorRoomTwo);
		outdoorRoomTwo.setSouthRoom(outdoorRoomThree);
		outdoorRoomThree.setSouthRoom(npcRoomOneHagridsHat);
		npcRoomOneHagridsHat.setSouthRoom(outdoorRoomFour);
		outdoorRoomFour.setSouthRoom(outdoorRoomFive);
		outdoorRoomFive.setSouthRoom(mobRoomOneHallway);
		mobRoomOneHallway.setSouthRoom(mobRoomTwoDiningHall);
		mobRoomTwoDiningHall.setSouthRoom(stairsRoomOne);
		stairsRoomOne.setSouthRoom(mobRoomThreeCastleEntrance);
		mobRoomThreeCastleEntrance.setSouthRoom(outdoorRoomOne);

		// North connection
		outdoorRoomOne.setNorthRoom(mobRoomThreeCastleEntrance);
		outdoorRoomTwo.setNorthRoom(outdoorRoomOne);
		outdoorRoomThree.setNorthRoom(outdoorRoomTwo);
		npcRoomOneHagridsHat.setNorthRoom(outdoorRoomThree);
		outdoorRoomFour.setNorthRoom(npcRoomOneHagridsHat);
		outdoorRoomFive.setNorthRoom(outdoorRoomFour);
		mobRoomOneHallway.setNorthRoom(outdoorRoomFive);
		mobRoomTwoDiningHall.setNorthRoom(mobRoomOneHallway);
		stairsRoomOne.setNorthRoom(mobRoomTwoDiningHall);
		mobRoomThreeCastleEntrance.setNorthRoom(stairsRoomOne);

		// East connection
		outdoorRoomThree.setEastRoom(twoMobRoomThreeForbiddenForest);
		npcRoomOneHagridsHat.setEastRoom(twoMobRoomFourForbiddenForest);
		mobRoomTwoDiningHall.setEastRoom(twoStairsTwo);
		stairsRoomOne.setEastRoom(twoStairsThree);
		mobRoomThreeCastleEntrance.setEastRoom(twoMobRoomSixHallway);

		// West Connection
		outdoorRoomTwo.setWestRoom(sixHogsmeadeVillage);
		npcRoomOneHagridsHat.setWestRoom(sixOutdoorGroundsOne);
		outdoorRoomFour.setWestRoom(sixOutdoorGroundsTwo);
		outdoorRoomFive.setWestRoom(sixOutdoorGroundsThree);
		mobRoomOneHallway.setWestRoom(sixSnapesRoom);

		// set Title and Description of 10 rooms
		// Room 0,0
		outdoorRoomOne.setTitle("Beyond the Whomping Willow");
		outdoorRoomOne.setRoomDescription("A tree sets off in the distance."
				+ " The branches appear fragile, but you know how fierce they can be. Turning away, "
				+ " you remember that you left something behind in the common room of Hogswart."
				+ " There are three ways to go north, east, and south.");
		outdoorRoomOne.setLookDownDescription("The grassy knoll leads down into a clearing."
				+ " The grass near the Whomping Willow is still smuldering.");
		outdoorRoomOne.setLookUpDescription(" Bright colors flash along the horizon."
				+ " The sky begins to turn bright red. This shit is getting real");
		mapArray[0][0] = outdoorRoomOne;

		// Room 1,0
		outdoorRoomTwo.setTitle("The Scenic Route");
		outdoorRoomTwo
				.setRoomDescription("Walking down the side of a hill. You see the quidditch arena in the distance. "
						+ " The small dots are whirling back and forth gliding through the air."
						+ " Other students are milling about on the field practicing their spells."
						+ " There are three ways to go north, west, and south.");
		outdoorRoomTwo.setLookDownDescription(" The path to the quidditch arena has been worn down. "
				+ " Mudding footsteps line the path heading in both directions.");
		outdoorRoomTwo.setLookUpDescription(" A sole figure is floating in the sky. It's cloack is whirling behind it. "
				+ "Legless as it flies around the castle.");
		mapArray[1][0] = outdoorRoomTwo;

		// Room 2,0
		outdoorRoomThree.setTitle("The Quidditch Practice Grounds");
		outdoorRoomThree.setRoomDescription(
				" As you approach the practice grounds, the HufflePuff and Ravenclaw players have been locked in a dead heat."
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
				+ " South of the Hut is the outdoor grounds to Hogwarts, but you can go in any direction you like");
		npcRoomOneHagridsHat.setLookDownDescription(" Pieces of wood lie about. ");
		npcRoomOneHagridsHat.setLookUpDescription(" Any light in this area is suffocated by the Forbidden Forest.");
		mapArray[3][0] = npcRoomOneHagridsHat;

		// Room 4,0
		outdoorRoomFour.setTitle("The Open Field");
		outdoorRoomFour.setRoomDescription(
				" You see an open field." + " It seems strangely desolate... " + " Mudding steps are seen everywhere. "
						+ " Like people left in a panic." + " The only way to go is south.");
		outdoorRoomFour.setLookDownDescription(
				" A lone pair of steps gain your attention. They seem to change as they go along"
						+ " Steps of a man becoming... wider... and longer. You see the imprint of claws begin to take root in the mud."
						+ " This is unsettling.");
		outdoorRoomFour.setLookUpDescription(
				" As the sky turns black, you see a flame shoot across it. It came from the castle.");
		mapArray[4][0] = outdoorRoomFour;

		// Room 5,0
		outdoorRoomFive.setTitle("The Scorched Remains");
		outdoorRoomFive
				.setRoomDescription(" You saw the smoke as you approached." + " It was the scorched remains of a body. "
						+ " There are no signs of who it is." + " What happened here..."
						+ " To the south you see the entrance hallway of Hogwarts, it is the only way to go.");
		outdoorRoomFive.setLookDownDescription(" Charred pink fabric lines the ground. Who was this...");
		outdoorRoomFive.setLookUpDescription(" A smokey mist flies over your head.");
		mapArray[5][0] = outdoorRoomFive;

		// Room 6, 0
		mobRoomOneHallway.setTitle("The Entrance Hallway");
		mobRoomOneHallway
				.setRoomDescription(" Scattered about the entrance to school are the robes of other students. Papers..."
						+ " Wands... shoes are strewn about." + " Something just happened."
						+ " The entrance is a grand door. Upon further examination, you see burn marks on it. "
						+ " The strong scent of smoke that you smelled outside remains."
						+ " The dining hall is the only room connected to the great entrance and it is south.");
		mobRoomOneHallway.setLookDownDescription(" You see bloody splotches of fur. What kind of animal was this?");
		mobRoomOneHallway
				.setLookUpDescription(" The entrance arches remind you of when you first came here many years ago.");
		mapArray[6][0] = mobRoomOneHallway;

		// Room 7, 0
		mobRoomTwoDiningHall.setTitle("The Dining Hall");
		mobRoomTwoDiningHall.setRoomDescription(
				" The instuctors chairs are seen in the background. Disturbingly vacant at this time..."
						+ " The drinks and food are still set on the tables. The food has barely been touched."
						+ " Exits to the east and south are present. ");
		mobRoomTwoDiningHall.setLookDownDescription(" Mom's spaghetti lines the floor.");
		mobRoomTwoDiningHall.setLookUpDescription(" Floating chandeliers with candles line the ceiling. "
				+ " The candles blow back and forth as if... something is breathing.");
		mapArray[7][0] = mobRoomTwoDiningHall;

		// Room 8, 0
		stairsRoomOne.setTitle("The Stairway ");
		stairsRoomOne
				.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
						+ " You double take. On the wall you see it."
						+ " You're eyes glaze upon the figure. The caption of the painting states, \" Dependency Injection \""
						+ " You don't quite understand the picture, but it is magnificent."
						+ " The stairs go south to the castle entrance or east to... more stairs huehuehuehue");
		stairsRoomOne.setLookDownDescription(" The stairs glide along as you move up them.");
		stairsRoomOne.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[8][0] = stairsRoomOne;

		// Room 9, 0
		mobRoomThreeCastleEntrance.setTitle("The Castle Entrance ");
		mobRoomThreeCastleEntrance
				.setRoomDescription(" The grand entrance to the castle is more majestic than you remembered. "
						+ " Vin Diesel sits atop in his bronze statue. You remember his famous wizard, Melchior. "
						+ " Your resolve to figure out what happen grows. "
						+ " The entrance leads east to a hallway. ");
		mobRoomThreeCastleEntrance.setLookDownDescription(" Etched in stone: \"Cindiesel was here\"");
		mobRoomThreeCastleEntrance
				.setLookUpDescription(" The heros of Hogwarts line the arches in memory of their great deeds.");
		mapArray[9][0] = mobRoomThreeCastleEntrance;

		// Second Column West Connection with first
		twoMobRoomThreeForbiddenForest.setWestRoom(outdoorRoomThree);
		twoMobRoomFourForbiddenForest.setWestRoom(npcRoomOneHagridsHat);
		twoStairsTwo.setWestRoom(mobRoomTwoDiningHall);
		twoStairsThree.setWestRoom(stairsRoomOne);
		twoMobRoomSixHallway.setWestRoom(mobRoomThreeCastleEntrance);

		// Second Column South Connections
		twoMobRoomOneHallway.setSouthRoom(twoMobRoomTwoRoomOfRequirement);
		twoMobRoomThreeForbiddenForest.setSouthRoom(twoMobRoomFourForbiddenForest);
		twoNPCRoomOneHarryRonShrine.setSouthRoom(twoMobRoomFiveBoysRoom);
		twoStairsOne.setSouthRoom(twoStairsTwo);
		twoStairsTwo.setSouthRoom(twoStairsThree);
		twoStairsThree.setSouthRoom(twoMobRoomSixHallway);
		twoMobRoomSixHallway.setSouthRoom(twoMobRoomOneHallway);

		// Second Column North Connections
		twoMobRoomOneHallway.setNorthRoom(twoMobRoomSixHallway);
		twoMobRoomTwoRoomOfRequirement.setNorthRoom(twoMobRoomOneHallway);
		twoMobRoomFourForbiddenForest.setNorthRoom(twoMobRoomThreeForbiddenForest);
		twoMobRoomFiveBoysRoom.setNorthRoom(twoNPCRoomOneHarryRonShrine);
		twoStairsTwo.setNorthRoom(twoStairsOne);
		twoStairsThree.setNorthRoom(twoStairsTwo);
		twoMobRoomSixHallway.setNorthRoom(twoStairsThree);

		// Second Column East Connections
		twoMobRoomOneHallway.setEastRoom(threeMobRoomOneJointBedRoom);
		twoMobRoomTwoRoomOfRequirement.setEastRoom(threeMobRoomTwoHallway);
		twoMobRoomFiveBoysRoom.setEastRoom(threeMobRoomFiveEmptyRoom);
		twoStairsTwo.setEastRoom(threeMobRoomSixGriffindorCommonRoom);
		twoStairsThree.setEastRoom(threeMobRoomSevenSlytherinCommonRoom);
		twoMobRoomSixHallway.setEastRoom(threeMobRoomEightHufflepuffCommonRoom);

		// Room 0, 1
		twoMobRoomOneHallway.setTitle("Spooky Hallway");
		twoMobRoomOneHallway.setRoomDescription(" These back hallways have always been a little spooky."
				+ " It doesn't help that they are the darkest placec in the castle."
				+ " I wish there was some way to light it up..." + " There is only one mysterious way to the south...");
		twoMobRoomOneHallway.setLookDownDescription(" Slime lines the ground. It's getting everywhere.");
		twoMobRoomOneHallway.setLookUpDescription(" On the roof and walls, spiderwebs line the hallway.");
		mapArray[0][1] = twoMobRoomOneHallway;

		// Room 1, 1
		twoMobRoomTwoRoomOfRequirement.setTitle("The RoR");
		twoMobRoomTwoRoomOfRequirement.setRoomDescription(" This room is full of trinkets. "
				+ "Piled as high as you can imagine there are many items for the taking."
				+ " I should be careful though, some of the items are cursed. "
				+ " I also wish I had more time to search through the mess..." + " ");
		twoMobRoomTwoRoomOfRequirement.setLookDownDescription(" A trinket shoots past your feet!");
		twoMobRoomTwoRoomOfRequirement
				.setLookUpDescription(" Goblins line piles of rubbish. They throw pieces at you. \"Get out\"");
		mapArray[1][1] = twoMobRoomTwoRoomOfRequirement;

		// Room 2, 1
		twoMobRoomThreeForbiddenForest.setTitle("Centaurs, Brah");
		twoMobRoomThreeForbiddenForest
				.setRoomDescription(" You're beginning to think this was a bad idea to go this way."
						+ " Yep, it was. In the distance, you see a group of centaurs. The dark underbrush provides concealment. They slowing"
						+ " start to head the other way.");
		twoMobRoomThreeForbiddenForest.setLookDownDescription(" Centaur footprints line the forest floor.");
		twoMobRoomThreeForbiddenForest.setLookUpDescription(" An arrow whizzes past your face. Definitely a bad idea.");
		mapArray[2][1] = twoMobRoomThreeForbiddenForest;

		// Room 3, 1
		twoMobRoomFourForbiddenForest.setTitle(" Spiders abound");
		twoMobRoomFourForbiddenForest.setRoomDescription(" The forest begins to thicken. "
				+ "More and more leaves seems to be sticking to your robe." + " Your movement begins to slow. "
				+ " You start to notice a clear dark substance attaching itself to you and "
				+ " whatever else it touches. You suddenly come the realization. You look up."
				+ " Thousands of eyes seem to be peering bck at you. It is the den of spiders."
				+ " You should go back from whence you came!");
		twoMobRoomFourForbiddenForest.setLookDownDescription(" Millions of eight legged freaks line the forest floor.");
		twoMobRoomFourForbiddenForest.setLookUpDescription(
				" Lurking in the trees, you begin to see branches moving." + " Those aren't branches...");
		mapArray[3][1] = twoMobRoomFourForbiddenForest;

		// Room 4, 1
		twoNPCRoomOneHarryRonShrine.setTitle("Harry and Ron's Shrine");
		twoNPCRoomOneHarryRonShrine
				.setRoomDescription("What a weird room. Nothing of great importance seems to be here."
						+ " You should go back to where you were.");
		twoNPCRoomOneHarryRonShrine.setLookDownDescription(" The floor is so sparkly.");
		twoNPCRoomOneHarryRonShrine.setLookUpDescription(" The ceiling is so sparkly.");
		mapArray[4][1] = twoNPCRoomOneHarryRonShrine;

		// Room 5, 1
		twoMobRoomFiveBoysRoom.setTitle("The Little Boys Room");
		twoMobRoomFiveBoysRoom.setRoomDescription("This is the boys room." + " Definitely not haunted.");
		twoMobRoomFiveBoysRoom
				.setLookDownDescription(" In one of the stalls, a massive club has broking the door in half. "
						+ " Only a giant could pick this up.");
		twoMobRoomFiveBoysRoom
				.setLookUpDescription("It's not haunted, but there is a huge hole in the ceiling and the walls.");
		mapArray[5][1] = twoMobRoomFiveBoysRoom;

		// Room 6,1
		twoStairsOne.setTitle("The Stairway ");
		twoStairsOne
				.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
						+ " You double take. On the wall you see it."
						+ " You're eyes glaze upon the figure. The caption of the painting states, \" CinDiesel \""
						+ " You don't quite understand the picture, but it is magnificent."
						+ " The stairs go south to the castle entrance or east to... more stairs huehuehuehue");
		twoStairsOne.setLookDownDescription(" The stairs glide along as you move up them.");
		twoStairsOne.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[6][1] = twoStairsOne;

		// Room 7, 1
		twoStairsTwo.setTitle("The Stairway ");
		twoStairsTwo
				.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
						+ " You double take. On the wall you see it."
						+ " You're eyes glaze upon the figure. The caption of the painting states, \" CSC 335 Class Code \""
						+ " You don't quite understand the picture, but it is magnificent."
						+ " The stairs go south to more stairs or east");
		twoStairsTwo.setLookDownDescription(" The stairs glide along as you move up them.");
		twoStairsTwo.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[7][1] = twoStairsTwo;

		// Room 8, 1
		twoStairsThree.setTitle("The Stairway ");
		twoStairsThree
				.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
						+ " You double take. On the wall you see it."
						+ " You're eyes glaze upon the figure. The caption of the painting states, \" CSC 345 Red Black Tree \""
						+ " You don't quite understand the picture, but it is magnificent."
						+ " The stairs go south or east");
		twoStairsThree.setLookDownDescription(" The stairs glide along as you move up them.");
		twoStairsThree.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[8][1] = twoStairsThree;

		// Room 9, 1
		twoMobRoomSixHallway.setTitle("The Entrance Hallway");
		twoMobRoomSixHallway.setRoomDescription(" The scorch marks at the entrance door continue here."
				+ " This hallway is unusually dark. Old, armored knights line the hallways. "
				+ " Their shining armor helps your vision somewhat. The hallway leads north or east.");
		twoMobRoomSixHallway.setLookDownDescription(" Metal swords hit the ground. And soon you hear footsteps.");
		twoMobRoomSixHallway.setLookUpDescription(" The ceiling is actually pretty normal here. Thank goodness.");
		mapArray[9][1] = twoMobRoomSixHallway;

		// Third Column west connection with second column
		threeMobRoomOneJointBedRoom.setWestRoom(twoMobRoomOneHallway);
		threeMobRoomTwoHallway.setWestRoom(twoMobRoomTwoRoomOfRequirement);
		threeMobRoomFiveEmptyRoom.setWestRoom(twoMobRoomFiveBoysRoom);
		threeMobRoomSixGriffindorCommonRoom.setWestRoom(twoStairsTwo);
		threeMobRoomSevenSlytherinCommonRoom.setWestRoom(twoStairsThree);
		threeMobRoomEightHufflepuffCommonRoom.setWestRoom(twoMobRoomSixHallway);

		// Third Column set south connection
		threeMobRoomOneJointBedRoom.setSouthRoom(threeMobRoomTwoHallway);
		threeMobRoomTwoHallway.setSouthRoom(threeStairsOne);
		threeStairsOne.setSouthRoom(threeMobRoomThreeThirdFloor);
		threeMobRoomFiveEmptyRoom.setSouthRoom(threeStairsTwo);
		threeStairsTwo.setSouthRoom(threeMobRoomSixGriffindorCommonRoom);

		// Third Column set North connection
		threeMobRoomSixGriffindorCommonRoom.setNorthRoom(threeStairsTwo);
		threeStairsTwo.setNorthRoom(threeMobRoomFiveEmptyRoom);
		threeMobRoomThreeThirdFloor.setNorthRoom(threeStairsOne);
		threeStairsOne.setNorthRoom(threeMobRoomTwoHallway);
		threeMobRoomTwoHallway.setNorthRoom(threeMobRoomOneJointBedRoom);

		// Third Column east connection with fourth column
		threeMobRoomOneJointBedRoom.setEastRoom(fourStairsOne);
		threeMobRoomTwoHallway.setEastRoom(fourMobRoomOneLibary);
		threeStairsOne.setEastRoom(fourMobRoomTwoRavenClawCommonRoom);
		threeMobRoomFourBoysRoom.setEastRoom(fourMobRoomThreeEmptyRoom);
		threeMobRoomFiveEmptyRoom.setEastRoom(fourMobRoomFourGirlsRoom);
		threeMobRoomSixGriffindorCommonRoom.setEastRoom(fourNPCRoomOneMcgonagalsRoom);
		threeMobRoomSevenSlytherinCommonRoom.setEastRoom(fourStairsThree);
		threeMobRoomEightHufflepuffCommonRoom.setEastRoom(fourNPCRoomTwoProfessorTrudeauxRoom);

		// Room 0,2
		threeMobRoomOneJointBedRoom.setTitle("The BedRooms");
		threeMobRoomOneJointBedRoom.setRoomDescription("The bed sheets and blankets are everywhere."
				+ " Blood is on the walls. " + " There are so many questions. I hope I have an answer."
				+ " The room can be exited to the east, south or west.");
		threeMobRoomOneJointBedRoom
				.setLookDownDescription(" You see the bodies of other students. You recognize some of their faces...");
		threeMobRoomOneJointBedRoom.setLookUpDescription(" You see a wizard cloak floating through the air.");
		mapArray[0][2] = threeMobRoomOneJointBedRoom;

		// Room 1,2
		threeMobRoomTwoHallway.setTitle("Spooky Hallway");
		threeMobRoomTwoHallway.setRoomDescription("Did I mention how dark and spooky these hallways were?"
				+ " Candle lights line both sides of the hallway. " + " The light coming off them is nothing. "
				+ " The flames sway back and forth. Like somethings breathing is causing it."
				+ " You feel a slight wind as you continue along the hallway."
				+ " This hallway can go in all four directions.");
		threeMobRoomTwoHallway.setLookDownDescription(
				" You see a student writhin in pain...like a dementor is sucking away their soul.");
		threeMobRoomTwoHallway.setLookUpDescription(" Flying above you, you see a dementor floating about.");
		mapArray[1][2] = threeMobRoomTwoHallway;

		// Room 2, 2
		threeStairsOne.setTitle("The Stairway ");
		threeStairsOne
				.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
						+ " You double take. On the wall you see it."
						+ " You're eyes glaze upon the figure. The caption of the painting states, \" Sahil was here \""
						+ " You don't quite understand the picture, but it is magnificent."
						+ " The stairs go south or east");
		threeStairsOne.setLookDownDescription(" The stairs glide along as you move up them.");
		threeStairsOne.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[2][2] = threeStairsOne;

		// Room 3, 2
		threeMobRoomThreeThirdFloor.setTitle("Third Floor Entrance");
		threeMobRoomThreeThirdFloor.setRoomDescription("You enter the room. Immediately, you are asked to"
				+ "input your credit card information to the Kickstarter for the sequel to this game."
				+ " Or you could just exit to the north.");
		threeMobRoomThreeThirdFloor.setLookDownDescription(" This is where the sequel will begin.");
		threeMobRoomThreeThirdFloor.setLookUpDescription(" This is where the prequel will begin.");
		mapArray[3][2] = threeMobRoomThreeThirdFloor;

		// Room 4, 2
		threeMobRoomFourBoysRoom.setTitle("Boys Room");
		threeMobRoomFourBoysRoom.setRoomDescription(
				" The room is untouched. Everything is clean." + " Wow so clean. Much sparkle. Wow.");
		threeMobRoomFourBoysRoom
				.setLookDownDescription("A troll breaks through the floor. It is massive. It hasn't noticed you yet.");
		threeMobRoomFourBoysRoom.setLookUpDescription(" There is nothing to help you here.");
		mapArray[4][2] = threeMobRoomFourBoysRoom;

		// Room 5, 2
		threeMobRoomFiveEmptyRoom.setTitle("Empty Room");
		threeMobRoomFiveEmptyRoom.setRoomDescription(" This is an empty room with an empty description.");
		threeMobRoomFiveEmptyRoom.setLookDownDescription(" Empty floor for an empty room.");
		threeMobRoomFiveEmptyRoom.setLookUpDescription(" Empty ceiling for an empty room.");
		mapArray[5][2] = threeMobRoomFiveEmptyRoom;

		// Room 6, 2
		threeStairsTwo.setTitle("The Stairway ");
		threeStairsTwo
				.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
						+ " You double take. On the wall you see it."
						+ " You're eyes glaze upon the figure. The caption of the painting states, \" For he who is worthy, they shall wield the Dependency Injection Staff of Jeremy \""
						+ " You don't quite understand the picture, but it is magnificent."
						+ " The stairs go south or east");
		threeStairsTwo.setLookDownDescription(" The stairs glide along as you move up them.");
		threeStairsTwo.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		mapArray[6][2] = threeStairsTwo;

		// Room 7, 2
		threeMobRoomSixGriffindorCommonRoom.setTitle("Griffindor Common Room");
		threeMobRoomSixGriffindorCommonRoom.setRoomDescription(" A group of students huddle in the corner."
				+ " They are visibly shaken and in shock. " + " They can't tell you what has happened."
				+ " As if something has a spell over them." + " You can leave the room from the west, north and east.");
		threeMobRoomSixGriffindorCommonRoom.setLookDownDescription(
				" Their wands line up in front of them as if someone was hoping they would grab one.");
		threeMobRoomSixGriffindorCommonRoom
				.setLookUpDescription(" A wizard you have never seen before sits in the air and stares at you.");
		mapArray[7][2] = threeMobRoomSixGriffindorCommonRoom;

		// Room 8, 2
		threeMobRoomSevenSlytherinCommonRoom.setTitle("Slytherin Common Room");
		threeMobRoomSevenSlytherinCommonRoom.setRoomDescription(" The crest of Slytherin is seen as you enter the room."
				+ " Everything is neat and where you would expect it. Nothing is strewn on the floor."
				+ " I'm pretty sure these are the bad guys." + " You can go east or west.");
		threeMobRoomSevenSlytherinCommonRoom.setLookDownDescription(
				" Green fabric lines the walls. Old rustic furniture  takes up most of the room."
						+ " This shit is straight up evil.");
		threeMobRoomSevenSlytherinCommonRoom
				.setLookUpDescription(" Old statues line the ceiling. Green is everywhere.");
		mapArray[8][2] = threeMobRoomSevenSlytherinCommonRoom;

		// Room 9, 2
		threeMobRoomEightHufflepuffCommonRoom.setTitle("Hufflepuff Common Room");
		threeMobRoomEightHufflepuffCommonRoom
				.setRoomDescription(" Hufflepuff things are in HufflePuffs room." + " What a weird name...");
		threeMobRoomEightHufflepuffCommonRoom
				.setLookDownDescription(" The floor is engraved with past leaders of HufflePuff."
						+ " A majestic rug lines the floor in front of the fire place.");
		threeMobRoomEightHufflepuffCommonRoom.setLookUpDescription(
				" The walls are lined with circular windows. " + " Magical sunlight enters the room and lights it up.");
		mapArray[9][2] = threeMobRoomEightHufflepuffCommonRoom;

		// Fourth Column west connection with third column
		fourStairsOne.setWestRoom(threeMobRoomOneJointBedRoom);
		fourMobRoomOneLibary.setWestRoom(threeMobRoomTwoHallway);
		fourMobRoomTwoRavenClawCommonRoom.setWestRoom(threeStairsOne);
		fourMobRoomThreeEmptyRoom.setWestRoom(threeMobRoomFourBoysRoom);
		fourMobRoomFourGirlsRoom.setWestRoom(threeMobRoomFiveEmptyRoom);
		fourNPCRoomOneMcgonagalsRoom.setWestRoom(threeMobRoomSixGriffindorCommonRoom);
		fourStairsThree.setWestRoom(threeMobRoomSevenSlytherinCommonRoom);
		fourNPCRoomTwoProfessorTrudeauxRoom.setWestRoom(threeMobRoomEightHufflepuffCommonRoom);

		// Fourth Column set south connection
		fourMobRoomTwoRavenClawCommonRoom.setSouthRoom(fourStairsTwo);
		fourStairsTwo.setSouthRoom(fourMobRoomThreeEmptyRoom);
		fourMobRoomFourGirlsRoom.setSouthRoom(fourMobRoomFiveHermionesShrine);

		// Fourth Column set North connection
		fourStairsOne.setNorthRoom(fourNPCRoomTwoProfessorTrudeauxRoom);
		fourStairsTwo.setNorthRoom(fourMobRoomTwoRavenClawCommonRoom);
		fourMobRoomThreeEmptyRoom.setNorthRoom(fourStairsTwo);
		fourMobRoomFiveHermionesShrine.setNorthRoom(fourMobRoomFourGirlsRoom);

		// Fourth column set East Connection
		fourMobRoomThreeEmptyRoom.setEastRoom(fiveRavenclawGirlsRoom);
		fourStairsThree.setEastRoom(fiveSlytherinEmptyRoom);

		// Room 0,3
		fourStairsOne.setTitle("The Stairway ");
		fourStairsOne
				.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
						+ " You double take. On the wall you see it."
						+ " You're eyes glaze upon the figure. The caption of the painting states, \" WELCOME TO CSC 335!!!! \""
						+ " You don't quite understand the picture, but it is magnificent."
						+ " The stairs go west or North");
		fourStairsOne.setLookUpDescription("Its more stairs guys ... just more stairs nothing else to it");
		fourStairsOne.setLookDownDescription("The floor. You wanted to look down at the floor. What is wrong with you");
		this.mapArray[0][3]=fourStairsOne;

		// Room 1,3
		fourMobRoomOneLibary.setTitle("Old Main Library");
		fourMobRoomOneLibary.setRoomDescription(
				" Old manuscripts and books are scatter all about. Scanning the room, pages sprinkle from shelves half burnt."
						+ " \"Fantastic Beasts a..\" flashes before your face. Peering around a dusted bookcase, a tail creeps around the corner and out of sight."
						+ " Beads of water drip along your cheek. "
						+ " Smuldering pages can be heard in the background."
						+ " Grasping your wand, you turn the corner." + " Gone."
						+ " You can only go back the way you came.");
		this.mapArray[1][3]=fourMobRoomOneLibary;
		fourMobRoomOneLibary.setLookDownDescription("The floor is wooden, but so old you can start to the see floorboard coming apart. Nothing a couple of spells shouldnt take care. Or instead Ill just get Filch to do it.");
		fourMobRoomOneLibary.setLookUpDescription("The ceiling changes its mood every so often and along with that its colors. You can see that you being in here has made it upset ... it is as red as Mars");
		
		// Room 2, 3
		fourMobRoomTwoRavenClawCommonRoom.setTitle("Ravenclaw Common Room");
		fourMobRoomTwoRavenClawCommonRoom.setRoomDescription(" As you enter the room, a shout echoes from behind you."
				+ " \"AVADA.. \" " + " Immediately you seize the door and slam it shut. "
				+ " Casting a spell to seal the door. " + " South is the only way out.");
		fourMobRoomTwoRavenClawCommonRoom.setLookDownDescription("The magestic Eagle, the symbol of Ravenclaw covers the ground as its all you can see.");
		fourMobRoomTwoRavenClawCommonRoom.setLookUpDescription("Hmmm what do you expect to see when you look up in a room. Oh thats right a ceiling.");

		this.mapArray[2][3]=fourMobRoomTwoRavenClawCommonRoom;
		
		// Room 3, 3
		fourStairsTwo.setTitle("The Stairway ");
		fourStairsTwo
				.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
						+ " You double take. On the wall you see it."
						+ " You're eyes glaze upon the figure. The caption of the painting states, \" Netpaint for Dummies. \""
						+ " You don't quite understand the picture, but it is magnificent."
						+ " The stairs go west or North");
		this.mapArray[3][3]=fourStairsTwo;
		fourStairsTwo.setLookDownDescription(" The stairs glide along as you move up them.");
		fourStairsTwo.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		
		// Room 4, 3
		fourMobRoomThreeEmptyRoom.setTitle("Empty Room");
		fourMobRoomThreeEmptyRoom.setRoomDescription(" The room is untouched. Everything is clean."
				+ " Wow so clean. Much sparkle. Wow." + " It's also empty." + " The only way out is west and north.");
		this.mapArray[4][3]=fourMobRoomThreeEmptyRoom;
		fourMobRoomThreeEmptyRoom.setLookDownDescription("This is a empty room. That is all Look I took away period for you. If you want important info look down. ");
		fourMobRoomThreeEmptyRoom.setLookUpDescription("This is a empty room. That is all. Look I added a period for you. If you want important info look up. ");
		
		// Room 5, 3
		fourMobRoomFourGirlsRoom.setTitle("The Girls Room");
		fourMobRoomFourGirlsRoom.setRoomDescription(" The girls room is untouched. The beds and stands remain intact."
				+ " Whatever is happening hasn't been here yet." + " The only way out are west and south.");
		this.mapArray[5][3]=fourMobRoomFourGirlsRoom;
		fourMobRoomFourGirlsRoom.setLookUpDescription("The ceiling is quite beautiful isnt it. You see that flower over there, that Petuina next to the Lily. It was painted by "
				+ "by my most important occupant");
		fourMobRoomFourGirlsRoom.setLookDownDescription("Yeah its just a floor board.");
		
		
		// Room 6, 3
		fourMobRoomFiveHermionesShrine.setTitle("Hermione's Shrine ");
		fourMobRoomFiveHermionesShrine.setRoomDescription(" You've read about this place in all your course."
				+ " The fabled shrine of the smartest student to ever go to Hogswarts. "
				+ " Something appears to be lodged in her hand. I wonder what it is." + " The only exit is north.");
		this.mapArray[6][3]=fourMobRoomFiveHermionesShrine;
		fourMobRoomFiveHermionesShrine.setLookDownDescription("Even the floor crawls with intelligence wait look over there theres some sort of bag, wait it cant be can it");
		fourMobRoomFiveHermionesShrine.setLookUpDescription("Just a bunch of pictures of Emma Watson. Enjoy my friend enjoy!!");
		
		// Room 7, 3
		fourNPCRoomOneMcgonagalsRoom.setTitle("McGonagals Office");
		fourNPCRoomOneMcgonagalsRoom.setRoomDescription(
				" As you enter the room, a torrent of wind pushes you on your back. Behind the desk, a wand points at you"
						+ " \"WHO GOES THERE?\"");
		this.mapArray[7][3]=fourNPCRoomOneMcgonagalsRoom;
		fourNPCRoomOneMcgonagalsRoom.setLookDownDescription("Hey wait theres a cat ... I know what you're thinking oh bloody hell");
		fourNPCRoomOneMcgonagalsRoom.setLookUpDescription("           why is it whenever anything happens its you. Wait you wanted a description?? Too bad.");
		
		// Room 8, 3
		fourStairsThree.setTitle("The Stairway ");
		fourStairsThree
				.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
						+ " You double take. On the wall you see it."
						+ " You're eyes glaze upon the figure. The caption of the painting states, \" THIS IS 335!\""
						+ " You don't quite understand the picture, but it is magnificent."
						+ " The stairs go west or North");
		this.mapArray[8][3]=fourStairsThree;
		fourStairsThree.setLookDownDescription(" The stairs glide along as you move up them.");
		fourStairsThree.setLookUpDescription(" Moving back and forth, the stairs eerily glide over your head.");
		
		
		
		// Room 9, 3
		fourNPCRoomTwoProfessorTrudeauxRoom.setTitle("Professor Trudeaux's Room");
		fourNPCRoomTwoProfessorTrudeauxRoom
				.setRoomDescription(" Stacks of paper clog the room. Old prohecies it seems it seems."
						+ " The floor is covered in from the outside. "
						+ " There may be something I can learn from these stacks." + " The only exit is west.");
		this.mapArray[9][3]=fourNPCRoomTwoProfessorTrudeauxRoom;
		fourNPCRoomTwoProfessorTrudeauxRoom.setLookDownDescription("I the ground predict that you will not be pleased with this description");
		fourNPCRoomTwoProfessorTrudeauxRoom.setLookUpDescription("I the ceiling predict pain and misfortune in your future. THE GRIM!!!!! THE GRIM!!!!");		
		
		// fifth column set west directions
		fiveRavenclawGirlsRoom.setWestRoom(fourMobRoomThreeEmptyRoom);
		fiveSlytherinEmptyRoom.setWestRoom(fourStairsThree);

		// fifth column set east directions
		fiveCommonGroundOne.setEastRoom(sixShriekingShack);
		fiveQuidditchPitch.setEastRoom(sixOutdoorGroundsThree);
		fiveHoneydukes.setEastRoom(sixHogsmeadeVillage);

		// fifth column set South direction
		fiveAstronomyTower.setSouthRoom(fiveOutdoorGroundsOne);
		fiveVoldemortsShrine.setSouthRoom(fiveSlytherinBoysRoom);
		fiveSlytherinBoysRoom.setSouthRoom(fiveSlytherinEmptyRoom);
		fiveSlytherinEmptyRoom.setSouthRoom(fiveSlytherinGirlsRoom);

		// fifth column set North direction
		fiveSlytherinGirlsRoom.setNorthRoom(fiveSlytherinEmptyRoom);
		fiveSlytherinEmptyRoom.setNorthRoom(fiveSlytherinBoysRoom);
		fiveSlytherinBoysRoom.setNorthRoom(fiveVoldemortsShrine);
		fiveOutdoorGroundsOne.setNorthRoom(fiveAstronomyTower);

		// room 0, 4
		fiveCommonGroundOne.setTitle("Common Ground");
		fiveCommonGroundOne.setRoomDescription(
				"Look there to the east ... what is that" + "I hear screaming, I sense fear, beware of going there");
		this.mapArray[0][4] = fiveCommonGroundOne;
		fiveCommonGroundOne.setLookDownDescription("The grass flows from the sound of the screams to the east.");
		fiveCommonGroundOne.setLookUpDescription("Even the stars dont seem to be as pretty anymore. The screams seem haunting to them too.");
		
		// room 1,4
		fiveHoneydukes.setTitle("Honeydukes Bar");
		fiveHoneydukes.setRoomDescription("Ahhh my sanctum santorum. Refreshing butterbeer all over the place"
				+ "and a nice sense of relaxation all over the place. Well I guess I can only go back to hogsmeade for here. I might as "
				+ "just continue to drink here");
		this.mapArray[1][4] = fiveHoneydukes;
		fiveHoneydukes.setLookDownDescription("Wooden floor boards all sticky and covered in the spilt delicious butterbeer of the bumbling drunks.");
		fiveHoneydukes.setLookUpDescription("The ceiling. No butterbeer there!!!!");		

		// room 2,4
		fiveAstronomyTower.setTitle("Astronomy Tower");
		fiveAstronomyTower.setRoomDescription("Look up to the sky you can see the stars from here. I dont know"
				+ "why, but I sense something bad my happen here in the future. It looks like I can only leave the way I came"
				+ ", but why leave");
		this.mapArray[2][4] = fiveAstronomyTower;
		fiveAstronomyTower.setLookUpDescription("The Astronomy Tower. What could possibly be up from here. The sky you twit.");
		fiveAstronomyTower.setLookDownDescription("The bricks that were used to build this place are still quiet solid.");
		
		// room 3,4
		fiveOutdoorGroundsOne.setTitle("Outdoor Grounds");
		fiveOutdoorGroundsOne.setRoomDescription("A tree sets off in the distance."
				+ " The branches appear fragile, but you know how fierce they can be. "
				+ "You could go back to hagrids, but either you gotta go to the east");
		this.mapArray[3][4] = fiveOutdoorGroundsOne;
		fiveOutdoorGroundsOne.setLookDownDescription("The grass is beneath you.");
		fiveOutdoorGroundsOne.setLookUpDescription("The sky is above you.");		
		
		// room 4,4
		fiveRavenclawGirlsRoom.setTitle("Ravenclaws Girls Room");
		fiveRavenclawGirlsRoom.setRoomDescription(
				"This, this right here is where intelligence was born. There maybe a spellbook for you in here or not. IDK IM JUST A ROOM."
						+ ", but if not just leave and get out");
		this.mapArray[4][4] = fiveRavenclawGirlsRoom;
		fiveRavenclawGirlsRoom.setLookDownDescription("Really nothing to describe here. ");
		fiveRavenclawGirlsRoom.setLookUpDescription("An eagle flying over everyone while they try and sleep. ");		
		
		// room 5,4
		fiveQuidditchPitch.setTitle("Qudditch Field");
		fiveQuidditchPitch.setRoomDescription(
				"I think if you pay attention you may still be able to hear the snitch. JK there is not snitch in this game"
						+ ", but hey you can still see the hoops. By the way you can only go back the way you come. I mean there is only"
						+ "one exit");
		this.mapArray[5][4] = fiveQuidditchPitch;
		fiveQuidditchPitch.setLookDownDescription("The grassy fields are torn up but only towards the entrance as it is Qudditch, you dont really walk except entering the field."
				+ "You can see that clearly.");
		fiveQuidditchPitch.setLookUpDescription("The stands surrounding the pitch are decorated differently for each Quidditch match at Hogwarts. Every second stand would be decorated with the colours of one team, and every other stand with the colours of the opposing team."
				+ " Spectators would sit in between these stands.");

		// room 6,4
		fiveVoldemortsShrine.setTitle("Voldemorts Shrine");
		fiveVoldemortsShrine.setRoomDescription(
				"This is the darkest room in the entire building. Only Slytherin would have shrine for the most"
						+ "ruthless killer ever. Look over there you can see his statue. You can still here his victims scream. Wait can you feel that can you feel that it is calling for you."
						+ "If you do not understand what I mean, stop playing pick up the books and read them. If not...");
		this.mapArray[6][4] = fiveVoldemortsShrine;
		fiveVoldemortsShrine.setLookUpDescription("The serpent the skull all together, it can only be one thing. The dark mark is on the ceiling.");
		fiveVoldemortsShrine.setLookDownDescription("Blood, blood all over the place.");
		
		// room 7,4
		fiveSlytherinBoysRoom.setTitle("Slytherin Boys Room");
		fiveSlytherinBoysRoom.setRoomDescription("This is the slytherins boys room. It deserves"
				+ "no other description. Oh and there is something particularly facinating to the north. Only go if you dare.");
		this.mapArray[7][4] = fiveSlytherinBoysRoom;
		fiveSlytherinBoysRoom.setLookDownDescription("The serpent slitherin all over the god damn floor.");
		fiveSlytherinBoysRoom.setLookUpDescription("Nothin but green.");		
		
		// room 8,4
		fiveSlytherinEmptyRoom.setTitle("Slytheirn Common Room");
		fiveSlytherinEmptyRoom.setRoomDescription("Here is where all the evil boys and girls reside peacefully and plot"
				+ "You can go to the south and see the girls room or the north and see the boys room.");
		this.mapArray[8][4] = fiveSlytherinEmptyRoom;
		fiveSlytherinEmptyRoom.setLookUpDescription("The ceiling is even trembling with all the evil that goes along in its corresponding rooms,"
				+ ", but its also calm known about the potential greatness that is ozzoing from the north and south,");
		fiveSlytherinEmptyRoom.setLookDownDescription("Clothes, everywhere all over the place, the Slytherins have no time for "
				+ "laundy with all of the plotting they do.");
		
		// room 9,4
		fiveSlytherinGirlsRoom.setTitle("Slytherin Girls Room");
		fiveSlytherinGirlsRoom.setRoomDescription("Nothin in the room nothin on the ceiling, nothin on the floor, nothing to describe. This room is pointless. Wait maybe Bellatrix is in here.");
		this.mapArray[9][4] = fiveSlytherinGirlsRoom;
		fiveSlytherinGirlsRoom.setLookDownDescription("Nothin here to describe.");
		fiveSlytherinGirlsRoom.setLookUpDescription("Nothin here to describe.");
		

		// sixth column set North direction
		sixHogsmeadeVillage.setNorthRoom(sixShriekingShack);
		sixZonksJokeShop.setNorthRoom(sixHogsmeadeVillage);
		sixOutdoorGroundsTwo.setNorthRoom(sixOutdoorGroundsOne);
		sixOutdoorGroundsThree.setNorthRoom(sixOutdoorGroundsThree);
		sixStairs.setNorthRoom(sixSnapesRoom);
		sixDumbledoresOffice.setNorthRoom(sixStairs);
		sixPensieveRoom.setNorthRoom(sixDumbledoresOffice);

		// sixth column set South direction
		sixDumbledoresOffice.setSouthRoom(sixPensieveRoom);
		sixStairs.setSouthRoom(sixDumbledoresOffice);
		sixSnapesRoom.setSouthRoom(sixStairs);
		sixOutdoorGroundsTwo.setSouthRoom(sixOutdoorGroundsThree);
		sixOutdoorGroundsOne.setSouthRoom(sixOutdoorGroundsTwo);
		sixShriekingShack.setSouthRoom(sixHogsmeadeVillage);
		sixHogsmeadeVillage.setSouthRoom(sixZonksJokeShop);

		// sixth column set West direction
		sixShriekingShack.setWestRoom(fiveCommonGroundOne);
		sixHogsmeadeVillage.setWestRoom(fiveHoneydukes);
		sixOutdoorGroundsThree.setWestRoom(fiveQuidditchPitch);

		// sixth column set East direction
		sixHogsmeadeVillage.setEastRoom(outdoorRoomTwo);
		sixOutdoorGroundsOne.setEastRoom(npcRoomOneHagridsHat);
		sixOutdoorGroundsTwo.setEastRoom(outdoorRoomFour);
		sixOutdoorGroundsThree.setEastRoom(outdoorRoomFive);
		sixSnapesRoom.setEastRoom(mobRoomOneHallway);

		// room 0,5
		sixShriekingShack.setTitle("Shrieking Shack");
		sixShriekingShack.setRoomDescription("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "...................................................................."
				+ "........................................................................"
				+ "AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		this.mapArray[0][5] = sixShriekingShack;
		sixShriekingShack.setLookDownDescription("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "...................................................................."
				+ "........................................................................"
				+ "AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		sixShriekingShack.setLookUpDescription("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "...................................................................."
				+ "........................................................................"
				+ "AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");

		// room 1,5
		sixHogsmeadeVillage.setTitle("Hogsmeade Village");
		sixHogsmeadeVillage.setRoomDescription(
				"From here you can honestly go anywhere. Wanna beer head west, wanna hear something interesting go north, wanna laugh"
						+ " go south, wanna go back to where you came from, well remember that direction at least I cant do everything for you. I am room not your mother.");
		this.mapArray[1][5] = sixHogsmeadeVillage;
		sixHogsmeadeVillage.setLookDownDescription("Footprint, shoe prints, all over the place as you could see the dust kicked up from "
				+ " the excited rumblings and tumblings of the young wizards ");
		sixHogsmeadeVillage.setLookUpDescription("The beautiful stary sky, the clouds, hanging over you. Nothing but peace a quiet can be felt from that look"
				+ "up");
		
		
		// room 2,5
		sixZonksJokeShop.setTitle("Zonks Joke Shop");
		sixZonksJokeShop.setRoomDescription(
				"HAHA, LOL, GOD DAMN THOSE WEASLEY REALLY HAVE MADE ME A FUNNY PLACE! WANNA ELDER WAND???????????"
						+ "JK LOL I DONT HAVE THAT. Well maybe I do IDK.");
		this.mapArray[2][5] = sixZonksJokeShop;
		sixZonksJokeShop.setLookDownDescription("HAHAHAHAHHAHAHHA");
		sixZonksJokeShop.setLookUpDescription("HAHAHAHAHHAHAHHA");		

		// room 3,5
		sixOutdoorGroundsOne.setTitle("Outdoor Grounds");
		sixOutdoorGroundsOne.setRoomDescription("Hear that ... thats right that is the sound of peace and quiet"
				+ "all you can hear is silence. The night sky is above you and all you can do is relax so sit back and realx and enjoy yourself");
		this.mapArray[3][5] = sixOutdoorGroundsOne;
		sixOutdoorGroundsOne.setLookDownDescription("The grass is beneath you.");
		sixOutdoorGroundsOne.setLookUpDescription("The sky is above you.");
		
		// room 4,5
		sixOutdoorGroundsTwo.setTitle("Outdoor Grounds");
		sixOutdoorGroundsTwo.setRoomDescription("Hear that ... thats right that is the sound of peace and quiet"
				+ "all you can hear is silence. The night sky is above you and all you can do is relax so sit back and realx and enjoy yourself. No you arent in the same room again but jeez its the same thing essentially");
		this.mapArray[4][5] = sixOutdoorGroundsTwo;
		sixOutdoorGroundsTwo.setLookDownDescription("The grass is beneath you.");
		sixOutdoorGroundsTwo.setLookUpDescription("The sky is above you.");

		// room 5,5
		sixOutdoorGroundsThree.setTitle("Outdoor Grounds");
		sixOutdoorGroundsThree.setRoomDescription("Hear that ... thats right that is the sound of peace and quiet"
				+ "all you can hear is silence. The night sky is above you and all you can do is relax so sit back and realx and enjoy yourself. No you arent in the same room again but jeez its the same thing essentially");
		this.mapArray[5][5] = sixOutdoorGroundsThree;
		sixOutdoorGroundsThree.setLookDownDescription("The grass is beneath you.");
		sixOutdoorGroundsThree.setLookUpDescription("The sky is above you.");

		// room 6,5
		sixSnapesRoom.setTitle("Professor Snapes Room");
		sixSnapesRoom.setRoomDescription("You are in the presence of the one and only Half-Blood Prince. If you try hard enough you can catch a faint whiff of the potions brewing"
				+ "even though they are being over powered by the lilys in here. You want to know sectum sempra, ask him what he says just try and talk to him. I know it can be nerving but give it a go. ");
		this.mapArray[6][5] = sixSnapesRoom;
		sixSnapesRoom.setLookUpDescription("The shadowy walls were lined with shelves of large glass jars filled with slimy, revolting things, such as bits of animals and plants, floating in potions of varying colour.");
		sixSnapesRoom.setLookDownDescription("Darkness, black floor boards should fill you up with fear and sadness");
		
		//room 7,5
		sixStairs.setTitle("The Stairway");
		sixStairs.setRoomDescription(" You enter the stair. Along the walls are pictures of old wizards can be seen. "
				+ " You double take. On the wall you see it."
				+ " The stairs go north to a certain professors room or south to a certain professors room. Take your pick");
		this.mapArray[7][5]=sixStairs;
		sixStairs.setLookDownDescription("The floor");
		sixStairs.setLookUpDescription("More stairs");
		
		//room 8,5 
		sixDumbledoresOffice.setTitle("The Headmasters Office");
		sixDumbledoresOffice.setRoomDescription("Can you pick up on all that wisdom and intelligence that is just ozzing out of every crack in the wall out of ever portion "
				+ "of this room. The headmaster sits there waiting for you staring, no not just stairing in fact talking with the portraits of all of his predeccesors."
				+ "He has been expecting you go ahead and go see him. Try and not be nervous, but remember he is the greatest wizard of all time. ");
		this.mapArray[8][5]=sixDumbledoresOffice;
		sixDumbledoresOffice.setLookUpDescription("Caww caww, the phoenix is flying around above acting like a protector. That phoenix"
				+ "would give its life for dumbledore and it seems like you too. Congrats you made a friend just by looking up");
		sixDumbledoresOffice.setLookDownDescription("Nothin here but look up, there is something for you there.");
		
		//room 9,5
		sixPensieveRoom.setTitle("The Pensieve Room");
		sixPensieveRoom.setRoomDescription("This is where the Phoenix sits, more importantly there sits the pensieve. Many have came in here"
				+ "to try and use it and see what has happened before, but it hasnt work, the pensieve no longer works. Its last user was the Chosen One and refuses"
				+ "to work for anyone else. And you, you are not the chosen one. Leave go back to dumbledores office");
		this.mapArray[9][5]=sixPensieveRoom;
		sixPensieveRoom.setLookDownDescription("Nothing, absolutely nothing.");
		sixPensieveRoom.setLookUpDescription("Memories, floating memories all over the palce");
		
	}

	private void generateItems() {
		ArrayList<Item> itemsToAddToMap = new ArrayList<Item>();
		Random random = new Random();
		Spell avadaKedvra = new AvadaKedvra();
		Spell expelliarumus = new Expelliarumus();
		Spell expectoPatronum = new ExpectoPatronum();
		Spell imperio = new Imperio();
		Spell crucio = new Crucio();
		Spell expluso = new Expulso();
		Spell incendio = new Incendio();
		Spell petrificusTotalus = new PetrificusTotalus();
		Spell sectumSempra = new SectumSempra();
		Spell stupefy = new Stupefy();
		Spellbook spellbookAvadaKedvra = new Spellbook(avadaKedvra);
		Spellbook spellbookExpelliarmus = new Spellbook(expelliarumus);
		Spellbook spellbookExpectoPatronum = new Spellbook(expectoPatronum);
		Spellbook spellbookImperio = new Spellbook(imperio);
		Spellbook spellbookCrucio = new Spellbook(crucio);
		Spellbook spellbookExpulso = new Spellbook(expluso);
		Spellbook spellbookIncendio = new Spellbook(incendio);
		Spellbook spellbookPetrificusTotalus = new Spellbook(petrificusTotalus);
		Spellbook spellbookSectumSempra = new Spellbook(sectumSempra);
		Spellbook spellbookStuepfy = new Spellbook(stupefy);
		// adding 5 spellbooks to the map only determining them here
		int numberOfSpellbooksAdded = 0;
		int whichSpellBook = 0;
		while (numberOfSpellbooksAdded != 7) {
			whichSpellBook = random.nextInt(10);
			switch (whichSpellBook) {
			case 0:
				if (!itemsToAddToMap.contains(spellbookAvadaKedvra)) {
					itemsToAddToMap.add(spellbookAvadaKedvra);
					numberOfSpellbooksAdded++;
					break;
				}
			case 1:
				if (!itemsToAddToMap.contains(spellbookExpelliarmus)) {
					numberOfSpellbooksAdded++;
					itemsToAddToMap.add(spellbookExpelliarmus);
					break;
				}
			case 2:
				if (!itemsToAddToMap.contains(spellbookExpectoPatronum)) {
					itemsToAddToMap.add(spellbookExpectoPatronum);
					numberOfSpellbooksAdded++;
					break;

				}
			case 3:
				if (!itemsToAddToMap.contains(spellbookImperio)) {
					itemsToAddToMap.add(spellbookImperio);
					numberOfSpellbooksAdded++;
					break;
				}
			case 4:
				if (!itemsToAddToMap.contains(spellbookCrucio)) {
					itemsToAddToMap.add(spellbookCrucio);
					numberOfSpellbooksAdded++;
					break;
				}
			case 5:
				if (!itemsToAddToMap.contains(spellbookIncendio)) {
					itemsToAddToMap.add(spellbookIncendio);
					numberOfSpellbooksAdded++;
					break;
				}
			case 6:
				if (!itemsToAddToMap.contains(spellbookPetrificusTotalus)) {
					itemsToAddToMap.add(spellbookPetrificusTotalus);
					numberOfSpellbooksAdded++;
					break;
				}
			case 7:
				if (!itemsToAddToMap.contains(spellbookSectumSempra)) {
					itemsToAddToMap.add(spellbookSectumSempra);
					numberOfSpellbooksAdded++;
					break;
				}
			case 8:
				if (!itemsToAddToMap.contains(spellbookExpulso)) {
					itemsToAddToMap.add(spellbookExpulso);
					numberOfSpellbooksAdded++;
					break;
				}
			case 9:
				if (!itemsToAddToMap.contains(spellbookStuepfy)) {
					itemsToAddToMap.add(spellbookStuepfy);
					numberOfSpellbooksAdded++;
					break;
				}
			default:
				break;
			}
		}
		// Adding the rest of the items to the arrayList
		BassilskFang bassilskFang = new BassilskFang();
		Broomstick broomstick = new Broomstick();
		PhoenixTears phoenixTears = new PhoenixTears();
		Horcrux horcrux = new Horcrux();
		MaurdersMap maurdersMap = new MaurdersMap();
		NeverEndingBook neverEndingBook = new NeverEndingBook();
		RegularWand regularWand = new RegularWand();
		RegularWand regularWandTwo = new RegularWand();
		RegularWand regularWandThree = new RegularWand();
		RegularWand regularWandFour = new RegularWand();
		RegularWand regularWandFive = new RegularWand();
		RegularWand regularWandSix = new RegularWand();
		RegularWand regularWandSeven = new RegularWand();
		RegularWand regularWandEight = new RegularWand();
		RegularWand regularWandNine = new RegularWand();
		RegularWand regularWandTen = new RegularWand();	
		SwordOfGryffindor swordOfGryffindor = new SwordOfGryffindor();
		HermoinesHandbag hermoinesHandbag = new HermoinesHandbag();
		RessurectionStone ressurectionStone = new RessurectionStone();
		ButterBeer butterBeer = new ButterBeer();
		HealingPotion healingPotion = new HealingPotion();
		DependencyInjectionSword dependencyInjectionSword = new DependencyInjectionSword();
		itemsToAddToMap.add(bassilskFang);
		itemsToAddToMap.add(broomstick);
		itemsToAddToMap.add(phoenixTears);
		itemsToAddToMap.add(horcrux);
		itemsToAddToMap.add(neverEndingBook);
		itemsToAddToMap.add(regularWand);
		itemsToAddToMap.add(regularWandTwo);
		itemsToAddToMap.add(regularWandThree);
		itemsToAddToMap.add(regularWandFour);
		itemsToAddToMap.add(regularWandFive);
		itemsToAddToMap.add(regularWandSix);
		itemsToAddToMap.add(regularWandSeven);
		itemsToAddToMap.add(regularWandEight);
		itemsToAddToMap.add(regularWandNine);
		itemsToAddToMap.add(regularWandTen);
		itemsToAddToMap.add(maurdersMap);
		itemsToAddToMap.add(swordOfGryffindor);
		itemsToAddToMap.add(hermoinesHandbag);
		itemsToAddToMap.add(ressurectionStone);
		itemsToAddToMap.add(butterBeer);
		itemsToAddToMap.add(healingPotion);
		itemsToAddToMap.add(dependencyInjectionSword);
		int row = 0;
		int column = 0;
		for (int i = 0; i < itemsToAddToMap.size(); i++) {
			row = random.nextInt(10);
			column = random.nextInt(6);
			this.mapArray[row][column].additemsInRoom(itemsToAddToMap.get(i));
			System.out.println(row + " " + column + " " + itemsToAddToMap.get(i).getName());
		}
		System.out.println("Done adding items");
	}

	public void generateMobs() {
		ArrayList<Mobs> mobsToAddToMap = new ArrayList<Mobs>();
		Bellatrix bellatrix = new Bellatrix(null, 0, 0, 0);
		Dementor dementor = new Dementor(null, 0, 0, 0);
		Snape snape = new Snape(null, 0, 0, 0);
		Dragons dragon = new Dragons("Dragon", 0, 0, 0);
		Dumbledore dumbledore = new Dumbledore(null, 0, 0, 0);
		Hagrid hagrid = new Hagrid(null, 0, 0, 0);
		Lupin lupin = new Lupin(null, 0, 0, 0);
		McGonagall mcgonagall = new McGonagall(null, 0, 0, 0);
		Sirius sirius = new Sirius(null, 0, 0, 0);
		Spiders spider = new Spiders("Spiders", 0, 0, 0);
		Spiders spiderTwo = new Spiders("Spiders", 0, 0, 0);
		Spiders spiderThree = new Spiders("Spiders", 0, 0, 0);
		Spiders spiderFour = new Spiders("Spiders", 0, 0, 0);
		Spiders spiderFive = new Spiders("Spiders", 0, 0, 0);
		Spiders spiderSix = new Spiders("Spiders", 0, 0, 0);
		Spiders spiderSeven = new Spiders("Spiders", 0, 0, 0);
		Spiders spiderEight = new Spiders("Spiders", 0, 0, 0);
		Trolls troll = new Trolls("Trolls", 0, 0, 0);
		Werewolves werewolves = new Werewolves("Werewolves", 0, 0, 0);
		OrdinaryWizards Ron = new OrdinaryWizards("Ron", 0, "Gryffindor", 0, 0);
		OrdinaryWizards Hermoine = new OrdinaryWizards("Hermoine", 0, "Gryffindor", 0, 0);
		OrdinaryWizards Harry = new OrdinaryWizards("Harry", 0, "Gryffindor", 0, 0);
		OrdinaryWizards Draco = new OrdinaryWizards("Malfoy", 0, "Slytherin", 0, 0);
		OrdinaryWizards Neville = new OrdinaryWizards("Neville", 0, "Gryffindor", 0, 0);
		OrdinaryWizards Cedric = new OrdinaryWizards("Cedric", 0, "Gryffindor", 0, 0);
		mobsToAddToMap.add(spider);
		mobsToAddToMap.add(spiderTwo);
		mobsToAddToMap.add(spiderThree);
		mobsToAddToMap.add(spiderFour);
		mobsToAddToMap.add(spiderFive);
		mobsToAddToMap.add(spiderSix);
		mobsToAddToMap.add(spiderSeven);
		mobsToAddToMap.add(spiderEight);
		mobsToAddToMap.add(sirius);
		mobsToAddToMap.add(lupin);
		mobsToAddToMap.add(dementor);
		mobsToAddToMap.add(Ron);
		mobsToAddToMap.add(Hermoine);
		mobsToAddToMap.add(Cedric);
		mobsToAddToMap.add(Harry);
		mobsToAddToMap.add(Draco);
		mobsToAddToMap.add(Neville);

//adding those to specific rooms that need to be added
		this.mapArray[8][5].setMobsInRoom(dumbledore);
		this.mapArray[8][5].setMobsPresent(true);
		dumbledore.setXpos(8);
		dumbledore.setYpos(5);
		dumbledore.setCurrentRoom(this.mapArray[8][5]);
		
		this.mapArray[6][5].setMobsInRoom(snape);
		this.mapArray[6][5].setMobsPresent(true);
		snape.setXpos(6);
		snape.setYpos(5);
		snape.setCurrentRoom(this.mapArray[6][5]);
		
		this.mapArray[7][3].setMobsInRoom(mcgonagall);
		this.mapArray[7][3].setMobsPresent(true);
		mcgonagall.setXpos(7);
		mcgonagall.setYpos(3);
		mcgonagall.setCurrentRoom(this.mapArray[7][3]);
		
		this.mapArray[9][4].setMobsInRoom(bellatrix);
		this.mapArray[9][4].setMobsPresent(true);
		bellatrix.setXpos(9);
		bellatrix.setYpos(4);
		bellatrix.setCurrentRoom(this.mapArray[9][4]);
		
		this.mapArray[3][0].setMobsInRoom(hagrid);
		this.mapArray[3][0].setMobsPresent(true);
		hagrid.setXpos(3);
		hagrid.setYpos(0);
		hagrid.setCurrentRoom(this.mapArray[3][0]);
		
		this.mapArray[2][1].setMobsInRoom(werewolves);
		this.mapArray[2][1].setMobsPresent(true);
		dumbledore.setXpos(2);
		dumbledore.setYpos(1);
		dumbledore.setCurrentRoom(this.mapArray[2][1]);
		
		this.mapArray[1][5].setMobsInRoom(troll);
		this.mapArray[1][5].setMobsPresent(true);
		troll.setXpos(1);
		troll.setYpos(5);
		troll.setCurrentRoom(this.mapArray[1][5]);
		
		this.mapArray[0][4].setMobsInRoom(dragon);
		this.mapArray[0][4].setMobsPresent(true);
		dumbledore.setXpos(0);
		dumbledore.setYpos(4);
		dumbledore.setCurrentRoom(this.mapArray[0][4]);
		
		
		Random random = new Random();
		int row = 0;
		int column = 0;
		for (int i = 0; i < mobsToAddToMap.size(); i++) {
			row = random.nextInt(10);
			column = random.nextInt(6);
			if (!this.mapArray[row][column].getMobsPresent()) {
				this.mapArray[row][column].setMobsInRoom(mobsToAddToMap.get(i));
				this.mapArray[row][column].setMobsPresent(true);
				mobsToAddToMap.get(i).setXpos(row);
				mobsToAddToMap.get(i).setYpos(column);
				mobsToAddToMap.get(i).setCurrentRoom(this.mapArray[row][column]);
				System.out.println(row + " " + column + " " + mobsToAddToMap.get(i).getName());
			} else {
				i--;
			}
		}
		System.out.println("Done adding mobs");

	}

	public GenericRoom getEntrance() {
		return mapStart;
	}

	public GenericRoom[][] getMapArray() {
		return this.mapArray;
	}
}