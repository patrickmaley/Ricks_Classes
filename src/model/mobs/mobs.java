package model.mobs;

public abstract class mobs {
	
	private String name;
	private int hp;

	
	public mobs(String name, int hp){
		this.name = name;
		this.hp = hp;
	}
	
	public int getHp(){
		return this.hp;
	}
	
	public String getName(){
		return this.name;
	}
	public abstract boolean canBeAttacked();
	
	public abstract String action();

	public abstract String getHouse();
}
