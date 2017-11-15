/**
 * Program Name:	Player.java
 * Purpose:				Represents players involved in the game.
 * Coder:					David Ball
 * Date:					Nov 14, 2017
 */

package ca.davidrobertball.tictactoeconsole;

public class Player {
	//Attributes
	private String name;
	private int wins;
	private CellValues piece;
	
	//Constructors
	public Player(String n, CellValues p) {
		name = n;
		wins = 0;
		piece = p;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public int getWins() {
		return wins;
	}
	public CellValues getPiece() {
		return piece;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public void setPiece(CellValues piece) {
		this.piece = piece;
	}
	
	//Utility Methods
	public void printPlayer() {
		System.out.println(name + " is " + piece.toString());
	}
	
	public void printWins() {
		System.out.println(name + ": " + wins);
	}
}//End of class.