package model.items;

import model.mobs.Mobs;
import model.player.Player;

public class BassilskFang extends Item {
	private static double attackPower;
	public BassilskFang() {
		super("Bassilsk Fang", "This is right out of the mouth of the Bassilsk. Using this will do unimaginable pain to your opponent");
		attackPower= 15;
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
							return "You have just attacked "+ mobToAttack.getName() + " and his hp is now "+ mobToAttack.getHp(); 
					}
					else{
						return "You cannot attack this mob";
					}
				}
			}


			
}
