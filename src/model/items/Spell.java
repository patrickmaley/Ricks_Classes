package model.items;

import java.io.Serializable;

public class Spell{
	private static String name;
	private static double attackPower;
	private static boolean alreadyInBook;
	private static Spell self;
	public Spell(String n, double aP){
		this.name=n;
		this.attackPower=aP;
		this.alreadyInBook=false;
	}
	public String getName(){
		return this.name;
	}
	public double getAttackPower(){
		return this.attackPower;
	}
	public void putInBook(){
		this.alreadyInBook=true;
	}
	public boolean getStatus(){
		return this.alreadyInBook;
	}
}
