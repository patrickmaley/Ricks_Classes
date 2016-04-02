package model.mobs;

public class Snape extends mobs {

	private int hp;
	private String name;
	private String house;
	public Snape(String name, int hp) {
		super(name, hp);
		//this.name = "Professor Snape";
		this.house = "Slytherin";
	}

	public String getHouse(){
		return this.house;
	}
	
	@Override
	public boolean canBeAttacked() {
		return false;
	}

	@Override
	public String action() {
		return "Get. Out.";
	}

}
