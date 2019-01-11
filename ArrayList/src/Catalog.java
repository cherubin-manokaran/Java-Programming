/**
 * @author Cherubin Manokaran
 * Programming Assignment 4
 * Shopping Program
 * cmanokaran@brandeis.edu
 */

import java.util.ArrayList;

// Defines behavior of catalog
// Creates and stores items in array list
public class Catalog {
	private ArrayList<Item> collection;
	private String name;
	
	// Constructs new catalog
	public Catalog(String name){
		this.name = name;
		collection = new ArrayList<Item>();
	}
	
	// Adds new item to array list and total
	public void add(Item item){
		collection.add(item);
	}
	
	// Returns size of or number of item types in catalog
	public int size(){
		return collection.size();
	}
	
	// Returns item at provided index
	public Item get(int index){
		return collection.get(index);
	}
	
	// Returns catalog name
	public String getName(){
		return name;
	}
}
