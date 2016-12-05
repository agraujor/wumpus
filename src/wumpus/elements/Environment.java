package wumpus.elements;

public class Environment extends Element{
	public static final int BREEZE = 0;
	public static final int STINK = 1;
	
	private int type;
	public Environment(int type){
		this.type = type;
		switch(type){
			case BREEZE:
				this.setDescription("Breeze");
				break;
			case STINK:
				this.setDescription("Stink");
				break;
			default:			
		}

	}
	
}
