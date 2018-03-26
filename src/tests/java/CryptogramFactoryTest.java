package tests.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Cryptogram;
import main.java.CryptogramFactory;

public class CryptogramFactoryTest {
	
	private CryptogramFactory cryptGen;
	private Cryptogram cryptogram;

	@Before
	public void setUp() {
		cryptGen = new CryptogramFactory();
	}
	
	@After
	public void tearDown() {
		cryptGen = null;
		cryptogram = null;
	}

	@Test
	public void makeLetterCryptogramTest() {
		cryptogram = cryptGen.makeCryptogram("letter");
		String phrase = cryptogram.getPhrase();
		System.out.println(phrase);
		ArrayList<Integer> encryptedPhrase = cryptogram.getEncryptedPhrase();
		for (int letter : encryptedPhrase)
			System.out.print((char) letter);
		System.out.println();
	}
	
	@Test
	public void makeNumberCryptogramTest() {
		cryptogram = cryptGen.makeCryptogram("number");
		String phrase = cryptogram.getPhrase();
		System.out.println(phrase);
		ArrayList<Integer> encryptedPhrase = cryptogram.getEncryptedPhrase();
		for (int i = 0; i < encryptedPhrase.size(); i++) {
			if (Character.isLetter(phrase.charAt(i))) {
				System.out.println(encryptedPhrase.get(i));
			} else {
				System.out.println(phrase.charAt(i));
			}
		}
		System.out.println();
	}
	
	@Test
	public void readPhrasesFromFileTest() {
		List<String> phrases = cryptGen.getPhrases();
		assertTrue(phrases.get(0).equals("Light travels faster than sound. This is why some people appear bright until you hear them speak."));
		assertTrue(phrases.get(1).equals("Sometimes I wonder, \'Why is that frisbee getting bigger?\' And then it hits me."));
	}

}
