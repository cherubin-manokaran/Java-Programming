/**
 * @author Cherubin Manokaran
 * Programming Assignment 0
 * Ice cream Truck
 * cmanokaran@brandeis.edu
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Object for storing flavors
 * @author Manokaran
 */
public class Flavors {
	private ArrayList<Flavor> flavors;
	private int totalScoops;
	
	/**
	 * Constructor for the Flavors class.
	 * Uses ArrayList to store ice cream flavors.
	 */
	public Flavors() {
		flavors = new ArrayList<Flavor>();
	}
	/**
	 * Adds flavor to flavors ArrayList
	 * @param flavor
	 */
	public void add(Flavor flavor){
		flavors.add(flavor);
	}
	/** Returns the number of flavors */
	public int getSize(){
		return flavors.size();
	}
	/** 
	 * Updates the number of scoops of a flavor 
	 * @param flavor
	 * @param scoops
	 */
	public void update(Flavor flavor, int scoops){
		flavors.remove(flavors.indexOf(flavor));
		flavor.updateNumberOfScoops(scoops);
		this.add(flavor);
	}
	/**
	 * Returns flavor based on index id
	 * Otherwise returns null
	 * @param index
	 * @return flavor
	 */
	public Flavor getFlavor(int index){
		for (Flavor flavor:flavors){
			if (flavor.getIndex() == index){
				return flavor;
			}
		}
		return null;
	}
	/** Returns total number of scoops of ice cream */
	public int getTotalScoops() {
		totalScoops = 0;
		for (Flavor flavor:flavors){
			totalScoops += flavor.getNumberOfScoops();
		}
		return totalScoops;
	}
	/** Returns value of missing ice cream to determine expected sales */ 
	public double getMissingValue(){
		double value = 0;
		for (Flavor flavor:flavors){
			value += (flavor.getCostPerScoop()*(flavor.getInitNumberOfScoops()-flavor.getNumberOfScoops()));
		}
		return value;
	}
	/** Sorts flavors based on index id */
	public void sortFlavors(){
		Collections.sort(flavors);
	}
	/** Returns table containing information about all flavors */
	public String toString() {
		String information = "";
		for (Flavor flavor:flavors){
			information = information + "\n" + flavor.toString();
		}
		return information;
	}
}
