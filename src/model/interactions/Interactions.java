package model.interactions;
import java.io.Serializable;
import java.util.ArrayList;

import model.interactions.*;
import model.items.ElderWand;
import model.items.Inventory;
import model.items.Item;
import model.mobs.Mobs;
import model.player.*;
import model.room.GenericRoom;
public class Interactions implements Serializable {
	private Player player;
	MoveDirection move;
	UseItem useItem;
	ItemInteraction items;
	public Interactions(Player player){
		this.player=player;
		move = new MoveDirection(player);
		useItem = new UseItem(player);
		items = new ItemInteraction(player);
	}
	public String performAction(String totalCommand){
		String command = "";
		totalCommand=totalCommand.toLowerCase();
		boolean foundSpace = false;
		int a=0;
		while(!foundSpace){
			if(a== totalCommand.length()){
				break;
			}
			if(totalCommand.charAt(a)==' '){
				foundSpace = true;
			}
			else{
			command+=totalCommand.charAt(a);
			}
			a++;
		}
		System.out.println(command);
		String commandParameters = totalCommand.substring(a).trim();
		System.out.println("This is the command paramters: " + commandParameters);
		if(command.equals("north")){
			return move.use(Move.NORTH);
		}
		else if(command.equals("south")){
			return move.use(Move.SOUTH);
		}
		else if(command.equals("east")){
			return move.use(Move.EAST);
		}
		else if(command.equals("west")){
			return move.use(Move.WEST);
		}
		else if(command.equals("look")){
			return look(commandParameters);
		}
		else if(command.equals("commands")){
			return commands();
		}
		else if(command.equals("up")){
			return up();
		}
		else if(command.equals("down")){
			return down();
		}
		else if(command.equals("who")){
			return "should have been taken care of in server";
		}
		else if(command.equals("say")){
			return say(commandParameters);
		}
		else if(command.equals("tell")){
			return tell(commandParameters);
		}
		else if(command.equals("score")){
			return information();
		}
		else if(command.equals("give")){
			return items.give(commandParameters);
		}
		else if(command.equals("take")){
			return items.take(commandParameters);
		}
		else if(command.equals("inventory")){
			return inventory();
		}
		else if(command.equals("drop")){
			return items.drop(commandParameters);
		}
		else if(command.equals("use")){
			return useItem.use(commandParameters);
		}
		else if(command.equals("quit")){
			return quit();
		}
		else{
			return shutdown();
		}
	}

	private String down() {
		return player.getRoom().getLookDownDescription();
	}
	private String up() {
		return player.getRoom().getLookUpDescription();
	}
	private String shutdown() {
		return null;
	}

	private String quit() {
		return null;
	}

	private String inventory() {
		String inventory = "";
		inventory = player.getInventory().toString();
		return inventory;
	}

	private String information() {
		return "There is no score in this game. God not everything is about winning and losing, but here is some of you information" + "\n" +
				"Your HP : "+this.player.getHP() + "\n" + "Your known spells: " + this.player.getKnownSpellsToString() + "\n" + "Your Inventory: " +
				this.player.getInventory().toString();
		
	}

	private String say(String commandParameters) {
		return null;
		// TODO Auto-generated method stub
		
	}

	private String tell(String commandParameters) {
		return null;
	}
	private String commands() {
		String listOfCommands = listOfCommands();
		return listOfCommands;
	}

	private String listOfCommands() {
		String returning = "";
		returning = "north" + "\n" + "south" + "\n" + "east" + "\n" + "west" + "\n" + "up" + "\n" + "down" + "\n" + "take <item> " +"\n" +"take <item> <target> "+"\n" + "give <item> <target>" + "\n" + "look"
		+ "\n" + "commands" + "\n" + "who" + "\n" + "say" + "\n" + "tell <player/mob> <message>" + "\n"+ "score" + "\n" + "drop" + "\n" + "use" + "\n" + "quit" + "\n" + "shutdown"; 
		return returning;
	}
	private String look(String commandParameters) {
		if(commandParameters.length() == 0){
			String withItemsAndMobs ="";
			if(player.getRoom().getitemsInRoom().size()!=0){
				ArrayList<Item> itemsinRoom = player.getRoom().getitemsInRoom();
				for(int i=0; i< itemsinRoom.size(); i++){
					if(itemsinRoom.size()>1){
					withItemsAndMobs += itemsinRoom.get(i).getForLookDescription() + ", and ";
				}
					else{
						withItemsAndMobs += itemsinRoom.get(i).getForLookDescription();
					}
				}	
			}
			if(player.getRoom().getMobsPresent()){
				ArrayList<Item> mobsinRoom = player.getRoom().getitemsInRoom();
				for(int i=0; i< mobsinRoom.size(); i++){
					withItemsAndMobs += mobsinRoom.get(i).getForLookDescription() + ".";
				}
			}
			return player.getRoom().getRoomDescription() + "\n" + withItemsAndMobs;
		}
		ArrayList<Item> itemsInPlayersCurrentRoom = player.getRoom().getitemsInRoom();
		boolean itemIsInRoom = false;
		Item toAdd = null;
		ArrayList<Mobs> mobsInPlayersCurrentRoom = player.getRoom().getMobsInRoom();
		boolean mobIsInRoom = false;
		Mobs mobInRoom = null;
		for(int i=0; i< itemsInPlayersCurrentRoom.size();i++){
			String itemName = itemsInPlayersCurrentRoom.get(i).getName().toLowerCase();
			if(itemName.compareTo(commandParameters)==0){
				itemIsInRoom = true;
				toAdd = itemsInPlayersCurrentRoom.get(i);
				break;	
			}
		}
		for(int i=0; i< mobsInPlayersCurrentRoom.size();i++){
			String mobName = mobsInPlayersCurrentRoom.get(i).getName().toLowerCase();
			if(mobName.compareTo(commandParameters)==0){
				mobIsInRoom = true;
				mobInRoom = mobsInPlayersCurrentRoom.get(i);
				break;
			}
		}
		if(itemIsInRoom){
			return toAdd.getDescription();
		}
		if(mobIsInRoom){
			return mobInRoom.getDescription();
		}
		else{
			return "What you are looking for is not here.";
		}
	}
}