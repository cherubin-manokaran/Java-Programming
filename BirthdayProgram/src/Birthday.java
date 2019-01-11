/**
 * @author Cherubin Manokaran
 * Programming Assignment 2
 * Birthday Program
 * cmanokaran@brandeis.edu
 */
import java.util.*;
public class Birthday {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("What month, day, and year were you born ");
		int birthmonth  = input.nextInt();
		int birthday = input.nextInt();
		int birthyear = input.nextInt();
		
		input.close();
		
		// Creates TeacherDate object that represents user's birthday
		TeacherDate birthdate = new TeacherDate(birthyear, birthmonth, birthday);
		String dayOfWeek = findDayOfWeek(birthdate);
		
		// Creates TeacherDate object that represents today
		TeacherDate today = new TeacherDate();
		int age = calcAge(birthdate, today);
		int ageInDays = countDays(birthdate, today);
		
		// Creates TacherDate object that represents user's birthday for this year
		TeacherDate currentBirthdate = findCurrentBirthday(birthdate, today);
		int daysToBirthday = countDays(today, currentBirthdate);
		
		// Prints results
		printResults(birthdate, currentBirthdate, today, dayOfWeek, age, ageInDays, daysToBirthday);
	}
	// Accesses user's birth date object
	// Returns the day of user's birth
	public static String findDayOfWeek(TeacherDate b) {
		TeacherDate birthdate = b;
		return birthdate.getDayOfWeek();
	}
	// Accesses object for user's birth date and today's date
	// Returns age in years
	public static int calcAge(TeacherDate b, TeacherDate t) {
		TeacherDate birthdate = b;
		TeacherDate today = t;
		
		return today.getYear() - birthdate.getYear();
	}
	// Accesses object for user's birth date and today's date
	// Creates and returns object for current birthday
	public static TeacherDate findCurrentBirthday(TeacherDate b, TeacherDate t) {
		TeacherDate birthdate = b;
		TeacherDate today = t;
		int year = 0;
		
		if (today.getMonth() >= birthdate.getMonth() && today.getDay() != birthdate.getDay())
			year = today.getYear() + 1;
		else
			year = today.getYear();
			
		return new TeacherDate(year, birthdate.getMonth(), birthdate.getDay());
		
	}
	// Accesses two dates
	// Returns number of days between dates
	public static int countDays(TeacherDate f, TeacherDate s) {
		TeacherDate first = f;
		TeacherDate second = s;
		
		TeacherDate counter = new TeacherDate(first.getYear(), first.getMonth(), first.getDay());
		
		int days = 0;
		while (!counter.equals(second)){
			counter.nextDay();
			days++;
		}
		return days;
	}
	// Prints results
	public static void printResults(TeacherDate b, TeacherDate cb, TeacherDate t, String dow, int a, int ad, int ds) {
		TeacherDate birthdate = b;
		TeacherDate currentBirthdate = cb;
		TeacherDate today = t;
		String dayOfWeek = dow;
		int age = a;
		int ageInDays = ad;
		int daysToBirthday = ds;
		
		System.out.println("You were born on " + birthdate.toString() + ", which was a " + dayOfWeek + ".");
		
		// Checks if birth year was a leap year
		if (birthdate.isLeapYear())
			System.out.println(birthdate.getYear() + " was a leap year");
		
		// Checks if today is the user's birthday
		// If not, prints the number of days until his or her birthday
		if (currentBirthdate.equals(today))
			System.out.println("Happy Birthday! You are now age " + age + ".");
		else
			System.out.println("It will be your birthday in " + daysToBirthday + " days");
		
		System.out.println("You are " + ageInDays + " days old");
	}
}
