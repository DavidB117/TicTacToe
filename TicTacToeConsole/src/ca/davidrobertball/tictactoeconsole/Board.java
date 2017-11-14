/**
 * Program Name:	Board.java
 * Purpose:				Stores values for TicTacToe game.
 * Coder:					David Ball
 * Date:					Nov 14, 2017
 */

package ca.davidrobertball.tictactoeconsole;

public class Board {
	//Attributes
	private Cell cells[][];
	private int rows;
	private int columns;
	
	//Constructors
	public Board() {
		cells = new Cell[rows][columns];
		//Initialize the value for each cell.
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				cells[r][c] = new Cell(r, c);
			}
		}
	}
	
	//Getters and Setters
	public CellValues getBoard(int r, int c) {
		//User input is validated in the TicTacToe class.
		return cells[r][c].getValue();
	}
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setBoard(int r, int c, CellValues cv) {
		//User input is validated in the TicTacToe class.
		cells[r][c].setValue(cv);
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public CellValues checkWin() {
		//Variables to hold row and column values;
		int r;
		int c;
		
		//Check every row.
		for(r = 0; r < rows; r++) {
			for(c = 0; c < (columns - 1); c++) {
				//If that value is the same as the next value, continue.
				if(cells[r][c].getValue() == cells[r][c + 1].getValue()) {
					//If we have compared every value including the last value in the row, return that value.
					if((c + 1) == (columns - 1)) {
						return cells[r][c].getValue();
					}
				} else {
					//If there is ever a value that doesn't match break from the loop.
					break;
				}
			}
		}
		
		//Check every column.
		for(c = 0; c < columns; c++) {
			for(r = 0 ; r < (rows - 1); r++) {
				if(cells[r][c].getValue() == cells[r + 1][c].getValue()) {
					//If all the values have matched then return that value as the winner.
					if((r + 1) == (rows - 1)) {
						return cells[r][c].getValue();
					}
				} else {
					break;
				}
			}
		}
		
		//Check both diagonals.
		//Top left to bottom right.
		r = 0;
		c = 0;
		while(true) {
			//Then check if tthe current value equals the next value.
			if(cells[r][c].getValue() == cells[r + 1][c + 1].getValue()) {
				//If so, and we have compared the last value, then return the value.
				if((r + 1) == (rows - 1) && (c + 1) == (columns - 1)) {
					return cells[r][c].getValue();
				}
			} else {
				//If not, break out of  loop.
				break;
			}
			//Increment the row and column values.
			r++;
			c++;
		}
		
		//Top right to bottom left.
		r = 0;
		c = columns - 1;
		while(true) {
			if(cells[r][c].getValue() == cells[r + 1][c - 1].getValue()) {
				if((r + 1) == (rows - 1) && (c - 1) == 0) {
					return cells[r][c].getValue();
				}
			} else {
				break;
			}
			r++;
			c--;
		}
		
		//Return an EMPTY value if there is no winner.
		return CellValues.EMPTY;
	}
	
	//Utility Methods
	public boolean checkDraw() {
		//Call this method after checkWin to see if there is a winner first.
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				//If the board contains an empty cell then it is not a draw.
				if(cells[r][c].getValue() == CellValues.EMPTY) {
					return false;
				}
			}
		}
		//If there are no empty cells then the game is a draw.
		return true;
	}
	
	public void clear() {
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				cells[r][c].setValue(CellValues.EMPTY);;
			}
		}
	}
	
	public void printBoard() {
		for(int r = 0; r < (rows - 1); r++) {
			//Print row contents.
			rowContents(r);
			//Print horizontal divider.
			rowDivider();
		}
		//Print the last row, with no horizontal divider.
		rowContents(rows - 1);
	}
	
	private void rowContents(int r) {
		rowFormatting();
		int c = 0;
		for(; c < (columns - 1); c++) {
			System.out.print(" " + cells[r][c].toString() + " |");
		}
		System.out.println(" " + cells[r][c].toString());
		rowFormatting();
	}
	
	private void rowFormatting() {
		for(int i = 0; i < (columns - 1); i++) {
			System.out.print("   |");
		}
		System.out.println();
	}
	
	private void rowDivider() {
		for(int i = 0; i < (columns - 1); i++) {
			System.out.print("----");
		}
		System.out.println("---");
	}
}//End of class.