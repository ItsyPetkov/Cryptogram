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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
				"Copyright © Hristo Petkov, Slav Ivanov and Kostadin Georgiev (CS207 2017/2018). All rights reserved");
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
				"Copyright © Hristo Petkov, Slav Ivanov and Kostadin Georgiev (CS207 2017/2018). All rights reserved");
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
				// TODO Auto-generated method stub

			}

		});

		JPanel panel2 = new JPanel(new GridLayout(1, 1));
		panel2.add(button);
		panel2.add(button1);
		content.add(panel2, BorderLayout.SOUTH);

		authenticationFrame.setSize(500, 300);
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
		username.addMouseListener(mListener = new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				username.setText(" ");
				username.setFont(new JTextField().getFont());
				username.setForeground(Color.black);
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
				if(username.getText().equals("Enter a username!") || username.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter a valid username");
				}else{
					player = new Player(username.toString());
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
		frame.setVisible(true);
	}
}

