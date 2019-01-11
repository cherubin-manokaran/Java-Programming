/**
 * @author Cherubin Manokaran
 * Programming Assignment 3 Part 1
 * Ticket Program
 * cmanokaran@brandeis.edu
 */

// Creates Test Ticket client program to test Ticket objects
public class TestTicket{
	// Sets total number of tickets
	private static int totalTickets = 15;
	private static double totalPrice = 0;
	
	// Main method calls method to create ticket array
	// Calls method to calculate profit
	// Calls method to print results
	public static void main(String[] args){
		int ticketNumber = 1;
		
		RegularTicket[] tickets = createArray(totalTickets, ticketNumber);
		getTotalPrice(tickets);
		printResults(tickets);
	}
	
	// Creates and returns ticket array 
	public static RegularTicket[] createArray(int tT, int tN){
		int totalTickets = tT;
		int ticketNumber = tN;
		int daysInAdvance = 0;
		
		// Instantiates ticket array
		RegularTicket[] tickets = new RegularTicket[totalTickets];
		
		// Creates new ticket object of every type with ticket number starting at 1
		// For advance and student advance tickets, sets three different days in advance
		while (ticketNumber <= totalTickets){
			if (ticketNumber <= 3 || ticketNumber > 11)
				tickets[ticketNumber - 1] = new RegularTicket(ticketNumber);
			else if (ticketNumber <= 5)
				tickets[ticketNumber - 1] = new WalkupTicket(ticketNumber);
			else if (ticketNumber <= 8){
				if (ticketNumber == 6)
					daysInAdvance = 30;
				if (ticketNumber == 7)
					daysInAdvance = 15;
				if (ticketNumber == 8)
					daysInAdvance = 3;
				tickets[ticketNumber - 1] = new AdvanceTicket(ticketNumber, daysInAdvance);
			}
			else if (ticketNumber <= 11){
				if (ticketNumber == 9)
					daysInAdvance = 30;
				if (ticketNumber == 10)
					daysInAdvance = 15;
				if (ticketNumber == 11)
					daysInAdvance = 3;
				tickets[ticketNumber - 1] = new StudentAdvanceTicket(ticketNumber, daysInAdvance);
			}
			ticketNumber++;
		}
		return tickets;
	}
	
	// Calculates total profit by finding the sum of the individual ticket prices 
	public static void getTotalPrice(RegularTicket[] t){
		RegularTicket[] tickets = t;
		for (int i = 0; i < totalTickets; i++){
			totalPrice = totalPrice + tickets[i].getPrice();
		}
	}
	
	// Prints all tickets in the array and total profit
	public static void printResults(RegularTicket[] t){
		RegularTicket[] tickets = t;
		for (int i = 0; i < totalTickets; i++){
			System.out.println(tickets[i].print());
			System.out.println();
		}
		System.out.printf("Total profit is $%,.2f%n", totalPrice);
	}
}
