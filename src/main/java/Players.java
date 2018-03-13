package main.java;

import java.util.ArrayList;

public class Players {
	private ArrayList<Player> allPlayers;
	
	public Players() {
		allPlayers = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player) {
		if (findPlayer(player.getName()) == null) {
			allPlayers.add(player);
		} else {
			// Player already exists
		}
	}
	
	public void removePlayer(String name) {
		try {
			allPlayers.remove(findPlayer(name));
		} catch (NullPointerException e) {
			
		}
	}
	
	public Player findPlayer(String name) {
		for (Player player : allPlayers)
			if (player.getName() == name)
				return player;
		
		return null;
	}
	
	public ArrayList<Integer> getAllPlayersAccuracies() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (Player player : allPlayers)
			list.add(player.getAccuracy());
		
		return list;
	}
	
	public ArrayList<Integer> getAllPlayersTimes() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (Player player : allPlayers)
			list.add(player.getAverageTime());
		
		return list;
	}
	
	public ArrayList<Integer> getAllPlayersCryptogramsPlayed() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (Player player : allPlayers)
			list.add(player.getNumCryptogramsPlayed());
		
		return list;
	}
	
	public ArrayList<Integer> getAllPlayersCompletedCryptograms() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (Player player : allPlayers)
			list.add(player.getNumCryptogramsCompleted());
		
		return list;
	}
}
