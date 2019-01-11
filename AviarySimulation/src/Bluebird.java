/**
 * @author Cherubin Manokaran
 * Programming Assignment 3 Part 2
 * Aviary Simulation
 * cmanokaran@brandeis.edu
 */

import java.awt.*;

// Creates Bluebird class defining behavior and state of a Bluebird object
public class Bluebird extends AbstractBird implements AviaryConstants{
	// Begins as though bird is at left edge
    private boolean leftEdge = true;
    private boolean rightEdge = false;
    private boolean upright = true;
    private boolean upleft = true;
    
    // Constructs Bluebird at location (x,y)
    public Bluebird(int x, int y){
        super(x, y);
        super.trackTotalCreated();
        super.setColor(Color.BLUE);
    }
    
    // Moves bird based upon specified behavior
    public void fly(){
        // Switches direction if bird is at edge of panel
        if (super.getX() == 0){
            leftEdge = true;
        }
        else if (super.getX() == SIZE){
            rightEdge = true;
        	leftEdge = false;
        }
        if (leftEdge){
        	// Follows zigzag pattern
        	if (upright){
                super.translateDown();
                super.translateRight();
                upright = false;
            } else {
                super.translateUp(); 
                super.translateRight();         
                upright = true;
            } 
        } 
        else if (rightEdge){
        	// Follows zigzag pattern
        	if (upleft){
                super.translateDown();
                super.translateLeft();
                upleft = false;
        	} else {
                super.translateUp();
                super.translateLeft();
                upleft = true;
            }
        } 
        super.trackTimesFlown();
    }
}