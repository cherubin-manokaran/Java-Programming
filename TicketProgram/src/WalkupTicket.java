/**
 * @author Cherubin Manokaran
 * Programming Assignment 3 Part 1
 * Ticket Program
 * cmanokaran@brandeis.edu
 */

// Creates Walk-up Ticket class that extends Regular Ticket
public class WalkupTicket extends RegularTicket {
	// Declares Constructor for Walk-up Ticket object
	// Sets new ticket price
	public WalkupTicket(int ticketNumber){
		super(ticketNumber);
		super.ticketPrice = 50.0;
	}
	
	// Returns ticket number and string
	// Indicates ticket is a walk-up
	public String print(){
		return super.print() + "\nThis is a walkup ticket";
	}
}
