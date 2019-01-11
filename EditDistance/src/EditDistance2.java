/**
 * @author Cherubin Manokaran
 * Programming Assignment 6
 * Edit Distance Problem
 * cmanokaran@brandeis.edu
 */

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeMap;

// Stores all words in dictionary in list
// Stores words and respective neighbors in map
// Finds path from one word to another
// Returns resulting edit distance
public class EditDistance2 {
	
	static ArrayList<String> dictionary;

	static String firstWord;
	static String secondWord;
	
	static HashMap<String, ArrayList<String>> allNeighbors;
	
	// Main method
	// Accesses and stores words in list
	// Accesses neighbors and stores in map
	// Prompts user for two words
	// Finds path from one word to another
	public static void main (String[] args) throws FileNotFoundException {
		Scanner  console = new Scanner(System.in);
        inputDictionary(console);
        inputNeighbors();
	    promptUser(console);
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
	
	// Accesses all words and corresponding neighbors from file
	// Calls method to separate lines into a word and its neighbors
	public static void inputNeighbors() throws FileNotFoundException{
		allNeighbors = new HashMap<String, ArrayList<String>>();
		Scanner scan = new Scanner(new File("./bin/neighbors.txt"));
		
	    while (scan.hasNext()) {
	    	mapNeighbors(scan.nextLine());
	    }
	    scan.close();
	}
	
	// Finds Separates word from its neighbors
	// Stores neighbors in array list
	// Stores word and array list of neighbors in the map
	public static void  mapNeighbors(String line) {
		int index = line.indexOf(":");
	    String word = line.substring(0, index);
	    String neighborList = line.substring(index + 1);
	    Scanner neighborFinder = new Scanner(neighborList);
	    
	    ArrayList<String> neighbors = new ArrayList<String>();
	    
	    while (neighborFinder.hasNext()) {
	    	String theNeighbor = neighborFinder.next();
	        neighbors.add(theNeighbor);
	    }
	    
	    neighborFinder.close();
	    
	    allNeighbors.put(word, neighbors);
	}
	
	// Prompts user to input two words
	// Provides user with option to quit by typing "quit"
	// Checks to see if words are of the same size
	// Checks to see if word exists in dictionary
	// Calls method to compute path from first to second word
	public static void promptUser(Scanner console) {
	    System.out.println("Enter two words separated by a space:");
	    firstWord = console.next();
	    
	    while (!firstWord.equals("quit")) {
	    	secondWord = console.next();
	    	if (!dictionary.contains(firstWord) || !dictionary.contains(secondWord)) {
	        	System.out.println("Word does not exist");
	        }
	    	else if (firstWord.length() != secondWord.length()) {
	    		System.out.println("No Solution");
	    	}
	    	else {	
			    for (String word1: dictionary) {
			        if (firstWord.equals(word1)) {
			            for (String word2: dictionary) {
			                if (secondWord.equals(word2)) {
			                    findEdits();
			                }
			            }
			        }
			    }
	    	}
		    System.out.println("Enter two words spearated by a space:");
		    firstWord = console.next();
	    }
	}

	// Creates linked list of all candidate words based on first word entered
	// Stores previously visited values in set
	// Tracks how many words at each distance
	// Creates map of path from first to second word
	// Displays results
	public static void findEdits() {
	    //LinkedList<String> tracker = new LinkedList<String>();
	    //tracker.add(firstWord);
	    
	    LinkedList<ArrayList<String>> tracker = new LinkedList<ArrayList<String>>();
	    ArrayList<String> start = new ArrayList<String>();
	    start.add(firstWord);
	    tracker.add(start);
	    
	    Set<ArrayList<String>> visited = new HashSet<ArrayList<String>>();
	    ArrayList<String> intermediateNeighbors = new ArrayList<String>();
	    Map<String, ArrayList<String>> path = new TreeMap<String, ArrayList<String>>();
	    Map<Integer, ArrayList<String>> path2 = new HashMap<Integer, ArrayList<String>>();
	    Map<Integer, ArrayList<String>> path3 = new HashMap<Integer, ArrayList<String>>();
	    ArrayList<Integer> distances = new ArrayList<Integer>();
	    
	    ArrayList<String> finalPath = new ArrayList<String>();
	    
	    ArrayList<String> step = tracker.peekFirst();
	    
		while (!tracker.isEmpty()) {
			visited.add(step);
			int index = visited.size()-1;
			
			for (String aWord : step) {
				int distance = calculateDistance(aWord);
				if (distance != 0)
					distances.add(distance);
			}
			
			path2.put(index, step);
			if (!step.contains(secondWord)) {
				for (String aWord : step) {
					intermediateNeighbors = allNeighbors.get(aWord);
					tracker.add(intermediateNeighbors);
					path.put(aWord, intermediateNeighbors);
					System.out.println(aWord + intermediateNeighbors.toString());
				}
				// Adds stored neighbors to linked list
				// Removes first word in list because it is not equal to the second word
				tracker.remove(0);
				// Stores next word for next iteration
				step = tracker.peekFirst();
				
				while (visited.contains(step)) {
					tracker.remove(0);
					step = tracker.peekFirst();
				}
				
				System.out.println(step.toString());
			}
			else {
				tracker.clear();
				Map<String, ArrayList<String>> truncatedPath = new TreeMap<String, ArrayList<String>>();
				for (String set : path.keySet()) {
					truncatedPath.put(set, path.get(set));
					if (path.get(set).equals(step))
						break;
				}
				System.out.println("Word exists");
				System.out.println(step.toString());
				while (!step.equals(start)) {
					boolean broken = false;
					for (String key : allNeighbors.keySet()) {
						if (step.equals(allNeighbors.get(key))) {
							finalPath.add(key);
							for (String otherKey : path.keySet()) {
								if (truncatedPath.get(otherKey).contains(key)) {
									step = truncatedPath.get(otherKey);
									broken = true;
									System.out.println(key + " " + otherKey);
									break;
								}
							}
						}
						if (broken)
							break;
					}
				}
			}	
		}
		int editDistance = calculateEditDistance(distances);
		System.out.println(editDistance);
		
		for (Integer key : path2.keySet()) {
			for (String otherKey : allNeighbors.keySet()) {
				if (path2.get(key).equals(allNeighbors.get(otherKey)))
					finalPath.add(otherKey);
			}
		}
		
		System.out.println(path2.values().toString());
		System.out.println(finalPath.toString());
		//int editDistance = calculateEditDistance(distances);
		//displayOutput(tracker, editDistance);
	}
	
	// Calculates how many chars are different for each word visited to give distance
	public static int calculateDistance(String step) {
		int distance = 0;
		for (int i = 0; i < step.length(); i++) {
			if (step.charAt(i) != firstWord.charAt(i))
				distance++;
		}
		return distance;
	}
	
	// Calculates how many different distances exist between the words in the path and the first word
	// This gives the total edit distance
	public static int calculateEditDistance(ArrayList<Integer> distances) {
		int editDistance = 0;
		for (int i = 0; i < 50; i++) {
			if (distances.contains(i))
				editDistance++;
		}
		return editDistance;
	}
	
	public static void displayOutput(LinkedList<ArrayList<String>> tracker, int editDistance) {
	    System.out.println("Path: " + tracker.toString());
	    System.out.println("Edit distance = " + editDistance);
	}
}