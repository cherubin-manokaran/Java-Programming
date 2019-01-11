/**
 * @author Cherubin Manokaran
 * Programming Assignment 0
 * Ice cream Truck
 * cmanokaran@brandeis.edu
 */

public class console{
	/** 
	 * Main method for all interactions with user.
	 * Instantiates UserInput object.
	 * Instantiates IcecreamTruck object.
	 * Requests user to increase investment if not enough.
	 * Displays main menu. 
	 * @param args
	 */
	public static void main(String[] args) {
		UserInput ui = new UserInput();
		System.out.println("Welcome to your new Ice Cream Truck");
		
		IcecreamTruck truck = null;
		double funds;
		
		while (truck == null){
			System.out.println("How much funds would you like to give your truck to start?");
			funds = ui.userInputDouble();
			try {
				truck = new IcecreamTruck(funds);
			}catch(IllegalArgumentException e){
				System.out.println("Insufficient funds to start truck");
			}
		}
		
		MainMenu(ui, truck);
	}
	/**
	 * Displays menu and instructs user to choose desired action
	 * @param ui
	 * @param truck
	 */
	public static void MainMenu(UserInput ui, IcecreamTruck truck){
		int choice = Integer.MAX_VALUE;
		while (choice != 0) {
			System.out.println("\nWhat would you like to do?"
					+ "\n1: Add flavor"
					+ "\n2: Add a new driver"
					+ "\n3: Start route"
					+ "\n4: Check cashbox"
					+ "\nEnter 0 to quit");
            choice = ui.userInputInteger();
            switch (choice) {
            case 1:
            	addFlavor(ui, truck);
            	break;
            case 2:
            	addDriver(ui, truck);
            	break;
            case 3:
            	startRoute(ui, truck);
            	break;
            case 4:
            	checkCashbox(truck);
            	break;
            }
        }
	}
	/**
	 * Adds ice cream flavor
	 * @param ui
	 * @param truck
	 */
	public static void addFlavor(UserInput ui, IcecreamTruck truck){
		System.out.println("What flavor will you add?");
		String name = ui.userInputString();
		System.out.println("How many scoops are there?");
		int scoops = ui.userInputInteger();
		System.out.println("When you sell to a customer, how much is the cost per scoop?");
		double cost = ui.userInputDouble();
		System.out.println("How much is the cost per scoop that we pay (Wholesale)?");
		double wholesaleCost = ui.userInputDouble();
		try{
			truck.purchaseAdditionalFlavors(name, scoops, cost, wholesaleCost);
		}catch (IllegalArgumentException e){
			System.out.println("Insufficient Funds");
		}
	}
	/**
	 * Adds driver
	 * @param ui
	 * @param truck
	 */
	public static void addDriver(UserInput ui, IcecreamTruck truck){
		System.out.println("What is the name of employee?");
		String name = ui.userInputString();
		System.out.println("Does the driver have permission to drive the truck (y/n)?");
		boolean driveTruck = ui.translateYesNo(ui.userInputString());
		System.out.println("Does the driver have permission to access the register (y/n)?");
		boolean accessRegister = ui.translateYesNo(ui.userInputString());
		truck.addDriver(name, driveTruck, accessRegister);
	}
	/**
	 * Starts ice cream truck on route
	 * @param ui
	 * @param truck
	 */
	public static void startRoute(UserInput ui, IcecreamTruck truck){
		Route route = new Route(ui, truck);
		route.selectEmployees();
		System.out.println("Truck is on route...");
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){
		    Thread.currentThread().interrupt();
		}
		route.sell();
		System.out.println("Route has ended");
	}
	/**
	 * Summarizes all transactions
	 * @param truck
	 */
	public static void checkCashbox(IcecreamTruck truck){
		truck.checkCashBox();
	}
}
