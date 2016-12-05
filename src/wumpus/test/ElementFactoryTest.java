package wumpus.test;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import wumpus.board.Position;
import wumpus.elements.ElementFactory;

public class ElementFactoryTest {

	@Test
	public void test() {
		ElementFactory.setPosiblePits(2);
		ElementFactory.setPosiblePits(4);
		
		assertTrue(ElementFactory.createPit()!=null);
		assertTrue(ElementFactory.createPit()!=null);
		assertTrue(ElementFactory.createPit()==null);
		
		assertTrue(ElementFactory.createGold()!=null);
		assertTrue(ElementFactory.createGold()==null);
		
		assertTrue(ElementFactory.createExit()!=null);
		assertTrue(ElementFactory.createExit()==null);
	
		assertTrue(ElementFactory.createWumpus(new Position(2,2))!=null);
		assertTrue(ElementFactory.createWumpus(new Position(2,5))==null);
		
		assertTrue(ElementFactory.createPlayer(new Position(2,2),3)!=null);
		assertTrue(ElementFactory.createPlayer(new Position(2,5),3)==null);
		
	}

}
