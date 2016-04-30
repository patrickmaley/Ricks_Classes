package model.items;

import model.player.Player;
import model.room.GenericRoom;

public class MaurdersMap extends Item {
	public MaurdersMap() {
		super("Maurders Map","Before you use this I better hear you say, I solemny swear I'm up to no good. Thats right and then the entire map"
				+ "will become visible to you");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String use(Player p, String notNeeded) {
		String allRoomStrings = "I solemnly swear that I am up to no good.\n";
		GenericRoom[][] allRooms = p.getPlayerMap().getMapArray();
		for (int i = 0; i < allRooms.length; i++) {
			for (int j = 0; j < allRooms[0].length; j++) {
				allRoomStrings += allRooms[i][j].getTitle() + "\n";
				allRoomStrings += allRooms[i][j].getItemsToString() + "\n";
			}
		}
		return this.getForLookDescription() + allRoomStrings;
	}
	
	public String getForLookDescription(){
		return "Do you solemnly swear you are up to no good? Thats right im in here.";
	}
}
