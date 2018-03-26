package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * A model of a cryptogram, using number-to-letter encryption.
 * Stores the mapping in a HashMap, where the key of each entry is
 * a encrypted number and the value is the real letter.
 */
public class NumberCryptogram extends Cryptogram {
	
	// A map, which maps encrypted numbers to real letters.
	private Map<Integer, Character> number_mapping;
	
	/**
	 * Create a new cryptogram, using number-to-letter encryption.
	 * @param phrase
	 */
	public NumberCryptogram(String phrase) {
		super(phrase);
		number_mapping = new HashMap<Integer, Character>();
	}
	
	/**
	 * Take the encrypted symbol number as a parameter and return the real letter back.
	 * @return letter, mapped to ecrypted number
	 */
	public char getLetter(int ecryptedNumber) throws NullPointerException {
		return number_mapping.get(ecryptedNumber);
	}
	
	/**
	 * Add a new entry to number_mapping, where key is the encrypted number
	 * and value is the real letter.
	 */
	public void addMappingEntry(int key, char value) {
		number_mapping.put(key, value);
	}
	
	/**
	 * Find the frequencies of each of the encrypted numbers from the phrase.
	 * @return frequencies
	 */
	@Override
	public Map<Integer, Integer> getFrequencies() {
		Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
		int count;
		int key;
		char value;
		
		for (Map.Entry<Integer, Character> entry : number_mapping.entrySet()) {
			count = 0;
			key = entry.getKey();
			value = entry.getValue();
			for (int i = 0; i < phrase.length(); i++) {
				if (phrase.charAt(i) == value) {
					count++;
				}
			}
			frequencies.put(key, count);
		}
		
		return frequencies;
	}

}
