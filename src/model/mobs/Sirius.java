package model.mobs;

import model.interactions.Interactions;

public class Sirius extends Mobs{

	private int hp;
	private String name;
	private String house;
	private String description;
	private boolean isPadfoot = false;
	
	public Sirius(String name, int hp, int x, int y) {
		super("Sirius Black", hp, "It's that convict Sirius Black! I wonder how he escaped from Azkaban? "
				+ "He was sent there for murdering innocent people!", x, y);
		this.house = "Gryffindor";
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean canBeAttacked() {
		return false;
	}

	public String getHouse() {
		return this.house;
	}

	public boolean isPadfoot(){
		return this.isPadfoot;
	}
	@Override
	public String action(String command) {
		//TODO: talk over him having multiple forms
		if(command.compareTo("talk")==0){
			//maybe add in dog form to change things.
			if(this.isPadfoot()){
				isPadfoot = false;
				return "woof woof";
			}
			else{
				isPadfoot = true;
				return "We've all got both light and dark inside us. What matters is the part"
						+ " we choose to act on. That's who we really are.";
			}
		}
		if(command.compareTo("look") == 0){
			if(this.isPadfoot()){
				isPadfoot = false;
				return "Oh look! A dog!";
			}
			return this.getDescription();
		}
		return "";
	}

	@Override
	public void move() {
		
	}

}