package model.items;
import model.*;
import model.mobs.Mobs;

import java.io.Serializable;

public abstract class Spell implements Serializable{
	private  String name;
	private  double attackPower;
	private  boolean alreadyInBook;
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
	abstract public boolean canAttack(Mobs m);
}
