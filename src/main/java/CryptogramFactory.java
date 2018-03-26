package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * A class, which is responsible for generating a cryptogram,
 * which uses a random phrase, and encrypts it.
 */
public class CryptogramFactory {
    
	// The cryptogram, which is created by makeCryptogram().
	Cryptogram cryptogram;
	// List of all the phrases taken from "phrases.txt".
	private List<String> phrases;
	// Random number generator.
	private Random rand;
    
	/**
	 * Constructor for the CryptogramFactory class, which reads all
	 * the phrases in the phrases ArrayList.
	 */
	public CryptogramFactory() {
    	phrases = new ArrayList<String>();
    	rand = new Random();
    	readPhrasesFromFile();
	}
	
	/**
	 * Return a list of all the phrases.
	 * @return phrases
	 */
	public List<String> getPhrases() {
		return phrases;
	}
    
	/**
	 * The most important method in this class, which is responsible for
	 * creating either a letter-to-letter, or a number-to-letter cryptogram,
	 * and encrypts the phrase passing the mapping of each letter to the cryptogram,
	 * as well as the actual phrase and the encrypted one.
	 * @param type - "letter" for a letter-encrypted, or "number" for number-encrypted
	 * @return cryptogram
	 */
	public Cryptogram makeCryptogram(String type) {
		String randomPhrase = getRandomPhrase().toLowerCase();
		ArrayList<Integer> encryptedPhrase = new ArrayList<Integer>();
		for (char ch : randomPhrase.toCharArray()) {
			encryptedPhrase.add((int) ch);
		}
		
		switch (type) {
			case "letter": {
				cryptogram = new LetterCryptogram(randomPhrase);
				randomPhrase = randomPhrase.replaceAll("[^a-zA-Z]", "");
				List<Character> availableAlphabet = new ArrayList<Character>();
				char head;
				for (char c = 'a'; c <= 'z'; c++) {
					availableAlphabet.add(c);
				}
				while(!randomPhrase.isEmpty()) {
					head = randomPhrase.charAt(0);
					if (Character.isLetter(head)) {
						int index = rand.nextInt(availableAlphabet.size());
						char encryptedLetter = availableAlphabet.get(index);
						while (encryptedLetter == head) {
							index = rand.nextInt(availableAlphabet.size());
							encryptedLetter = availableAlphabet.get(index);
						}
						cryptogram.addMappingEntry(encryptedLetter, head);
						Collections.replaceAll(encryptedPhrase, (int) head, (int) encryptedLetter);
						randomPhrase = randomPhrase.replaceAll(String.valueOf(head), "");
						availableAlphabet.remove(index);
					}
					else {
						randomPhrase = randomPhrase.replaceAll(String.valueOf(head), "");
					}
				}
				break;
			}
			case "number": {
				cryptogram = new NumberCryptogram(randomPhrase);
				randomPhrase = randomPhrase.replaceAll("[^a-zA-Z]", "");
				List<Integer> availableNumbers = new ArrayList<Integer>();
				char head;
				for (int i = 0; i < 26; i++) {
					availableNumbers.add(i);
				}
				while(!randomPhrase.isEmpty()) {
					head = randomPhrase.charAt(0);
					if (Character.isLetter(head)) {
						int index = rand.nextInt(availableNumbers.size());
						int encryptedNumber = availableNumbers.get(index);
						cryptogram.addMappingEntry(encryptedNumber, head);
						Collections.replaceAll(encryptedPhrase, (int) head, encryptedNumber);
						randomPhrase = randomPhrase.replaceAll(String.valueOf(head), "");
						availableNumbers.remove(index);
					}
					else {
						randomPhrase = randomPhrase.replaceAll(String.valueOf(head), "");
					}
				}
				break;
			}
		}
		cryptogram.setEncryptedPhrase(encryptedPhrase);
    	return cryptogram;
	}

	/**
	 * Read the phrases from file and fill them in the list phrases,
	 * where each line of "phrases.txt" holds a whole phrase.
	 */
	private void readPhrasesFromFile() {
		try {
			String phrase;
			FileReader fr = new FileReader("phrases.txt");
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			Scanner scanner = null;
			while (line != null) {
				scanner = new Scanner(line);
				phrase = scanner.nextLine();
				phrases.add(phrase);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");// alter if needed
		} catch (IOException e) {
			System.out.println("Something went wrong while reading from file!");// alter if needed
		}
	}

	/**
	 * Return a random phrase from the list.
	 */
	public String getRandomPhrase() {
		return phrases.get(rand.nextInt(phrases.size()));
	}

}
