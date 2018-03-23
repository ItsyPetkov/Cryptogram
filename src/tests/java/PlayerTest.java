package tests.java;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import main.java.Player;
import main.java.Players;

public class PlayerTest {

	private Player john;
	private Player james;
	private Players array_list;

	@AfterEach
	protected void tearDown() {
		john = null;
		james = null;
		array_list = null;
	}

	@Test
	public void getNameReturnsCorrectMessage() {
		 john = new Player("John");
		 
		assertTrue(john.getName().equals("John"));
	}

	@Test
	public void findPlayerReturnsCorrectMessage() {
		 array_list = new Players();
		 john = new Player("John");
		 
		array_list.addPlayer(john);
		assertTrue(array_list.findPlayer("John").getName().equals(john.getName()));
	}

	@Test
	public void removePlayerRemovesCorrectPlayer() {
		 array_list = new Players();
		 john = new Player("John");
		 
		array_list.addPlayer(john);
		array_list.removePlayer("John");
		assertNull(array_list.findPlayer("John"));
	}

	@Test
	public void getAllPlayerAccuraciesReturnsCorrectValue() {
		 array_list = new Players();
		 john = new Player("John");
		 james = new Player("James");

		array_list.addPlayer(john);
		array_list.addPlayer(james);

		ArrayList<Integer> accuracy_test = array_list.getAllPlayersAccuracies();
		assertTrue(accuracy_test.get(0).intValue() == john.getAccuracy());
		assertTrue(accuracy_test.get(1).intValue() == james.getAccuracy());
	}

	@Test
	public void getAllPlayerTimesReturnsCorrectValue() {
		 array_list = new Players();
		 john = new Player("John");
		 james = new Player("James");

		array_list.addPlayer(john);
		array_list.addPlayer(james);

		ArrayList<Integer> accuracy_test = array_list.getAllPlayersAccuracies();
		assertTrue(accuracy_test.get(0).intValue() == john.getAverageTime());
		assertTrue(accuracy_test.get(1).intValue() == james.getAverageTime());
	}

	@Test
	public void getAllCryptogramsPlayedReturnsCorrectValue() {
		 array_list = new Players();
		 john = new Player("John");
		 james = new Player("James");

		array_list.addPlayer(john);
		array_list.addPlayer(james);

		ArrayList<Integer> accuracy_test = array_list.getAllPlayersAccuracies();
		assertTrue(accuracy_test.get(0).intValue() == john.getNumCryptogramsPlayed());
		assertTrue(accuracy_test.get(1).intValue() == james.getNumCryptogramsPlayed());
	}

	@Test
	public void getAllCompletedCryptogramsReturnsCorrectValue() {
		 array_list = new Players();
		 john = new Player("John");
		 james = new Player("James");

		array_list.addPlayer(john);
		array_list.addPlayer(james);

		ArrayList<Integer> accuracy_test = array_list.getAllPlayersAccuracies();
		assertTrue(accuracy_test.get(0).intValue() == john.getNumCryptogramsCompleted());
		assertTrue(accuracy_test.get(1).intValue() == james.getNumCryptogramsCompleted());
	}

}
