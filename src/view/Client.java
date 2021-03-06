package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.items.Item;
import model.player.Player;


public class Client extends JFrame{
	private static final String ADDRESS = "localhost";
	private final Dimension STATUS_PANEL_DIMENSION = new Dimension(200, 300);
	private final String GAME_COMMANDS = "Command List\n"
			+ "Movement: \nNorth, South, East, West\n"
			+ "Interactions:\n"
			+ "Look or Look <arg>\n"
			+ "Take <item>\n"
			+ "Take <1st word of item or item name> <playerUsername>\n"
			+ "Give <1st word of item or item name> <playerUsername>\n"
			+ "You cannot take/give from a mob. They will drop the item in the room once you have earned it\n "
			+ "Drop <item> or Drop <first word of item>\n"
			+ "Up\n"
			+ "Down\n"
			+ "Use <1st word of item or item name>\n"
			+ "attack or attack <mob name>"
			+ "Quit\n"
			+ "say <message>\n"
			+ "tell <player name> <message>\n"
			+ "talk <mob name> <message>\n"
			+ "ooc <message>\n"
			+ "Miscellaneous:\n"
			+ "who\n"
			+ "score\n"
			+ "inventory\n"
			+ "commands \n"
			+ "";
	private final String TEXT_BREAK ="------------------------------------------------------------------------------------------------------------\n";
	
	private JPanel textPanel = new JPanel();
	private JPanel signInPanel = new JPanel(new FlowLayout());
	private JPanel gameInstructionsPanel = new JPanel(new FlowLayout());
	
	private JTextArea signInInstructions = new JTextArea();
	private JTextArea gameTextArea = new JTextArea();
	private JTextArea playerStatsTextArea = new JTextArea();

	private JTextField playerTextArea = new JTextField();
	private JTextField signInText = new JTextField();
	private JTextField gameNameText = new JTextField();
	private JTextField gameHouseText = new JTextField();
	private JTextField titleText = new JTextField();
	
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	
	private JPasswordField passwordText = new JPasswordField();
	private JButton signInButton = new JButton("Sign In");
	Font displayFont = new Font("AngsanaUPC", 1, 16);
	private Player newPlayer = null;
	
	private Image express, hogwartsMap;
	public static void main(String[] args) {
		new Client().setVisible(true);
	}
	
