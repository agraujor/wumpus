package wumpus.board;

import wumpus.elements.ElementFactory;
import wumpus.elements.Environment;
import wumpus.elements.Gold;
import wumpus.elements.Pit;
import wumpus.elements.Player;
import wumpus.elements.Wumpus;
import wumpus.elements.Element;

public class Board {
	private Section[][] board;

	private Wumpus		wumpus;		//THESE REFERENCES ARE USED TO FIND QUICKLY WUMPUS AND PLAYER 
	private Player		pj;			//
		
	public Board(int n, int nPits, int nArrows) throws Exception{
		
		if(n*n-1 > nPits){ 			
			//INICIALIZAMOS board	
			board = new Section[n][n];
			for(int i =0;i<n;i++)			
				for(int j=0;j<n;j++)
					board[i][j] = new Section();
			//CREAMOS SALIDA
			board[0][n-1].add(ElementFactory.createExit());
			//CREAMOS PJ
			pj = ElementFactory.createPlayer(new Position(0,n-1),nArrows);
			pj.setBoard(this);		

			//CREAMOS ORO
			while(!ElementFactory.isGoldCreated()){
				int x = (int) (Math.random() * n);
				int y = (int) (Math.random() * n);
				if ((x!=0)&&(y!=n-1)){
					board[x][y].add(ElementFactory.createGold());
				}
			}
			//CREAMOS WUMPUS
			boolean wumpusCreado = false;
			while(!ElementFactory.isWumpusCreated()){
				int x = (int) (Math.random() * n);
				int y = (int) (Math.random() * n);
				if ((x!=0)&&(y!=n-1)){
					wumpus = ElementFactory.createWumpus(new Position(x,y));
					putElementWithEffect(x,y,wumpus);		
				}
			}
			//PONEMOS POZOS
			ElementFactory.setPozosPosibles(nPits);
			while(ElementFactory.getPitsLeft()>0){				
				int x = (int) (Math.random() * n);
				int y = (int) (Math.random() * n);
				if (board[x][y].posiblePonerPozo())
					putElementWithEffect(x,y,ElementFactory.createPit());		
			}
		}
		else{
			throw new Exception();
		}
	}
	public Section getSection(Position position){
		return board[position.getX()][position.getY()];
	}

	public boolean pjIsAlive(){
		return pj.isAlive();
	}
	
	public Wumpus getWumpus(){
		return wumpus;
	}
	
	public void putElementWithEffect(int x, int y, Element element){

		board[x][y].add(element);
		int type;
		if (element instanceof Pit)
			type = Environment.BREEZE;
		else
			type = Environment.STINK;
		
		if (x>0){
			board[x-1][y].add(ElementFactory.createEnviroment(type));
		}
		if (x<board.length-1){
			board[x+1][y].add(ElementFactory.createEnviroment(type));
		}
		if (y>0){
			board[x][y-1].add(ElementFactory.createEnviroment(type));
		}
		if (y<board.length-1){
			board[x][y+1].add(ElementFactory.createEnviroment(type));
		}
	}
	public void turn(int turn){
		pj.turn(turn);
	}
	public void go(){
		pj.go();
	}
	public void removeElement(int x,int y, Element ele){
		board[x][y].remove(ele);
	}
	public void ponerPj(int x,int y){
		board[x][y].add(pj);
	}	
	public String descripcionCasilla(){
		Position pos = pj.getPosition();
		String s = board[pos.getX()][pos.getY()].toString();
		if (board[pos.getX()][pos.getY()].getGoldIfPosible()){
			board[pos.getX()][pos.getY()].remove(new Gold());
			pj.setCarriesGold(true);
		}
		return s;
	}
	public int getN(){
		return board.length;
	}
	public void disparar(){
		pj.shoot();
	}
}
