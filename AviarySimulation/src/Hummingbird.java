/**
 * @author Cherubin Manokaran
 * Programming Assignment 3 Part 2
 * Aviary Simulation
 * cmanokaran@brandeis.edu
 */

import java.util.Random;
import java.awt.*;

// Creates Hummingbird class defining behavior and state of a Hummingbird object
public class Hummingbird extends AbstractBird {
    // Constructs Hummingbird at location (x,y)
    public Hummingbird(int x, int y){
        super(x, y);
        super.trackTotalCreated();
        super.setColor(Color.MAGENTA);
    }
    
    // Moves bird based upon specified behavior
    public void fly(){   
        // Generates coordinates between (0,0) and (19,19)
    	// Flies to those coordinates
        Random randomNumberGenerator = new Random();
        super.setX(randomNumberGenerator.nextInt(20));
        super.setY(randomNumberGenerator.nextInt(20));
        super.trackTimesFlown();
    }
}