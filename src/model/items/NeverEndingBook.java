package model.items;

import model.player.Player;

public class NeverEndingBook extends Item{
	private String bookText;
	public NeverEndingBook() {
		super("Neverending Book","Ahh the never ending book ... thats all you get");
	}

	@Override
	public String use(Player p, String notNeeded) {
		String jeremy = "Jeremy Mowry";
		String professorMercer = "Rick Mercer";
		String cindy  = "Cindiesel!!!!!";
		String hasanain = "Hasanain Jamal";
		String daniel = "Daniel Vaughn";
		String theBook = "";
		for(int i=0;i<335;i++){
			theBook += professorMercer +" "+ jeremy +" " + cindy +" "+ hasanain+" "+ daniel+ "\n";
		}
		return theBook;
	}
	public String getForLookDescription(){
		return "Over here in the corner there is a book waiting for you.";
	}

}
