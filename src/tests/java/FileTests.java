package tests.java;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import main.java.Game;
import main.java.LetterCryptogram;
import main.java.Player;

public class FileTests {
	
	public Game game;
	public Player james;
	public LetterCryptogram crg;
		
	@Test
	public void saveGameCreatesFileSuccessfully() throws IOException
	{
		FileReader fr = null;
		james = new Player("James");
		crg = new LetterCryptogram("test");
		game = new Game();
		
		try {
			game.saveGame(james, crg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
		fr = new FileReader(james.getName()+"_saved_game_"+james.getSavedGames()+1+".txt");
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		assertTrue(fr != null);
		
	}
}
