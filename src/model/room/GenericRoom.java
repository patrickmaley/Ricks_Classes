package model.room;

import java.util.ArrayList;

import model.items.Item;
import model.mobs.Mobs;

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
	private ArrayList<Mobs> mobsInRoom = new ArrayList<Mobs>();
	private ArrayList<Mobs> npcInRoom = new ArrayList<Mobs>();
	private boolean mobPresent;
	private boolean playerPresent;
	private int gridX;
	private int gridY;
	
	public GenericRoom(RoomType roomType){
		playerPresent = false;
		this.roomType = roomType;
	}

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
	
	public void setPlayerPresent(boolean player){
		this.playerPresent = player;
	}
	
	public boolean getPlayerPresent(){
		return this.playerPresent;
	}
	public void setRoomDescription(String details){
		this.roomDescription = details;
	}
	public String getRoomDescription(){
		return this.roomDescription;
	}
	
	public boolean checkMobs(){
		return this.mobPresent;
	}
	
	public ArrayList<Mobs> getMobsInRoom(){
		return this.mobsInRoom;
	}
	
	public ArrayList<Mobs> getNpcInRoom(){
		return this.npcInRoom;
	}
	
	public void setMobs(boolean inRoom){
		this.mobPresent = inRoom;
	}
	
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