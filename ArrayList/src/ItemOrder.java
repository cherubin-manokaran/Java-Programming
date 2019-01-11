/**
 * @author Cherubin Manokaran
 * Programming Assignment 4
 * Shopping Program
 * cmanokaran@brandeis.edu
 */

// Defines behavior of item orders
// Implements Comparable interface in order to compare item orders
public class ItemOrder implements Comparable<ItemOrder> {
	private Item item;
	private int quantity;
	
	// Constructs new item order
	public ItemOrder(Item item, int quantity){
		this.item = item;
		this.quantity = quantity;
	}
	
	// Returns price of item for specified quantity in item order
	public double getPrice(){
		return item.priceFor(quantity);
	}
	
	// Returns item in item order
	public Item getItem(){
		return item;
	}
	
	// Returns item order as string
	public String toString(){
		return String.format("%s, %d", item.getName(),quantity);
	}
	
	public int compareTo(ItemOrder other) { 
		if (this.quantity != other.quantity)
			return this.quantity - other.quantity;
		else
			return 0;
	}
}