	public Client(){
		openConnection();
		setTitle("9 3/4 Jump Street: Hogwarts");
		setLayout(new FlowLayout());
		//setPreferredSize(new Dimension(1200, 600));
		setSize(1350, 650);
		setLocation(0,0);
		//setLocationRelativeTo(null);
		//setResizable(false);
		getContentPane().setBackground(new Color(8, 2, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			express = ImageIO.read(new File("images/hogwartsExpress.jpg"));
			hogwartsMap = ImageIO.read(new File("images/rsz_yeoldemap2.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signInFrame();
		
		new ServerListener().start();
	}
	
	private void signInFrame() {
		//setLayout(new FlowLayout());
		//setPreferredSize(new Dimension(450, 110));
		//setSize(800, 650);
		//setLocation(0,0);
		//Sets up the sign In Panel where the user inputs information
		//BackgroundPanel test = new BackgroundPanel();
		
		//Set title of the game
  		Font titleFont = new Font("Bodoni MT Black", 1, 60);
  		titleText.setSize(1800, 100);
  		titleText.setFont(titleFont);
  		titleText.setBackground(new Color(192, 142, 45));
  		titleText.setEditable(false);
  		titleText.setText("Harry Potter in 9 3/4's Jump Street");
  		add(titleText);
  		
  		ImageIcon icon = new ImageIcon(express); 
  		JLabel thumb = new JLabel();
  		thumb.setIcon(icon);
  		add(thumb);
  		
		JLabel userNameLabel = new JLabel("User Name");
		JLabel passwordLabel = new JLabel("Password  ");
		
		userNameLabel.setForeground(new Color(59, 58, 54));
		userNameLabel.setLabelFor(signInText);
		userNameLabel.setFont(displayFont);
		passwordLabel.setForeground(new Color(59, 58, 54));
		passwordLabel.setLabelFor(passwordText);
		passwordLabel.setFont(displayFont);	
	
		signInPanel.setPreferredSize(STATUS_PANEL_DIMENSION);
		signInPanel.add(userNameLabel);
		signInText.setPreferredSize(new Dimension(100, 25));
		signInPanel.add(signInText);
		signInPanel.add(passwordLabel);
		passwordText.setPreferredSize(new Dimension(100, 25));
        signInPanel.add(passwordText);
        signInPanel.add(this.signInButton);
        add(signInPanel);
      
        signInButton.addActionListener(new SignInListener()); 
	}

	
	private void frameProperties(){
		//this.setPreferredSize(new Dimension(800,1000));
		//setSize(800, 1200);
		JLabel gameNameLabel = new JLabel("Game Name");
		JLabel gameHouseLabel = new JLabel("House Name");
		gameNameLabel.setForeground(new Color(59, 58, 54));
		gameNameLabel.setLabelFor(gameNameText);
		gameNameLabel.setFont(displayFont);	
		gameHouseLabel.setForeground(new Color(59, 58, 54));
		gameHouseLabel.setLabelFor(gameHouseText);
		gameHouseLabel.setFont(displayFont);	
		//signInPanel.removeAll();
		gameInstructionsPanel.setPreferredSize(new Dimension(200,550));
		gameInstructionsPanel.setBackground(new Color(192, 142, 45));
		signInPanel.setBackground(new Color(192, 142, 45));
        signInInstructions.setText(GAME_COMMANDS);
        signInInstructions.setPreferredSize(new Dimension(175, 400));
        signInInstructions.setBackground(new Color(192, 142, 45));
        signInInstructions.setWrapStyleWord(true);
        signInInstructions.setEditable(false);
		signInInstructions.setLineWrap(true);
		gameInstructionsPanel.add(signInInstructions);
        gameNameText.setPreferredSize(new Dimension(100, 25));
        gameNameText.setEditable(false);
        add(gameInstructionsPanel);
		
        //Set panel for second column
        textPanel.setPreferredSize(new Dimension(550,575));
		textPanel.setBackground(new Color(192, 142, 45));
		textPanel.setLayout(new FlowLayout());
		
        //Set title of the game
  		Font titleFont = new Font("Bodoni MT Black", 1, 30);
  		titleText.setSize(100, 100);
  		titleText.setFont(titleFont);
  		titleText.setBackground(new Color(192, 142, 45));
  		titleText.setEditable(false);
  		titleText.setText("9 3/4 Jump Street: Hogwarts");
  		textPanel.add(titleText);
      		
  		//Jtextarea for the game
		gameTextArea.setEditable(false);
		gameTextArea.setLineWrap(true);
		gameTextArea.setWrapStyleWord(true);
		//gameTextArea.setText(this.dragonTitle);
		JScrollPane gameTextPane = new JScrollPane(this.gameTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		gameTextPane.setPreferredSize(new Dimension(450, 400));
		textPanel.add(gameTextPane);
		
		//Text area for player commands
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Player Commands");
		playerTextArea.setBorder(title);
		playerTextArea.setEditable(true);
		playerTextArea.setPreferredSize(new Dimension(450,50));
		textPanel.add(playerTextArea);
		
		//Player information
		playerStatsTextArea.setEditable(false);
		playerStatsTextArea.setLineWrap(true);
		playerStatsTextArea.setWrapStyleWord(true);
		playerStatsTextArea.setPreferredSize(new Dimension(450, 35));
		//textPanel.add(playerStatsTextArea);
		
		//Add all components to the frame and set actionlistener
		add(textPanel);
		
		//add(graphicsView);
		playerTextArea.addActionListener(new textBoxListener());
	}
	
	private void openConnection() {
		try {
			socket = new Socket(ADDRESS, Server.SERVER_PORT);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			this.cleanUpAndQuit("Couldn't connect to the server");
		}
	}

	private class ServerListener extends Thread {
		@Override
		public void run() {
			try {
				while (true){
					Player player = (Player) ois.readObject();
					String hello = (String)ois.readObject();
					
					//Wrong password typed in to an already created account
					if(player == null && Client.this.newPlayer == null){
						JOptionPane.showMessageDialog(Client.this, "Password incorrect!!!!");
						Client.this.revalidate();
						Client.this.getContentPane().repaint();
					}
					
					//If the client is new, then this loads up the first player
					if(player != null && player.getGameName() != null && Client.this.newPlayer == null){
						//Changes the sign in gui to the game gui
						Client.this.getContentPane().removeAll();
						Client.this.frameProperties();
						Client.this.revalidate();
						Client.this.getContentPane().repaint();
						
						Client.this.newPlayer = player;
						Client.this.gameTextArea.append("You wake up after taking a nap outside of Hogwarts." + "\n");
						Client.this.gameTextArea.append(TEXT_BREAK);
					}
					
					if(player != null && player.getGameName() == null && Client.this.newPlayer == null){
						JTextField gameName = new JTextField();
						JTextField houseName = new JTextField();
						JTextArea characterDescription = new JTextArea();
						characterDescription.setPreferredSize(new Dimension(100, 150));
						characterDescription.setLineWrap(true);
						characterDescription.setWrapStyleWord(true);
						final JComponent[] inputs = new JComponent[] {
								new JLabel("Please enter your game name:"),
								gameName,
								new JLabel("Please enter your house name"),
								houseName,
								new JLabel("Please enter your character description"),
								characterDescription
						};
						
						JOptionPane optionPane = new JOptionPane(inputs);
						
						JDialog dialog = optionPane.createDialog("Character Information");
						
						dialog.setAlwaysOnTop(true);
						dialog.setModal(true);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
						player.setGameName(gameName.getText());
						player.setHouse(houseName.getText());
						player.setDescription(characterDescription.getText());
						String[] nullArray = {"null"};
						sendObjects("",new char[0], player, nullArray);
					}
					
					//Sets the player to the updated version
					if(player != null && Client.this.newPlayer != null && player.getUsername().compareTo(Client.this.newPlayer.getUsername()) ==0){
						Client.this.newPlayer = player;
					}else if(player!=null && Client.this.newPlayer != null){
						Client.this.newPlayer.setPlayerMap(player.getPlayerMap());
					}
					
					if(hello != null){
						if(hello.compareTo("") != 0 ){
							//Global Chat
							if(hello.contains("Global Chat:")){
								Client.this.gameTextArea.append(hello + "\n");
							//Tell command
							}else if(hello.contains("Tell:")){
								String[] username = hello.split("\\s+");
								if(hello.contains(Client.this.newPlayer.getUsername())){
									Client.this.gameTextArea.append(hello + "\n");
								}
							//Say command
							}else if(hello.contains("Room Chat:")){
								ArrayList<Player> playersInRoom = player.getRoom().getPlayersInRoom();
								Set<Player> s = new HashSet<Player>(playersInRoom);
								for (Player player2 : s) {
									if(Client.this.newPlayer.getUsername().compareTo(player2.getUsername()) == 0){
										Client.this.gameTextArea.append(hello + "\n");
									}
								}
							//All other actions
							}else if(hello.contains("NO")){
								String returned = hello.toLowerCase();
								String[] take = returned.split("\\s+");
								String playerGettingUserName = take[3];
								String playerTakingFromUserName = take[4];
								ArrayList<Player> playersInRoom = player.getRoom().getPlayersInRoom();
								Set<Player> s = new HashSet<Player>(playersInRoom);
								for (Player player2 : s) {
									if(playerGettingUserName.compareTo(player2.getUsername()) == 0){
										Client.this.gameTextArea.append("Deal was rejected ");
										Client.this.gameTextArea.append(TEXT_BREAK);
									}
									else if(playerTakingFromUserName.compareTo(player2.getUsername()) == 0){
										Client.this.gameTextArea.append("Deal was rejected ");
										Client.this.gameTextArea.append(TEXT_BREAK);
									}
								}
							}else if(hello.contains("YES")){
								String returned = hello.toLowerCase();
								String[] take = returned.split("\\s+");
								String playerGettingUserName = take[3];
								String playerTakingFromUserName = take[4];
								if(Client.this.newPlayer.getUsername().compareTo(playerTakingFromUserName)==0){
									Client.this.gameTextArea.append("Deal is done " + "\n");
									Client.this.gameTextArea.append(TEXT_BREAK);
								}
								ArrayList<Player> playersInRoom = player.getRoom().getPlayersInRoom();
								Set<Player> s = new HashSet<Player>(playersInRoom);
								Player sendingBack=null;
								for(int i =0;i<playersInRoom.size();i++){
									if(playersInRoom.get(i).getUsername().contains(playerGettingUserName)){
										sendingBack = playersInRoom.get(i);
										break;
									}
								}
								sendObjects("",new char[0], sendingBack, null);
								
							}else if(hello.contains("Take")){
								String returned = hello.toLowerCase();
								String[] take = returned.split("\\s+");
								ArrayList<Player> playersInRoom = player.getRoom().getPlayersInRoom();
								Set<Player> s = new HashSet<Player>(playersInRoom);
								String itemName="";
								for(int i =1;i<take.length-2;i++){
									itemName+=take[i] + " ";
								}
								itemName=itemName.trim();
								String toTakeFromUserName = take [take.length-2];
								String askingToTakeUserName = take[take.length-1];
								if(Client.this.newPlayer.getUsername().compareTo(toTakeFromUserName)==0){
									int reply = JOptionPane.showConfirmDialog(null, askingToTakeUserName + " would like to take " + itemName, "Take Request", JOptionPane.YES_NO_OPTION);
									if(reply == JOptionPane.YES_OPTION){
										String [] tradeYes = {"trade", "Accepted", take[1], askingToTakeUserName};
										sendObjects("",new char[0], Client.this.newPlayer, tradeYes);
									}
									if(reply == JOptionPane.NO_OPTION){
											String [] tradeNo = {"trade", "Rejected", take[1], askingToTakeUserName};
											sendObjects("",new char[0], Client.this.newPlayer, tradeNo);
									}
								}
							}else if(hello.contains("Give")){
								String returned = hello.toLowerCase();
								String[] take = returned.split("\\s+");
								ArrayList<Player> playersInRoom = player.getRoom().getPlayersInRoom();
								Set<Player> s = new HashSet<Player>(playersInRoom);
								String itemName="";
								for(int i =1;i<take.length-2;i++){
									itemName+=take[i] + " ";
								}
								itemName=itemName.trim();
								String toTakeFromUserName = take [take.length-2];
								String ToGiveToUserName = take[take.length-1];
								if(Client.this.newPlayer.getUsername().compareTo(ToGiveToUserName)==0){
									int reply = JOptionPane.showConfirmDialog(null, toTakeFromUserName + " would like to give " + itemName, "Take Request", JOptionPane.YES_NO_OPTION);
									if(reply == JOptionPane.YES_OPTION){
										String [] tradeYes = {"giving", "Accepted", take[1], toTakeFromUserName};
										sendObjects("",new char[0], Client.this.newPlayer, tradeYes);
									}
									if(reply == JOptionPane.NO_OPTION){
											String [] tradeNo = {"giving", "Rejected", take[1], toTakeFromUserName};
											sendObjects("",new char[0], Client.this.newPlayer, tradeNo);
									}
								}
							}else{
								if(player != null && player.getUsername().compareTo(Client.this.newPlayer.getUsername()) ==0){
										Client.this.gameTextArea.append(hello + "\n");
										Client.this.gameTextArea.append(TEXT_BREAK);
										//Resets descriptions value
										playerTextArea.setText("");
										if(hello.contains("I solemnly swear that I am up")){
											ImageIcon icon = new ImageIcon(hogwartsMap); 
											JLabel thumb = new JLabel();
											thumb.setIcon(icon);
											add(thumb);
											Client.this.revalidate();
											Client.this.getContentPane().repaint();
										}
								}
							}
						}
					}else{
						if(player != null && player.getUsername().compareTo(Client.this.newPlayer.getUsername()) ==0){
							Client.this.gameTextArea.append("Nothing much happens\n");
							Client.this.gameTextArea.append(TEXT_BREAK);
						}
					}
					//Auto updates the scrollpane to the last description
					gameTextArea.setCaretPosition(gameTextArea.getDocument().getLength());
					
					
				}
			} catch (IOException e) {
				Client.this.cleanUpAndQuit("The server hung up on us. Exiting...");
			} catch (ClassNotFoundException e) {
				Client.this.cleanUpAndQuit("Got something from the server that wasn't a MUD...");
			}
		}
	}
	
	private void cleanUpAndQuit(String message) {
		JOptionPane.showMessageDialog(this, message);
		try {
			if (socket != null)
				socket.close();
		} catch (IOException e) {
			// Couldn't close the socket, we are in deep trouble. Abandon ship.
			e.printStackTrace();
		}
		Client.this.dispatchEvent(new WindowEvent(Client.this,WindowEvent.WINDOW_CLOSING));
	}
	
	private class textBoxListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = playerTextArea.getText().toLowerCase();
			String[] firstWord = command.split("\\s+");
			
			if(firstWord[0].compareTo("quit")== 0){
				sendObjects("",new char[0], Client.this.newPlayer, firstWord);
				cleanUpAndQuit("See ya next time!");
			}else if(firstWord[0].compareTo("commands")==0 || 
					firstWord[0].compareTo("help")==0){
					Client.this.playerTextArea.setText("");
					Client.this.gameTextArea.append(GAME_COMMANDS);
			}else if(firstWord[0].compareTo("shutdown")==0 ||
					firstWord[0].compareTo("say")==0 ||
					firstWord[0].compareTo("ooc")==0 ||
					firstWord[0].compareTo("tell")==0 ||
					firstWord[0].compareTo("who")==0 ||
					firstWord[0].compareTo("give")==0 ||
					firstWord[0].compareTo("take")==0 && itemsIsNotOnMap(firstWord[firstWord.length-1])){
				String[] commandArray = command.split("\\s+");
				Client.this.playerTextArea.setText("");
				if(firstWord[0].compareTo("who") == 0 ||commandArray.length  > 1){
					sendObjects("",new char[0], Client.this.newPlayer, commandArray);
				}
			}else{
				String commandInstruction = "command " + command;
				String[] commandArray = commandInstruction.split("\\s+");
				Client.this.playerTextArea.setText("");
				sendObjects("",new char[0], Client.this.newPlayer, commandArray);
			}
		}
	}
	

	private class SignInListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
			
			String userName = signInText.getText();
			char[] password = passwordText.getPassword();
			if(password.length > 0){
				sendObjects(userName,password, null, null);
			}else{
				Client.this.revalidate();
				Client.this.getContentPane().repaint();
			}
		}	
	}
	
	private  void sendObjects(String string, char[] array, Player player, String[] commands){
		try {
			oos.writeObject(string);
			oos.writeObject(array);
			oos.writeObject(player);
			oos.writeObject(commands);
			oos.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private boolean itemsIsNotOnMap(String lastWord) {
		boolean itIsAPlayer = false;
		ArrayList<Item> temp = Client.this.newPlayer.getPlayerMap().getItemsOnMap();
		System.out.println(temp.size());
		for(int i =0;i<temp.size();i++){
			System.out.println(lastWord);
			if(temp.get(i).getName().toLowerCase().contains(lastWord)){
				itIsAPlayer=false;
				System.out.println(itIsAPlayer);
				return itIsAPlayer;
			}
		}
		itIsAPlayer = true;
		return itIsAPlayer;
	}
}
