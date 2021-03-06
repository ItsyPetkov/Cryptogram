package gui.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

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
				"Created by Hristo Petkov, Slav Ivanov and Kostadin Georgiev (CS207 2017/2018).");
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
		game = new Game();
		
	}

	private void authentication() {
		authenticationFrame = new JFrame("Authentication!");
		Container content = authenticationFrame.getContentPane();

		JLabel label = new JLabel("Authentication required in order to play!");
		label.setFont(new java.awt.Font("Arail", Font.PLAIN, 18));
		label.setHorizontalAlignment(JLabel.CENTER);
		JLabel label1 = new JLabel("Hmm! I haven't seen you around here, you must be new!");
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
				"Created by Hristo Petkov, Slav Ivanov and Kostadin Georgiev (CS207 2017/2018).");
		label4.setVerticalAlignment(JLabel.NORTH);
		label4.setFont(new java.awt.Font("Arail", Font.PLAIN, 10));
		content.add(label4, BorderLayout.NORTH);

		JButton button = new JButton("Create Account");
		button.setToolTipText("Create a new account, with all values set to 0.");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getActionCommand() == "Create Account") {
					accountCreation();
				}
			}

		});

		JButton button1 = new JButton("Load Account");
		button1.setToolTipText("Input the name of an existing account to load into it.");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				filePlayerLoad();
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
	
	
	private void filePlayerLoad(){
		JFrame frame = new JFrame();
		Container content = frame.getContentPane();
		
		JLabel label = new JLabel("Please enter a name");
		TextField field = new TextField("Enter a name!");
		field.setForeground(Color.gray);
		field.setFont(new java.awt.Font("Arial", Font.ITALIC, 12));
		field.setEditable(true);
		field.addMouseListener(mListener = new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				field.setText(" ");
				field.setFont(new JTextField().getFont());
				field.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		JPanel panel = new JPanel(new GridLayout(2,1));
		panel.add(label);
		panel.add(field);
		content.add(panel, BorderLayout.CENTER);
		
		JButton button = new JButton("Find & Load");
		button.setToolTipText("Finds file in directory and loads data saved.");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand() == "Find & Load"){
					try{
						if(field.getText().isEmpty() || field.getText().equals("Enter a name!")){
							JOptionPane.showMessageDialog(null, "Please enter an account to load!");
						}else{
							frame.dispose();
							player = game.addSavedPlayerToArrayList(field.getText().toString());
							players.addPlayer(player);
							gameFrame();
						}
					} catch(NullPointerException e){
						JOptionPane.showMessageDialog(null, "No such name!");
					}
					
				}
				
			}
			
		});
		
		JPanel panel1 = new JPanel(new GridLayout(1,1));
		panel1.add(button);
		content.add(panel1, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
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
				if (username.getText().equals("Enter a username!")) {
					JOptionPane.showMessageDialog(null, "Please enter a valid username");
				} 
				else if(username.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter a valid username");
				}
				else {
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
		button.setToolTipText("Creates a new frame which is the main frame fin which the game is played.");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getActionCommand() == "New Game") {
					cryptogramChoiceFrame();
				}
			}

		});
		JButton button1 = new JButton("Load Game");
		button1.setToolTipText("Load one of the saved games your current account has.");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "Load Game") {
					loadGameFrame();
				}
			}

		});
		JButton button2 = new JButton("Credits");
		button2.setToolTipText("Press here to view the best programmers in the world.");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "Credits") {
					credits();
				}
			}

		});
		JButton button3 = new JButton("Exit Game");
		button3.setToolTipText("This exits the game. Bye bye!");
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
				"Created by Hristo Petkov, Slav Ivanov and Kostadin Georgiev (CS207 2017/2018).");
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
		button.setToolTipText("This button leads back to the main menu.");
		button.addActionListener(new ActionListener(){

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
		letterCryptogramButton.setToolTipText("Clicking this button means you choose to create a letter cryptogram");
		JRadioButton numberCryptogramButton = new JRadioButton("Number Cryptogram");
		numberCryptogramButton.setToolTipText("Clicking this button means you choose to create a number cryptogram.");
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(letterCryptogramButton);
		bGroup.add(numberCryptogramButton);
		
		
		
		JPanel panel1 = new JPanel(new GridLayout(1,1));
		panel1.add(letterCryptogramButton);
		panel1.add(numberCryptogramButton);
		content.add(panel1, BorderLayout.CENTER);
		
		JButton cryptChoiceButton = new JButton("Generate cryptogram");
		cryptChoiceButton.setToolTipText("Creates a cryptogram based on the choice you make regarding its type.");
		cryptChoiceButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(letterCryptogramButton.isSelected()) {
					//Generate LetterCryptogram
					cf = new CryptogramFactory();
					cryptogram = cf.makeCryptogram("letter");
					frame.dispose();
					cryptogramFrame();
				} else {
					//Generate NumberCryptogram
					cf = new CryptogramFactory();
					cryptogram = cf.makeCryptogram("number");
					frame.dispose();
					cryptogramFrame();
				}
			}
			
		});
		
		JPanel panel2 = new JPanel(new GridLayout(1,1));
		panel2.add(cryptChoiceButton);
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
		
		JComboBox<Integer> box = new JComboBox<Integer>();
		for(int i = 0; i < player.getSavedGames(); i++){
		box.addItem(i+1);
		}
		JPanel panel = new JPanel(new GridLayout(2,1));
		panel.add(label);
		panel.add(box);
		content.add(panel, BorderLayout.CENTER);
		
		JButton button = new JButton("Load Cryptogram");
		button.setToolTipText("Chooses which cryptogram to load.");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand() == "Load Cryptogram"){
					try {
						if(box.getSelectedIndex() == -1){
							JOptionPane.showMessageDialog(null, "Please select a game to load!");
						}else{
							System.out.println(Integer.decode(box.getSelectedItem().toString()));
							game.loadGame(player, Integer.decode(box.getSelectedItem().toString())); // Gets number from JComboBox, somehow
							JOptionPane.showMessageDialog(null, "Loading Cryptogram");
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frame.dispose();
					
				}
				
			}
			
		});
		JPanel panel1 = new JPanel(new GridLayout(1,1));
		panel1.add(button);
		content.add(panel1, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void cryptogramFrame(){
		cryptogramGameFrame = new JFrame("CryptogramCS207");
		cryptogramGameFrame.setBackground(Color.WHITE);
		Container content = cryptogramGameFrame.getContentPane();
		content.setBackground(Color.WHITE);
		
		JPanel phrase = new JPanel();
		phrase.setBackground(Color.WHITE);
		
		ArrayList<Integer> encryptedPhrase = cryptogram.getEncryptedPhrase();
		String realPhrase = cryptogram.getPhrase();
		List<TextFieldLabelAssociation> textFieldAssociations = new ArrayList<TextFieldLabelAssociation>();
		Map<Integer, Integer> frequencies = cryptogram.getFrequencies();
		List<JLabel> frequencyLabels = new ArrayList<JLabel>();
		List<JTextField> textFields = new ArrayList<JTextField>();
		Stack<String> undoLastLetter = new Stack<String>();
		
		int i = 0;
		while (i < encryptedPhrase.size()) {
			JPanel word = new JPanel();
			JPanel separator = new JPanel();
			separator.setBackground(Color.WHITE);
			word.setBackground(new Color(234, 234, 234));
			
			if (Character.isLetter(realPhrase.charAt(i)) || Character.isDigit(realPhrase.charAt(i))) {
				while (Character.isLetter(realPhrase.charAt(i)) || Character.isDigit(realPhrase.charAt(i))) {
					JPanel letter = new JPanel();
					letter.setBackground(new Color(234, 234, 234));
					letter.setLayout(new GridLayout(3, 1));
					
					// Add an empty text field.
					JTextField field = new JTextField();
					field.setDocument(new JTextFieldCharLimit(1));
					field.setPreferredSize(new Dimension(20,30));
					field.setHorizontalAlignment(JTextField.CENTER);
					
					// Add the encrypted symbol below the text field.
					JLabel encryptedSymbol = new JLabel();
					encryptedSymbol.setHorizontalAlignment(JLabel.CENTER);
					encryptedSymbol.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
					if (cryptogram instanceof LetterCryptogram) {
						encryptedSymbol.setText(String.valueOf((char) ((int) encryptedPhrase.get(i))).toUpperCase());
					} else {
						encryptedSymbol.setText(String.valueOf(encryptedPhrase.get(i)));
					}
					
					// Add frequency.
					JLabel frequency = new JLabel();
					if (cryptogram instanceof LetterCryptogram) {
						System.out.println(frequencies.get((int) encryptedPhrase.get(i)));
						frequency.setText(Integer.toString(frequencies.get(encryptedPhrase.get(i))));
					} else {
						frequency.setText(String.valueOf(frequencies.get(encryptedPhrase.get(i))));
					}
					frequency.setHorizontalAlignment(JLabel.CENTER);
					frequency.setVisible(false);
					frequencyLabels.add(frequency);
					
					// Add association between the encrypted symbol and the text field.
					textFieldAssociations.add(new TextFieldLabelAssociation(encryptedSymbol.getText(), field));
					textFields.add(field);
					
					letter.add(field);
					letter.add(encryptedSymbol);
					letter.add(frequency);
					word.add(letter);
					i++;
				}
				phrase.add(word);
			} else {
				JPanel symbol = new JPanel();
				symbol.setBackground(Color.WHITE);
				symbol.add(new JLabel(String.valueOf(realPhrase.charAt(i))));
				symbol.setLayout(new GridLayout(3, 1));
				separator.add(symbol);
				
				phrase.add(separator);
				i++;
			}
		}
		
		for (TextFieldLabelAssociation item : textFieldAssociations) {
			item.getField().addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
					for (TextFieldLabelAssociation item2 : textFieldAssociations) {
						if (item.getSymbol().equals(item2.getSymbol())) {
							item2.getField().setText(item.getField().getText());
						}
					}
				}

				@Override
				public void keyTyped(KeyEvent e) {
					if (!(Character.isLetter(e.getKeyChar()))) {
						e.consume();
					} else {
						System.out.println(String.valueOf(e.getKeyChar()));
						undoLastLetter.push(String.valueOf(e.getKeyChar()));
						System.out.println(Arrays.toString(undoLastLetter.toArray()));
					}
				}
				
			});
		}
		
		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!undoLastLetter.isEmpty()) {
					String lastLetter = undoLastLetter.pop();
					
					for (JTextField tf : textFields) {
						if (tf.getText().equals(lastLetter.toUpperCase())) {
							tf.setText("");
						}
					}
				}
			}
			
		});
		undoButton.setToolTipText("Button allows you to create a new game at any time.");
		JButton frequencyButton = new JButton("View Frequencies");
		frequencyButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JLabel frequency : frequencyLabels) {
					if (frequency.isVisible()) {
						frequency.setVisible(false);
						frequencyButton.setText("Show frequencies");
					} else {
						frequency.setVisible(true);
						frequencyButton.setText("Hide frequencies");
					}
					
				}
			}
			
		});
		frequencyButton.setToolTipText("Button allows you to view frequencies and hide them.");
		JButton getHintButton = new JButton("Get a Hint");
		getHintButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<TextFieldLabelAssociation> emptyFields = new ArrayList<TextFieldLabelAssociation>();
				
				for (TextFieldLabelAssociation item : textFieldAssociations) {
					if (item.getField().getText().equals("")) {
						emptyFields.add(item);
					}
				}
				
				Random rnd = new Random();
				TextFieldLabelAssociation rndField = emptyFields.get(rnd.nextInt(emptyFields.size() - 1));
				String realLetter = String.valueOf(cryptogram.getLetter(rndField.getSymbol().charAt(0)));
				rndField.getField().setText(realLetter);
				
				for (TextFieldLabelAssociation item2 : textFieldAssociations) {
					if (rndField.getSymbol().equals(item2.getSymbol())) {
						item2.getField().setText(realLetter);
					}
				}
			}
			
		});
		getHintButton.setToolTipText("Button gives you a hint");
		JButton button3 = new JButton("Load Game");
		button3.setToolTipText("Button allows you to load a game at any time.");
		button3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "Load Game"){
					//Maybe do stuff alter
				}
				
			}
			
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new FlowLayout(-2));
		panel.add(undoButton);
		panel.add(frequencyButton);
		panel.add(getHintButton);
		panel.add(button3);
		
		JButton checkButton = new JButton("Check Cryptogram");
		checkButton.setToolTipText("Button Allows you to check the current cryptogram at any time");
		JButton resetButton = new JButton("Reset Cryptogram");
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JTextField tf : textFields) {
					tf.setText("");
				}
			}
			
		});
		resetButton.setToolTipText("Button allows you to reset the cryptogram at any time");
		JButton saveButton = new JButton("Save Game");
		saveButton.setToolTipText("Button allows you to save game at anhy time");
		saveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand() == "Save Game"){
					try {
						game.saveGame(player, cryptogram);
						JOptionPane.showMessageDialog(null, "Game Saved!");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		JButton exitButton = new JButton("Exit Game");
		exitButton.setToolTipText("Button allows you to exit the game at any time.");
		exitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand() == "Exit Game"){
					saveFrame();
				}
				
			}
			
		});
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setLayout(new FlowLayout(2));
		panel1.add(checkButton);
		panel1.add(resetButton);
		panel1.add(saveButton);
		panel1.add(exitButton);
		
		content.add(panel, BorderLayout.NORTH);
		content.add(panel1, BorderLayout.SOUTH);
		content.add(phrase, BorderLayout.CENTER);
		
		cryptogramGameFrame.pack();
		cryptogramGameFrame.setSize(800, 600);
		cryptogramGameFrame.setLocationRelativeTo(null);
		cryptogramGameFrame.setVisible(true);
	}
	
	private void chooseExitWay(){
		JFrame frame = new JFrame("Exit?");
		Container content = frame.getContentPane();
		JLabel label = new JLabel("Are you sure you want to quit?");
		JLabel label1 = new JLabel(" ");
		
		JPanel panel = new JPanel(new GridLayout(2,1));
		panel.add(label);
		panel.add(label1);
		content.add(panel, BorderLayout.CENTER);
		
		JButton button = new JButton("Yes");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand() == "Yes"){
					frame.dispose();
					whereToExitTo();
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
	
	private void whereToExitTo(){
		JFrame frame = new JFrame("Where to?");
		Container content = frame.getContentPane();
		JLabel label = new JLabel("Please select your exit destination");
		JLabel label1 = new JLabel(" ");
		JPanel panel = new JPanel(new GridLayout(2,1));
		panel.add(label);
		panel.add(label1);
		content.add(panel, BorderLayout.CENTER);
		
		JButton button = new JButton("To desktop");
		button.setToolTipText("Allows you to exit to desktop");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand() == "To desktop"){
					System.exit(0);
				}
				
			}
			
		});
		JButton button1 = new JButton("To main menu");
		button1.setToolTipText("Allows you to exit to main menu");
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "To main menu"){
					frame.dispose();
					cryptogramGameFrame.dispose();
					gameFrame();
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
	
	private void saveFrame(){
		JFrame frame = new JFrame("Save Game?");
		Container content = frame.getContentPane();
		
		JLabel label = new JLabel("Would you like to save your progress?");
		JLabel label1 = new JLabel("Any unsaved progress wouyld be lost!");
		JPanel panel = new JPanel(new GridLayout(2,1));
		panel.add(label);
		panel.add(label1);
		content.add(panel, BorderLayout.CENTER);
		
		JButton button = new JButton("Yes");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "Yes"){
					frame.dispose();
					chooseExitWay();
					//Save file functionality
					try {
						game.saveGame(player, cryptogram);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		JButton button1 = new JButton("No");
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "No"){
					frame.dispose();
					chooseExitWay();
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
