package model.items;

import model.player.Player;
import model.room.GenericRoom;

import java.util.Random;
public class Broomstick extends Item {
	public Broomstick() {
		super("Broomstick","It's the Nimbus 2016!! Whenever you are stuck use it and it will randomly take you to a different room");
	}

	@Override
	public String use(Player p, String notNeeded) {
		Random random = new Random();
		int numberOfRoomsToMove = random.nextInt(3);
		String direction = "";
		//north = 0;
		//south = 1;
		//east = 2;
		//west = 3;
		boolean haveBeenMoved = false;
		for(int i =0; i< numberOfRoomsToMove;i++){
			GenericRoom roomToMoveIn = null;
			while(!haveBeenMoved){
				int whichDirection = random.nextInt(3);
				switch(whichDirection){
				case 0:
					direction = "north";
					roomToMoveIn = p.getRoom().getNextRoom(direction);
					if(roomToMoveIn!=null){
						p.getRoom().setPlayerPresent(false);
						p.setCurrentRoom(roomToMoveIn);
						p.getRoom().setPlayerPresent(true);
					}
					haveBeenMoved = true;
				case 1:
					direction = "south";
					roomToMoveIn = p.getRoom().getNextRoom(direction);
					if(roomToMoveIn!=null){
						p.getRoom().setPlayerPresent(false);
						p.setCurrentRoom(roomToMoveIn);
						p.getRoom().setPlayerPresent(true);					}
					haveBeenMoved = true;
				case 2:
					direction = "east";
					roomToMoveIn = p.getRoom().getNextRoom(direction);
					if(roomToMoveIn!=null){
						p.getRoom().setPlayerPresent(false);
						p.setCurrentRoom(roomToMoveIn);
						p.getRoom().setPlayerPresent(true);					}
					haveBeenMoved = true;
				case 3: 
					direction = "south";
					roomToMoveIn = p.getRoom().getNextRoom(direction);
					if(roomToMoveIn!=null){
						p.getRoom().setPlayerPresent(false);
						p.setCurrentRoom(roomToMoveIn);
						p.getRoom().setPlayerPresent(true);					}
					haveBeenMoved = true;
				}
			}
		}
		return p.getRoom().getRoomDescription();
	}
}
