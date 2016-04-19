package model.interactions;
import java.util.ArrayList;

import model.interactions.*;
import model.items.ElderWand;
import model.items.Inventory;
import model.items.Item;
import model.mobs.Mobs;
import model.player.*;
import model.room.GenericRoom;
public class Interactions {
	private Player player;
	public Interactions(Player player){
		this.player=player;
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
			return move(Move.NORTH);
		}
		else if(command.equals("south")){
			return move(Move.SOUTH);
		}
		else if(command.equals("east")){
			return move(Move.EAST);
		}
		else if(command.equals("west")){
			return move(Move.WEST);
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
			return who();
		}
		else if(command.equals("say")){
			return say(commandParameters);
		}
		else if(command.equals("tell")){
			return tell(a);
		}
		else if(command.equals("score")){
			return information();
		}
		else if(command.equals("give")){
			return give(commandParameters);
		}
		else if(command.equals("take")){
			return take(commandParameters);
		}
		else if(command.equals("inventory")){
			return inventory();
		}
		else if(command.equals("drop")){
			return drop(commandParameters);
		}
		else if(command.equals("use")){
			return use(commandParameters);
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
		// TODO Auto-generated method stub
		
	}

	private String quit() {
		return null;
		// TODO Auto-generated method stub
		
	}

	private String use(String commandParameters) {
		String item = "";
		boolean foundSpace = false;
		int a=0;
		while(!foundSpace){
			if(a== commandParameters.length()){
				break;
			}
			if(commandParameters.charAt(a)==' '){
				foundSpace = true;
			}
			else{
			item+=commandParameters.charAt(a);
			}
			a++;
		}
		String spellName = commandParameters.substring(a).trim();
		if(item.equals("elder")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}		
		}
		else if (item.equals("regular")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("sword")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("dependency")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("bassilsk")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("butter")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("healing")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("hermoines")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("horcrux")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("phoenix")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("maurders")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("never")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("ressurection")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else if (item.equals("broomstick")){
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}
		else{
			Item toUse = player.getInventory().getItem(item);
			if(toUse==null){
				return "This item was not found in your inventory therefore you cannot use it";
			}
			else{
				return toUse.use(this.player, spellName);
			}
		}		
	}
	private String drop(String commandParameters) {
		boolean beenDropped = this.player.getInventory().drop(commandParameters);
		if(beenDropped){
			return commandParameters + " has been dropped from you inventory";
		}
		else{
			return commandParameters + " cannot be dropped as it is not in your inventory";
		}
	}

	private String inventory() {
		String inventory = "";
		inventory = player.getInventory().toString();
		return inventory;
	}

	private String take(String commandParameters) {
		ArrayList<Item> itemsInPlayersCurrentRoom = player.getRoom().getitemsInRoom();
		boolean itemIsInRoom = false;
		Item toAdd = null;
		for(int i=0; i< itemsInPlayersCurrentRoom.size();i++){
			String itemName = itemsInPlayersCurrentRoom.get(i).getName();
			if(itemName.compareTo(commandParameters)==0){
				itemIsInRoom = true;
				toAdd = itemsInPlayersCurrentRoom.get(i);
				break;	
			}
		}
		if(itemIsInRoom){
			Inventory playersInventory = player.getInventory();
			boolean abilityToAdd = playersInventory.add(toAdd);
			if(abilityToAdd){
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

	private String give(String commandParameters) {
		return "You are not allowed to give another play any items!!";
	}

	private String information() {
		return "There is no score in this game. God not everything is about winning and losing, but here is some of you information" + "/n" +
				"Your HP : "+this.player.getHP() + "/n" + "Your known spells " + this.player.getKnownSpells().toString() + "\n" + "Your Inventory " +
				this.player.getInventory().toString();
		
	}

	private String tell(int a) {
		return null;
		// TODO Auto-generated method stub
		
	}

	private String say(String commandParameters) {
		return commandParameters;
		// TODO Auto-generated method stub
		
	}

	private String who() {
		return null;
	}

	private String commands() {
		String listOfCommands = listOfCommands();
		return listOfCommands;
	}

	private String listOfCommands() {
		String returning = "";
		returning = "north" + "\n" + "south" + "\n" + "east" + "\n" + "west" + "\n" + "up" + "\n" + "down" + "\n" + "take" + "\n" + "give" + "\n" + "look"
		+ "\n" + "commands" + "\n" + "who" + "\n" + "say" + "\n" + "tell" + "\n"+ "score" + "\n" + "drop" + "\n" + "use" + "\n" + "quit" + "\n" + "shutdown"; 
		return returning;
	}
	private String look(String commandParameters) {
		if(commandParameters.compareTo("") == 0){
			return player.getRoom().getRoomDescription();
		}
		ArrayList<Item> itemsInPlayersCurrentRoom = player.getRoom().getitemsInRoom();
		boolean itemIsInRoom = false;
		Item toAdd = null;
		ArrayList<Mobs> mobsInPlayersCurrentRoom = player.getRoom().getMobsInRoom();
		boolean mobIsInRoom = false;
		Mobs mobInRoom = null;
		for(int i=0; i< itemsInPlayersCurrentRoom.size();i++){
			String itemName = itemsInPlayersCurrentRoom.get(i).getName();
			String mobName = mobsInPlayersCurrentRoom.get(i).getName();
			if(itemName.compareTo(commandParameters)==0){
				itemIsInRoom = true;
				toAdd = itemsInPlayersCurrentRoom.get(i);
				break;	
			}
			if(mobName.compareTo(commandParameters)==0){
				mobIsInRoom = true;
				mobInRoom = mobsInPlayersCurrentRoom.get(i);
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

	private String move(Move direction) {
		GenericRoom roomToMoveIn = null;
		if(direction == Move.NORTH){
			String directionString = "north";
			roomToMoveIn = player.getRoom().getNextRoom(directionString);
			if(roomToMoveIn!=null){
				player.getRoom().setPlayerPresent(false);
				player.setCurrentRoom(roomToMoveIn);
				player.getRoom().setPlayerPresent(true);
				return player.getRoom().getRoomDescription();
			}
		else{
			return "There is no door in the north direction. Please enter a new direction";
		}
		}
		if(direction == Move.SOUTH){
			String directionString = "south";
			roomToMoveIn = player.getRoom().getNextRoom(directionString);
			if(roomToMoveIn!=null){
				player.getRoom().setPlayerPresent(false);
				player.setCurrentRoom(roomToMoveIn);
				player.getRoom().setPlayerPresent(true);
				return player.getRoom().getRoomDescription();
			}
			else{
				return "There is no door in the north direction. Please enter a new direction";
			}
		}
		if(direction == Move.EAST){
			String directionString = "east";
			roomToMoveIn = player.getRoom().getNextRoom(directionString);
			if(roomToMoveIn!=null){
				player.getRoom().setPlayerPresent(false);
				player.setCurrentRoom(roomToMoveIn);
				player.getRoom().setPlayerPresent(true);
				return player.getRoom().getRoomDescription();
			}
				else{
				return "There is no door in the north direction. Please enter a new direction";
			}
		}
		if(direction == Move.WEST){
			String directionString = "west";
			roomToMoveIn = player.getRoom().getNextRoom(directionString);
			if(roomToMoveIn!=null){
				player.getRoom().setPlayerPresent(false);
				player.setCurrentRoom(roomToMoveIn);
				player.getRoom().setPlayerPresent(true);
				return player.getRoom().getRoomDescription();
			}
			else{
				return "There is no door in the north direction. Please enter a new direction";
			}
		}
		return "That is not a valid command for movement";	
}
}