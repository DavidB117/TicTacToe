/**
 * Program Name:	Cell.java
 * Purpose:				The Cells that make up the game Board.
 * Coder:					David Ball
 * Date:					Nov 13, 2017
 */

package ca.davidrobertball.tictactoeconsole;

public class Cell {
	//Attributes
	private CellValues value;
	private int row;
	private int column;
	
	//Constructors
	public Cell(int r, int c) {
		value = CellValues.EMPTY;
		row = r;
		column = c;
	}
	
	//Getters and Setters
	public CellValues getValue() {
		return value;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return column;
	}
	public void setValue(CellValues value) {
		this.value = value;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.column = col;
	}

	//Utility Methods
	public String toString() {
		return value.toString();
	}
}//End of class.