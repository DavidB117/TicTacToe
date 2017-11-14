/**
 * Program Name:	CellValues.java
 * Purpose:				Enumerated values for Cell contents.
 * Coder:					David Ball
 * Date:					Nov 13, 2017
 */

package ca.davidrobertball.tictactoeconsole;

public enum CellValues {
	EMPTY(' '),
	NOUGHT('O'),
	CROSS('X');
	
	//Attributes
	private char value;
	
	//Constructors
	private CellValues(char c) {
		value = c;
	}
	
	//Utility Methods
	public char getValue() {
		return value;
	}
	
	public String toString() {
		return Character.toString(value);
	}
}//End of class.