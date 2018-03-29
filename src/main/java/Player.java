package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Player {
	private String name;
	private int accuracy;
	private int averageTime;
	private int cryptogramsPlayed;
	private int cryptogramsCompleted;
	private int savedGames;
	
	public Player(String name){
		this.name = name;
		accuracy = 0;
		averageTime = 0;
		cryptogramsPlayed = 0;
		cryptogramsCompleted = 0;
		savedGames = 0;
		try{
			savePlayerFile();
		}catch(IOException e){
			System.err.println(e);
		}
		
	}
	
	//Constructor meant for loading the player back into the game on the 2nd launch of the application.
	public Player(String name, int accuracy, int averageTime, int cryptogramsPlayed, int cryptogramsCompleted, int gamesSaved) {
		this.name = name;
		this.accuracy = accuracy;
		this.averageTime = averageTime;
		this.cryptogramsPlayed = cryptogramsPlayed;
		this.cryptogramsCompleted = cryptogramsCompleted;
		this.savedGames = gamesSaved;
	}
	
	public void updateAccuracy(int accuracy) {
		
	}
	
	public void incrementCryptogramsCompleted() {
		cryptogramsCompleted++;
	}
	
	public void updateAverageCompletitionTime() {
		
	}
	
	public void incrementCryptogramsPlayed() {
		cryptogramsPlayed++;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public int getNumCryptogramsCompleted() {
		return cryptogramsCompleted;
	}
	
	public int getAverageTime() {
		return averageTime;
	}
	
	public int getNumCryptogramsPlayed() {
		return cryptogramsPlayed;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSavedGames()
	{
		return savedGames;
	}
	
	public int incrementSavedGames()
	{
		return savedGames++;
	}
	
	public int decrementSavedGames()
	{
		return savedGames--;
	}

	
	public void savePlayerFile() throws IOException
	{
			File file = new File(this.getName() +"_file.txt");
			file.createNewFile();
			FileWriter writer = new FileWriter(file);

			try
			{
			//Writes the player
			writer.write(this.getName());
			writer.write(System.getProperty("line.separator"));
			writer.write(String.valueOf(this.getAccuracy()));
			writer.write(System.getProperty("line.separator"));
			writer.write(String.valueOf(this.getAverageTime()));
			writer.write(System.getProperty("line.separator"));
			writer.write(String.valueOf(this.getNumCryptogramsPlayed()));
			writer.write(System.getProperty("line.separator"));
			writer.write(String.valueOf(this.getNumCryptogramsCompleted()));
			writer.write(System.getProperty("line.separator"));
			writer.write(String.valueOf(this.getSavedGames()));
			}
			catch(IOException e)
			{
				e.getMessage();
			}
			
			
			writer.flush();
		    writer.close();
	}
}
