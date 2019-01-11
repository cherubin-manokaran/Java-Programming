/**
 * @author Cherubin Manokaran
 * Programming Assignment 6
 * Edit Distance Problem
 * cmanokaran@brandeis.edu
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Computes all neighbors of all words in dictionary
// Writes results to file
public class FindNeighbors {
	// Create list for all words in dictionary
	static ArrayList<String> dictionary;
	
	// Main method
	// Accesses and stores words in list
	// Finds neighbors
	public static void main (String[] args) throws IOException {
		Scanner  console = new Scanner(System.in);
        inputDictionary(console);
        findAllNeighbors();
	}
	
	// Prompts user for dictionary file
	// Adds each word in file to list
	public static void inputDictionary(Scanner console) throws FileNotFoundException {
	    dictionary = new ArrayList<String>();
	    
	    System.out.print("What is the input file? ");
		String fileName = console.nextLine();
		File inputFile = new File("./bin/" + fileName);
		while(!inputFile.exists()){
			System.out.print("File not found. Try again: ");
			fileName = console.next();
			inputFile = new File("./bin/" + fileName);
		}
		Scanner scan = new Scanner(inputFile);
		while (scan.hasNext()) {
	        String word = scan.next();
	        dictionary.add(word);
		}
	    scan.close();
	}
	
	// Creates file writer for output file neighbors.txt
	// Calls method to the find and store neighbors in list
	// Each word and its neighbors are passed as parameters to output method
	public static void findAllNeighbors() throws IOException {
		FileWriter out = new FileWriter(new File("./bin/neighbors.txt"));
		BufferedWriter writer = new BufferedWriter(out);
		for (String eachWord : dictionary) {
			ArrayList<String> neighbors = findNeighbors(eachWord);
			writeToFile(neighbors, eachWord, writer);
		}
		writer.close();
	}
	
	// Iterates through each letter in the word
	// Constructs a new word by altering each letter
	// Checks to see if new word is in dictionary
	// If so, adds new word to list
	public static ArrayList<String> findNeighbors(String word) {
	    ArrayList<String> newWords = new ArrayList<String>();
	    
        for (int i = 0; i < word.length(); i++)	{           
        	for (char c = 'a'; c <= 'z'; c++) {
        		String newWord = word.substring(0, i) + String.valueOf(c) + word.substring(i + 1);
        		if (dictionary.contains(newWord) && !newWord.equals(word))	
        			newWords.add(newWord);
        		//System.out.println("Cool");
        	}
        }
	    return newWords;
	}
	
	// Constructs string with word and neighbors
	// Writes constructed string on a new line
	public static void writeToFile(ArrayList<String> neighbors, String eachWord, BufferedWriter writer) throws IOException {
		String output = String.format("%s: ", eachWord);
		for (String neighbor : neighbors) {
			output = output + String.format("%s ", neighbor);
		}
		writer.write(output);
		writer.newLine();
	}
}

