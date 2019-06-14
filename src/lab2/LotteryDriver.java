/*
  * File: LotteryDriver.java
  * Auther: Caleb Howard
  * Date: 24/2/2018
  * The following program simulates a lottery where the user inputs five numbers, 
and the computer compares the numbers to five randomly generated ones to see how
many match.
*/
package lab2;

import java.util.Scanner;
import validatedata.DataValidation;
import validatedata.RegxValidation;

public class LotteryDriver {
  public static void main(String[] args){
    
    
    String numFormat = ""; // string used for formating number suffix
    boolean exit = false; // main loop boolean
    
    // array used to store user's lottery numbers
    int[] userNumbers = new int[5];
    
    // introduction
    System.out.println("===========================================");
    System.out.println("       Welcome to Lottery $imulator\n\n" + 
            "The way it works is the simulator will generate\n" +
            "5 random numbers. Then you will enter 5 numbers\n" + 
            "between 0-9. After that, the simulator will determine\n" + 
            "how many of the numbers match. " + "If all of the numbers " + 
            "match then\n"+ "you'll win 350,000,000 simulated dollars!\n");
    
    System.out.println("Note that they have to be the same number and\n" +
            "in the same spot to count as a match.");
    System.out.println("===========================================");
    
    pressEnter();// waits for user to hit enter
    
    // main game loop
    while (!exit){
      
      Lottery numberMatch = new Lottery();// creates Lottery object
      
      // accepts 5 integers from the user
      for(int i = 0; i < 5; i++){
        // detemines number suffix 1st 2nd 3rd etc
        switch(i){
          case(0): numFormat = "st"; //1st
            break;
          case(1): numFormat = "nd"; //2nd
            break; 
          case(2): numFormat = "rd"; //3rd
            break;
          case(3): numFormat = "th"; //4th, 5th
        }
        System.out.println("======================================");
        System.out.println("Please enter your " + (i + 1) + 
                numFormat +" number");
        System.out.println("======================================");
        // validates input, making sure it's an integer ranging from 0-9
        userNumbers[i] = DataValidation.inputInteger(0, 9, 5);
        pressEnter();// waits for user to press enter  
      }
      /* accepts user's numbers and calculates how many of them match
      the lottery numbers */
      int matchingNumbers = numberMatch.lotteryMatches(userNumbers);
      
      // prints toString method of number match
      System.out.println("=======================================");
      System.out.println(numberMatch);
      System.out.println("=======================================");
      
      // checks if all of the user's numbers match
      if(matchingNumbers == 5){
        System.out.println("Congratulation!\n\n" + // user wins
                "You won the grand prize of " + 
                "$350,000,000.\n");
      }else{
        System.out.println("Sorry you lost.\n\n" + // user loses
                "All of the numbers have to\n" + 
                "match in order to win.\n");
      }
          
      pressEnter(); // waits for user to press enter
      
      // promts user if they want to try again
      System.out.println("=======================================");
      System.out.println("Do you want to have another go at it?");
      System.out.println("=======================================\n");
      System.out.println( "1) Try again\n" + "2) Exit\n\n" + 
              "Choose what you want to do by entering\n" +
              "the corresponding number");
      // accepts and validates user input
      int userChoice = DataValidation.inputInteger(1, 2, 1);
      
      // exits if user enters 2
      if (userChoice == 2){
        exit = true;
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


