Cherubin Manokaran
cmanokaran@brandeis.edu
COSI 12b
Programming Assignment 4.2
Shopping Program

Implements the following classes:
Item.java
Catalog.java
ItemOrder.java
ShoppingCart.java


Tests classes using ShoppingMain.java and ShoppingFrame.java client programs

The program was designed to define the behavior of items for a client shopping program. 
Items are created with an item price and name and sometimes also with a bulk quantity option
Price for items is calculated based on a quantity
A catalog for the items is created using an array list of the type item
The client program creates a such a catalog

An item order is also created with the item name and quantity
The Comparable interface is implemented here in order to compare the order quantities using the compareTo method
A shopping cart for the item orders is created using an array list of the type item order
The client program creates such a shopping cart
A sorted list of the shopping cart contents is generated