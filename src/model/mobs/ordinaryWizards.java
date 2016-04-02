package model.mobs;

public class ordinaryWizards extends mobs{

	private String name;
	private int hp;
	private String house;
	
	public ordinaryWizards(String name, int hp, String house) {
		super(name, hp);
		this.house = house;
	}

	public String getHouse(){
		if(this.house == null){
			return null;
		}
		return this.house;
	}
	
	@Override
	public String action() {
		if(house == "Gryffindor"){
			return "Hey what can I help with?";
		}
		if(house == "Hufflepuff"){
				return "Our ghost is the Fat Friar";
		}
		if(house == "Ravenclaw"){
			return "I'm smarter than you!";
		}
		if(house == "Slytherin"){
			return "Piss off!";
		}
		return "I once belonged to a house, but then I took a spell to the knee :(";	
	}

	@Override
	public boolean canBeAttacked() {
		return false;
	}

}
