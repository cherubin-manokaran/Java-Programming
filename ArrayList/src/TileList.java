/**
 * @author Cherubin Manokaran
 * Programming Assignment 4
 * Shopping Program
 * cmanokaran@brandeis.edu
 */

import java.util.ArrayList;

// Defines behavior of tile list
// Creates and stores tiles in array list
public class TileList {
	private ArrayList<Tile> tiles;
	
	// Constructs new tile list
	public TileList(){
		tiles = new ArrayList<Tile>();
	}
	
	// Checks to see if provided x and y value are within tile
	// If so, moves tile to back
	// Returns tile
	public Tile moveToBack(int x, int y){
		for (int i=0; i<this.size(); i++){
			if (tiles.get(i).inside(x, y)){
				this.insertBack(this.get(i));
				return this.get(i);
			}
		}
		return null;
	}
	
	// Adds tile to tile list
	public void insertBack(Tile t){
		tiles.add(t);
	}
	
	// Returns number of tiles in list
	public int size(){
		return tiles.size();
	}
	
	// Returns tile at provided index
	public Tile get(int index){
		return tiles.get(index);
	}
	
}
