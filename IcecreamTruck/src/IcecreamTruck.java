/**
 * @author Cherubin Manokaran
 * Programming Assignment 0
 * Ice cream Truck
 * cmanokaran@brandeis.edu
 */

import java.text.NumberFormat;

/**
 * Various attributes of ice cream truck and related behavior. 
 * @author Manokaran
 */
public class IcecreamTruck {
	private double funds = 0;
	private double investment;
	private double purchases = 0;
	private double sales = 0;
	private double transaction;
	private Flavors flavors;
	private Drivers drivers;
	
	/**
	 * Constructor for the IcecreamTruck class.
	 * Instantiates Flavors and Drivers objects.
	 * Adds investment. 
	 * Buys three basic flavors.
	 * @param funds initial investment
	 * @exception IllegalArgumentException if initial investment is insufficient
	 */
	public IcecreamTruck(double funds){
		flavors = new Flavors();
		drivers = new Drivers();
		investment = funds;
		this.addFunds(funds);
		purchaseBasicFlavors();
	}
	/**
	 * Adds total investment to ice cream truck
	 * @param funds
	 */
	public void addFunds(double funds) {
		this.funds += funds;
	}
	/** Returns funds of ice cream truck */
	public double getFunds(){
		return funds;
	}
	/**
	 * Buys ice cream wholesale if truck has sufficient funds 
	 * @param name
	 * @param scoops
	 * @param cost
	 * @param wholesaleCost
	 * @return <code>true<code> if truck has sufficient funds
	 */
	public boolean buyIcecreamWholesale(String name, int scoops, double cost, double wholesaleCost){
		Flavor flavor = new Flavor(name, scoops, cost, wholesaleCost, flavors.getSize());
		transaction = computeTransaction(flavor.getWholesaleCostPerScoop(), scoops);
		if (funds >= transaction){
			flavors.add(flavor);
			purchases+=(transaction);
			funds-=(transaction);
			System.out.printf("Flavor added: %s\n", flavor.getFlavorName());
			return true;
		}
		return false;
	}
	/**
	 * Buys additional flavors
	 * Throws exception if truck has insufficient funds
	 * @param name
	 * @param scoops
	 * @param cost
	 * @param wholesaleCost
	 */
	public void purchaseAdditionalFlavors(String name, int scoops, double cost, double wholesaleCost){
		if (!buyIcecreamWholesale(name, scoops, cost, wholesaleCost)){
			throw new IllegalArgumentException();
		}
	}
	/**
	 * Buys three basic flavors.
	 * @exception IllegalArgumentException if initial investment is insufficient.
	 */
	public void purchaseBasicFlavors(){
		if (!this.buyIcecreamWholesale("Vanilla", 24, 1.00, 0.50)){
			throwInvestmentException();
		}else if (!this.buyIcecreamWholesale("Chocolate", 32, 1.50, 1.00)){
			throwInvestmentException();
		}else if (!this.buyIcecreamWholesale("Strawberry", 16, 1.50, 1.00)){
			throwInvestmentException();
		}
	}
	/** Throws exception */ 
	public void throwInvestmentException(){
		funds = investment;
		throw new IllegalArgumentException();
	}
	/**
	 * Sells requested flavor of ice cream
	 * Throws exception if there is not enough ice cream
	 * @param index
	 * @param scoops
	 * @exception IllegalArgumentException if not enough ice cream
	 */
	public void sellIcecream(int index, int scoops){
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		Flavor flavor = flavors.getFlavor(index);
		if (flavor.getNumberOfScoops() >= scoops){
			flavors.update(flavor, scoops*-1);
			transaction = computeTransaction(flavor.getCostPerScoop(), scoops);
			System.out.println("Customer owes " + fmt.format(transaction));
			sales += transaction;
			funds += transaction;
		}else{
			throw new IllegalArgumentException("Not enough of the chosen flavor");
		}
	}
	/** Returns total value of ice cream bought wholesale */
	public double getTotalPurchases(){
		return purchases;
	}
	/** Returns total value of ice cream sold */
	public double getTotalSales(){
		return sales;
	}
	/** Returns total number of scoops of ice cream sold */
	public int getTotalScoops(){
		return flavors.getTotalScoops();
	}
	/** Returns total expected sales based on value of missing ice creams */
	public double getTotalExpectedSales(){
		return flavors.getMissingValue();
	}
	/** Returns total profit based on purchases and sales */
	public double getProfit(){
		return sales-purchases;
	}
	/**
	 * Returns cost of the requested number of scoops of ice cream 
	 * @param cost
	 * @param scoops
	 */
	public double computeTransaction(double cost, int scoops) {
		return scoops*cost;
	}
	/** Prints information about all available flavors */
	public void printFlavors(){
		flavors.sortFlavors();
      	System.out.printf("%-20s %10s   %10s%s\n", "Flavor", "Scoops left", "Cost per scoop", flavors); 
	}
	/** 
	 * Adds new driver with certain permissions
	 * @param name
	 * @param driveTruck
	 * @param accessRegister
	 */
	public void addDriver(String name, boolean driveTruck, boolean accessRegister){
		Driver driver = new Driver(name, driveTruck, accessRegister, drivers.getSize());
		drivers.add(driver);
		System.out.println("Employee added");
	}
	/**
	 * Returns driver based on index id
	 * @param index
	 */
	public Driver getDriver(int index){
		return drivers.getDriver(index);
	}
	/** Prints information about all sales */
	public void checkCashBox(){
		System.out.printf("\nStartingCash: %10.2f\nIcecream bought: %10.2f"
				+ "\nIcecream sold: %10.2f" + "\nExpected sales from missing inventory: %10.2f"
				+ "\nCash in truck: %10.2f\nProfit: %10.2f", investment, this.getTotalPurchases(),
				this.getTotalSales(), this.getTotalExpectedSales(), this.getFunds(), 
				this.getProfit());
	}
	/**
	 * Checks too see if driver has permission to drive and access register
	 * @param index
	 * @return <code>true<code> if driver has full access
	 */
	public boolean driverFullAccess(int index){
		Driver driver = getDriver(index);
		if (driver.accessRegister() && driver.driveTruck()){
			return true;
		}
		return false;
	}
	/**
	 * Checks too see if driver has permission to drive
	 * @param index
	 * @return <code>true<code> if driver has permission to drive
	 */
	public boolean driveTruck(int index){
		Driver driver = getDriver(index);
		if (driver.driveTruck()){
			return true;
		}
		return false;
	}
	/**
	 * Checks too see if driver has permission to access register
	 * @param index
	 * @return <code>true<code> if driver has permission to access register
	 */
	public boolean accessRegister(int index){
		Driver driver = getDriver(index);
		if (driver.accessRegister()){
			return true;
		}
		return false;
	}
	/** Print information about all available drivers */
	public void printDrivers(){
		drivers.sortDrivers();
		System.out.println("Select the Employee:" + drivers);
	}
}
