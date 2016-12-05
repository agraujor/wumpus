package wumpus.elements;

import wumpus.board.Position;

public class ElementFactory {
	
	private static boolean 	playerCreated   = false;
	private static boolean 	goldCreated 	= false;
	private static boolean 	exitCreated 	= false;
	private static boolean 	wumpusCreated 	= false;
	private static int		pitsCreated 	= 0;
	private static int		posiblePits		= 0;
	private static boolean  pitsLocked  	= false;
	
	static public Pit createPit(){					//IT IS ONLY POSIBLE TO CREATE A FIXED NUMBER OF PITS
		
		if (pitsCreated < posiblePits){
			pitsCreated++;
			return new Pit();}
		else
			return null;
	}

	static public void setPosiblePits(int nPits){      //IT IS ONLY POSIBLE TO SET PITS ONCE (AFTER THAT IS LOCKED)
		if (!pitsLocked){
			posiblePits = nPits;
			pitsLocked  = true;
		}
	}
	static public int getPitsLeft(){
		return posiblePits-pitsCreated;
	}
	
	static public boolean isGoldCreated(){
		return goldCreated;
	}
	static public boolean isWumpusCreated(){
		return wumpusCreated;
	}
	static public boolean isExitCreated(){
		return exitCreated;
	}
	
	static public Wumpus createWumpus(Position position){		//ONLY ONE WUMPUS IS ALLOWED				
		if (!wumpusCreated){													
			wumpusCreated = true;
			return new Wumpus(position);
		}
		else
			return null;	
	}
	static public Gold createGold(){		//ONLY ONE GOLD BAR IS ALLOWED 		
		if (!goldCreated){
			goldCreated = true;
			return new Gold();
		}
		else
			return null;	
	}
	static public Player createPlayer(Position position, int arrows){	//ONLY ONE PLAYER IS ALLOWED
		if (!playerCreated){
			playerCreated = true;

			return new Player(position,arrows);
		}
		else
			return null;
	}
	static public Exit createExit(){	//ONLY ONE EXIT IS ALLOWED
		if (!exitCreated){
			exitCreated = true;
			return new Exit();
		}
		else
			return null;
	}
	
	static public Environment createEnviroment(int type){
		return new Environment(type);
	}
}


