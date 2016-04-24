package model.items;

import model.player.Player;

public class Horcrux extends Item {
	boolean hasLight = false;
	public Horcrux() {
		super("Horcrux","Well well well ... this here is a horcrux. By using it you will make a horcrux. The result will be a decrease in your HP by a 25, but you will have gained the knowledge of Avada Kedavra");
	}

	@Override
	public String use(Player p, String notNeeded) {
		p.decreaseHP(25.00);
		AvadaKedvra avadaKedvra = new AvadaKedvra();
		p.addKnownSpells(avadaKedvra);
		p.getInventory().drop(this.getName().toLowerCase());
		return "Congrats you death eater. You have sacrificed your soul for power. Your HP is now : " + p.getHP()+ " , but you do know the killing curse now";
	}
	public String getForLookDescription(){
		return "Whats the dark eerily sensation you are feeling. Crap over there a horcrux, are you drawn in by the dark side?";
	}
}
