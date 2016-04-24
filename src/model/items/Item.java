package model.items;

import java.io.Serializable;

import model.player.Player;;

public abstract class Item implements Serializable {
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
abstract public String getForLookDescription();
}