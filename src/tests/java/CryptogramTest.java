package tests.java;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Cryptogram;
import main.java.LetterCryptogram;
import main.java.NumberCryptogram;

public class CryptogramTest {

	private	String phrase = "xyyxzz xx zyyy";
	private	Cryptogram letterCrypt;
	private	Cryptogram numberCrypt;
	private	Map<Integer, Integer> frequenciesLetter;
	private	Map<Integer, Integer> frequenciesNumber;
	
	@Before
	public void setUp() {
		letterCrypt = new LetterCryptogram(phrase);
		frequenciesLetter = new HashMap<Integer, Integer>();
		numberCrypt = new NumberCryptogram(phrase);
		frequenciesNumber = new HashMap<Integer, Integer>();
	}
	
	@After
	public void tearDown() {
		letterCrypt = null;
		numberCrypt = null;
		frequenciesLetter = null;
		frequenciesNumber = null;
	}
	
	@Test(expected = NullPointerException.class)
	public void getLetterExceptionTest1() {
		assertTrue(letterCrypt.getLetter('b') == 'k');
	}
	
	@Test(expected = NullPointerException.class)
	public void getLetterExceptionTest2() {
		assertTrue(numberCrypt.getLetter(20) == 'r');
	}
	
	@Test
	public void getLetterCryptogramTest() {
		letterCrypt.addMappingEntry('b', 'e');
		letterCrypt.addMappingEntry('g', 'b');
		numberCrypt.addMappingEntry(15, 'o');
		numberCrypt.addMappingEntry(6, 'u');
		
		assertTrue((char) letterCrypt.getLetter('b') == 'e');
		assertTrue((char) letterCrypt.getLetter('g') == 'b');
		assertTrue((char) numberCrypt.getLetter(15) == 'o');
		assertTrue((char) numberCrypt.getLetter(6) == 'u');
	}

	@Test
	public void getFrequenciesLetterCryptogramTest() {
		letterCrypt.addMappingEntry('m', 'x');
		letterCrypt.addMappingEntry('d', 'y');
		letterCrypt.addMappingEntry('y', 'z');
		
		frequenciesLetter = letterCrypt.getFrequencies();
		
		assertTrue(frequenciesLetter.get((int) 'm') == 4);
		assertTrue(frequenciesLetter.get((int) 'd') == 5);
		assertTrue(frequenciesLetter.get((int) 'y') == 3);
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

