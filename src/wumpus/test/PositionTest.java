package wumpus.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import wumpus.board.Position;

public class PositionTest {

	@Test
	public void test() {
		Position p = new Position(4,4,Position.NORTH);
		
		Assert.assertTrue(p.checkShoot(new Position(4,1)));
		Assert.assertTrue(!p.checkShoot(new Position(2,1)));
		
		p.turn(Position.LEFT);
		Assert.assertTrue(p.getDirection()==Position.WEST);
		
		p.turn(Position.RIGHT);
		Assert.assertTrue(p.getDirection()==Position.NORTH);
		p.turn(Position.RIGHT);
		Assert.assertTrue(p.go(7));
		Assert.assertTrue(p.equals(new Position(5,4)));
		Assert.assertTrue(!p.go(3));
		
		
	}

}
