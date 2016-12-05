package wumpus.main;

import wumpus.controller.Controller;

public class Main {
	
	//GAME CONSTANTS
	static final int SIZE 		= 2;
	static final int PITS 		= 1;
	static final int ARROWS 	= 4;
	
	public static void main(String[] args) {

		Controller c = new Controller(); 
		c.loadGame(SIZE,PITS,ARROWS);
	}

}
