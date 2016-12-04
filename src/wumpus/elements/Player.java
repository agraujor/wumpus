package wumpus.elements;

import wumpus.board.Board;
import wumpus.board.Position;

public class Player extends Element{

	
	private int orientation;
	private int numberOfArrows;
	private Position position;
	private Board b;
	private boolean alive;
	private boolean carriesGold;
	
	public Player(Position position, int nArrows){
		this.orientation = Position.EAST;
		this.position = position;
		this.numberOfArrows = nArrows;
		this.alive = true;
		this.carriesGold = false;
	}
	public void setBoard(Board b){
		this.b = b;
	}
	public boolean carriesGold(){
		return carriesGold;
	}
	public void setCarriesGold(boolean n){
		carriesGold = n;
	}
	
	public boolean isAlive(){
		return alive;
	}
	public void turn(int turn){
	
		switch(orientation){
			case Position.NORTH:
				if (turn == Position.LEFT)
					orientation= Position.WEST;
				else
					orientation = Position.EAST;
			
			break;
			case Position.SOUTH:
				if (turn == Position.LEFT)
					orientation =  Position.EAST;
				else
					orientation =  Position.WEST;
			
			break;
			case Position.EAST:
				if (turn ==  Position.LEFT)
					orientation= Position.NORTH;
				else
					orientation = Position.SOUTH;
	
			break;
			case Position.WEST:
				if (turn ==  Position.LEFT)
					orientation= Position.SOUTH;
				else
					orientation = Position.NORTH;
			
			break;
			default:		
		}	
	}
	public void go(){
		int posX = position.getX();
		int posY = position.getY();
		
		switch(this.orientation){
			case  Position.NORTH:
				if(posY==0)
					System.out.println("Oops! There is a wall blocking the way.");
				else
					position.setY(posY-1);
				
				break;
			case  Position.SOUTH:
				if(posY==b.getN()-1)
					System.out.println("Oops! There is a wall blocking the way.");
				else
					position.setY(posY+1);
		
				break;
			case Position.WEST:
				if(posX==0)
					System.out.println("Oops! There is a wall blocking the way.");
				else
					position.setX(posX-1);
				
				break;
			case Position.EAST:
				if(posX==b.getN()-1)
					System.out.println("Oops! There is a wall blocking the way.");
				else
					position.setX(posX+1);
				
				break;
			default:
		}
		Element e =b.getSection(position).giveMePitOrWumpus();
		
		if(e instanceof Wumpus){
			alive = false;
			System.out.println("Wumpus kills you without mercy.END.");
		}
		if(e instanceof Pit){
			alive = false;
			System.out.println("You fall into an endless pit.END.");
		}
	}

	public void shoot(){
		if(numberOfArrows>0){
			numberOfArrows--;
			Position positionWumpus = b.getWumpus().getPosition();
			System.out.println("Shooting towards "+Position.cardinalPoints[orientation]);
			switch(this.orientation){
			case Position.SOUTH:
				if((positionWumpus.getX()==position.getX())&&(positionWumpus.getY()>position.getY()))
					b.getWumpus().matar();		
				break;
			case Position.NORTH:
				if((positionWumpus.getX()==position.getX())&&(positionWumpus.getY()<position.getY()))
					b.getWumpus().matar();
				break;
			case Position.WEST:
				if((positionWumpus.getX()<position.getX())&&(positionWumpus.getY()==position.getY()))
					b.getWumpus().matar();
				break;
			case Position.EAST:
				if((positionWumpus.getX()>position.getX())&&(positionWumpus.getY()==position.getY()))
					b.getWumpus().matar();
				break;
				
			}
		}
		else
			System.out.println("There are no more arrows.");
	}
	/**
	 * @return the numberOfArrows
	 */
	public int getNumberOfArrows() {
		return numberOfArrows;
	}
	/**
	 * @param numberOfArrows the numberOfArrows to set
	 */
	public void setNumberOfArrows(int numberOfArrows) {
		this.numberOfArrows = numberOfArrows;
	}
	/**
	 * @return the position
	 */
	public Position getPosition() {
	
		return position;
	}

	@Override
	public String toString(){
		return "Pj";
	}
}
