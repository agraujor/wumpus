package wumpus.test;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.Assert;

import wumpus.board.Board;
import wumpus.board.Position;
import wumpus.board.Section;
import wumpus.elements.Element;
import wumpus.elements.ElementFactory;
import wumpus.elements.Pit;
import wumpus.elements.Wumpus;

public class BoardTest {


	@Test
	public void testBoardException() {

		try {
			Board b = new Board(4,3,0);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBoard() throws Exception {
		int nPits =1;
		int nDim  = 3;
		int nArrow= 4;
		

		Board b = new Board(nDim,nPits,nArrow);

		int testNPits 		= 0;
		int testWumpus		= 0;
		int testExit		= 0;
		int testGold 		= 0;
		boolean stinkyFlag  = true;
		
		for(int i= 0;i<nDim;i++)
			for(int j = 0;j<nDim;j++){
				Section s = b.getSection(new Position(i,j));
				Element e = s.giveMePitOrWumpus();
				if(e instanceof Wumpus)
					testWumpus++;
				if(e instanceof Pit)
					testNPits++;
				if(s.getGoldIfPosible())
					testGold++;
				if(s.exitIsHere())
					testExit++;
			}
		Wumpus w = b.getWumpus();
		Position pos = w.getPosition();
		if (pos.getX()>0)
			stinkyFlag = stinkyFlag && (b.getSection(new Position(pos.getX()-1,pos.getY())).toString().indexOf("Stink") !=-1);
		if (pos.getX()<b.getN()-1)
			stinkyFlag= stinkyFlag &&(b.getSection(new Position(pos.getX()+1,pos.getY())).toString().indexOf("Stink") !=-1);					
		if (pos.getY()>0)
			stinkyFlag = stinkyFlag &&(b.getSection(new Position(pos.getX(),pos.getY()-1)).toString().indexOf("Stink") !=-1);
		if (pos.getY()<b.getN()-1)
			stinkyFlag= stinkyFlag&&(b.getSection(new Position(pos.getX(),pos.getY()+1)).toString().indexOf("Stink") !=-1);
		
		
		assertTrue(testWumpus == 1);
		assertTrue(testNPits == nPits);
		assertTrue(testExit == 1);
		assertTrue(testGold == 1);
		assertTrue(stinkyFlag);
	}

}
