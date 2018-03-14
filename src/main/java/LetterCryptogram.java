package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LetterCryptogram extends Cryptogram {

	private HashMap<Character, Character> letter_mapping;
	private char[] characters;

	public LetterCryptogram() {
		super();
		letter_mapping = new HashMap<Character, Character>();
	}

	public char generateLetterCryptogram(HashSet<Character> letters) {
		for (Character letter : letters) {
			char cryptletter = letter_mapping.get(letter);
			if (cryptletter != ' ') {// needs work not cheking everything
				return cryptletter;
			}
		}
		return returnAnythingButLetters();
	}

	public void splitStringIntoChar() {
		// !!!DO NOT ALTER!!!
		Cryptogram c = new Cryptogram();
		c.readPhrasesFromFile(RNG());
		String temp = c.toString();
		char[] characters = temp.toCharArray();
		this.characters = characters;
		// System.out.println("Array is:" + Arrays.toString(this.characters));
	}

	public void fillInLetterMap() {
		// Mapping for the uppercase letters
		letter_mapping.put('A', 'Z');
		letter_mapping.put('B', 'Y');
		letter_mapping.put('C', 'X');
		letter_mapping.put('D', 'W');
		letter_mapping.put('E', 'V');
		letter_mapping.put('F', 'U');
		letter_mapping.put('G', 'T');
		letter_mapping.put('H', 'S');
		letter_mapping.put('I', 'R');
		letter_mapping.put('J', 'Q');
		letter_mapping.put('K', 'P');
		letter_mapping.put('L', 'O');
		letter_mapping.put('M', 'N');

		// Mapping for the lowercase letters
		letter_mapping.put('a', 'z');
		letter_mapping.put('b', 'y');
		letter_mapping.put('c', 'x');
		letter_mapping.put('d', 'w');
		letter_mapping.put('e', 'v');
		letter_mapping.put('f', 'u');
		letter_mapping.put('g', 't');
		letter_mapping.put('h', 's');
		letter_mapping.put('i', 'r');
		letter_mapping.put('j', 'q');
		letter_mapping.put('k', 'p');
		letter_mapping.put('l', 'o');
		letter_mapping.put('m', 'n');
	}

	public char returnAnythingButLetters() {
		char temp = 0;
		for (Character Char : characters) {
			if (Char.equals(' ') || Char.equals('!') || Char.equals('.') || Char.equals('?') || Char.equals('-')
					|| Char.equals(':') || Char.equals(',') || Char.equals(';') || Char.equals('"') || Char.equals('(')
					|| Char.equals('{') || Char.equals('}') || Char.equals('[') || Char.equals(']')) {// needs
																										// work
																										// not
																										// checking
																										// everything
				temp = Char;
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		new LetterCryptogram().splitStringIntoChar();
	}
}
