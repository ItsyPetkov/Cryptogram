package main.java;

import java.util.HashMap;
import java.util.Map;

public class NumberCryptogram extends Cryptogram<Integer> {
	
	private Map<Integer, Character> number_mapping;
	
	public NumberCryptogram(String phrase) {
		super(phrase);
		number_mapping = new HashMap<Integer, Character>();
	}
	
	public char getLetter(int cryptogramInt) {
		return number_mapping.get(cryptogramInt);
	}
	
	public void addMappingEntry(int key, char value) {
		number_mapping.put(key, value);
	}
	
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
			System.out.println(key + " " + count);
		}
		
		return frequencies;
	}

}
