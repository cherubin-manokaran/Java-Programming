/**
 * @author Cherubin Manokaran
 * Programming Assignment 3 Part 1
 * Ticket Program
 * cmanokaran@brandeis.edu
 */

// Creates Advance Ticket class that extends Regular Ticket
public class AdvanceTicket extends RegularTicket{
	// Sets two different cutoffs for advance ticket purchases
	private final int FIRST_INCREASE = 20;
	private final int SECOND_INCREASE = 10;
	
	// Sets prices for advance ticket purchases
	private double firstPrice = 15.0;
	private double secondPrice = 20.0;
	private double thirdPrice = 40.0;
	
	private int daysInAdvance;
	
	// Declares Constructor for Advance Ticket object
	// Sets new ticket price
	public AdvanceTicket(int ticketNumber, int daysInAdvance){
		super(ticketNumber);
		
		// Sets prices for advance ticket purchases according to days in advance
		if (daysInAdvance > FIRST_INCREASE)
			super.ticketPrice = firstPrice;
		if (daysInAdvance < FIRST_INCREASE && daysInAdvance > SECOND_INCREASE)
			super.ticketPrice = secondPrice;
		if (daysInAdvance < SECOND_INCREASE)
			super.ticketPrice = thirdPrice;
		
		this.daysInAdvance = daysInAdvance;
	}
	
	// Returns ticket number and string
	// Indicates the days in advance
	public String print(){
		return super.print() + "\nThis ticket was purchased " + daysInAdvance + " days in advance";
	}
}
