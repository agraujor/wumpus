package wumpus.test;

import static org.junit.Assert.*;

import org.junit.Test;

import wumpus.elements.Element;
import wumpus.elements.Environment;

public class EnvironmentTest {

	@Test
	public void test() {
		Element e1 = new Environment(Environment.BREEZE);
		Element e2 = new Environment(Environment.STINK);
		
		assertTrue(e1.getDescription().equals("Breeze"));
		assertTrue(e2.getDescription().equals("Stink"));
	}

}
