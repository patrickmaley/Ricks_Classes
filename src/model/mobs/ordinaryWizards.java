package model.mobs;

import model.interactions.Interactions;

public class OrdinaryWizards extends Mobs{

	private String name;
	private int hp;
	private String house;
	private String description;
	
	public OrdinaryWizards(String name, int hp, String house) {
		super(name, hp);
		this.house = house;
		this.description = "This is " + name + " just an ordinary wizard minding their own business.";
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
	public String action(String a) {
		// TODO Auto-generated method stub
		return null;
	}

}
