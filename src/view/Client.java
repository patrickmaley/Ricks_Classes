package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
import model.map.Map;
import model.player.Player;
import model.room.GenericRoom;


public class Client extends JFrame{
	private static final String ADDRESS = "localhost";
	private final Dimension STATUS_PANEL_DIMENSION = new Dimension(200, 575);
	private final String GAME_COMMANDS = "After logging in please enter your name and house for new characters. \n\n           Command List\n"
			+ "    Movement: \nNorth, South, East, West\n"
			+ "    Interactions:\n"
			+ "Look: Look or Look <arg>\n"
			+ "Take: Take <item>\n"
			+ "Drop <item>"
			+ "Up\n"
			+ "Down\n"
			+ "Use <item>\n"
			+ "Quit\n"
			+ "    Chat Commands:\n "
			+ "say <message>\n"
			+ "tell <player name><message>\n"
			+ "ooc <message>"
			+ "	   Miscellaneous:\n"
			+ "who\n"
			+ "score\n"
			+ "inventory\n"
			+ "";
	private final String TEXT_BREAK ="------------------------------------------------------------------------------------------------------------\n";
	
	private JPanel textPanel = new JPanel();
	private JPanel signInPanel = new JPanel(new FlowLayout());
	
	private JTextArea signInInstructions = new JTextArea();
	private JTextArea gameTextArea = new JTextArea();
	private JTextArea playerStatsTextArea = new JTextArea();

	private JTextField playerTextArea = new JTextField();
	private JTextField signInText = new JTextField();
	private JTextField gameNameText = new JTextField();
	private JTextField gameHouseText = new JTextField();
	private JTextField titleText = new JTextField("9 3/4 Jump Street: Hogwarts");
	
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	
	private JPasswordField passwordText = new JPasswordField();
	private JButton signInButton = new JButton("Sign In");
	Font displayFont = new Font("AngsanaUPC", 1, 14);
	private Player newPlayer = null;
	
	public static void main(String[] args) {
		new Client().setVisible(true);
		
	}
	
	public Client(){
		openConnection();
		setTitle("9 3/4 Jump Street: Hogwarts");
		setLayout(new FlowLayout());
		//setPreferredSize(new Dimension(450, 110));
		setSize(800, 650);
		setLocation(0,0);
		
		//setResizable(false);
		getContentPane().setBackground(new Color(8, 2, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signInFrame();
		
		new ServerListener().start();
	}
	
	private void signInFrame() {
		setLayout(new FlowLayout());
		//setPreferredSize(new Dimension(450, 110));
		setSize(800, 650);
		setLocation(0,0);
		//Sets up the sign In Panel where the user inputs information
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

	private void frameProperties() {
		addComponents();
	}
	
	private void addComponents() {
		JLabel gameNameLabel = new JLabel("Game Name");
		JLabel gameHouseLabel = new JLabel("House Name");
		gameNameLabel.setForeground(new Color(59, 58, 54));
		gameNameLabel.setLabelFor(gameNameText);
		gameNameLabel.setFont(displayFont);	
		gameHouseLabel.setForeground(new Color(59, 58, 54));
		gameHouseLabel.setLabelFor(gameHouseText);
		gameHouseLabel.setFont(displayFont);	
		signInPanel.removeAll();
		signInPanel.setBackground(new Color(192, 142, 45));
        signInInstructions.setText(GAME_COMMANDS);
        signInInstructions.setPreferredSize(new Dimension(175, 400));
        signInInstructions.setBackground(new Color(192, 142, 45));
        signInInstructions.setWrapStyleWord(true);
        signInInstructions.setEditable(false);
		signInInstructions.setLineWrap(true);
        signInPanel.add(signInInstructions);
        gameNameText.setPreferredSize(new Dimension(100, 25));
        gameNameText.setEditable(false);
        add(signInPanel);
		
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
					}
					
					//If the client is new, then this loads up the first player
					if(player != null && Client.this.newPlayer == null){
						//Changes the sign in gui to the game gui
						Client.this.getContentPane().removeAll();
						Client.this.frameProperties();
						Client.this.revalidate();
						Client.this.getContentPane().repaint();
						
						Client.this.newPlayer = player;
						Client.this.gameTextArea.append("You wake up after taking a nap outside of Hogwarts." + "\n");
						Client.this.gameTextArea.append(TEXT_BREAK);
					}
					
					//Sets the player to the updated version
					if(player != null && player.getUsername().compareTo(Client.this.newPlayer.getUsername()) ==0){
						Client.this.newPlayer = player;
					}else{
						Client.this.newPlayer.setPlayerMap(player.getPlayerMap());
						
					}

					
					if(hello.compareTo("") != 0){
						if(hello.contains("Global Chat:")){
							Client.this.gameTextArea.append(hello);
						}else if(hello.contains("Tell:")){
							String[] username = hello.split("\\s+");
							if(hello.contains(Client.this.newPlayer.getUsername())){
								Client.this.gameTextArea.append(hello);
							}
//						}else if(player.getRoom().getRoomDescription().compareTo(Client.this.newPlayer.getRoom().getRoomDescription())==0){
//							Client.this.gameTextArea.append(hello);
						}else{
							if(player != null && player.getUsername().compareTo(Client.this.newPlayer.getUsername()) ==0){
									Client.this.gameTextArea.append(hello + "\n");
									Client.this.gameTextArea.append(TEXT_BREAK);
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
					
					//Resets descriptions value
					playerTextArea.setText("");
					
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
				try {
					oos.writeObject("");
					oos.writeObject(new char[0]);
					oos.writeObject(Client.this.newPlayer);
					oos.writeObject(firstWord);
					oos.reset();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				cleanUpAndQuit("Do you really want to quit?");
				
			}else if(firstWord[0].compareTo("shutdown")==0 ||
					firstWord[0].compareTo("say")==0 ||
					firstWord[0].compareTo("ooc")==0 ||
					firstWord[0].compareTo("tell")==0 ||
					firstWord[0].compareTo("who")==0 ||
					firstWord[0].compareTo("give")==0 ||
					firstWord[0].compareTo("take")==0 && itemsIsNotOnMap(firstWord[firstWord.length-1])){
				String[] commandArray = command.split("\\s+");
				
				if(firstWord[0].compareTo("who") == 0 ||commandArray.length  > 1){
					try {
						oos.writeObject("");
						oos.writeObject(new char[0]);
						oos.writeObject(Client.this.newPlayer);
						oos.writeObject(commandArray);
						oos.reset();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}else{
				String commandInstruction = "command " + command;
				String[] commandArray = commandInstruction.split("\\s+");
				try {
					oos.writeObject("");
					oos.writeObject(new char[0]);
					oos.writeObject(Client.this.newPlayer);
					oos.writeObject(commandArray);
					oos.reset();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			
		}
	}
	
	private class SignInListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String userName = signInText.getText();
			char[] password = passwordText.getPassword();

			try {
				oos.writeObject(userName);
				oos.writeObject(password);
				oos.writeObject(null);
				oos.writeObject(null);
				oos.reset();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
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