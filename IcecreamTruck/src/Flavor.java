/**
 * @author Cherubin Manokaran
 * Programming Assignment 0
 * Ice cream Truck
 * cmanokaran@brandeis.edu
 */

/**
 * Various attributes of flavor and related behavior.
 * @author Manokaran
 */
public class Flavor implements Comparable<Flavor>{
	private String name;
	private int initNumberOfScoops;
	private int numberOfScoops;
	private double costPerScoop;
	private double wholesaleCostPerScoop;
	private int index;
	
	/**
	 * Constructor for the Flavor class
	 * 
	 * @param name name of the ice cream flavor
	 * @param scoops number of scoops to start
	 * @param cost cost per scoop for sales
	 * @param wholesaleCost wholesale cost per scoop for purchase
	 * @param index flavor id
	 */
	public Flavor(String name, int scoops, double cost, double wholesaleCost, int index){
		this.name = name;
		this.setNumberOfScoops(scoops);
		this.setInitNumberOfScoops(scoops);
		this.setCostPerScoop(cost);
		this.setWholesaleCostPerScoop(wholesaleCost);
		this.setIndex(index);
    }
	/** Return name of flavor */
	public String getFlavorName(){
		return name;
	}
	/**
	 * Sets number of scoops
	 * @param scoops
	 */
	public void setNumberOfScoops(int scoops){
		numberOfScoops = scoops;
	}
	/**
	 * Sets and stores initial number of scoops
	 * @param scoops
	 */
	private void setInitNumberOfScoops(int scoops){
		initNumberOfScoops = scoops;
	}
	/** Returns number of scoops */
	public int getNumberOfScoops(){
		return numberOfScoops;
	}
	/** Returns initial number of scoops */
	public int getInitNumberOfScoops(){
		return initNumberOfScoops;
	}
	/**
	 * Update number of scoops
	 * @param scoops
	 */
	public void updateNumberOfScoops(int scoops){
		numberOfScoops += scoops;
	}
	/**
	 * Sets cost per scoop for sales
	 * @param cost
	 */
	public void setCostPerScoop(double cost){
		costPerScoop = cost;
	}
	/** Returns cost per scoop for sales */
	public double getCostPerScoop(){
		return costPerScoop;
	}
	/**
	 * Sets wholesale cost per scoop for purchases
	 * @param cost
	 */
	public void setWholesaleCostPerScoop(double cost){
		wholesaleCostPerScoop = cost;
	}
	/** Returns wholesale cost per scoop for purchases */
	public double getWholesaleCostPerScoop(){
		return wholesaleCostPerScoop;
	}
	/** 
	 * Sets index id of flavor
	 * @param index
	 */
	private void setIndex(int index){
		this.index = index;
	}
	/** Returns index id of flavor */
	public int getIndex(){
		return index;
	}
	/** Return formatted string with flavor information */
	public String toString(){
		return String.format("%-20.20s %10d   %10.2f   %10d", name, numberOfScoops, costPerScoop, index);
	}
	/** 
	 * Compares ice cream flavor indices for sorting
	 * @param other flavor for comparison
	 */
	public int compareTo(Flavor other) { 
		if (this.index != other.index)
			return this.index - other.index;
		else
			return 0;
	}
}
