package wumpus.test;

import static org.junit.Assert.*;

import org.junit.Test;

import wumpus.elements.Element;

public class ElementTest {

	@Test
	public void test() {
		String s ="fdsf";
		Element e = new Element();
		
		e.setDescription(s);
		
		assertTrue(s.equals(e.getDescription()));
	}

}
