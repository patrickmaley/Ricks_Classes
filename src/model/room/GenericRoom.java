package model.room;

import java.util.ArrayList;

import model.items.Item;

public abstract class GenericRoom {
	private GenericRoom northRoom;
	private GenericRoom eastRoom;
	private GenericRoom southRoom;
	private GenericRoom westRoom;
	private RoomType roomType;
	private String roomTitle;
	private String roomDescription;
	private String lookUpDescription;
	private String lookDownDescription;
	private ArrayList<Item> itemsInRoom = new ArrayList<Item>();
	private Object[] mobsInRoom = new Object[2];
	private Object[] npcInRoom = new Object[2];
	private boolean mobPresent;
	private boolean playerPresent;
	private int gridX;
	private int gridY;
	
	public GenericRoom(RoomType roomType){
		this.roomType = roomType;
	}

	//private ArrayList<Items> itemsList = new ArrayList<Items>();
//	public GenericRoom(GenericRoom north, GenericRoom south, GenericRoom east, GenericRoom west){
//		this.northRoom = north;
//		this.southRoom = south;
//		this.eastRoom = east;
//		this.westRoom = west;
//	}
//	
	public GenericRoom getNextRoom(String direction){
		switch(direction){
		case "n": case "north":
			if(northRoom != null) return this.northRoom;
			else return null;
		case "e": case "east":
			if(eastRoom !=null) return this.eastRoom;
			else return null;
		case "s": case "south":
			if(southRoom != null) return this.southRoom;
			else return null;
		case "w": case "west":
			if(westRoom != null) return this.westRoom;
			else return null;
		default:
			return null;
		}
	}
	
	public void setRoomDescription(String details){
		this.roomDescription = details;
	}
	public String getRoomDescription(){
		return this.roomDescription;
	}
	
//	public boolean checkMobs(){
//		return this.mobPresent;
//	}
	
	public void setTitle(String title){
		this.roomTitle = title;
	}
	
	public String getTitle(){
		return this.roomTitle;
	}
	public void setNorthRoom(GenericRoom room){
		this.northRoom = room;
	}
	
	public void setSouthRoom(GenericRoom room){
		this.southRoom = room;
	}
	
	public void setEastRoom(GenericRoom room){
		this.eastRoom = room;
	}
	
	public void setWestRoom(GenericRoom room){
		this.westRoom = room;
	}
	
	public GenericRoom getNorthRoom(){
		return this.northRoom;
	}
	public GenericRoom getSouthRoom(){
		return this.southRoom;
	}
	public GenericRoom getEastRoom(){
		return this.eastRoom;
	}
	public GenericRoom getWestRoom(){
		return this.westRoom;
	}

	public void setLookDownDescription(String string) {
		this.lookDownDescription = string;
		
	}

	public void setLookUpDescription(String string) {
		this.lookUpDescription = string;
		
	}
	public String getLookUpDescription(){
		return this.lookUpDescription;
	}
	
	public String getLookDownDescription(){
		return this.lookUpDescription;
	}
	public ArrayList<Item> getitemsInRoom(){
		return this.itemsInRoom;
	}
	
}