/**
 * Program Name:	TicTacToe.java
 * Purpose:				Contains rules for the Tic Tac Toe game and
 * 								the main method to run the game.
 * Coder:					David Ball, 0692323
 * Date:					Nov 13, 2017
 */

package ca.davidrobertball.tictactoeconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
	//Attributes
	Board board;
	Player player1;
	Player player2;
	boolean multiplayer;
	BufferedReader in;
	
	//Constructors
	public TicTacToe(){
		board = new Board();
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	//Utility Functions
	public void startGame() {
		welcomeMessage();
		mainMenu();
	}
	
	private void welcomeMessage() {
		System.out.println("Tic Tac Toe\n-----------");
		System.out.println("Welcome to the console version of Tic Tac Toe.");
		System.out.println("You can play against the computer or play against a friend.\n");
	}
	
	private void mainMenu() {
		System.out.println("Main Menu");
		System.out.println("\t1) One Player Game");
		System.out.println("\t2) Two Player Game");
		System.out.println("\t3) How To Play");
		System.out.println("\t4) Exit");
		System.out.print("Option: ");
		int option = ValidateInput.getInt(1, 4);
		System.out.println();
		
		//Run option chosen by the user.
		if(option == 1) {
			multiplayer = false;
			runGame();
		} else if(option == 2) {
			multiplayer = true;
			runGame();
		} else if(option == 3) {
			help();
		} else {
			System.exit(0);
		}
	}
	
	private void help() {
		System.out.println("How To Play\n-----------");
		System.out.println("Tic Tac Toe is traditionally played on a 3x3 square board.");
		System.out.println("Many people refer to the games as X's and O's.");
		System.out.println("Players play as either a cross (X) or a nought (0).");
		System.out.println("The goal is to get a row, column, or a diagonal line filled");
		System.out.println("with your game piece (X or O). Be sure to block your opponent");
		System.out.println("from getting a win if you spot their strategy.");
		System.out.println("Player 1 will play as cross (X) and player 2 will play as");
		System.out.println("nought (O).\n");
		mainMenu();
	}
	
	private void runGame() {
		//Get player1 name.
		System.out.print("Enter name for Player 1: ");
		String name = getPlayerName();
		player1 = new Player(name, CellValues.CROSS);
		
		//Initialize player 2 based on menu choice.
		if(multiplayer) {
			System.out.print("Enter name for Player 2: ");
			name = getPlayerName();
			player2 = new Player(name, CellValues.NOUGHT);
		} else {
			player2 = new Player("COMPUTER", CellValues.NOUGHT);
		}
		
		//Display player information.
		System.out.println();
		player1.printPlayer();
		player2.printPlayer();
		System.out.println();
	}
	
	private String getPlayerName() {
		String name = "";
		try { name = in.readLine(); }
		catch (IOException e) { System.out.println(e.getMessage()); }
		return name;
	}
	
	private void player1Turn() {
		
	}
	
	private void player2Turn() {
		
	}
	
	private void computerTurn() {
		
	}
	
	private void gameOver() {
		System.out.println("Game Over");
		System.out.println("\t1) Continue Playing");
		System.out.println("\t2) Main Menu");
		System.out.println("\t3) Exit");
	}
	
	public static void main(String[] args) {
		//Create a TicTacToe object and run the game.
		TicTacToe game = new TicTacToe();
		game.startGame();
	}//End of main method.
}//End of class.