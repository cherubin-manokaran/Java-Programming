/**
 * @author Cherubin Manokaran
 * Programming Assignment 0
 * Ice cream Truck
 * cmanokaran@brandeis.edu
 */

/**
 * Various attributes of route and related behavior.
 * @author Manokaran
 */
public class Route{
	private IcecreamTruck truck;
	private UserInput ui;
	private Driver driver;
	private Driver partner;
	
	/**
	 * Constructor for the Route class
	 * 
	 * @param ui UserInput object user input parsing
	 * @param truck IcecreamTruck object
	 */
	public Route(UserInput ui, IcecreamTruck truck){
		this.ui = ui;
		this.truck = truck;
	}
	/** 
	 * Selects ice cream truck drivers to start route.
	 * Finds an employee with full access or
	 * one employee to drive the truck and
	 * another to handle the register.
	 */
	public void selectEmployees(){
		int driverChoice = DriversMenu();
		int partnerChoice = driverChoice;
		if (!truck.driverFullAccess(driverChoice)){
			do{
				if (!truck.driveTruck(driverChoice)){
					System.out.println("Employee not authroized to drive truck. Choose another employee to drive truck.");
					partnerChoice = driverChoice;
					driverChoice = DriversMenu();
				}else{
					System.out.println("Employee not authorized to access register. Choose another employee to handle register.");
					partnerChoice = DriversMenu();
				}
			}while((!truck.accessRegister(driverChoice) && !truck.accessRegister(partnerChoice)) ||
					(!truck.driveTruck(partnerChoice) && !truck.driveTruck(driverChoice)));
		}
		driver = truck.getDriver(driverChoice);
		partner = truck.getDriver(partnerChoice);
	}
	/** 
	 * Starts route and checks to see if 
	 * customers are available.
	 * Sells ice cream and catches <code>IllegalArgumentException()<code> 
	 * if there is not enough ice cream and
	 * requests user to reenter amount.
	 */
	public void sell(){
		boolean customerAvailable = true;
		System.out.println("Customer found!");
		while (customerAvailable){
			System.out.println("What flavor does the customer want?");
			int flavorChoice = FlavorsMenu();
			int scoops = Integer.MAX_VALUE;
			while (scoops == Integer.MAX_VALUE){
				System.out.println("How many scoops?");
				scoops = ui.userInputInteger();
				System.out.println(scoops);
				try{
					truck.sellIcecream(flavorChoice, scoops);
				}catch(Exception e){
					System.out.println("Not enough of selected flavor");
					scoops = Integer.MAX_VALUE;
				}
			}
			System.out.println("Is there another customer available?");
			customerAvailable = ui.translateYesNo(ui.userInputString());
		}
	}
	/** Returns index id of selected driver */
	public int DriversMenu(){
		truck.printDrivers();
		return ui.userInputInteger();
	}
	/** Returns index id of requested flavor */
	public int FlavorsMenu(){
		truck.printFlavors();
		return ui.userInputInteger();
	}
	/** Returns driver */
	public Driver getDriver(){
		return driver;
	}
	/** Returns driver's partner */
	public Driver getPartner(){
		return partner;
	}
}
