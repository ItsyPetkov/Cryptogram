package main.java;

public class Player {
	private String name;
	private int accuracy;
	private int averageTime;
	private int cryptogramsPlayed;
	private int cryptogramsCompleted;
	
	public Player(String name) {
		this.name = name;
		accuracy = 0;
		averageTime = 0;
		cryptogramsPlayed = 0;
		cryptogramsCompleted = 0;
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
	
	public String toString(){
		return getName();
	}
}
