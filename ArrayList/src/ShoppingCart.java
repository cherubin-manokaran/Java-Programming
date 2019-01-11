/**
 * @author Cherubin Manokaran
 * Programming Assignment 4
 * Shopping Program
 * cmanokaran@brandeis.edu
 */

import java.util.ArrayList;
import java.util.Collections;

// Defines behavior of shopping cart
// Creates and stores item orders in array list
public class ShoppingCart {	private ArrayList<ItemOrder> cart;
	private double totalCost = 0;
	
	// Constructs new shopping cart
	public ShoppingCart(){
		cart = new ArrayList<ItemOrder>();
	}
	
	// Adds new item order to array list and total cost
	// Subtracts costs of previous orders of same type
	// Removes those order from array list
	public void add(ItemOrder order){
		for (int i=0; i<cart.size(); i++){
			if (cart.get(i).getItem() == order.getItem()){
				totalCost -= cart.get(i).getPrice();
				cart.remove(i);
			}
		}
		cart.add(order);
		totalCost += order.getPrice();
	}
	
	// Returns total cost of order
	public double getTotal(){
		return totalCost;
	}
	
	// Applies discount if value is true
	public void setDiscount(boolean value){
		if (value)
			totalCost *= .9;
		else
			totalCost /= .9;
	}
	
	// Sorts order based on quantities from low to high
	public void sortCart(){
		Collections.sort(cart);
	}
	
	// Returns all orders as a string
	public String toString(){
		return cart.toString();
	}
}
