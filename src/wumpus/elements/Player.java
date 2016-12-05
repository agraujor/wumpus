package wumpus.elements;

import wumpus.board.Board;
import wumpus.board.Position;

public class Player extends Element{

	
	private int numberOfArrows;
	private Position position;
	private Board b;
	private boolean alive;
	private boolean carriesGold;
	
	public Player(Position position, int nArrows){

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
		this.position.turn(turn);
	}
	
	//MOVES AND KILLS PLAYER IF WUMPUS/PIT IS THERE
	public void go(){
		
		if(position.go(b.getN())){
			Element e =b.getSection(position).giveMePitOrWumpus();		
			if(e instanceof Wumpus){
				Wumpus w = (Wumpus)e;
				if (w.isAlive()){
					alive = false;
					System.out.println("Wumpus kills you without mercy.END.");
				}
			}
			if(e instanceof Pit){
				alive = false;
				System.out.println("You have fallen into an endless pit.END.");
			}
		}
		else
			System.out.println("Ooops, there is a wall on your way.");
	}

	//SHOT AND KILLS WUMPUS IF IT'S POSIBLE
	public void shoot(){
		if(numberOfArrows>0){
			numberOfArrows--;
			Position positionWumpus = b.getWumpus().getPosition();
			if (position.checkShoot(positionWumpus))
				b.getWumpus().kill();
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

}
