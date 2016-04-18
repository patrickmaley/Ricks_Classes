package model.items;

import model.player.Player;;

public abstract class Item {
	private String name;
	private String description;
public Item(String s,String d){
	name=s;
	description = d;
}
public String getName(){
	return name;
}
public String getDescription(){
	return description;
}
abstract public String use(Player p, String ifNeeded);
}