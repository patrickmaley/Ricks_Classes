package model.room;

public class OutdoorGroundsRoom extends GenericRoom{
	//private ArrayList<mobs> mobList = new ArrayList<Mob>();
	private int mobsAllowed;
	private final String name = "Outdoor Grounds";
//	public OutdoorGroundsRoom(GenericRoom north, GenericRoom south, GenericRoom east, GenericRoom west) {
//		super(north, south, east, west);
//		mobsAllowed = 2;
//		this.setTitle(name);
//	}
	public OutdoorGroundsRoom() {
		super(RoomType.OUTDOORS);
		mobsAllowed = 2;
		//this.setTitle(name);
	}
}