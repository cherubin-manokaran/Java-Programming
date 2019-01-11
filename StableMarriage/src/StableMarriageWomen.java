/**
 * @author Cherubin Manokaran
 * Programming Assignment 5
 * Stable Marriage Problem
 * cmanokaran@brandeis.edu
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StableMarriageWomen {
	public static final String LIST_END = "END";
	public static int position = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
	    Scanner console = new Scanner(System.in);
		
	    Scanner input = accessFile(console);
		List<Person> men = readMen(input);
		List<Person> women = readWomen(input);
		
		makeMatches(women, men);
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
			fileName = console.next();
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
	
	public static void makeMatches(List<Person> women, List<Person> men) {
		List<Person> unPartnered = new ArrayList<Person>();
		for (Person man :  men){
		     man.erasePartner();
		}
		for (Person woman : women){
		     woman.erasePartner();
		}
		int womanIndex = 0;
		Person woman = women.get(womanIndex);
		while (woman.hasPreference() && !woman.hasPartner()){
			int womanPreference = woman.getFirstPreference();
			for (Person otherWoman : women){
				if (otherWoman.hasPartner() && womanPreference == otherWoman.getPartner()){
	                 otherWoman.erasePartner();
	                 unPartnered.add(otherWoman);
	            } 
			}
			women.addAll(unPartnered);
			woman.setPartner(womanPreference);
			int womanPosition = woman.getPosition();
			Person man = men.get(womanPreference);
			man.setPartner(womanPosition);
			int index = man.getIndexOfPreference(womanPosition);
			if (index != -1){
				List<Integer> manChoices = man.getPreferences();
				for (int q = manChoices.size()-1; q > index; q--){
					Person otherWoman = women.get(manChoices.get(q));
					otherWoman.removePreference(otherWoman.getIndexOfPreference(womanPreference));
					man.removePreference(q);
				}
			}
			if (womanIndex < women.size()-1)
				woman = women.get(++womanIndex);
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
		System.out.println("Mean choice = " + (double) sum / count);
		System.out.println();
	}
}
