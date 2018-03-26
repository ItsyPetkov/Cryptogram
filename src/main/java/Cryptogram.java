package main.java;

import java.util.ArrayList;
import java.util.Map;

/**
 * A class representing a cryptogram, which uses either
 * letter-to-letter encryption, or number-to-letter encryption.
 */
public abstract class Cryptogram {
	
	// Holds the phrase.
	protected String phrase;
	// Stores the encrypted phrase.
	protected ArrayList<Integer> encryptedPhrase;
	
	/**
	 * Create a new cryptogram.
	 * @param phrase
	 */
	public Cryptogram(String phrase) {
		this.phrase = phrase;
	}
	
	/**
	 * Return the phrase.
	 * @return phrase
	 */
	public String getPhrase() {
		return phrase;
	}
	
	/**
	 * Set the phrase.
	 */
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	
	/**
	 * Return the encrypted phrase.
	 * @return phrase
	 */
	public ArrayList<Integer> getEncryptedPhrase() {
		return encryptedPhrase;
	}
	
	/**
	 * Set the encrypted phrase.
	 */
	public void setEncryptedPhrase(ArrayList<Integer> encryptedPhrase) {
		this.encryptedPhrase = new ArrayList<Integer>(encryptedPhrase);
	}
	
	/**
	 * Take the encrypted symbol as a parameter and return the real letter back.
	 * @return letter, mapped to encrypted symbol
	 */
	public abstract char getLetter(int encryptedSymbol);
	
	/**
	 * Add a new entry to the mapping, where key is the encrypted symbol
	 * and value is the real letter.
	 */
	public abstract void addMappingEntry(int key, char value);
	
	/**
	 * Find the frequencies of each of the encrypted symbols from the phrase.
	 * @return frequencies
	 */
	public abstract Map<Integer, Integer> getFrequencies();
	
}