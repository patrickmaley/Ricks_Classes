package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.map.Map;

//TODO: 1: Add scrollpane to the gameTextArea
//		2: Set font for player text area

public class Client extends JFrame{
	private static final String ADDRESS = "localhost";
	
	private JPanel textPanel = new JPanel();
	private JPanel playerInputPanel = new JPanel();
	private JTextArea gameTextArea = new JTextArea();
	private JTextArea playerTextArea = new JTextArea();
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Map playerMap = null;
	
	private String dragonTitle = "11111111111111111111111111111111111111001111111111111111111111111\n"+
            "11111111111111111111111111111111111100011111111111111111111111111\n"+
            "11111111111111111111111111111111100001111111111111111111111111111\n"+
            "11111111111111111111111111111110000111111111111111111111111111111\n"+
            "11111111111111111111111111111000000111111111111111111111111111111\n"+
            "11111111111111111111111111100000011110001100000000000000011111111\n"+
            "11111111111111111100000000000000000000000000000000011111111111111\n"+
            "11111111111111110111000000000000000000000000000011111111111111111\n"+
            "11111111111111111111111000000000000000000000000000000000111111111\n"+
            "11111111111111111110000000000000000000000000000000111111111111111\n"+
            "11111111111111111100011100000000000000000000000000000111111111111\n"+
            "11111111111111100000110000000000011000000000000000000011111111111\n"+
            "11111111111111000000000000000100111100000000000001100000111111111\n"+
            "11111111110000000000000000001110111110000000000000111000011111111\n"+
            "11111111000000000000000000011111111100000000000000011110001111111\n"+
            "11111110000000011111111111111111111100000000000000001111100111111\n"+
            "11111111000001111111111111111111110000000000000000001111111111111\n"+
            "11111111110111111111111111111100000000000000000000000111111111111\n"+
            "11111111111111110000000000000000000000000000000000000111111111111\n"+
            "11111111111111111100000000000000000000000000001100000111111111111\n"+
            "11111111111111000000000000000000000000000000111100000111111111111\n"+
            "11111111111000000000000000000000000000000001111110000111111111111\n"+
            "11111111100000000000000000000000000000001111111110000111111111111\n"+
            "11111110000000000000000000000000000000111111111110000111111111111\n"+
            "11111100000000000000000001110000001111111111111110001111111111111\n"+
            "11111000000000000000011111111111111111111111111110011111111111111\n"+
            "11110000000000000001111111111111111100111111111111111111111111111\n"+
            "11100000000000000011111111111111111111100001111111111111111111111\n"+
            "11100000000001000111111111111111111111111000001111111111111111111\n"+
            "11000000000001100111111111111111111111111110000000111111111111111\n"+
            "11000000000000111011111111111100011111000011100000001111111111111\n"+
            "11000000000000011111111111111111000111110000000000000011111111111\n"+
            "11000000000000000011111111111111000000000000000000000000111111111\n"+
            "11001000000000000000001111111110000000000000000000000000001111111\n"+
            "11100110000000000001111111110000000000000000111000000000000111111\n"+
            "11110110000000000000000000000000000000000111111111110000000011111\n"+
            "11111110000000000000000000000000000000001111111111111100000001111\n"+
            "11111110000010000000000000000001100000000111011111111110000001111\n"+
            "11111111000111110000000000000111110000000000111111111110110000111\n"+
            "11111110001111111100010000000001111100000111111111111111110000111\n"+
            "11111110001111111111111110000000111111100000000111111111111000111\n"+
            "11111111001111111111111111111000000111111111111111111111111100011\n"+
            "11111111101111111111111111111110000111111111111111111111111001111\n"+
            "11111111111111111111111111111110001111111111111111111111100111111\n"+
            "11111111111111111111111111111111001111111111111111111111001111111\n"+
            "11111111111111111111111111111111100111111111111111111111111111111\n"+
            "11111111111111111111111111111111110111111111111111111111111111111\n";
	
	public static void main(String[] args) {
		new Client().setVisible(true);
		
	}
	
	public Client(){
		frameProperties();
		this.openConnection();
		
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
		setSize(1000, 900);
		setLocation(0,0);
		
		
		//setResizable(false);
		getContentPane().setBackground(new Color(8, 2, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Adds all the components to the JFrame -PM
		addComponents();
		
	}
	
	private void addComponents() {
		this.textPanel.setPreferredSize(new Dimension(500,800));
		this.textPanel.setBackground(new Color(192, 142, 45));
		this.gameTextArea.setPreferredSize(new Dimension(475,780));
		this.gameTextArea.setEditable(false);
		this.gameTextArea.setText(this.dragonTitle);
		JScrollPane gameTextPane = new JScrollPane();
		textPanel.add(gameTextArea);
		this.add(textPanel);
		
		this.playerInputPanel.setPreferredSize(new Dimension(600, 50));
		this.playerInputPanel.setBackground(new Color(0, 0, 0));
		this.playerTextArea.setPreferredSize(new Dimension(600,50));
		this.playerInputPanel.add(playerTextArea);
		this.add(playerInputPanel);
	
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

}
