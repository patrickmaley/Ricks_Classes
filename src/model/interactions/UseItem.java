package model.interactions;

import java.io.Serializable;

import model.items.Item;
import model.player.Player;

public class UseItem implements Serializable{
	Player player;
	
	public UseItem(Player p){
		this.player = p;
	}
	
	public String use(String commandParameters) {
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
}
