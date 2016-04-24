package model.items;

import java.util.ArrayList;

import model.mobs.Mobs;
import model.player.Player;

public class RegularWand  extends Item {
	private int attackPower;
	public RegularWand() {
		super("Regular Wand","This ordinary wand will allow you to start using all those spells you have learned. Congratulation and you it carefully, as you"
				+ "must remember that the wand chooses the wizrd");
		attackPower = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String use(Player p, String spellName) {
		ArrayList<Spell> playerKnownSpells = p.getKnownSpells();
		boolean areThereMobsInTheRoom = p.getRoom().getMobsPresent();
		boolean areTherePlayersInTheRoom = p.getRoom().getPlayerPresent();
		if(!areThereMobsInTheRoom /*&& !areTherePlayersInTheRoom*/){
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
				else{
					return "You cannot attack this mob";
				}
			}
		}
		return "The attack was not possible";
	}
	public String getForLookDescription(){
		return "Remember the wand chooses the wizard. And this wand seems to be wanting you. Come and take it if you desire.";
	}

	}
