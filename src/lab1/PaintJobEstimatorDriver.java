/*
  * File: PaintJobEstimatorDriver.java
  * Auther: Caleb Howard
  * Date: 2/3/18
  * The following program allows the user to input information related to
painting, such as rooms, square footage, and price per gallon of paint. The 
program then calculates the total cost of the job according to what the company
charges.
*/
package lab1;
import java.util.Scanner;
import java.text.NumberFormat;
import validatedata.DataValidation;
/**
 *
 * @author caleb
 */
public class PaintJobEstimatorDriver {
  
  public static void main(String [] args){
   
    // variable used for program loop
    boolean exit = false;
    
    Scanner input = new Scanner(System.in);
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    
    
    
    
     
    // introduction
    System.out.println("========================================");
    System.out.println("Welcome! So you have some rooms that need painting?\n" +
            "We'll need the following information\n" + "1) How many rooms\n" + 
            "2) The square footage of each room \n" +
            "3) The price of paint per gallon\n");
    System.out.println("For every 115 square feet, it will take us 8 hours " + 
            "at $18.00 dollars a hour and 1 gallon of paint.\n");
    System.out.println("Press enter to continue");
    System.out.println("========================================");
    input.nextLine();
    
    // loop until user decides to exit
    while (!exit){
      // calls method to get user input for number of rooms
      int rooms = PaintJobEstimator.getRooms();
    
      pressEnter();// calls method that stops the program until enter is hit
    
      // calls method to get user input square footage for each room
      int squareFootage = PaintJobEstimator.getSquareFeet(rooms);
    
      pressEnter();// waits until enter is hit
      
      // calls method that gets the price per gallon of paint and calculates
      // the total cost of the job
      double total = PaintJobEstimator.getTotal(squareFootage);
    
      pressEnter();// waits until enter is hit
      
      // prints the total cost of the job
      System.out.println("============================================");
      System.out.println("The total cost of this job would be " 
              + fmt.format(total));
      System.out.println("============================================\n\n");
      
      // promts user if they want exit or do any estimation
      System.out.println("==========================================");
      System.out.println("Enter 1 if you want to input another job\n" +
              "Enter 0 if you wish to exit");
      System.out.println("==========================================");

      int userInput = DataValidation.inputInteger(1);     
      
      // if user choose 0 exit becomes true and the program ends
      if (userInput == 0){
        exit = true;
      }
    
    
    }
  }
  
  
  
  
  // the following method pauses the program and promts the user to press enter
  // to continue
  public static void pressEnter(){
    Scanner input = new Scanner(System.in);
    System.out.println("Thank you. Press enter to continue");
    input.nextLine();
  }


}


