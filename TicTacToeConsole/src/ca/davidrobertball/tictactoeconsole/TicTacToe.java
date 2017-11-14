/**
 * Program Name:	TicTacToe.java
 * Purpose:				Contains rules for the Tic Tac Toe game and
 * 								the main method to run the game.
 * Coder:					David Ball, 0692323
 * Date:					Nov 13, 2017
 */

package ca.davidrobertball.tictactoeconsole;

public class TicTacToe {
	//Attributes
	Board board;
	Player player1;
	Player player2;
	boolean multiplayer;
	
	//Constructors
	public TicTacToe(){
		board = new Board();
		startGame();
	}
	
	//Utility Functions
	public void startGame() {
		printWelcomeMessage();
		printMainMenu();
	}
	
	public void printWelcomeMessage() {
		System.out.println("Tic Tac Toe\n-----------\n");
		
		
	}
	
	public void printMainMenu() {
		System.out.println("Main Menu");
		System.out.println("\t1) One Player Game");
		System.out.println("\t2) Two Player Game");
		System.out.println("\t3) How To Play");
		System.out.println("\t4) Exit");
	}
	
	public void printHelp() {
		
	}
	
	public void player1Turn() {
		
	}
	
	public void player2Turn() {
		
	}
	
	public void computerTurn() {
		
	}
	
	public void printGameOver() {
		System.out.println("Game Over");
		System.out.println("\t1) Continue Playing");
		System.out.println("\t2) Main Menu");
		System.out.println("\t3) Exit");
	}
	
	public static void main(String[] args) {
		//Create a TicTacToe object and run the game.
		
		
	}//End of main method.
}//End of class.