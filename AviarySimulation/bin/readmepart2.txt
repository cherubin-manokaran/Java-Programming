Cherubin Manokaran
cmanokaran@brandeis.edu
COSI 12b
Programming Assignment 3.2
Aviary Simulation

Implements the following interfaces:
Bird.java
AviaryConstants.java

Implements the following classes:
AbstractBird.java
Cardinal.java
Hummingbird.java
Bluebird.java
Vulture.java

Tests classes using Aviary.java and DrawingPanel.java client programs

The program was designed to define the behavior of birds in a client aviary simulation program. 
The program represents four types of birds: cardinals, humming birds, bluebirds and vultures.
As defined in the Bird interface, every bird has a color and position and can fly.
As defined in the AbstractBird class, some behaviors will be common among the birds.
Birds are always assigned a color.
In order to fly the birds must move in four directions.
For this reason, methods that alter their x and y coordinates are implemented.
The number of birds created and the number of times birds have flown are also tracked.

All four types of birds are given specific fields and behavior.
Each bird type is given a different color and follows unique patterns in flight.

The provided client program creates an array of birds of each type. 
The flying pattern and color of each bird type is simulated on a panel have coordinates from (0,0) to (19,19)