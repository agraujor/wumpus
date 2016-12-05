package wumpus.elements;

import wumpus.board.Position;

public class Wumpus extends Element{
	private Position position;
	private boolean alive;
	
	public Wumpus(Position position){
		this.setDescription("Wumpus is here");
		this.position = position;
		alive= true;
	}
	public void kill(){
		if (alive){
			alive = false;
			System.out.println("A scream is heard in the distance: ROAAARRRRRRRRRRR.");
			this.setDescription("Wumpus lies on the floor");		
		}
	}
	
	public Position getPosition(){
		return position;
	}
	
	public void setPosition(Position position){
		this.position = position;
	}

	public boolean isAlive(){
		return alive;				
	}
	
}
