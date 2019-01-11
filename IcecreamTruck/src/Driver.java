/**
 * @author Cherubin Manokaran
 * Programming Assignment 0
 * Ice cream Truck
 * cmanokaran@brandeis.edu
 */

/**
 * Various attributes of driver and related behavior.
 * @author Manokaran
 */
public class Driver implements Comparable<Driver>{
	private String name;
	private int index;
	private boolean driveTruck = false;
	private boolean accessRegister = false;
	
	/**
	 * Constructor for the Driver class
	 * 
	 * @param name name of the driver
	 * @param dT permission to drive truck
	 * @param aR permission to access register
	 * @param index driver id
	 */
	public Driver(String name, boolean dT, boolean aR, int index){
		this.name = name;
		driveTruck = dT;
		accessRegister = aR;
		this.setIndex(index);
	}
	/** Returns name of driver */
	public String getName(){
		return name;
	}
	/** 
	 * Sets index id of driver 
	 * @param index
	 */
	private void setIndex(int index){
		this.index = index;
	}
	/** Returns index id of driver */
	public int getIndex(){
		return index;
	}
	/** Returns whether driver has permission to drive truck */
	public boolean driveTruck(){
		return driveTruck;
	}
	/** Returns whether driver has permission to access register */
	public boolean accessRegister(){
		return accessRegister;
	}
	/** Returns formatted string containing information about driver */
	public String toString(){
		return String.format("%d: %s", index, name);
	}
	/**
	 * Compares ice cream flavor indices for sorting
	 * @param other
	 */
	public int compareTo(Driver other) { 
		if (this.index != other.index)
			return this.index - other.index;
		else
			return 0;
	}
}
