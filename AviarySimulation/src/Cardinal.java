/**
 * @author Cherubin Manokaran
 * Programming Assignment 3 Part 2
 * Aviary Simulation
 * cmanokaran@brandeis.edu
 */

import java.awt.*;

// Creates Cardinal class defining behavior and state of a Cardinal object
public class Cardinal extends AbstractBird implements AviaryConstants{
    private boolean upward;

    // Constructs Cardinal at location (x,y)
    public Cardinal(int x, int y){
        super(x, y);
        super.trackTotalCreated();
        super.setColor(Color.RED);
    }
    // Moves bird based upon specified behavior
    public void fly() {
        // If the bird is at the edges, changes direction
        if (super.getY() == SIZE - 1){
            upward = false;
        }
        else if (super.getY() == 0 ){
            upward = true;
        }
        if (upward){
            super.translateDown();
        }
        else {
            super.translateUp();
        } 
        super.trackTimesFlown();
    }
}

