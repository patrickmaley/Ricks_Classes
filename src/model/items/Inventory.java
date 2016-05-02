package model.items;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable  {
private ArrayList<Item> inventory;
private	int allowedSize;
public Inventory(){
	inventory = new ArrayList<Item>();
	allowedSize = 5;
}
public Item getItem(String getThis){
	for(int j=0;j<inventory.size();j++){
		if(inventory.get(j).getName().toLowerCase().contains(getThis.toLowerCase())){
			return inventory.get(j);		
		}
	}
	return null;
}
public String toString(){
	String list="";
	if(inventory.size()==0){
		list+="You have nothing in your inventory";
	}
	for(int i=0;i<inventory.size();i++){
		System.out.println(inventory.get(i).getName());
		list= list + inventory.get(i).getName()+" ";
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
public boolean drop(String dropThis){
	for(int j=0;j<inventory.size();j++){
		if(inventory.get(j).getName().toLowerCase().contains(dropThis)){
			inventory.remove(j);
			return true;
		}
	}
	return false;
}
public void changeInventorySize(Item n){
	if(n.getName().equals("Hermoines Handbag")){
		allowedSize = 10;
	}
}
public int getInventorySize(){
	return this.inventory.size();
}
}
