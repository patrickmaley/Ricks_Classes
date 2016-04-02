package model.items;

public abstract class Item {
	private static String name;
	private static String type;
	
public Item(String s, String t){
	this.name=s;
	this.type=t;
}
public String getName(){
	return this.name;
}
public String getType(){
	return this.type;
}
abstract public void use();
}