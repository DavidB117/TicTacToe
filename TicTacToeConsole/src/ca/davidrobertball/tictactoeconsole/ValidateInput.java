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
	private BufferedReader in;
	
	public ValidateInput() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public int getInt() {
		int output = 0;
		while(true) {
			try {
				output = Integer.parseInt(in.readLine().trim());
				return output;
			} catch(NumberFormatException e) {
				System.out.println("Please enter a valid integer: ");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}//End of validateInt method.
	
	public int getInt(BufferedReader brin) {
		int output = 0;
		while(true) {
			try {
				output = Integer.parseInt(brin.readLine().trim());
				return output;
			} catch(NumberFormatException e) {
				System.out.print("Please enter a valid integer: ");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}//End of validateInt method.
	
	public int getInt(int value) {
		String errorMessage = "Please enter the integer value " + value + ": ";
		int output = 0;
		while(true) {
			try {
				output = Integer.parseInt(in.readLine().trim());
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
	
	public int getInt(int value, BufferedReader brin) {
		String errorMessage = "Please enter the integer value " + value + ": ";
		int output = 0;
		while(true) {
			try {
				output = Integer.parseInt(brin.readLine().trim());
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
	
	public int getInt(int startRange, int endRange) {
		if(startRange > endRange) {
			int temp = endRange;
			endRange = startRange;
			startRange = temp;
		}
		
		String errorMessage = "Please enter a valid integer between " + startRange + " and " + endRange +": ";
		int output = 0;
		while(true) {
			try {
				output = Integer.parseInt(in.readLine().trim());
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
	
	public static int getInt(int startRange, int endRange, BufferedReader brin) {
		if(startRange > endRange) {
			int temp = endRange;
			endRange = startRange;
			startRange = temp;
		}
		
		String errorMessage = "Please enter a valid integer between " + startRange + " and " + endRange +": ";
		int output = 0;
		while(true) {
			try {
				output = Integer.parseInt(brin.readLine().trim());
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