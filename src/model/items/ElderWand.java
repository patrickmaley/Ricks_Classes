package model.items;

import java.util.ArrayList;

import model.mobs.Mobs;
import model.player.Player;

public class ElderWand extends Item {
	private static double attackPower = 30.00;
	public ElderWand() {
		super("Elder Wand","With this you will be one step closer to mastering death. The ultimate weapon"
				+ "this Elder Wand will add 30 attack points to all the spells you can use making you"
				+ "a beast!!");
	}
	
	@Override
	public String use(Player p, String spellName) {		
		ArrayList<Spell> playerKnownSpells = p.getKnownSpells();
		boolean areThereMobsInTheRoom = p.getRoom().getMobsPresent();
		boolean areTherePlayersInTheRoom = p.getRoom().getPlayerPresent();
		if(!areThereMobsInTheRoom && !areTherePlayersInTheRoom){
			return "There is no one in the room for you to try and attack";
		}
		else{
			Spell tryingToUseThis = null;
			for(int i=0;i < playerKnownSpells.size();i++){
				Spell temp = playerKnownSpells.get(i);
				if(temp.getName().toLowerCase().equals(spellName.trim().toLowerCase())){
					tryingToUseThis= playerKnownSpells.get(i);
					break;
				}
			}
			if(tryingToUseThis == null){
				return "You are trying to use a spell that you do not know";
			}
			else{
				Mobs mobToAttack = p.getRoom().getMobsInRoom().get(0);
				if(mobToAttack.canBeAttacked()){
					if(tryingToUseThis.canAttack(mobToAttack)){
						mobToAttack.decreaseHP(attackPower+tryingToUseThis.getAttackPower());
						if(mobToAttack.getHp() > 0){
						p.decreaseHP(mobToAttack.getAttackPower());
						return "You have just attacked "+ mobToAttack.getName() + " and his hp is now "+ mobToAttack.getHp() + "\n"
								+ mobToAttack.getName() + " attacked back. Your hp is now: " + p.getHP();
						}
						else{
							return "You have just attacked "+ mobToAttack.getName() + " and is now dead.";							}
						}
				}
			}
					return "You cannot attack this mob";
				}

		}

	@Override
	public String getForLookDescription() {
		return " Hey the all powerful elder wand is here!";
	}


}
