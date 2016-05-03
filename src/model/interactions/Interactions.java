package model.interactions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.interactions.*;
import model.items.ElderWand;
import model.items.Inventory;
import model.items.Item;
import model.items.Spell;
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
		else if(command.equals("attack")){
			return attack();
		}
		else if(command.equals("talk")){
			return talk(commandParameters);
		}
		else{
			return shutdown();
		}
	}

	private String talk(String commandParameters) {
		String playerText = "";
		if(player.getRoom().getMobsInRoom().size()>0){
			Mobs mobInRoom = player.getRoom().getMobsInRoom().get(0);
			if(commandParameters.toLowerCase().compareTo(mobInRoom.getName().toLowerCase()) == 0){
				playerText += mobInRoom.getName() + ": ";
				playerText += mobInRoom.action("talk", player) + "\n";
			}
			else{
				playerText += "That person is not in this room.";
			}
		}
		else{
			playerText += "That person is not in this room.";
		}
		return playerText;
	}
	private String attack() {
		Item strongestItem = player.strongestItem();
		Spell strongestSpell = player.strongestSpell();
		String returner = "";
		String parameters = "";
		if(strongestItem != null){
			if(strongestSpell != null){
				parameters = strongestItem.getName() + " " + strongestSpell.getName();
			}
			else{
				parameters = strongestItem.getName();
			}
			return useItem.use(parameters.toLowerCase());
		}
		else{
			return "You currently have nothing to attack with.";
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
		return "Movement: \nNorth, South, East, West\n"
				+ "Interactions:\n"
				+ "Look: Look or Look <arg>\n"
				+ "Take: Take <item>\n"
				+ "Take: Take <item> <playerUsername>\n"
				+ "Give: Give <item> <playerUsername>\n"
				+ "You cannot take/give from a mob. They will drop the item in the room once you have earned it\n "
				+ "Drop <item>\n"
				+ "Up\n"
				+ "Down\n"
				+ "Use <item>\n"
				+ "Quit\n"
				+ "say <message>\n"
				+ "tell <player name> <message>\n"
				+ "talk <mob name> <message>\n"
				+ "ooc <message>\n"
				+ "Miscellaneous:\n"
				+ "who\n"
				+ "score\n"
				+ "inventory\n"
				+ "commands \n"
				+ "";
	}
	
	private String look(String commandParameters) {
		if(commandParameters.length() == 0){
			int sizeOfArray = player.getRoom().getitemsInRoom().size();
			String withItemsAndMobs ="";
			if(sizeOfArray==1){
				withItemsAndMobs = "Hey it seems like there is an item in the room with you, look over there you can see a ";
			}
			if(sizeOfArray>1){
				withItemsAndMobs = "Lucky you there are multiple items in here scattered all over the place, instead of making "
					+ "you look again I'll tell you what they are now, there is a ";
			}
				String period = ".";
			if(sizeOfArray!=0){
				ArrayList<Item> itemsinRoom = player.getRoom().getitemsInRoom();
				for(int i=0; i< itemsinRoom.size(); i++){
					if(itemsinRoom.size()>1){
						if(sizeOfArray-1!=i){
							withItemsAndMobs += itemsinRoom.get(i).getName().toLowerCase()+", and ";
						}
						else{
							withItemsAndMobs += itemsinRoom.get(i).getName().toLowerCase();
						}
						}
					else{
						withItemsAndMobs += itemsinRoom.get(i).getName();
					}
				}	
			}
			withItemsAndMobs+=period;
			if(player.getRoom().getMobsPresent()){
				ArrayList<Mobs> mobsinRoom = player.getRoom().getMobsInRoom();
				for(int i=0; i< mobsinRoom.size(); i++){
					withItemsAndMobs += mobsinRoom.get(i).getForLookDescription() + ".";
				}
			}
			if(player.getRoom().getPlayersInRoom().size()> 0){
				ArrayList<Player> playersInRoom = player.getRoom().getPlayersInRoom();
				Set<Player> playersHashSet = new HashSet<Player>(playersInRoom);
				withItemsAndMobs += "\n Players in this Room:\n";
				Iterator<Player> players = playersHashSet.iterator();
				while(players.hasNext()){
					withItemsAndMobs += players.next().getUsername() + "\n";
				}
			}
			return player.getRoom().getRoomDescription() + withItemsAndMobs;
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
		ArrayList<Player> playersInRoom = player.getRoom().getPlayersInRoom();
		boolean playersIsInRoom = false;
		Player playerInRoom = null;
		for (int i = 0; i < playersInRoom.size(); i++) {
			String playerName = playersInRoom.get(i).getUsername().toLowerCase();
			if(playerName.compareTo(commandParameters) == 0){
				playersIsInRoom = true;
				playerInRoom = playersInRoom.get(i);
				break;
			}
		}
		if(itemIsInRoom){
			return toAdd.getDescription();
		}
		if(mobIsInRoom){
			return mobInRoom.getDescription();
		}
		if(playersIsInRoom){
			return playerInRoom.getDescription();
		}
		else{
			return "What you are looking for is not here.";
		}
	}
	
	
}