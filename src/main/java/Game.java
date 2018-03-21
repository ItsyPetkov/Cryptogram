package main.java;

import javax.swing.JFrame;

import gui.java.CryptogramGUI;

public class Game {

	Player currentPlayer;
	Players playerGameMapping;
	CryptogramGUI gui;
	
	public Game(){
		playerGameMapping = new Players();
		playGame();
	}
	
	public Player loadPlayer(Player player){

		for(int i = 0; i < playerGameMapping.allPlayers.size() - 1; i++){
			if(playerGameMapping.allPlayers.get(i).getName() == player.getName()){
				currentPlayer = new Player(player.getName());
				System.out.println(currentPlayer.getName());
			}
		}
		return currentPlayer;
	}
	
	public void playGame(){
		gui = new CryptogramGUI();
	}
}
