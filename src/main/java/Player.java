package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Player {
	private String name;
	private int accuracy;
	private int averageTime;
	private int cryptogramsPlayed;
	private int cryptogramsCompleted;
	private int savedGames;
	
	public Player(String name) throws IOException {
		this.name = name;
		accuracy = 0;
		averageTime = 0;
		cryptogramsPlayed = 0;
		cryptogramsCompleted = 0;
		savedGames = 0;
		savePlayerFile();
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
		writer.write(this.getAccuracy());
		writer.write(System.getProperty("line.separator"));
		writer.write(this.getAverageTime());
		writer.write(System.getProperty("line.separator"));
		writer.write(this.getNumCryptogramsPlayed());
		writer.write(System.getProperty("line.separator"));
		writer.write(this.getNumCryptogramsCompleted());
		writer.write(System.getProperty("line.separator"));
		writer.write(this.getSavedGames());
		}
		catch(IOException e)
		{
			e.getMessage();
		}
		
		writer.flush();
	    writer.close();
	}
}
