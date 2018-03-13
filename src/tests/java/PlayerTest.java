package tests.java;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.Player;
import main.java.Players;

public class PlayerTest {
	
	@Test
	public void getNameReturnsCorrectMessage() {
        Player john = new Player("John");
        assertTrue(john.getName().equals("John"));
    }
	
	@Test
	public void findPlayerReturnsCorrectMessage()
	{
		Players array_list = new Players();
		Player john = new Player("John");
		array_list.addPlayer(john);
		 assertTrue(array_list.findPlayer("John").getName().equals(john.getName()));
	}
	
	
	//Needs work still
	@Test
	public void removePlayerRemovesCorrectPlayer()
	{
		Players array_list = new Players();
		Player john = new Player("John");
		array_list.addPlayer(john);
		array_list.removePlayer("John");
		assertTrue(array_list.findPlayer("John").equals(null));
	}

}
