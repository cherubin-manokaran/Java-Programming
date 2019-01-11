/**
 * @author Cherubin Manokaran
 * Programming Assignment 0
 * Ice cream Truck
 * cmanokaran@brandeis.edu
 */

import java.util.Scanner;

/**
 * Class for handling all user input
 * @author Manokaran
 */
public class UserInput {
	private Scanner input;
	
	/**
	 * Constructor for the UserInput class.
	 * Instantiates scanner for all user input.
	 */
	public UserInput(){
		input = new Scanner(System.in);
	}
	/** Returns input of type string */
	public String userInputString(){
		String userInput = input.next();
		return userInput;
	}
	/** Returns input of type integer */
	public int userInputInteger(){
		int userInput = Integer.MAX_VALUE;
		while (userInput == Integer.MAX_VALUE) {
			try{
			    userInput = Integer.parseInt(input.next());
			}catch (NumberFormatException e){
			    System.out.println("Not an integer");
			}
		}
		return userInput;
	}
	/** Returns input of type double */
	public double userInputDouble(){
		double userInput = Double.MAX_VALUE;
		while (userInput == Double.MAX_VALUE){
			try{
			    userInput = Double.parseDouble(input.next());
			}catch (NumberFormatException e){
			    System.out.println("Not a number");
			}
		}
		return userInput;
	}
	/** Returns boolean value for strings "y" and "n" */
	public boolean translateYesNo(String choice){
		if (choice.equalsIgnoreCase("y")){
			return true;
		}else{
			return false;
		}
	}
}
