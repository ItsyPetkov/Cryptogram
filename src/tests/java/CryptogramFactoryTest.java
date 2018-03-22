package tests.java;

import static org.junit.Assert.*;

import java.util.List;

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
		System.out.println(cryptogram.getEncryptedPhrase());
	}
	
	@Test
	public void makeNumberCryptogramTest() {
		cryptogram = cryptGen.makeCryptogram("number");
		String phrase = cryptogram.getPhrase();
		System.out.println(phrase);
		System.out.println(cryptogram.getEncryptedPhrase());
	}
	
	@Test
	public void readPhrasesFromFileTest() {
		List<String> phrases = cryptGen.getPhrases();
		assertTrue(phrases.get(0).equals("Light travels faster than sound. This is why some people appear bright until you hear them speak."));
		assertTrue(phrases.get(1).equals("Sometimes I wonder, \'Why is that frisbee getting bigger?\' And then it hits me."));
	}

}
