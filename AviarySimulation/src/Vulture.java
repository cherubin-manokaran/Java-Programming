/**
 * @author Cherubin Manokaran
 * Programming Assignment 3 Part 2
 * Aviary Simulation
 * cmanokaran@brandeis.edu
 */

import java.awt.*;

// Creates Vulture class defining behavior and state of a Vulture object
public class Vulture extends AbstractBird{
    private int directionFacing = 1;
    
    // Constructs Vulture at location (x,y)
    public Vulture(int x, int y){
        super(x, y);
        super.trackTotalCreated();
        super.setColor(Color.BLACK);
    }
    
    // Moves bird based upon specified behavior
    public void fly()
    {
        // Determines which way the bird is currently facing
        // Flies in that direction
    	// Resets directionFacing after all four directions have been traveled for circular motion
        if (directionFacing == 1){
            super.translateUp();
            ++directionFacing;
        } 
        else if (directionFacing == 2){
            super.translateLeft();
            ++directionFacing;
        }
        else if (directionFacing == 3){
            super.translateDown();
            ++directionFacing;
        } 
        else if (directionFacing == 4){
            super.translateRight();
            directionFacing = 1;
        } 
        super.trackTimesFlown();
    }
}
