/*
  * File: LetterCounterDriver.java
  * Auther: Caleb Howard
  * Date: 28/2/2018
  * The following program accepts a string from the user and determines how many
times each letter of the alphabet occurs. 
*/
package lab2;

import java.util.Scanner;
import validatedata.DataValidation;


public class LetterCounterDriver {
  
  public static void main(String[] args){
    
    boolean exit = false;// boolean used for main loop
    
    // introduction
    System.out.println("===========================================");
    System.out.println("             <<Letter Counter>>      \n");
    System.out.println("Welcome to Letter Counter. The way " + 
            "this program\nworks is very simple. " + 
            "All you have to do is enter \na string of characters " + 
            "such as \"Happy Birthday!\" \nthen the program will count " + 
            "how many times\neach letter of the alphabet occurs. " + "You can" + 
            "even\n enter something like \"123ad58G*&Z@!\", and the program\n" +
            "will find the letters and count them.\n");
    System.out.println("===========================================\n");
      
    pressEnter();// waits for user to press enter
    
    // main program loop  
    while(!exit){
      
      // creates LetterCounter object
      LetterCounter counter = new LetterCounter();
      
      // promts user to enter a string
      System.out.println("============================================");
      System.out.println("Please enter your string of characters.\n");
      System.out.println("Example: George Washington");
      System.out.println("============================================");
      
      // Calls inputString method in DataValidation class
      String userInput = DataValidation.inputString();
    
      pressEnter();// waits on user to press enter
      
      // passes user input to counter object to count how many letters are in
      // the string
      counter.countLetters(userInput);
    
      // displays what the user type and in a table show how many times
      // each letter occurred
      System.out.println("============================================");
      System.out.println("The following table shows how many times\n" +
              "each letter of the alphabet occurs in \n" 
              + "\""+userInput+"\".");
    
      System.out.println(counter);
      System.out.println("============================================\n");
    
      pressEnter();// waits for user to press enter
      
      // promts user if they want to try again
      System.out.println("===================================");
      System.out.println("Would you like to try another one?");
      System.out.println("===================================");
    
      System.out.println( "1) Try again\n" + "2) Exit\n\n" + 
                "Choose what you want to do by entering\n" +
                "the corresponding number");
      // accepts and validates user input
      int userChoice = DataValidation.inputInteger(1, 2, 1);
      if(userChoice == 2){
        exit = true;// changes exit to true if user wants to leave
      }
      
    }
  }
  
  // this method waits until the user presses enter
  private static void pressEnter(){
    Scanner input = new Scanner(System.in);
    System.out.println("Press enter to continue");
    input.nextLine();
  }
}
 

