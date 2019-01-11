/**
 * @author Cherubin Manokaran
 * Programming Assignment 0
 * Ice cream Truck
 * cmanokaran@brandeis.edu
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Object for storing drivers
 * @author Manokaran
 */
public class Drivers {
	private ArrayList<Driver> drivers;
	
	/**
	 * Constructor for the Drivers class.
	 * Uses ArrayList to store drivers.
	 */
	public Drivers(){
		drivers = new ArrayList<Driver>();
	}
	/**
	 * Adds driver to drivers ArrayList
	 * @param driver
	 */
	public void add(Driver driver){
		drivers.add(driver);
	}
	/** Returns number of drivers */
	public int getSize(){
		return drivers.size();
	}
	/**
	 * Returns driver based on index id
	 * @param index
	 */
	public Driver getDriver(int index){
		for (Driver driver:drivers){
			if (driver.getIndex() == index){
				return driver;
			}
		}
		return null;
	}
	/** Sorts all drivers based on index id */
	public void sortDrivers(){
		Collections.sort(drivers);
	}
	/** Returns table containing information about all drivers */	
	public String toString() {
		String information = "";
		for (Driver driver:drivers){
			information = information + "\n" + driver.toString();
		}
		return information;
	}
}
