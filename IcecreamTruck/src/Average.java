/**
 * @author Cherubin Manokaran
 * Homework 2
 * Calculates sum of first n terms in a simple arithmetic sequence
 * cmanokaran@brandeis.edu
 */
public class Average {
	public static void main(String[] args) {
		System.out.println("This program prints the sum of the first n terms in a user defined arithmetic sequence.");
		System.out.println("Please enter, as an integer, the number of terms:");
		int x = TextIO.getlnInt();
		System.out.println("Please enter, as a double, the first term:");
		double y = TextIO.getlnDouble();
		System.out.println("Please enter, as a double, the constant amount by which each term in the sequence increases:");
		double z = TextIO.getlnDouble();
		
		// Finds nth term
		double nterm = (double) y + (x-1)*z;
		
		// Finds sum of first n terms
		double sum = (x*(y+nterm)) / 2;
		System.out.println("The sum of the first " + x + " terms is " + sum);
	}
}
