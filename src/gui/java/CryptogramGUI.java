package gui.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import main.java.Cryptogram;
import main.java.CryptogramFactory;
import main.java.Game;
import main.java.LetterCryptogram;
import main.java.Player;
import main.java.Players;

public class CryptogramGUI {

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JFrame introductionFrame;
	private JFrame cryptogramGameFrame;
	private JFrame authenticationFrame;
	JComboBox<String> box;
	DefaultComboBoxModel<String> boxModel;
	private MouseListener mListener;
	private Players players;
	private Player player;
	private Game game;
	private CryptogramFactory cf;
	private Cryptogram cryptogram;

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
		box = new JComboBox<String>();
		boxModel = new DefaultComboBoxModel<String>();
		for(int i = 0; i < players.allPlayers.size(); i++){
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
						gameFrame();
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
					cryptogramChoiceFrame();
				}
			}

		});
		JButton button1 = new JButton("Load Game");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "Load Game") {
					loadGameFrame();
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
				"Copyright В© Hristo Petkov, Slav Ivanov and Kostadin Georgiev (CS207 2017/2018). All rights reserved");
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
	
	private void cryptogramChoiceFrame(){
		JFrame frame = new JFrame("Choose Wisely!");
		Container content = frame.getContentPane();
		
		JLabel label = new JLabel("Please select what type of cryptogram you want?");
		label.setVerticalAlignment(JLabel.BOTTOM);
		JPanel panel = new JPanel(new GridLayout(1,1));
		panel.add(label);
		content.add(panel, BorderLayout.NORTH);
		
		JRadioButton letterCryptogramButton = new JRadioButton("Letter Cryptogram");
		JRadioButton numberCryptogramButton = new JRadioButton("Number Cryptogram");
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(letterCryptogramButton);
		bGroup.add(numberCryptogramButton);
		
		if(letterCryptogramButton.isSelected()){
			//Generate LetterCryptogram
			cf = new CryptogramFactory();
			cryptogram = cf.makeCryptogram("letter");
		}
		else{
			//Generate NumberCryptogram
			cf = new CryptogramFactory();
			cryptogram = cf.makeCryptogram("number");
		}
		
		JPanel panel1 = new JPanel(new GridLayout(1,1));
		panel1.add(letterCryptogramButton);
		panel1.add(numberCryptogramButton);
		content.add(panel1, BorderLayout.CENTER);
		
		JButton button3 = new JButton("Okay");
		button3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand() == "Okay"){
					JOptionPane.showMessageDialog(null, "Generating Cryptogram");
					frame.dispose();
					cryptogramFrame();
				}
			}
			
		});
		
		JPanel panel2 = new JPanel(new GridLayout(1,1));
		panel2.add(button3);
		content.add(panel2, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void loadGameFrame(){
		JFrame frame = new JFrame("Load Game");
		Container content = frame.getContentPane();
		
		JLabel label = new JLabel("Please select the game you want to load!");
		label.setHorizontalAlignment(JLabel.CENTER);
		
		JComboBox<String> box = new JComboBox<String>();
		
		JPanel panel = new JPanel(new GridLayout(2,1));
		panel.add(label);
		panel.add(box);
		content.add(panel, BorderLayout.CENTER);
		
		JButton button = new JButton("Load Cryptogram");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand() == "Load Cryptogram"){
					JOptionPane.showMessageDialog(null, "Loading Cryptogram");
					frame.dispose();
					//Call the frame in which the game itself is going to be
				}
				
			}
			
		});
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void cryptogramFrame(){
		cryptogramGameFrame = new JFrame("CryptogramCS207");
		Container content = cryptogramGameFrame.getContentPane();
		JButton button1 = new JButton("View Frequencies");
		JButton button2 = new JButton("Get a Hint");
		JButton button3 = new JButton("Save Game");
		JButton button4 = new JButton("Help!");
		button4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "Help!"){
					helpingFrame();
				}
				
			}
			
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(-2));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		
		JButton button5 = new JButton("Undo letter");
		JButton button6 = new JButton("Check Cryptogram");
		JButton button7 = new JButton("Reset Cryptogram");
		JButton button8 = new JButton("Exit Game");
		button8.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand() == "Exit Game"){
					saveAndExitFrame();
				}
				
			}
			
		});
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(2));
		panel1.add(button5);
		panel1.add(button6);
		panel1.add(button7);
		panel1.add(button8);
		
		//ArrayList<JTextField> fields = new ArrayList<JTextField>();
		JPanel phrase = new JPanel();
		JPanel panel2 = new JPanel(new GridBagLayout());
		GridBagConstraints alignmentY = new GridBagConstraints();
		alignmentY.gridy = 0;
		char[] encryptedPhrase = cryptogram.getEncryptedPhrase().toCharArray();
		for (char ch : encryptedPhrase) {
			JPanel word = new JPanel();
			word.setBorder(BorderFactory.createLineBorder(Color.black));
			if (Character.isLetter(ch) || Character.isDigit(ch)){
				JPanel letter = new JPanel();
				JTextField field = new JTextField();
				field.setPreferredSize(new Dimension(30,30));
				word.add(field);
				
				if (cryptogram instanceof LetterCryptogram) {
					word.add(new JLabel(String.valueOf((char) ch)));
				} else {
					word.add(new JLabel(String.valueOf(ch)));
				}
				word.add(letter);
			}
			else{
				JPanel symbol = new JPanel();
				JLabel label = new JLabel(String.valueOf(ch));
				symbol.add(label);
				word.add(symbol);
			}
			phrase.add(word);
		}
		
		
		
		content.add(panel, BorderLayout.NORTH);
		content.add(panel1, BorderLayout.SOUTH);
		content.add(phrase, BorderLayout.CENTER);
		
		cryptogramGameFrame.pack();
		cryptogramGameFrame.setSize(800, 600);
		cryptogramGameFrame.setLocationRelativeTo(null);
		cryptogramGameFrame.setVisible(true);
	}
	
	private void saveAndExitFrame(){
		JFrame frame = new JFrame("Save and Exit game");
		Container content = frame.getContentPane();
		
		JLabel label = new JLabel("Are you sure you wnat to leave?");
		JLabel label1 = new JLabel("If you leave now woudl you like to save your game progress?");
		JLabel label2 = new JLabel("If you don't save your game all your progress will be lost!");
		
		JPanel panel = new JPanel(new GridLayout(3,1));
		panel.add(label);
		panel.add(label1);
		panel.add(label2);
		content.add(panel, BorderLayout.CENTER);
		
		JButton button = new JButton("Yes, save it");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "Yes, save it"){
					//save game
					frame.dispose();
					cryptogramGameFrame.dispose();
					gameFrame();
				}
				
			}
			
		});
		JButton button1 = new JButton("No, don't save it");
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "No, don't save it"){
					frame.dispose();
					cryptogramGameFrame.dispose();
					gameFrame();
				}
				
			}
			
		});
		JButton button2 = new JButton("Cancel");
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "Cancel"){
					frame.dispose();
				}
				
			}
			
		});
		
		JPanel panel1 = new JPanel(new GridLayout(3,1));
		panel1.add(button);
		panel1.add(button1);
		panel1.add(button2);
		content.add(panel1, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void helpingFrame(){
		JFrame frame = new JFrame("Helping Frame");
		Container content = frame.getContentPane();
		
		JLabel label = new JLabel("Instructions");
		label.setFont(new java.awt.Font("Arial", Font.ITALIC, 18));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel panel = new JPanel(new GridLayout(1,1));
		panel.add(label);
		content.add(panel, BorderLayout.NORTH);
		
		JLabel label1 = new JLabel("Step by step instruction on how to play the game.");
		JLabel label2 = new JLabel("1. The aim of the puzzle is to identify the original message.");
		JLabel label3 = new JLabel("2. Looking for short words such as 1 letter words, which are ‘I’ or ‘A’ as these are the only two 1 letter words in English.");
		JLabel label4 = new JLabel("3. Players can also use the frequency each enciphered letter appears in the puzzle");
		JLabel label5 = new JLabel("4. There may also be common groups of letters such as ‘TH’ or ‘ION’ which may be repeated in the message.");
		JLabel label6 = new JLabel(" ");
		JLabel label7 = new JLabel("The ultimate goal of the game is to test the way you think and your knowledges of phrases, ");
		JLabel label8 = new JLabel("but most importantly the game is supposed to make you have a good time and alot of fun.");
		
		JPanel panel2 = new JPanel(new GridLayout(8,1));
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(label6);
		panel2.add(label7);
		panel2.add(label8);
		content.add(panel2, BorderLayout.CENTER);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand() == "Back"){
					frame.dispose();
				}
				
			}
			
		});
		
		JPanel panel3 = new JPanel(new GridLayout(1,1));
		panel3.add(button);
		content.add(panel3, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}