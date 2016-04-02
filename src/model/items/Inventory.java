package model.items;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable  {
private ArrayList<Item> inventory;
private static Inventory self;
private	int allowedSize;
private Inventory(){
	inventory = new ArrayList<Item>();
	allowedSize = 5;
}
private static synchronized Inventory getInstance(){
	if(self==null){
		self = new Inventory();
	}
	return self;
}
public String toString(){
	String list="";
	for(int i=0;i<inventory.size();i++){
		list= list + " " + inventory.get(i);
	}
	return list;
}
public boolean add(Item i){
	if(inventory.size()== allowedSize){
		return false;
	}
	else{
		inventory.add(i);
		return true;
	}
	
}
public void drop(Item i){
	String dropThis = i.getName();
	for(int j=0;j<inventory.size();j++){
		if(inventory.get(j).getName().equals(dropThis)){
			inventory.remove(j);
			break;
		}
	}
}
public void changeInventorySize(Item n){
	if(n.getName().equals("Hermoines Handbag")){
		allowedSize = 10;
	}
}
}