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
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

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

import model.map.Map;
import model.player.Player;


public class Client extends JFrame{
	private static final String ADDRESS = "localhost";
	private final Dimension STATUS_PANEL_DIMENSION = new Dimension(200, 575);
	private final String GAME_COMMANDS = "After logging in please enter your name and house for new characters. \n\nCommand List:\n"
			+ "Look\n"
			+ "Take\n"
			+ "Up\n"
			+ "Down\n"
			+ "North\n"
			+ "South\n"
			+ "East\n"
			+ "West\n"
			+ "Use\n"
			+ "Quit\n";
	private final String TEXT_BREAK ="------------------------------------------------------------------------------------------------------------\n";
	
	private JPanel textPanel = new JPanel();
	//private JPanel playerInputPanel = new JPanel();
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
	
	private Map playerMap = null;
	
	private JPasswordField passwordText = new JPasswordField();
	private JButton signInButton = new JButton("Sign In");
	//private JButton signOutButton = new JButton("Sign Out");
	
	//private String dragonTitle = "\t\tDragon\n";
	private Player newPlayer = null;
	
	public static void main(String[] args) {
		new Client().setVisible(true);
	}
	
	public Client(){
		openConnection();
		frameProperties();
		new ServerListener().start();
	}
	
	private void frameProperties() {
		setTitle("9 3/4 Jump Street: Hogwarts");
		setLayout(new FlowLayout());
		//setPreferredSize(new Dimension(450, 110));
		setSize(800, 650);
		setLocation(0,0);
		
		//setResizable(false);
		getContentPane().setBackground(new Color(8, 2, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Adds all the components to the JFrame
		addComponents();
	}
	

	
	private void addComponents() {
		Font displayFont = new Font("AngsanaUPC", 1, 14);
		
		//Sets up the sign In Panel where the user inputs information
		JLabel userNameLabel = new JLabel("User Name");
		JLabel passwordLabel = new JLabel("Password  ");
		JLabel gameNameLabel = new JLabel("Game Name");
		JLabel gameHouseLabel = new JLabel("House Name");
		userNameLabel.setForeground(new Color(59, 58, 54));
		userNameLabel.setLabelFor(signInText);
		userNameLabel.setFont(displayFont);
		passwordLabel.setForeground(new Color(59, 58, 54));
		passwordLabel.setLabelFor(passwordText);
		passwordLabel.setFont(displayFont);	
		gameNameLabel.setForeground(new Color(59, 58, 54));
		gameNameLabel.setLabelFor(gameNameText);
		gameNameLabel.setFont(displayFont);	
		gameHouseLabel.setForeground(new Color(59, 58, 54));
		gameHouseLabel.setLabelFor(gameHouseText);
		gameHouseLabel.setFont(displayFont);	
		
		signInPanel.setPreferredSize(STATUS_PANEL_DIMENSION);
		signInPanel.add(userNameLabel);
		signInText.setPreferredSize(new Dimension(100, 25));
		signInPanel.add(signInText);
		signInPanel.add(passwordLabel);
		passwordText.setPreferredSize(new Dimension(100, 25));
        signInPanel.add(passwordText);
        signInPanel.add(this.signInButton);
       // signInPanel.add(this.signOutButton);
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
        signInPanel.add(gameNameLabel);
        signInPanel.add(gameNameText);
        gameHouseText.setPreferredSize(new Dimension(100, 25));
        gameHouseText.setEditable(false);
        signInPanel.add(gameHouseLabel);
        signInPanel.add(gameHouseText);
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
		playerTextArea.setEditable(false);
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
		signInButton.addActionListener(new SignInListener());
		//signOutButton.addActionListener(new SignOutListener());
		gameNameText.addActionListener(new gameNameTextListener());
		gameHouseText.addActionListener(new gameHouseTextListener());
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
					if(Client.this.newPlayer == null){
						Client.this.newPlayer =  player;
						Client.this.gameTextArea.append("You wake up after taking a nap outside of Hogwarts." + "\n");
						Client.this.gameTextArea.append(TEXT_BREAK);
					}
					if(player.getGameName() != null && Client.this.newPlayer.getGameName() != null && player.getGameName().compareTo(Client.this.newPlayer.getGameName())== 0)
						Client.this.newPlayer =  player;
					Client.this.playerMap =  (Map)ois.readObject();
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
			String descriptions = null;
			if(command.compareTo("quit")== 0){
				cleanUpAndQuit("Do you really want to quit?");
			}else{
			    descriptions = Client.this.newPlayer.performAction(command);
				if(descriptions != null){
					Client.this.gameTextArea.append(descriptions + "\n");
					Client.this.gameTextArea.append(TEXT_BREAK);
				}else{
					Client.this.gameTextArea.append("Nothing much happens\n");
					Client.this.gameTextArea.append(TEXT_BREAK);
				}
			}
			//Auto updates the scrollpane to the last description
			gameTextArea.setCaretPosition(gameTextArea.getDocument().getLength());
			
			//Resets descriptions value
			descriptions = null;
			
			playerTextArea.setText("");
			
			try {
				oos.writeObject(Client.this.newPlayer);
				oos.writeObject(playerMap);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private class gameNameTextListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String gameName = gameNameText.getText();
			Client.this.newPlayer.setGameName(gameName);
			gameNameText.setEditable(false);
			playerTextArea.setEditable(true);
		}
	}
	
	private class gameHouseTextListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String gameHouse = gameHouseText.getText();
			Client.this.newPlayer.setHouse(gameHouse);
			gameHouseText.setEditable(false);
		}
	}
	
	private class SignInListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String userName = signInText.getText();
			char[] password = passwordText.getPassword();
			Player player = null;
			
			try {
				 player = new Player(userName, password);
			} catch (NoSuchAlgorithmException | NoSuchProviderException e1) {
				e1.printStackTrace();
			}
			try {
				oos.writeObject(player);
				oos.writeObject(playerMap);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			gameNameText.setEditable(true);
			gameHouseText.setEditable(true);
		}	
	}
}
