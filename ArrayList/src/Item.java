/**
 * @author Cherubin Manokaran
 * Programming Assignment 4
 * Shopping Program
 * cmanokaran@brandeis.edu
 */

// Defines behavior of item
public class Item {
	private String name;
	private double price;
	private int bulkQuantity = 0;
	private double bulkPrice = 0;
	
	// Constructs new item
	public Item (String itemName, double itemPrice){
	    this.name = itemName;
	    this.price = itemPrice;
	}
	
	// Constructs new item
	public Item (String name, double price, int bulkQuantity, double bulkPrice){
	    this.name = name;
	    this.price = price;
	    this.bulkQuantity = bulkQuantity;
	    this.bulkPrice = bulkPrice;
	}

	// Returns the item name 
	public String getName(){
	    return name;
	}
	
	// Returns total price for item based on quantity, bulk quantity, and bulk price
	public double priceFor(int quantity) throws IllegalArgumentException{
		if (quantity < 0)
			throw new IllegalArgumentException("Negative Quantity");
		
		// Checks if there is no bulk quantity option
		if (bulkQuantity == 0)
			return price * quantity;
		
		// Checks to see if there is a bulk quantity option
		// Also checks if quantity is evenly divisible by bulk quantity
		else if (bulkQuantity != 0 && quantity % bulkQuantity == 0)
			return bulkPrice * (quantity / bulkQuantity);
		
		// Checks to see if there is a bulk quantity option
		// Also checks if quantity is not evenly divisible by bulk quantity
		else
			return price * (quantity % bulkQuantity) + bulkPrice * (quantity / bulkQuantity);
	}

	// Returns item information as string
	// Includes additional information if bulk quantity option exists
	public String toString(){
		String itemDescription = String.format("%s, $%,.2f", name, price);
		if (bulkQuantity != 0 || bulkPrice != 0 )
				itemDescription = itemDescription + String.format("(%d for $%,.2f", bulkQuantity, bulkPrice);
		return itemDescription;
	}
}
