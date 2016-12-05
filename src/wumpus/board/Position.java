package wumpus.board;

public class Position {
	public final static int NOT_ORIENTED = -1;
	public final static int NORTH = 0;
	public final static int EAST  = 1;
	public final static int SOUTH = 2;
	public final static int WEST  = 3;
	
	public final static Position GO_NORTH 	= new Position(0,-1);
	public final static Position GO_EAST 	= new Position(1,0);
	public final static Position GO_SOUTH 	= new Position(0,1);
	public final static Position GO_WEST 	= new Position(-1,0);
	
	public final static int LEFT  = 0;
	public final static int RIGHT = 1;
	
	
	public final static String[] 	cardinalPoints ={"north","east","south","west"}; 
	public final static Position[]	toward ={GO_NORTH,GO_EAST,GO_SOUTH,GO_WEST};
	
	private int x;
	private int y;

	private int direction;
	
	public Position(int x, int y,int direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Position(int x, int y){
		this.x = x;
		this.y = y;
		this.direction = NOT_ORIENTED;
	}
	
	//SET DIRECTION IN FUNCTION OF LEFT OF RIGHT(NOTICE CLOCKWISE WHEN CHANGING DIRECTION (-- OR ++))
	public void turn(int side){
		if (direction !=NOT_ORIENTED){
			if (side == RIGHT){
				if (direction==WEST)
					direction=NORTH;
				else
					direction++;
			}else{
				if (direction==NORTH)
					direction=WEST;
				else
					direction--;
			}
		}
	}
	//WALKS-> CHANGE POSITION IF IT'S POSIBLE RETURNING TRUE OR FALSE
	public boolean go(int max){
		boolean posible=false;
		
		int newX = toward[direction].getX()+this.x;
		int newY = toward[direction].getY()+this.y;
			
		if ((newX>=0)&&(newX<max)&&(newY>=0)&&(newY<max)){
			posible = true;
			this.x = newX;
			this.y = newY;
		}	
		return posible;
	}
	
	//CHECKS IF SHOT CAN KILL OBJECTIVE
	public boolean checkShoot(Position objective){
		System.out.println("Shooting towards "+Position.cardinalPoints[direction]);
		switch(this.direction){
		case Position.SOUTH:
			if((objective.getX()==x)&&(objective.getY()>y))
				return true;		
			break;
		case Position.NORTH:
			if((objective.getX()==x)&&(objective.getY()<y))
				return true;
			break;
		case Position.WEST:
			if((objective.getX()<x)&&(objective.getY()==y))
				return true;
			break;
		case Position.EAST:
			if((objective.getX()>x)&&(objective.getY()==y))
				return true;
			break;
		default:
			
		}
		return false;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public int getDirection() {
		return direction;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
