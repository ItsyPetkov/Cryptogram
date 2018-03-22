package gui.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.java.Game;
import main.java.Player;
import main.java.Players;

public class CryptogramGUI {

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JFrame introductionFrame;
	private JFrame authenticationFrame;
	private MouseListener mListener;
	private Players players;
	private Player player;
	private Game game;

	public CryptogramGUI() {

		introductionFrame = new JFrame("Cryptogram Game!");
		Container content = introductionFrame.getContentPane();

		label1 = new JLabel("Welcome to Cryptogram");
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setFont(new java.awt.Font("Arail", Font.PLAIN, 24));

		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.add(label1);
		content.add(panel, BorderLayout.NORTH);

		label2 = new JLabel(
				"Copyright  Hristo Petkov, Slav Ivanov and Kostadin Georgiev (CS207 2017/2018). All rights reserved");
		label2.setVerticalAlignment(JLabel.BOTTOM);
		label2.setFont(new java.awt.Font("Arail", Font.PLAIN, 10));

		JPanel panel1 = new JPanel(new GridLayout(1, 1));
		panel1.add(label2);
		content.add(panel1, BorderLayout.SOUTH);

		label3 = new JLabel("This is a game involving puzzle-solving and mind-training");
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setFont(new java.awt.Font("Arial", Font.PLAIN, 18));
		label4 = new JLabel("but most importantly about having fun!");
		label4.setFont(new java.awt.Font("Arial", Font.PLAIN, 18));
		label4.setHorizontalAlignment(JLabel.CENTER);
		label5 = new JLabel("To continue please press the 'Space' key");
		label5.setFont(new java.awt.Font("Arial", Font.ITALIC, 18));
		label5.setHorizontalAlignment(JLabel.CENTER);

		JPanel panel2 = new JPanel(new GridLayout(3, 1));
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(label5);
		content.add(panel2, BorderLayout.CENTER);

		introductionFrame.setSize(500, 300);
		introductionFrame.setLocationRelativeTo(null);
		introductionFrame.setVisible(true);
		introductionFrame.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
					introductionFrame.dispose();
					authentication();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

		});

		players = new Players();
	}

	private void authentication() {
		authenticationFrame = new JFrame("Authentication!");
		Container content = authenticationFrame.getContentPane();

		JLabel label = new JLabel("Authentication required in order to play!");
		label.setFont(new java.awt.Font("Arail", Font.PLAIN, 18));
		label.setHorizontalAlignment(JLabel.CENTER);
		JLabel label1 = new JLabel("Hmm! If haven't seen you around here, you must be new!");
		label1.setFont(new java.awt.Font("Arial", Font.PLAIN, 18));
		label1.setHorizontalAlignment(JLabel.CENTER);
		JLabel label2 = new JLabel("In order to continue further into the game you must either");
		label2.setFont(new java.awt.Font("Arail", Font.PLAIN, 18));
		label2.setHorizontalAlignment(JLabel.CENTER);
		JLabel label3 = new JLabel("create or load an account!");
		label3.setFont(new java.awt.Font("Arail", Font.PLAIN, 18));
		label3.setHorizontalAlignment(JLabel.CENTER);

		JPanel panel1 = new JPanel(new GridLayout(4, 1));
		panel1.add(label);
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(label3);
		content.add(panel1, BorderLayout.CENTER);

		JLabel label4 = new JLabel(
				"Copyright  Hristo Petkov, Slav Ivanov and Kostadin Georgiev (CS207 2017/2018). All rights reserved");
		label4.setVerticalAlignment(JLabel.NORTH);
		label4.setFont(new java.awt.Font("Arail", Font.PLAIN, 10));
		content.add(label4, BorderLayout.NORTH);

		JButton button = new JButton("Create Account");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getActionCommand() == "Create Account") {
					accountCreation();
				}
			}

		});

		JButton button1 = new JButton("Load Account");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logIn();
			}

		});

		JPanel panel2 = new JPanel(new GridLayout(1, 1));
		panel2.add(button);
		panel2.add(button1);
		content.add(panel2, BorderLayout.SOUTH);

		authenticationFrame.setSize(500, 300);
		authenticationFrame.setLocationRelativeTo(null);
		authenticationFrame.setVisible(true);
	}

	private void accountCreation() {
		JFrame frame = new JFrame("Account creation!");
		Container content = frame.getContentPane();

		JLabel label = new JLabel("Welcome to account creation!");
		label.setHorizontalAlignment(JLabel.CENTER);

		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.add(label, BorderLayout.NORTH);

		JLabel label1 = new JLabel("In order to create an account,");
		JLabel label2 = new JLabel("you must enter your account name ");
		JLabel label3 = new JLabel("in the text field below");

		TextField username = new TextField("Enter a username!");
		username.setForeground(Color.gray);
		username.setFont(new java.awt.Font("Arial", Font.ITALIC, 12));
		username.setEditable(true);
		username.addMouseListener(mListener = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				username.setText(" ");
				username.setFont(new JTextField().getFont());
				username.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});

		JPanel panel1 = new JPanel(new GridLayout(4, 1));
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(label3);
		panel1.add(username);
		content.add(panel1, BorderLayout.CENTER);

		JButton button = new JButton("Okay");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (username.getText().equals("Enter a username!") || username.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a valid username");
				} else {
					String name = username.getText();
					player = new Player(name.toString());
					players.addPlayer(player);
					JOptionPane.showMessageDialog(null, "Account created Successfuly!");
					frame.dispose();
				}

			}

		});

		JPanel panel2 = new JPanel(new GridLayout(1, 1));
		panel2.add(button);
		content.add(panel2, BorderLayout.SOUTH);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void logIn() {

		JFrame frame = new JFrame("Log In");
		Container content = frame.getContentPane();

		JLabel label = new JLabel("User log in!");
		label.setHorizontalAlignment(JLabel.CENTER);
		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.add(label);
		content.add(panel, BorderLayout.NORTH);

		JLabel label1 = new JLabel("Please select one of the following...");
		JComboBox<String> box = new JComboBox<String>();
		DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<String>();
		for(int i = 0; i < players.allPlayers.size() - 1; i++){
			boxModel.addElement(players.allPlayers.get(i).getName().toString());
		}
		box.setModel(boxModel);
		JPanel panel1 = new JPanel(new GridLayout(2, 1));
		panel1.add(label1);
		panel1.add(box);
		content.add(panel1, BorderLayout.CENTER);

		JButton button = new JButton("Load Player");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getActionCommand() == "Load Player") {
					if(box.getSelectedIndex() == -1){
						JOptionPane.showMessageDialog(null, "Please select a username with which to log in!");
					}else{
						JOptionPane.showMessageDialog(null, "Log in successful!");
						frame.dispose();
						authenticationFrame.dispose();
					}
				}
			}

		});
		
		JPanel panel2 = new JPanel(new GridLayout(1,1));
		panel2.add(button);
		content.add(panel2, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void splitStringIntoChar() {
		// !!!DO NOT ALTER!!!
		CryptogramFactory cf = new CryptogramFactory();
		cf.readPhrasesFromFile(cf.RNG());
		String temp = cf.toString();
		char[] characters = temp.toCharArray();
		System.out.println("Array is:" + Arrays.toString(characters));
	}

	public void gameFrame() {
		JFrame frame = new JFrame("Cryptogram Game!");
		Container content = frame.getContentPane();

		JLabel label = new JLabel("Cryptogram Game cs207(2017/2018)");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new java.awt.Font("Arial", Font.ITALIC, 24));

		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.add(label);
		content.add(panel, BorderLayout.NORTH);

		JButton button = new JButton("New Game");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getActionCommand() == "New Game") {
					// execute another method for new game
				}
			}

		});
		JButton button1 = new JButton("Load Game");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "Load Game") {
					// exectute another frame for load game
				}
			}

		});
		JButton button2 = new JButton("Credits");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "Credits") {
					credits();
				}
			}

		});
		JButton button3 = new JButton("Exit Game");
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "Exit Game") {
					exitingFrame();
				}
			}

		});

		JPanel panel1 = new JPanel(new GridLayout(4, 1));
		panel1.add(button);
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		content.add(panel1, BorderLayout.CENTER);

		JLabel label1 = new JLabel(
				"Copyright © Hristo Petkov, Slav Ivanov and Kostadin Georgiev (CS207 2017/2018). All rights reserved");
		label1.setVerticalAlignment(JLabel.BOTTOM);

		JPanel panel2 = new JPanel(new GridLayout(1, 1));
		panel2.add(label1);
		content.add(panel2, BorderLayout.SOUTH);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void credits() {
		JFrame frame = new JFrame("Credits");
		Container contents = frame.getContentPane();

		JLabel label = new JLabel("Cryptogram Game - Credits");
		label.setVerticalAlignment(JLabel.TOP);
		label.setFont(new java.awt.Font("Arial", Font.ITALIC, 18));

		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.add(label);
		contents.add(panel, BorderLayout.NORTH);

		JLabel label1 = new JLabel("Development team consists of 3 people");
		label1.setHorizontalAlignment(JLabel.CENTER);
		JLabel label2 = new JLabel(" ");
		JLabel label3 = new JLabel("Game Developers:");
		label3.setHorizontalAlignment(JLabel.CENTER);
		JLabel label4 = new JLabel("Kostadin Georgiev");
		label4.setHorizontalAlignment(JLabel.CENTER);
		JLabel label5 = new JLabel("Hristo Petkov");
		label5.setHorizontalAlignment(JLabel.CENTER);
		JLabel label6 = new JLabel("Slav Ivanov");
		label6.setHorizontalAlignment(JLabel.CENTER);
		JLabel label7 = new JLabel(" ");
		JLabel label8 = new JLabel("Game Testers");
		label8.setHorizontalAlignment(JLabel.CENTER);
		JLabel label9 = new JLabel("Kostadin Georgiev");
		label9.setHorizontalAlignment(JLabel.CENTER);
		JLabel label10 = new JLabel("Slav Ivanov");
		label10.setHorizontalAlignment(JLabel.CENTER);
		JLabel label11 = new JLabel(" ");
		JLabel label12 = new JLabel("GUI Develper");
		label12.setHorizontalAlignment(JLabel.CENTER);
		JLabel label13 = new JLabel("Hristo Petkov");
		label13.setHorizontalAlignment(JLabel.CENTER);
		JLabel label14 = new JLabel(" ");

		JPanel panel1 = new JPanel(new GridLayout(14, 1));
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(label3);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		panel1.add(label7);
		panel1.add(label8);
		panel1.add(label9);
		panel1.add(label10);
		panel1.add(label11);
		panel1.add(label12);
		panel1.add(label13);
		panel1.add(label14);
		contents.add(panel1, BorderLayout.WEST);

		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getActionCommand() == "Back") {
					frame.dispose();
				}
			}

		});

		JPanel panel2 = new JPanel(new GridLayout(1, 1));
		panel2.add(button);
		contents.add(panel2, BorderLayout.SOUTH);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void exitingFrame() {
		JFrame frame = new JFrame("Exit game");
		Container content = frame.getContentPane();

		JLabel label = new JLabel("Are you sure you want to exit?");
		label.setHorizontalAlignment(JLabel.CENTER);

		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.add(label);
		content.add(panel, BorderLayout.CENTER);

		JButton button = new JButton("Yes");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getActionCommand() == "Yes") {
					System.exit(0);
				}
			}
		});
		JButton button1 = new JButton("No");
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "No"){
					frame.dispose();
				}
			}
		});
		
		JPanel panel1 = new JPanel(new GridLayout(1,1));
		panel1.add(button);
		panel1.add(button1);
		content.add(panel1, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
