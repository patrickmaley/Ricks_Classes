package view;

import java.awt.BorderLayout;
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
import javax.swing.RootPaneContainer;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import model.map.Map;
import model.player.Player;

//TODO: 1: Add scrollpane to the gameTextArea
//		2: Set font for player text area

public class Client extends JFrame{
	private static final String ADDRESS = "localhost";
	private final Dimension STATUS_PANEL_DIMENSION = new Dimension(200, 550);
	
	private JPanel textPanel = new JPanel();
	private JPanel playerInputPanel = new JPanel();
	private JTextArea gameTextArea = new JTextArea();
	private JTextArea playerStatsTextArea = new JTextArea();
	private JTextField playerTextArea = new JTextField();
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Map playerMap = null;
	
	private JTextField signInText = new JTextField();
	private JTextArea signInInstructions = new JTextArea();
	private JPasswordField passwordText = new JPasswordField();
	private JButton signInButton = new JButton("Sign In");
	private JButton signOutButton = new JButton("Sign Out");
	private JTextField titleText = new JTextField("Game Title");
	private JPanel signInPanel = new JPanel(new FlowLayout());
	
	private String dragonTitle = "\t\tDragon\n";
	private Player newPlayer = new Player(dragonTitle, null, dragonTitle, dragonTitle);
	public static void main(String[] args) {
		new Client().setVisible(true);
		
	}
	
	public Client(){
		
		this.openConnection();
		frameProperties();
		new ServerListener().start();
//		try {
//			oos.writeObject(nPO);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	private void frameProperties() {
		setTitle("24 Jump Street: Hogwarts");
		setLayout(new FlowLayout());
		//setPreferredSize(new Dimension(450, 110));
		setSize(800, 600);
		setLocation(0,0);
		
		
		//setResizable(false);
		getContentPane().setBackground(new Color(8, 2, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Adds all the components to the JFrame -PM
		addComponents();
		
	}
	

	
	private void addComponents() {
		Font displayFont = new Font("AngsanaUPC", 1, 14);
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
        signInPanel.add(this.signOutButton);
        signInPanel.setBackground(new Color(179, 194, 191));
        signInInstructions.setText("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        signInInstructions.setPreferredSize(new Dimension(150, 400));
        signInInstructions.setWrapStyleWord(true);
        this.signInInstructions.setEditable(false);
		this.signInInstructions.setLineWrap(true);
        signInPanel.add(signInInstructions);
        add(signInPanel);
		        
        
        //Set title of the Player
  		Font titleFont = new Font("Bodoni MT Black", 1, 30);
  		titleText.setSize(100, 100);
  		titleText.setFont(titleFont);
  		titleText.setBackground(new Color(192, 223, 217));
  		titleText.setEditable(false);
  		textPanel.add(titleText);
      		
		this.textPanel.setPreferredSize(new Dimension(550,550));
		this.textPanel.setBackground(new Color(192, 142, 45));
		this.textPanel.setLayout(new FlowLayout());
		//this.gameTextArea.setPreferredSize(new Dimension(450,450));
		this.gameTextArea.setEditable(false);
		this.gameTextArea.setLineWrap(true);
		this.gameTextArea.setWrapStyleWord(true);
		this.gameTextArea.setText(this.dragonTitle);
		
		JScrollPane gameTextPane = new JScrollPane(this.gameTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		gameTextPane.setPreferredSize(new Dimension(450, 400));
		
		this.textPanel.add(gameTextPane);
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Player Commands");
		playerTextArea.setBorder(title);
		
		//this.playerInputPanel.setPreferredSize(new Dimension(600, 50));
		//this.playerInputPanel.setBackground(new Color(0, 0, 0));
		this.playerTextArea.setPreferredSize(new Dimension(450,50));
		
		//this.playerInputPanel.add(playerTextArea);
		this.textPanel.add(playerTextArea);
		
		this.playerStatsTextArea.setEditable(false);
		this.playerStatsTextArea.setLineWrap(true);
		this.playerStatsTextArea.setWrapStyleWord(true);
		playerStatsTextArea.setPreferredSize(new Dimension(450, 35));
		
		this.textPanel.add(playerStatsTextArea);
		
		this.add(textPanel);
		this.playerTextArea.addActionListener(new textBoxListener());
		this.setVisible(true);
	}
	
	private void openConnection() {
		/* Our server is on our computer, but make sure to use the same port. */
		try {
			// TODO 6: Connect to the Server
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
			// TODO 9: Repeatedly accept String objects from the server and add
			// them to our model.
			try {
				/* The server sent us a String? Stick it in the JList! */
				while (true){
					Client.this.playerMap =  (Map) ois.readObject();
					//NetpaintGUI.this.drawingPanel.repaint();
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
			
			String descriptions = Client.this.newPlayer.performAction(playerTextArea.getText());
			if(descriptions != null){
				Client.this.gameTextArea.append(descriptions + "\n");
			}else{
				Client.this.gameTextArea.append("Nothing much happens\n");
			}
			
			//Auto updates the scrollpane to the last description
			gameTextArea.setCaretPosition(gameTextArea.getDocument().getLength());
			
			//Resets descriptions value
			descriptions = null;
			
			playerTextArea.setText("");
		}
	}
}
