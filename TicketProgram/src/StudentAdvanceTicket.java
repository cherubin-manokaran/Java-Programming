/**
 * @author Cherubin Manokaran
 * Programming Assignment 3 Part 1
 * Ticket Program
 * cmanokaran@brandeis.edu
 */

// Creates Student Advance Ticket class that extends Advance Ticket
public class StudentAdvanceTicket extends AdvanceTicket{
	// Declares Constructor for Student Advance Ticket object
	// Sets new ticket price by dividing Advance Ticket price by 2
	public StudentAdvanceTicket(int ticketNumber, int daysInAdvance){
		super(ticketNumber, daysInAdvance);
		super.ticketPrice = super.ticketPrice / 2;
	}
	
	// Returns ticket number and string
	// Indicates the days in advance
	// Indicates that Student ID is required
	public String print(){
		return super.print() + "\nStudent ID is required";
	}
}