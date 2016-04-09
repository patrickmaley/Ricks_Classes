package model.room;

public class RoomFactory {
	public static GenericRoom designRoom(RoomType roomType){
		GenericRoom room = null;
		 switch (roomType) {
	        case OUTDOORS:
	        	room = new OutdoorGroundsRoom();
	            break;
	 
	        case STAIRS:
	        	room = new Stairs();
	            break;
	 
	        case NPC:
	        	room = new NPCRoom();
	            break;
	            
	        case MOB:
	        	room = new MobRoom();
	            break;
	            
	        default:
	            break;
	        }
	        return room;
	    
	}
}
