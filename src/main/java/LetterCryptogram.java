package main.java;

import java.util.HashMap;
import java.util.Map;

public class LetterCryptogram extends Cryptogram<Character> {
	
	private Map<Character, Character> letter_mapping;
	
	public LetterCryptogram(String phrase) {
		super(phrase);
		letter_mapping = new HashMap<Character, Character>();
	}
	
	public char getLetter(char cryptogramLetter) {
		return letter_mapping.get(cryptogramLetter);
	}

	public void addMappingEntry(int key, char value) {
		letter_mapping.put((char) key, value);
	}
	
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
			System.out.println(key + " " + count);
		}
		
		return frequencies;
	}
	
}
