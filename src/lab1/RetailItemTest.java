/*
  * File: RetailItemTest.java
  * Auther: Caleb Howard
  * Date: 2/5/18
  * the following program allows the user to input data that is then set to a 
retail item object. It then prints the data stored in 3 retail item objects
*/
package lab1;

import java.util.Scanner;
import validatedata.DataValidation;

/**
 *
 * @author caleb
 */
public class RetailItemTest {
  
  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    
    // creating item objects
    RetailItem item1 = new RetailItem("Jacket", 59.95, 12);
    RetailItem item2 = new RetailItem("Designer Jeans", 34.95 , 40);
    RetailItem item3 = new RetailItem();
    
    // introduction
    System.out.println("===========================================");
    System.out.println("<<<<<<<<<Retail Item Warehouse>>>>>>>>>>>>>");
    System.out.println("To enter a new item into the warehouse item " + 
            "tracker");
    System.out.println("you will need to know the following information");
    System.out.println("Description: Shoes, T-Shirt, etc\n" + 
                       "Item Price: 14.99, 75.95, etc\n" +
                       "Units in Stock: 25, 57, etc");
    System.out.println("Press enter to continue");
    System.out.println("===========================================");
    input.nextLine();
    
    
    // promts user to enter item descritption
    System.out.println("========================================");
    System.out.println("Please enter the description of the item");
    System.out.println("========================================");
    
    // accepts and validates user input of type String
    String itemDescript = DataValidation.inputStringLessThanEqualTo(20);
    // sets description to item3
    item3.setItemDescription(itemDescript);
    
    pressEnter();// waits until user hits enter
    
    // promts user to enter item price
    System.out.println("==================================");
    System.out.println("Please enter the price of the item");
    System.out.println("==================================");
    
    // accepts and validates user input of type double
    double itemPrice = DataValidation.inputDoubleGreaterThan(0, 14.95);
    // sets price to item3
    item3.setItemPrice(itemPrice);
    
    pressEnter();// waits until user hits enter
    
    // promts user to enter the number of units in stock of item
    System.out.println("=========================================");
    System.out.println("Please enter the number of units in stock");
    System.out.println("=========================================");
    
    // accepts and validates user input of type int
    int unitsInStock = DataValidation.inputIntegerGreaterThan(-1, 14);
    item3.setUnitsInStock(unitsInStock);
    
    pressEnter();// waits until user hits enter
    
    
    // prints items in a table
    System.out.println("=====================================================");
    System.out.println("\t\tDiscription      Units on Hand          Price");
    System.out.println("Item #1\t\t" + item1);
    System.out.println("item #2\t\t" + item2);
    System.out.println("item #3\t\t" + item3);
    System.out.println("=====================================================");
    
    
    
    
  
  }
 
  
  
  
   // the following method pauses the program and promts the user to press enter
  // to continue
  public static void pressEnter(){
    Scanner input = new Scanner(System.in);
    System.out.println("Thank you. Press enter to continue");
    input.nextLine();
  }
}
