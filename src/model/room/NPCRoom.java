package model.room;

public class NPCRoom extends GenericRoom{
	private int mobsAllowed;
	//private ArrayList<Mob> npcList = new ArrayList<Mob>();
//	public NPCRoom(GenericRoom north, 
//			GenericRoom south, 
//			GenericRoom east, 
//			GenericRoom west,
//			String roomName) {
//		super(north, south, east, west);
//		mobsAllowed = 0;
//		this.setTitle(roomName);
//	}
	
	public NPCRoom() {
		super(RoomType.NPC);
		mobsAllowed = 0;
		//this.setTitle(roomName);
	}
	
	//Place in getters and setters for the npc object in the room

}