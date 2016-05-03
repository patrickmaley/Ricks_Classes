package model.interactions;

import java.io.Serializable;

import model.player.Player;
import model.room.GenericRoom;

public class MoveDirection implements Serializable {
	private Player player;
	public MoveDirection(Player p){
		this.player = p;
	}
	
	public String use(Move direction) {
		GenericRoom roomToMoveIn = null;
		if(direction == Move.NORTH){
			String directionString = "north";
			roomToMoveIn = player.getRoom().getNextRoom(directionString);
			if(roomToMoveIn!=null){
				player.getRoom().setPlayerPresent(false, this.player);
				player.setCurrentRoom(roomToMoveIn);
				player.getRoom().setPlayerPresent(true, this.player);
				return player.performAction("look");
			}
		else{
			return "There is no door in the north direction. Please enter a new direction";
		}
		}
		if(direction == Move.SOUTH){
			String directionString = "south";
			roomToMoveIn = player.getRoom().getNextRoom(directionString);
			if(roomToMoveIn!=null){
				player.getRoom().setPlayerPresent(false, this.player);
				player.setCurrentRoom(roomToMoveIn);
				player.getRoom().setPlayerPresent(true, this.player);
				return player.performAction("look");
			}
			else{
				return "There is no door in the south direction. Please enter a new direction";
			}
		}
		if(direction == Move.EAST){
			String directionString = "east";
			roomToMoveIn = player.getRoom().getNextRoom(directionString);
			if(roomToMoveIn!=null){
				player.getRoom().setPlayerPresent(false, this.player);
				player.setCurrentRoom(roomToMoveIn);
				player.getRoom().setPlayerPresent(true, this.player);
				return player.performAction("look");
			}
				else{
				return "There is no door in the east direction. Please enter a new direction";
			}
		}
		if(direction == Move.WEST){
			String directionString = "west";
			roomToMoveIn = player.getRoom().getNextRoom(directionString);
			if(roomToMoveIn!=null){
				player.getRoom().setPlayerPresent(false, this.player);
				player.setCurrentRoom(roomToMoveIn);
				player.getRoom().setPlayerPresent(true, this.player);
				return player.performAction("look");
			}
			else{
				return "There is no door in the west direction. Please enter a new direction";
			}
		}
		return "That is not a valid command for movement";	
}
}
