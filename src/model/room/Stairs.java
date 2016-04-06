package model.room;

public class Stairs extends GenericRoom{
	//private ArrayList<mobs> mobList = new ArrayList<Mob>();
	private int mobsAllowed;
	//private final String name = "Stairwell";
//	public Stairs(GenericRoom north, GenericRoom south, GenericRoom east, GenericRoom west) {
//		super(north, south, east, west);
//		this.mobsAllowed = 1;
//		this.setTitle(name);
//	}
//	
	public Stairs() {
		super(RoomType.STAIRS);
		this.mobsAllowed = 1;
		//this.setTitle(name);
	}
}