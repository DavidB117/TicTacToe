/**
 * Program Name:	TicTacToe.java
 * Purpose:				Contains rules for the Tic Tac Toe game and
 * 								the main method to run the game.
 * Coder:					David Ball, 0692323
 * Date:					Nov 13, 2017
 */

//TODO Implement a displayBoard to show quadrants. This is how the user will select where to place game piece.

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
	public void initialize() {
		welcomeMessage();
		mainMenu();
	}
	
	private void welcomeMessage() {
		System.out.println("\tTic Tac Toe\n\t-----------");
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
		switch(option) {
		case 1:
			multiplayer = false;
			startGame();
			break;
		case 2:
			multiplayer = true;
			startGame();
			break;
		case 3:
			help();
			break;
		default:
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
	
	private void startGame() {
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
		
		//Run the game.
		runGame();
	}
	
	private void runGame() {
		//Display player information.
		System.out.println();
		player1.printPlayer();
		player2.printPlayer();
		System.out.println();
		//Display the game board.
		System.out.println("Game Board:");
		board.printBoard();
		System.out.println();
		
		//Run the game logic until there is a winner or a draw.
		CellValues winner = CellValues.EMPTY;
		while(winner == CellValues.EMPTY) {
			//Player 1's turn.
			playerTurn(player1);
			board.printBoard();
			//Player 2's turn (OR computer's turn).
			if(multiplayer) { playerTurn(player2); }
			else { computerTurn(); }
			board.printBoard();
			//Check if there is a winner.
			winner = board.checkWin();
			//Check if there is a draw.
			if(board.checkDraw()) {
				System.out.println("The game is a draw.");
				break;
			}
		}
		//Once there is a winner or the game is a draw, add to wins, and print game over menu.
		if(winner == player1.getPiece()) {
			System.out.println(player1.getName() + " (" + player1.getPiece().toString() + "'s) is the winner!");
			player1.printWins();
			player1.setWins(player1.getWins() + 1);
		} else if(winner == player2.getPiece()) {
			System.out.println(player2.getName() + " (" + player2.getPiece().toString() + "'s) is the winner!");
			player2.printWins();
			player2.setWins(player2.getWins() + 1);
		}
		System.out.println();
		gameOver();
	}
	
	private String getPlayerName() {
		String name = "";
		try { name = in.readLine(); }
		catch (IOException e) { System.out.println(e.getMessage()); }
		return name;
	}
	
	private void playerTurn(Player p) {
		
	}
	
	private void computerTurn() {
		
	}
	
	private void gameOver() {
		System.out.println("Game Over");
		System.out.println("\t1) Continue Playing");
		System.out.println("\t2) Main Menu");
		System.out.println("\t3) Exit");
		System.out.print("Option: ");
		int option = ValidateInput.getInt(1, 3);
		System.out.println();
		
		//Run option chosen by the user.
		switch(option) {
		case 1:
			runGame();
			break;
		case 2:
			board.clear();
			player1.setWins(0);
			player2.setWins(0);
			break;
		default:
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		//Create a TicTacToe object and run the game.
		TicTacToe game = new TicTacToe();
		game.initialize();
	}//End of main method.
}//End of class.