package model.interactions;

import java.io.Serializable;
import java.util.ArrayList;

import model.items.Inventory;
import model.items.Item;
import model.player.Player;

public class ItemInteraction implements Serializable{
	private Player player;
	
	public ItemInteraction(Player player) {
		this.player = player;
	}
	
	public String drop(String commandParameters) {
		Item temp = this.player.getInventory().getItem(commandParameters);
		boolean beenDropped = this.player.getInventory().drop(commandParameters);
		if(beenDropped){			
			this.player.getRoom().additemsInRoom(temp);
			return commandParameters + " has been dropped from you inventory";
		}
		else{
			return commandParameters + " cannot be dropped as it is not in your inventory";
		}
	}

	public String take(String commandParameters) {
		ArrayList<Item> itemsInPlayersCurrentRoom = player.getRoom().getitemsInRoom();
		boolean itemIsInRoom = false;
		Item toAdd = null;
		for(int i=0; i< itemsInPlayersCurrentRoom.size();i++){
			String itemName = itemsInPlayersCurrentRoom.get(i).getName();
			if(itemName.toLowerCase().compareTo(commandParameters)==0){
				itemIsInRoom = true;
				toAdd = itemsInPlayersCurrentRoom.get(i);
				break;	
			}
		}
		if(itemIsInRoom){
			Inventory playersInventory = player.getInventory();
			boolean abilityToAdd = playersInventory.add(toAdd);
			if(abilityToAdd){
				
				player.getRoom().removeItemInRoom(toAdd);
				System.out.println("THIS IS ERICS " + player.getRoom().getItemsToString());
				return "The following item: " + commandParameters + " was added to your inventory";
			}
			else{
				return "The following item: " + commandParameters + " cannot be added to your inventory as you have reached the max capacity of size. Drop an item and try again";
			}
		}
		else{
			return "The following item: " + commandParameters + " is not in the room, so we could not add it to your inventory";
		}
	}

	public String give(String commandParameters) {
		return "You are not allowed to give another play any items for now";
	}
}
