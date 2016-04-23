package model.items;

import java.util.ArrayList;

import model.mobs.Mobs;
import model.player.Player;

public class SwordOfGryffindor  extends Item {
	private static double attackPower;
	public SwordOfGryffindor() {
		super("Sword of Gryffindor","The sword of the great Godric Griffyndor. Only a true hero can use this");
		attackPower = 50;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String use(Player p, String notNeeded) {
		boolean areThereMobsInTheRoom = p.getRoom().getMobsPresent();
	//	boolean areTherePlayersInTheRoom = p.getRoom().getPlayerPresent();
		if(!areThereMobsInTheRoom /*&& !areTherePlayersInTheRoom*/){
			return "There is no one in the room for you to try and attack";
		}
		else{
				Mobs mobToAttack = p.getRoom().getMobsInRoom().get(0);
				if(mobToAttack.canBeAttacked()){
						mobToAttack.decreaseHP(attackPower);
						p.decreaseHP(mobToAttack.getAttackPower());
						return "You have just attacked "+ mobToAttack.getName() + " and his hp is now "+ mobToAttack.getHp() + "\n"
								+ mobToAttack.getName() + "attacked back. Your hp is now: " + p.getHP(); 	
						}
				else{
					return "You cannot attack this mob";
				}
			}
		}


		
	}


