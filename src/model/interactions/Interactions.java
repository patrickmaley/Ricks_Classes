package model.interactions;
import model.Player;
import model.interactions.*;
import model.*;
public class Interactions {
	private Player player;
	public Interactions(Player p){
		this.player=p;
	}
	public void performAction(String totalCommand){
		String command = "";
		boolean foundSpace = false;
		int a=0;
		while(!foundSpace){
			if(a== totalCommand.length()){
				break;
			}
			if(totalCommand.charAt(a)==' '){
				foundSpace = true;
			}
			else{
			command+=totalCommand.charAt(a);
			}
			a++;
			//System.out.println(a);
			//System.out.println(totalCommand.length());
		}
		command.toLowerCase();
		System.out.println(command);
		String commandParameters = totalCommand.substring(a).trim();
		System.out.println("This is the command paramters: " + commandParameters);
		if(command.equals("north")){
			move(Move.NORTH);
		}
		else if(command.equals("south")){
			move(Move.SOUTH);
		}
		else if(command.equals("east")){
			move(Move.EAST);
		}
		else if(command.equals("west")){
			move(Move.WEST);
		}
		else if(command.equals("look")){
			look();
		}
		else if(command.equals("commands")){
			commands();
		}
		else if(command.equals("who")){
			who();
		}
		else if(command.equals("say")){
			say(commandParameters);
		}
		else if(command.equals("tell")){
			tell(a);
		}
		else if(command.equals("score")){
			information();
		}
		else if(command.equals("give")){
			give(commandParameters);
		}
		else if(command.equals("take")){
			take(commandParameters);
		}
		else if(command.equals("inventory")){
			inventory();
		}
		else if(command.equals("drop")){
			drop(commandParameters);
		}
		else if(command.equals("use")){
			use(commandParameters);
		}
		else if(command.equals("quit")){
			quit();
		}
		else{
			shutdown();
		}
	}

	private void shutdown() {
		// TODO Auto-generated method stub
		
	}

	private void quit() {
		// TODO Auto-generated method stub
		
	}

	private void use(String commandParameters) {
		// TODO Auto-generated method stub
		
	}

	private void drop(String commandParameters) {
		// TODO Auto-generated method stub
		
	}

	private void inventory() {
		//System.out.println("I was called");
		System.out.println(player.getInventory().toString());
	}

	private void take(String commandParameters) {
		// TODO Auto-generated method stub
		
	}

	private void give(String commandParameters) {
		// TODO Auto-generated method stub
		
	}

	private void information() {
		// TODO Auto-generated method stub
		
	}

	private void tell(int a) {
		// TODO Auto-generated method stub
		
	}

	private void say(String commandParameters) {
		// TODO Auto-generated method stub
		
	}

	private void who() {
		// TODO Auto-generated method stub
		
	}

	private void commands() {
		// TODO Auto-generated method stub
		
	}

	private void look() {
		// TODO Auto-generated method stub
		
	}

	private void move(Move direction) {
		// TODO Auto-generated method stub
		
	}

	
}