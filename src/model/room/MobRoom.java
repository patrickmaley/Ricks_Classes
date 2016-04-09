package model.room;

public class MobRoom extends GenericRoom{
	private int mobsAllowed;
	//private ArrayList<mobs> mobList = new ArrayList<Mob>();
//	public MobRoom(GenericRoom north, 
//			GenericRoom south,
//			GenericRoom east,
//			GenericRoom west,
//			String roomName) {
//		super(north, south, east, west);
//		mobsAllowed = 3;
//		this.setTitle(roomName);
//	}
	
	public MobRoom() {
		super(RoomType.MOB);
		mobsAllowed = 3;
		//this.setTitle(roomName);
	}

}