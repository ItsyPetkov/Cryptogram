package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import gui.java.CryptogramGUI;

public class Game {

	Player currentPlayer;
	Players playerGameMapping;
	CryptogramGUI gui;

	public Game() {
		playerGameMapping = new Players();
		playGame();
	}

	public void playGame() {
		gui = new CryptogramGUI();
	}

	public void saveGame(Player player, Cryptogram cr) throws IOException
	{
		Player saved_player = null;
		Cryptogram cryptog = null;
		if(player != null && cr != null) {
		saved_player = player;
		cryptog = cr;
		}	
		
		File file = new File("saved_game.txt");
		file.createNewFile();
		FileWriter writer = new FileWriter(file);

		try
		{
		//Writes the player
		writer.write(saved_player.getName());
		writer.write(saved_player.getAccuracy());
		writer.write(saved_player.getNumCryptogramsPlayed());
		writer.write(saved_player.getNumCryptogramsCompleted());
		
		//Writes the cryptogram
		writer.write(cryptog.getPhrase());
		}
		catch(IOException e)
		{
			e.getMessage();
		}
		
		writer.flush();
	    writer.close();

	}
	
	public void loadGame()
	{
		//used to hold all the player's statistics, would then be passed onto constructor to create player object with those values.
		String[] player_info;
		player_info = new String[5];
		try {
			int j = 0;
			Scanner scanner = null;
			FileReader fr = new FileReader("saved_game.txt");
			BufferedReader br = new BufferedReader(fr);
			String input = br.readLine();
			while (input != null && j < 5) {
				scanner = new Scanner(input);
				String phrase = scanner.nextLine();
				player_info[j] = phrase;
				input = br.readLine();
				j++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");// alter if needed
		} catch (IOException e) {
			System.out.println("Something went wrong while reading from file!");// alter if needed
		}
		Player player = new Player(player_info[0]);
		playerGameMapping.addPlayer(player);
		
	}

	public Player loadPlayer(Player player) {

		for (int i = 0; i < playerGameMapping.allPlayers.size() - 1; i++) {
			if (playerGameMapping.allPlayers.get(i).getName() == player.getName()) {
				currentPlayer = new Player(player.getName());
				System.out.println(currentPlayer.getName());
			}
		}
		return currentPlayer;
	}

}
