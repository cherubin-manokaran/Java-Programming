/**
 * @author Cherubin Manokaran
 * Programming Assignment 3 Part 2
 * Aviary Simulation
 * cmanokaran@brandeis.edu
 */

import java.awt.*;

// Describes behavior of all birds
public abstract class AbstractBird implements Bird {
	private int timesFlown = 0;
	private Color color;
    private static int birdsCreated = 0;
    private int x;
    private int y;
    
	public AbstractBird(int x, int y){
        this.x = x;
        this.y = y;
    }
    // Increments number of times flown
    public void trackTimesFlown(){
        ++this.timesFlown;
    }
    // Returns number of times flown
    public int getFlown(){
        return this.timesFlown;
    }
    // Increments the number of birds created.
    public void trackTotalCreated(){
        AbstractBird.birdsCreated = this.create();
    }
    // Returns number of birds created
    public int create(){
        return AbstractBird.birdsCreated;
    }
    // Sets bird color
    public void setColor(Color c){
        this.color = c;
    }
    // Returns bird color 
    public Color getColor(){
        return this.color;
    }
    // Differs based on bird type
    public abstract void fly();
    // Returns the coordinates of the bird as a point
    public Point getPosition() {
        return new Point(this.getX(), getY());
    }
    // Sets the value of x
    public void setX(int x) {
        this.x = x;
    }
    // Sets the value of y
    public void setY(int y) {
        this.y = y;
    }
    // Returns the value of x
    public int getX() {
        return this.x;
    }
    // Returns the value of y
    public int getY() {
        return this.y;
    }
    // Translates a point up one
    public void translateUp() {
        this.setY(this.getY() - 1);
    }
    // Translates a point down one
    public void translateDown() {
        this.setY(this.getY() + 1);
    }
    // Translate a point left one
    public void translateLeft(){
        this.setX(this.getX() - 1);
    }
    // Translates a point right one
    public void translateRight() {
        this.setX(this.getX() + 1);
    }
}
