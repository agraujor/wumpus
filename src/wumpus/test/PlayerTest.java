package wumpus.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import wumpus.board.Board;
import wumpus.board.Position;
import wumpus.elements.Player;

public class PlayerTest {

	@Test
	public void test() throws Exception {
		
		Board b = new Board(4,0,2);

		b.getPlayer().go();
		Assert.assertTrue(b.getPlayer().getPosition().equals(new Position(1,3)));
		b.getPlayer().shoot();
		b.getPlayer().shoot();
		Assert.assertTrue(b.getPlayer().getNumberOfArrows()==0);
	}

}
