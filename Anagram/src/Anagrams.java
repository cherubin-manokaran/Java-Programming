/**
 * @author Cherubin Manokaran
 * Programming Assignment 8
 * Anagrams Problem
 * cmanokaran@brandeis.edu
 */

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Anagrams {
	private Set<String> dictionary;
	
	// Constructs new Anagrams solver using dictionary of words
	// If set is null returns exception
	public Anagrams(Set<String> dictionary) {
		if (dictionary == null)
			throw new IllegalArgumentException("Empty Set");
		
		this.dictionary = dictionary;
	}
	
	// Finds all words that can be formed from provided phrase
	// If null, throws exception
	public Set<String> getWords(String phrase) {
		if (phrase == null)
			throw new IllegalArgumentException("String is null");
		
		Set<String> allWords = new TreeSet<String>();
		
		// Creates a letter inventory for provided phrase
		LetterInventory letters = new LetterInventory(phrase);
		
		// Iterates through dictionary
		// Checks if the word can be formed from letter inventory
		for (String word : dictionary) {
			if (letters.contains(word))
				allWords.add(word);
		}
		
		return allWords;
	}
	
	// Passes max of 0
	// Finds and prints all anagrams for provided phrase
	public void print(String phrase) {
		print(phrase, 0);
	}
	
	// Passes user provided maximum number of anagrams
	// Finds and prints anagrams for provided phrase
	public void print(String phrase, int max) {
		if (phrase == null|| max < 0)
			throw new IllegalArgumentException("String is null or max out of bounds");
		
		Set<String> allWords = this.getWords(phrase);
		LetterInventory letters = new LetterInventory(phrase);
		
		Stack<String> choices = new Stack<String>();
		
		print(allWords, max, letters, choices);
	}
	
	// Finds anagrams using recursion
	private void print(Set<String> allWords, int max, LetterInventory letters, Stack<String> choices) {
		if (letters.size() == 0 && max == 0)
			System.out.println(choices.toString());
		else if (letters.size() == 0 && choices.size() <= max)
			System.out.println(choices.toString());
		else {
			// Iterates through set of words that can be formed from letter inventory
			for (String word : allWords) {
				if (letters.contains(word)) {
					// Pushes word on stack
					choices.push(word);
					// Removes letters used from the inventory
					letters.subtract(word);
					
					// Finds next word that can be formed from remaining letters
					// Continues until base case when all letters from inventory have been used
					print(allWords, max, letters, choices);
					
					// Regenerates original letter inventory
					letters.add(word);
					choices.pop();
				}
			}
		}
	}
} 
