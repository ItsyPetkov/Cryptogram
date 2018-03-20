package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * A model of a cryptogram, using letter-to-letter encryption.
 * Stores the mapping in a HashMap, where the key of each entry is
 * a encrypted letter and the value is the real letter.
 */
public class LetterCryptogram extends Cryptogram<Character> {
	
	// A map, which maps encrypted letters to real letters.
	private Map<Character, Character> letter_mapping;
	
	/**
	 * Create a new cryptogram, using letter-to-letter encryption.
	 * @param phrase
	 */
	public LetterCryptogram(String phrase) {
		super(phrase);
		letter_mapping = new HashMap<Character, Character>();
	}
	
	/**
	 * Take the encrypted letter as a parameter and return the real letter back.
	 * @return letter, mapped to encrypted letter
	 */
	@Override
	public char getLetter(int encryptedLetter) throws NullPointerException {
		return letter_mapping.get((char) encryptedLetter);
	}

	/**
	 * Add a new entry to letter_mapping, where key is the encrypted letter
	 * and value is the real letter.
	 */
	@Override
	public void addMappingEntry(int key, char value) {
		letter_mapping.put((char) key, value);
	}
	
	/**
	 * Find the frequencies of each of the encrypted symbols letters from the phrase.
	 * @return frequencies
	 */
	@Override
	public Map<Character, Integer> getFrequencies() {
		Map<Character, Integer> frequencies = new HashMap<Character, Integer>();
		int count;
		char key;
		char value;
		
		for (Map.Entry<Character, Character> entry : letter_mapping.entrySet()) {
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
