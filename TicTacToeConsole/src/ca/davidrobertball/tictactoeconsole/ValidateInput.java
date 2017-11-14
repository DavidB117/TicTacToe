/**
 * Program Name:	ValidateInput.java
 * Purpose:				Contains methods used to validate user input.
 * Coder:					David Ball
 * Date:					Nov 14, 2017
 */

package ca.davidrobertball.tictactoeconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidateInput {
	public static int getInt() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int output = 0;
		while(true) {
			try {
				//Attempt to parse input to int, if fails a NumberFormatException is thrown.
				output = Integer.parseInt(in.readLine());
				//If parseInt fails the return statement is not executed.
				return output;
			} catch(NumberFormatException e) {
				System.out.println("Please enter a valid integer: ");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}//End of validateInt method.
	
	public static int getInt(BufferedReader in) {
		int output = 0;
		while(true) {
			try {
				output = Integer.parseInt(in.readLine());
				return output;
			} catch(NumberFormatException e) {
				System.out.print("Please enter a valid integer: ");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}//End of validateInt method.
	
	public static int getInt(int value) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String errorMessage = "Please enter the integer value " + value + ": ";
		int output = 0;
		while(true) {
			try {
				output = Integer.parseInt(in.readLine());
				//If the input is a valid int, check if it matches the value specified.
				if(output != value) {
					System.out.print(errorMessage);
				} else {
					return output;
				}
			} catch(NumberFormatException e) {
				System.out.print(errorMessage);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}//End of getInt method.
	
	public static int getInt(int value, BufferedReader in) {
		String errorMessage = "Please enter the integer value " + value + ": ";
		int output = 0;
		while(true) {
			try {
				output = Integer.parseInt(in.readLine());
				if(output != value) {
					System.out.print(errorMessage);
				} else {
					return output;
				}
			} catch(NumberFormatException e) {
				System.out.print(errorMessage);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}//End of getInt method.
	
	public static int getInt(int startRange, int endRange) {
		if(startRange > endRange) {
			int temp = endRange;
			endRange = startRange;
			startRange = temp;
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String errorMessage = "Please enter a valid integer between " + startRange + " and " + endRange +": ";
		int output = 0;
		while(true) {
			try {
				output = Integer.parseInt(in.readLine());
				if(output < startRange || output > endRange) {
					System.out.print(errorMessage);
				} else {
					return output;
				}
			} catch(NumberFormatException e) {
				System.out.print(errorMessage);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}//End of validateInt method.
	
	public static int getInt(int startRange, int endRange, BufferedReader in) {
		if(startRange > endRange) {
			int temp = endRange;
			endRange = startRange;
			startRange = temp;
		}
		String errorMessage = "Please enter a valid integer between " + startRange + " and " + endRange +": ";
		int output = 0;
		while(true) {
			try {
				output = Integer.parseInt(in.readLine());
				if(output < startRange || output > endRange) {
					System.out.print(errorMessage);
				} else {
					return output;
				}
			} catch(NumberFormatException e) {
				System.out.print(errorMessage);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}//End of validateInt method.
}//End of class.