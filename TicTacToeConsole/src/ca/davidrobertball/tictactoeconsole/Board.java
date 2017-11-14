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
		//If there is no winner then return EMPTY.
		CellValues cv = CellValues.EMPTY;
		
		//Check every row.
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < (columns - 1); c++) {
				//Process every column in each row.
				if(cells[r][c].getValue() == cells[r][c + 1].getValue()) {
					cv = cells[r][c].getValue();
				} else {
					cv = CellValues.EMPTY;
					break;
				}
			}
		}
		
		//Check every column.
		for(int c = 0; c < columns; c++) {
			for(int r = 0 ; r < (rows - 1); r++) {
				if(cells[r][c].getValue() == cells[r + 1][c].getValue()) {
					cv = cells[r][c].getValue();
				} else {
					cv = CellValues.EMPTY;
					break;
				}
			}
		}
		
		//Check both diagonals.
		
		
		return cv;
	}
	
	//Utility Methods
	public boolean checkDraw() {
		//Call this method after checkWin to see if there is a winner first.
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				//If the board doesn't contain an empty cell then it is a draw.
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