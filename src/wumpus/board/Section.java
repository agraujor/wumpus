package wumpus.board;

import java.util.HashSet;
import wumpus.elements.Element;
import wumpus.elements.Exit;
import wumpus.elements.Gold;
import wumpus.elements.Pit;
import wumpus.elements.Player;
import wumpus.elements.Wumpus;
public class Section {

	
	private HashSet<Element> occupiedBy;
	
	public Section(){
	
		occupiedBy = new HashSet();
	}
	
	public void add(Element element){
		occupiedBy.add(element);
	}
	public void remove(Element element){
		occupiedBy.remove(element);
	}
	
	public boolean isEmpty(){
		return occupiedBy.isEmpty();
	}
	
	public boolean posiblePonerPozo(){
		boolean posible = true;
		for(Element e:occupiedBy){
			if ((e instanceof Exit)||(e instanceof Wumpus)||(e instanceof Player)||(e instanceof Pit)||(e instanceof Gold)){
				posible = false;
				break;
			}
		}
		return posible;
	}
	public boolean getGoldIfPosible(){
		boolean posible = false;
		for(Element e:occupiedBy){
			if (e instanceof Gold){
				posible = true;
				break;
			}
		}
		return posible;
	}
	public Element giveMePitOrWumpus(){
		for(Element e:occupiedBy){
			if ((e instanceof Pit)||(e instanceof Wumpus)){
				return e;
			}
		}
		return null;
	}
	
	@Override
	public String toString(){
		String txt = "";
		if (occupiedBy.isEmpty())
			txt="There is nothing in this room.";
		for(Element e : occupiedBy){
			txt = txt+e.toString()+"." +System.lineSeparator();
		}
		return txt;
	}
}
