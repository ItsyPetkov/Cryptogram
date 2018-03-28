package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

	public void saveGame(Player player, Cryptogram cr) throws IOException {
		File file;
		Player saved_player = null;
		Cryptogram cryptogram = null;

		if (player != null && cr != null) {
			saved_player = player;
			cryptogram = cr;
		}

		file = new File(saved_player.getName() + "_saved_game_" + saved_player.getSavedGames() + 1 + ".txt");
		FileWriter writer = new FileWriter(file);

		try {
			// Writes the cryptogram
			writer.write(cryptogram.getPhrase());
			writer.write(System.getProperty("line.separator"));
//	Needs work		writer.write(cryptogram.getEncryptedPhrase()); 
		} catch (IOException e) {
			System.err.println(e);
		}

		writer.flush();
		writer.close();
	}

	public void loadGame(Player pl) throws Exception {
		CryptogramFactory cf;
		Player player = pl;
		String encrypted_phrase = null;
		for (int i = 0; i < 10; i++) {
			try {
				int j = 0;
				Scanner scanner = null;
				FileReader fr = new FileReader(player.getName() + "_saved_game_" + i + ".txt");
				BufferedReader br = new BufferedReader(fr);
				String input = br.readLine();
				while (input != null) {
					scanner = new Scanner(input);
					String phrase = scanner.next();
					encrypted_phrase = phrase;
					input = br.readLine();
					j++;
				}
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found!");// alter if needed
			} catch (IOException e) {
				System.out.println("Something went wrong while reading from file!");// alter if needed
			}	
		}
		cf = new CryptogramFactory();
		cf.makeCryptogram(encrypted_phrase);
	}

	public Player loadPlayer(Player player) throws IOException {

		for (int i = 0; i < playerGameMapping.allPlayers.size() - 1; i++) {
			if (playerGameMapping.allPlayers.get(i).getName() == player.getName()) {
				currentPlayer = new Player(player.getName());
				System.out.println(currentPlayer.getName());
			}
		}
		return currentPlayer;
	}

}
