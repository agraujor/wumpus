package wumpus.board;

public class Position {
	public final static int NORTH = 0;
	public final static int SOUTH = 1;
	public final static int EAST  = 2;
	public final static int WEST  = 3;
	public final static int LEFT  = 0;
	public final static int RIGHT = 1;
	
	public final static String[] cardinalPoints ={"north","south","east","west"};
	
	private int x;
	private int y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
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
