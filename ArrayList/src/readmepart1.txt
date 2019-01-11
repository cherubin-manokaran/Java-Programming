Cherubin Manokaran
cmanokaran@brandeis.edu
COSI 12b
Programming Assignment 4.1
Shopping Program

Implements the following classes:
TileList.java
Tile.java
TileListener.java
TileFrame.java
TilePanel.java

Tests classes using TileMain.java client program

The program was designed to define the behavior of tiles for a client tile program.
Users should be able to create and move tiles of all sizes and three different colors.
Users should also be able to click on a tile to bring it to the front in the case that it is behind another.

This is achieved by creating and storing tiles in an array list.
Creating a new tile may be achieved by clicking to indicate the beginning and dragging to indicate the end point
Upon creating a tile, it is added to the end of the list.
Also if a previously created tile is behind another, it can be brought to the front by clicking on it.
This achieved with the moveToBack function. 
After the hidden tile is found it is added to the back of the list to be displayed in the front.
  