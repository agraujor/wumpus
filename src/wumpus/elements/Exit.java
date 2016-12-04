package wumpus.elements;

public class Exit extends Element{
	public Exit(){
		this.setDescription("salida");
	}
	
	public String toString(){
		return this.getDescription();
	}
}
