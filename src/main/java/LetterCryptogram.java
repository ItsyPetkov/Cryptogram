package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LetterCryptogram extends Cryptogram {

	private HashMap<Character, Character> letter_mapping;
	public char[] characters;

	public LetterCryptogram() {
		super();
		letter_mapping = new HashMap<Character, Character>();
		fillInLetterMap();
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
		letter_mapping.put('N', 'M');
		letter_mapping.put('O', 'L');
		letter_mapping.put('P', 'K');
		letter_mapping.put('Q', 'J');
		letter_mapping.put('R', 'I');
		letter_mapping.put('S', 'H');
		letter_mapping.put('T', 'G');
		letter_mapping.put('U', 'F');
		letter_mapping.put('V', 'E');
		letter_mapping.put('W', 'D');
		letter_mapping.put('X', 'C');
		letter_mapping.put('Y', 'B');
		letter_mapping.put('Z', 'A');
		
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
		letter_mapping.put('n', 'm');
		letter_mapping.put('o', 'l');
		letter_mapping.put('p', 'k');
		letter_mapping.put('q', 'j');
		letter_mapping.put('r', 'i');
		letter_mapping.put('s', 'h');
		letter_mapping.put('t', 'g');
		letter_mapping.put('u', 'f');
		letter_mapping.put('v', 'e');
		letter_mapping.put('w', 'd');
		letter_mapping.put('x', 'c');
		letter_mapping.put('y', 'b');
		letter_mapping.put('z', 'a');
		
		//Mapping for any thing but letters
		letter_mapping.put(',', ',');
		letter_mapping.put('.', '.');
		letter_mapping.put('!', '!');
		letter_mapping.put(' ', ' ');
		
	}

	public char generateLetterCryptogram(HashSet<Character> letters) {
		char cryptletter = 0;
			for (Character letter : letters) {
				System.out.println(letter);
				if(letter != returnAnythingButLetters()){
					cryptletter = letter_mapping.get(letter);
					if (cryptletter != returnAnythingButLetters()) {// needs work not cheking everything
						return cryptletter;
					}
				}
			}
		return returnAnythingButLetters();
	}

	public HashSet<Character> splitStringIntoChar() {
		// !!!DO NOT ALTER!!!
		Cryptogram c = new Cryptogram();
		c.readPhrasesFromFile(RNG());
		String temp = c.toString();
		char[] characters = temp.toCharArray();
		this.characters = characters;
		// System.out.println("Array is:" + Arrays.toString(this.characters));
		
		HashSet<Character> letters = new HashSet<Character>();
		for(Character Char: characters){
			letters.add(Char);
		}
		return letters;
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
}
