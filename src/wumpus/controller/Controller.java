package wumpus.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import wumpus.board.Board;
import wumpus.board.Position;

public class Controller {
	public void loadGame(int nMax,int nPits,int nArrows){
		boolean goOn = true;
		String s;
		InputStreamReader ir	= new InputStreamReader(System.in);
		BufferedReader in 		= new BufferedReader(ir);
		
		try{
			
			Board b = new Board(nMax,nPits,nArrows);
			
			
			do{
				System.out.println(b.describeSection());
				goOn = processInput(b,in.readLine());
				
				if (goOn)
					goOn = b.pjIsAlive();
			}while (goOn);
			
			in.close();
			
			if (winningCondition(b))
				System.out.println("Congrats! You left the maze with the gold.");
			else
				System.out.println("You have lost.");
		}catch(IOException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean winningCondition(Board b){
		return b.pjHasGold()&&b.tryToExit();
	}
	
	public boolean processInput(Board b, String s){
		boolean  goOn = true;
		switch(s.toLowerCase()){
			case "q":
				goOn = false;
				break;
			case "l":
				b.turn(Position.LEFT);
				break;
			case "r":
				b.turn(Position.RIGHT);
				break;
			case "g":
				b.go();
				break;
			case "s":
				b.shoot();
				break;
			case "e":
				if( b.tryToExit())
					goOn = false;
				break;
		}	

		return goOn;
		
	}
}
