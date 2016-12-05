package wumpus.elements;

public class Element {

	private String description;
	
	public void setDescription(String newDescription){
		description = newDescription;
	}
	
	public String getDescription(){
		return description;
	}
	@Override
	public String toString(){
		return getDescription();
	}	

	
}
