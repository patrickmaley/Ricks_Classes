package model.mobs;

import model.interactions.Interactions;

public class OrdinaryWizards extends Mobs{

	private String name;
	private int hp;
	private String house;
	private String description;
	
	public OrdinaryWizards(String name, int hp, String house, int x, int y) {
		super(name, hp, "This is " + name + " just an ordinary wizard minding their own business.", x , y);
		this.house = house;
	}

	public String getHouse(){
		if(this.house == null){
			return null;
		}
		return this.house;
	}

	@Override
	public boolean canBeAttacked() {
		return false;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String action(String command) {
		if(command.compareTo("talk")==0){
			//figure out house and compare to players house
		}
		if(command.compareTo("look") == 0){
			return this.getDescription();
		}
		return null;
	}

}