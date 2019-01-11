/**
 * @author Cherubin Manokaran
 * Programming Assignment 5
 * Stable Marriage Problem
 * cmanokaran@brandeis.edu
 */

import java.io.*;
import java.util.*;

// The greatest difficulty that I was unable to address
// was breaking an engagement if the first preference
// of an individual is engaged. The problem is that
// I have not been able to return to the individual
// for whom an engagement was broken. To achieve this 
// I have added the individual to another array list
// that I then append the original list with. This
// ensures that the individual has another chance to be
// paired. But that does not appear to be the most efficient
// and accurate method. Specifically when testing
// short.dat, man 3 is not engaged to woman 0.
// To figure out whats wrong, I added print statements to
// checks the preference lists of men and women.
// The appropriate lists are generated. Even so, man 3
// is not engaged to woman 0.

public class StableMarriage {
	public static final String LIST_END = "END";
	public static int position = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
	    Scanner console = new Scanner(System.in);
		
	    Scanner input = accessFile(console);
		List<Person> men = readMen(input);
		List<Person> women = readWomen(input);
		
		makeMatches(men, women);
		writeList(men, women, "Matches for men");
		writeList(women, men, "Matches for women");
	}
	
	public static Person readPerson(String line) {
	    int index = line.indexOf(":");
	    Person result = new Person(line.substring(0, index));
	    String preferences = line.substring(index + 1);
	    Scanner intFinder = new Scanner(preferences);
	    while (intFinder.hasNext()) {
	        result.addPreference(intFinder.nextInt());
	    }
	    intFinder.close();
	    result.setPosition(position++); 
	    return result;
	}
	
	public static Scanner accessFile(Scanner console) throws FileNotFoundException {
		System.out.print("What is the input file? ");
		String fileName = console.nextLine();
		File inputFile = new File("./bin/" + fileName);
		while(!inputFile.exists()){
			System.out.print("File not found. Try again: ");
			fileName = console.nextLine();
			inputFile = new File("./bin/" + fileName);
		}
		return new Scanner(inputFile);
	}
	
	public static List<Person> readMen(Scanner input){
	    List<Person> men = new ArrayList<Person>();
	    String line = input.nextLine();
	    while (!line.equals(LIST_END)) {
	        men.add(readPerson(line));
	        line = input.nextLine();
	    }
	    
	    return men;
	}
	
	public static List<Person> readWomen(Scanner input){
	    List<Person> women = new ArrayList<Person>();
	    System.out.println();
	    String line = input.nextLine();
	    while (!line.equals(LIST_END)) {
	        women.add(readPerson(line));
	        line = input.nextLine();
	        
	    }
	    input.close();
	    
	    return women;
	}
	
	public static void makeMatches(List<Person> men, List<Person> women) {
		List<Person> unPartnered = new ArrayList<Person>();
		for (Person man :  men){
		     man.erasePartner();
		}
		for (Person woman : women){
		     woman.erasePartner();
		}
		int manIndex = 0;
		Person man = men.get(manIndex);
		while (man.hasPreference() && !man.hasPartner()){
			int manPreference = man.getFirstPreference();
			// Iterates through all men and checks to see if he is different
			// Checks to see if he has a partner and if that partner
			// is the same as the original man's preference
			// If so, the two are unpaired and the man is added to another array
			for (Person otherMan : men){
				if (!man.getName().equals(otherMan.getName()) && otherMan.hasPartner() && manPreference == otherMan.getPartner()){
	                 otherMan.erasePartner();
	                 unPartnered.add(otherMan);
	            } 
			}
			
			// Appends original list of men with unpartnered individuals
			// Engages original man to preference
			// for (int i=0; i<=unPartnered.size()-1; i++){
				// men.remove(unPartnered.get(i));
			// }	
			men.addAll(unPartnered);
			unPartnered.clear();
			man.setPartner(manPreference);
			int manPosition = man.getPosition();
			Person woman = women.get(manPreference);
			woman.setPartner(manPosition);
			
			// Finds index of man on man's prefereed woman's preference list
			// Iterates to this value from the end removing those preferences
			// Also finds men indicated by these numbers and remove the woman 
			// from the mens' respective lists.
			int index = woman.getIndexOfPreference(manPosition);
			if (index != -1){
				List<Integer> womanChoices = woman.getPreferences();
				for (int q = womanChoices.size()-1; q > index; q--){
					Person otherMan = men.get(womanChoices.get(q));
					otherMan.removePreference(otherMan.getIndexOfPreference(manPreference));
					woman.removePreference(q);
				}
			}
			
			// Proceeds to next man in list
			// To partner all unpartnered individuals
			if (manIndex < men.size()-1)
				man = men.get(++manIndex);
		}
	}
	public static void writeList(List<Person> list1,  List<Person> list2, String title) {
	    System.out.println(title);
	    System.out.println("Name           Choice  Partner");
		System.out.println("--------------------------------------");
		int sum = 0;
		int count = 0;
		for (Person p : list1) {
		    System.out.printf("%-15s", p.getName());
		    if (!p.hasPartner()) {
		        System.out.println("  --    nobody");
		    } else {
		        int rank = p.getPartnerRank();
		        sum += rank;
		        count++;
		        System.out.printf("%4d    %s\n", rank, list2.get(p.getPartner()).getName());
		    }
		}
		// Print statement to display preferences to prove that correct
		// preferences are generated for short.dat
		System.out.println();
		for (Person p : list1){
			System.out.println(p.getName() + " " + p.getPreferences() + ",\tPartner: " + p.getPartner());
		}
		System.out.println("Mean choice = " + (double) sum / count);
		System.out.println();
	}
}

	  
		        
