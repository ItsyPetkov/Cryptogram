package tests.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Cryptogram;
import main.java.LetterCryptogram;
import main.java.NumberCryptogram;

class TestCryptogram {
	
	private	String phrase = "xyyxzz xx zyyy";
	private	Cryptogram<Character> letterCrypt;
	private	Cryptogram<Integer> numberCrypt;
	private	Map<Character, Integer> frequenciesLetter;
	private	Map<Integer, Integer> frequenciesNumber;
	
	@BeforeEach
	protected void setUp() {
		letterCrypt = new LetterCryptogram(phrase);
		frequenciesLetter = new HashMap<Character, Integer>();
		numberCrypt = new NumberCryptogram(phrase);
		frequenciesNumber = new HashMap<Integer, Integer>();
	}
	
	@AfterEach
	protected void tearDown() {
		letterCrypt = null;
		numberCrypt = null;
		frequenciesLetter = null;
		frequenciesNumber = null;
	}

	@Test
	public void getFrequenciesLetterCryptogramTest() {
		letterCrypt.addMappingEntry('m', 'x');
		letterCrypt.addMappingEntry('d', 'y');
		letterCrypt.addMappingEntry('y', 'z');
		
		frequenciesLetter = letterCrypt.getFrequencies();
		
		assertTrue(frequenciesLetter.get('m') == 4);
		assertTrue(frequenciesLetter.get('d') == 5);
		assertTrue(frequenciesLetter.get('y') == 3);
	}
	
	@Test
	public void getFrequenciesNumberCryptogramTest() {
		numberCrypt.addMappingEntry(12, 'x');
		numberCrypt.addMappingEntry(6, 'y');
		numberCrypt.addMappingEntry(11, 'z');
		
		frequenciesNumber = numberCrypt.getFrequencies();
		
		assertTrue(frequenciesNumber.get(12) == 4);
		assertTrue(frequenciesNumber.get(6) == 5);
		assertTrue(frequenciesNumber.get(11) == 3);
	}

}
