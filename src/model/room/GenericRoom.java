package model.room;

import java.io.Serializable;
import java.util.ArrayList;

import model.items.Item;
import model.mobs.Mobs;
import model.player.Player;

public abstract class GenericRoom implements Serializable{
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
	private ArrayList<Player> playersInRoom = new ArrayList<Player>();
	private boolean mobPresent;
	private boolean playerPresent;
	private boolean isVisible;
	private int gridX;
	private int gridY;
	
	public GenericRoom(RoomType roomType){
		playerPresent = false;
		this.roomType = roomType;
		isVisible = false;
	}
	
	public void setIsVisible(boolean bool){
		this.isVisible = bool;
	}

	public boolean getIsVisible(){
		return this.isVisible;
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
	public String getItemsToString(){
		String list="";
		for(int i=0;i<itemsInRoom.size();i++){
			//System.out.println(itemsInRoom.get(i).getName());
			list= list + itemsInRoom.get(i).getName()+" ";
		}
		return list;
	}
	public String getMobsToString(){
		String list="";
		for(int i=0;i<mobsInRoom.size();i++){
			//System.out.println(mobsInRoom.get(i).getName());
			list= list + mobsInRoom.get(i).getName()+" ";
		}
		return list;
	}
	public void setPlayerPresent(boolean player, Player p){
		if(player == false){
			for(int i =0;i<playersInRoom.size();i++){
				if(playersInRoom.get(i).getGameName().equals(p.getGameName())){
					playersInRoom.remove(i);
					break;
				}
			}
		}
		if(player == true){
			playersInRoom.add(p);
		}
		if(playersInRoom.size()>0){
			this.playerPresent=true;
		}		
	}
	public ArrayList<Player> getPlayersInRoom(){
		return this.playersInRoom;
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
	
	public ArrayList<Mobs> getMobsInRoom(){
		return this.mobsInRoom;
	}
		
	public void setMobsPresent(boolean inRoom){
		this.mobPresent = inRoom;
	}
	public boolean getMobsPresent(){
		return this.mobPresent;
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
		return this.lookDownDescription;
	}
	
	public ArrayList<Item> getitemsInRoom(){
		return this.itemsInRoom;
	}
	
	public void additemsInRoom(Item item){
		 this.itemsInRoom.add(item);
	}
	
	public void setMobsInRoom(Mobs mob){
		this.mobsInRoom.add(mob);
		this.setMobsPresent(true);
	}
	public void removeMobsInRoom(Mobs mob){
		if(this.mobsInRoom.contains(mob)){
			this.mobsInRoom.remove(mob);
		}
	}
	public void removeItemInRoom(Item item){
		 if(this.itemsInRoom.contains(item)){
			 System.out.println("REMOVED");
			this.itemsInRoom.remove(item);
		 }
	}	
}
