package wumpus.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wumpus.board.Position;
import wumpus.elements.Wumpus;

public class WumpusTest {


	@Test
	public void deadAfterShoot() {
		Wumpus w = new Wumpus(new Position(1,1));
		Assert.assertTrue(w.isAlive()==true);
		Assert.assertTrue(w.toString().equals("Wumpus is here"));
		w.kill();
		Assert.assertTrue(w.isAlive()==false);
		Assert.assertTrue(w.toString().equals("Wumpus lies on the floor"));
	}

}
