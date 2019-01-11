/**
 * @author Cherubin Manokaran
 * Programming Assignment 3 Part 1
 * Ticket Program
 * cmanokaran@brandeis.edu
 */

// Creates Regular Ticket class
public class RegularTicket {
	private int ticketNumber;
	double ticketPrice = 40.0;
	
	// Declares constructor for the Regular Ticket object
	public RegularTicket(int ticketNumber){
		this.ticketNumber = ticketNumber;
	}
	
	// Returns price
	public double getPrice(){
		return this.ticketPrice;
	}
	
	// Returns ticket number and price
	public String print(){
		return String.format("Ticket number = %d and price = $%,.2f", this.ticketNumber, this.getPrice());
	}
}
