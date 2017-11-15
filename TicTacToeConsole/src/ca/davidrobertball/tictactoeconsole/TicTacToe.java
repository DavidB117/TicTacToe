/**
 * Program Name:	TicTacToe.java
 * Purpose:				Contains rules for the Tic Tac Toe game and
 * 								the main method to run the game.
 * Coder:					David Ball, 0692323
 * Date:					Nov 13, 2017
 */

//TODO	Implement a displayBoard to show quadrants.
//			This is how the user will select where to place game piece.
//			Quadrants are numbered from 1 - 9 (for standard game board). Left to right, top to bottom.

//TODO	computerTurn Algorithm:
//			Find 2 surrounding and take the middle, if empty.
//			Find 2 in a row and take the 3rd, if empty.
//			Impement after attempt to set up multiple options.

package ca.davidrobertball.tictactoeconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
	//Attributes
	private Board board;
	private Player player1;
	private Player player2;
	private boolean multiplayer;
	private int playerTurn;
	private BufferedReader in;
	
	//Constructors
	public TicTacToe(){
		board = new Board();
		in = new BufferedReader(new InputStreamReader(System.in));
		//Call the initialize method to run the program and initialize other attributes.
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
		System.out.println("\t1) Single Player Game");
		System.out.println("\t2) Multiplayer Game");
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
		System.out.println();
		
		//Run the game.
		runGame();
	}
	
	private String getPlayerName() {
		String name = "";
		try { name = in.readLine(); }
		catch (IOException e) { System.out.println(e.getMessage()); }
		return name;
	}
	
	private void runGame() {
		//Print player information and game board.
		printGameInfo();
		
		//Do a coin flip to see which player will go first.
		coinFlip();
		
		CellValues winner = CellValues.EMPTY;
		//Run the game logic until there is a winner or a draw.
		while(winner == CellValues.EMPTY) {
			if(playerTurn == 1) {
				//Player 1's turn.
				System.out.println(player1.getName() + "'s Turn");
				playerTurn(player1);
				board.printBoard();
				System.out.println();
				//Increment so player 2's turn is next.
				playerTurn++;
			} else {
				//Player 2's turn.
				System.out.println(player2.getName() +"'s Turn");
				if(multiplayer) { playerTurn(player2); }
				else { computerTurn(player2); }
				board.printBoard();
				System.out.println();
				//Decrement so player 2's turn is next.
				playerTurn--;
			}
			
			//Check if there is a winner.
			winner = board.checkWin();
			if(winner != CellValues.EMPTY) {
				break;
			}
			//Check if there is a draw.
			if(board.checkDraw()) {
				System.out.println("The game is a draw.");
				break;
			}
		}
		
		//Once there is a winner or the game is a draw, add to wins, and print game over menu.
		if(winner == player1.getPiece()) {
			System.out.println(player1.getName() + " (" + player1.getPiece().toString() + ") is the winner!");
			player1.setWins(player1.getWins() + 1);
		} else if(winner == player2.getPiece()) {
			System.out.println(player2.getName() + " (" + player2.getPiece().toString() + ") is the winner!");
			player2.setWins(player2.getWins() + 1);
		}
		
		//Print player info and call game over menu.
		printPlayerInfo();
		gameOver();
	}
	
	private void coinFlip() {
		System.out.println("Flipping coin...");
		//Generate random with: (int)(Math.random() * (HIGH - LOW + 1) + LOW)
		playerTurn = (int)(Math.random() * (2 - 1 + 1) + 1);
		switch(playerTurn) {
		case 1:
			System.out.println(player1.getName() + " goes first.\n");
			break;
		case 2:
			System.out.println(player2.getName() + " goes first.\n");
			break;
		}
	}
	
	private void printGameInfo() {
		//Display player information.
		player1.printPlayer();
		player2.printPlayer();
		System.out.println();
		//Display the game board.
		System.out.println("Game Board:");
		board.printBoard();
		System.out.println();
	}
	
	private void printPlayerInfo() {
		System.out.println("Wins");
		player1.printWins();
		player2.printWins();
		System.out.println();
	}
	
	private void playerTurn(Player p) {
		System.out.println("Enter coordinates for where you want to place an " + p.getPiece().toString() + ".");
		
		while(true) {
			//Get the location of where the user wants to place their piece.
			System.out.print("Enter row(1 - " + board.getRows() + "): ");
			int row = ValidateInput.getInt(1, board.getRows());
			System.out.print("Enter column(1 - " + board.getColumns() + "): ");
			int column = ValidateInput.getInt(1, board.getColumns());
			System.out.println();
			
			//Check to ensure that the space on the board is available.
			if(board.getBoard(row - 1, column - 1) == CellValues.EMPTY) {
				board.setBoard(row - 1, column - 1, p.getPiece());
				break;
			} else {
				System.out.println("There is already a piece at that location.\n");
			}
		}
	}
	
	private void computerTurn(Player p) {
		//1. Attempt to take the center.
		//	1a. Find the center of the board.
		int row = (board.getRows() / 2);
		int column = (board.getColumns() / 2);
		//	1b. Take the center spot if it is empty.
		if(board.getBoard(row, column) == CellValues.EMPTY) {
			board.setBoard(row, column, p.getPiece());
			return;
		}
		
		//2. Attempt to take 3 corners (set up multiple options).
		//	2a. Set corner values.
		int cornerRowValues[] = {0, 0, (board.getRows() - 1), (board.getRows() - 1)};
		int cornerColumnValues[] = {0, (board.getColumns() - 1), 0, (board.getColumns() - 1)};
		//	2b. Once 3 corners are taken don't take another. Also make sure there is a free corner.
		int cornersTaken = 0;
		boolean freeCorner = false;
		for(int r = 0; r < cornerRowValues.length; r++) {
			for(int c = 0; c < cornerColumnValues.length; c++) {
				if(board.getBoard(cornerRowValues[r], cornerColumnValues[c]) == p.getPiece()) {
					cornersTaken++;
				}
				if(board.getBoard(cornerRowValues[r], cornerColumnValues[c]) == CellValues.EMPTY) {
					freeCorner = true;
				}
			}
		}
		//	2c. Choose corner at random.
		if(cornersTaken < 3 && freeCorner) {
			while(true) {
				int corner = (int)(Math.random() * ((cornerRowValues.length - 1) - 0 + 1) + 0);
				if(board.getBoard(cornerRowValues[corner], cornerColumnValues[corner]) == CellValues.EMPTY) {
					board.setBoard(cornerRowValues[corner], cornerColumnValues[corner], p.getPiece());
					return;
				}
			}
		}
		
		//3. Take adjacent tiles (if there are no spaces left then checkDraw would have been called).
		//	3a. Choose a leftover tile at random.
		while(true) {
			row = (int)(Math.random() * ((board.getRows() - 1) - 0 + 1) + 0);
			column = (int)(Math.random() * ((board.getColumns() - 1) - 0 + 1) + 0);
			if(board.getBoard(row, column) == CellValues.EMPTY) {
				board.setBoard(row, column, p.getPiece());
				return;
			}
		}
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
			board.clear();
			runGame();
			break;
		case 2:
			board.clear();
			mainMenu();
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