/**
 * @author Cherubin Manokaran
 * Programming Assignment 1
 * Keirsey Temperament Sorter
 * cmanokaran@brandeis.edu
 */
import java.io.*;
import java.util.*;

public class PersonalityTest {
	// Produces the results of the Keirsey Temperament Sorter
	// The personality test asks 70 questions
	// And forms personality types for participants based on the responses
	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		System.out.print("Input File Name: ");
		String input_filename = console.next();
		File input = new File("./bin/" + input_filename);
		while(!input.exists()){
			System.out.print("File not found. Try again: ");
			input_filename = console.next();
			input = new File("./bin/" + input_filename);
		}
		System.out.print("Output File Name: ");
		String output_filename = console.next();
		File output = new File("./bin/" + output_filename);
		console.close();
		readFile(input, output);
	}
	// Accesses input and output file
	// Creates scanner instance to read file
	// Assigns name and responses to string
	// Calls decoding methods and enumerates responses in arrays
	// Calls calculation methods
	// Assigns both percentages and personality dimensions to arrays
	// Calls method to write results to output file
	public static void readFile(File in, File out) throws FileNotFoundException{
		File input = in;
		File output = out;
		int[] categoriesA = new int[4];
		int[] categoriesB = new int[4];
		int[] percentage = new int[4];
		char[] type = new char[4];
		
		Scanner inputfile = new Scanner(input);
		PrintStream outputfile = new PrintStream(output);
		
		while (inputfile.hasNext()){
			String name = inputfile.nextLine();
			String responses = inputfile.nextLine().toUpperCase();
			categoriesA = decodeA(responses);
			categoriesB = decodeB(responses);
			percentage = calcPercentage(categoriesA, categoriesB);
			type = calcType(percentage);
			writeFile(outputfile, name, categoriesA, categoriesB, percentage, type);
			if (inputfile.hasNextLine()){
				outputfile.println();
				outputfile.println();
			}
		}
		inputfile.close();
		outputfile.close();
	}
	// Accesses string of responses
	// Identifies A's
	// Increments number in each category
	// Returns array containing the total for each category
	public static int[] decodeA(String input){
		String responses = input;
		int[] categories = new int[4];
		// Iterates string
		for (int i = 1; i < 71; i++){
			// Tests if char at position i is a B
			if (responses.charAt(i-1) == 'A'){
				// Then categorizes answer based on question number
				// Increments total in each dimension
				if (i % 7 == 1) 
					categories[0]++;
				else if (i % 7 == 2 || i % 7 == 3)
					categories[1]++;
				else if (i % 7 == 4 || i % 7 == 5)
					categories[2]++;
				else if (i % 7 == 6 || i % 7 == 0)
					categories[3]++;
			}
		}
		return categories;
	}
	// Accesses string of responses
	// Identifies B's
	// increments number in each category
	// Returns array containing the total for each category
	public static int[] decodeB(String input){
		String responses = input;
		int[] categories = new int[4];
		// Iterates string
		for (int i = 1; i < 71; i++){
			// Tests if char at position i is a B
			if (responses.charAt(i-1) == 'B'){
				// Then categorizes answer based on question number
				// Increments total in each dimension
				if (i % 7 == 1) 
					categories[0]++;
				else if (i % 7 == 2 || i % 7 == 3)
					categories[1]++;
				else if (i % 7 == 4 || i % 7 == 5)
					categories[2]++;
				else if (i % 7 == 6 || i % 7 == 0)
					categories[3]++;
			}
		}
		return categories;
	}
	// Accesses two arrays containing the total number of A's and B's in each category
	// Calculates percentage of B's in each category
	// Returns array containing the percentages
	public static int[] calcPercentage(int[] a, int[] b){
		int[] categoriesA = a;
		int[] categoriesB = b;
		double[] temp = new double[4];
		int[] percentage = new int[4];
		
		// Calculates percentage of B's in each dimension as a double
		temp[0] = ((double)categoriesB[0] / (categoriesA[0] +  categoriesB[0])) * 100;
		temp[1] = ((double)categoriesB[1] / (categoriesA[1] +  categoriesB[1])) * 100;
		temp[2] = ((double)categoriesB[2] / (categoriesA[2] +  categoriesB[2])) * 100;
		temp[3] = ((double)categoriesB[3] / (categoriesA[3] +  categoriesB[3])) * 100;
		// Converts percentage from type double to type integer
		for (int i=0; i < 4; i++){
			percentage[i] = (int)temp[i];
		}
		
		return percentage;
	}
	// Accesses the percentages array
	// Assigns personality types
	public static char[] calcType(int[] input){
		int[] percentage = input;
		char[] type = new char[4];
		char one, two;
		// Iterates percentages array
		for (int i=0; i < 4; i++){
			// Compares percentage to 50 and assigns appropriate type for each dimension 
			if (percentage[i] > 50){
				if (i == 0)
					type[i] = 'I';
				else if (i == 1)
					type[i] = 'N';
				else if (i == 2)
					type[i] = 'F';
				else if (i == 3)
					type[i] = 'P';
			} else if (percentage[i] == 50)
				type[i] = 'X';
			else if (percentage[i] < 50){
				if (i == 0)
					type[i] = 'E';
				if (i == 1)
					type[i] = 'S';
				if (i == 2)
					type[i] = 'T';
				if (i == 3)
					type[i] = 'J';
			}
		}
		return type;
	}
	// Accesses PrintStream instance
	// Writes name, number of A's and B's, percentages for each category and resulting personality type to file
	public static void writeFile(PrintStream o, String n, int[] a, int[] b, int[] p, char[] t) throws FileNotFoundException{
		PrintStream outputfile = o;
		String name = n;
		int[] categoriesA = a;
		int[] categoriesB = b;
		int[] percentage = p;
		char[] type = t;
		outputfile.println(name);
		for (int i=0; i < 4; i++){
			outputfile.print(categoriesA[i] + "A-" + categoriesB[i] + "B ");
		}
		outputfile.println();
		outputfile.print("[");
		for (int i=0; i < 4; i++){
			outputfile.print(percentage[i] + "%");
			if (i<3)
				outputfile.print(" ");
		}
		outputfile.print("]");
		outputfile.print("= " + new String(type));
	}
}
