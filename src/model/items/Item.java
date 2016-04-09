package model.items;

import model.Player;

public abstract class Item {
	private String name;
public Item(String s){
	name=s;
}
public String getName(){
	return name;
}
abstract public String use(Player p);
abstract public String getDescription();
}