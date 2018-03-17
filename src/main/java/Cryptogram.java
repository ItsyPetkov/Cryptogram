package main.java;

import java.util.Map;

public abstract class Cryptogram<E> {
	
	protected String phrase;
	
	public Cryptogram(String phrase) {
		this.phrase = phrase;
	}
	
	public String getPhrase() {
		return phrase;
	}
	
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	
	public abstract void addMappingEntry(int key, char value);
	
	public abstract Map<E, Integer> getFrequencies();
	
}