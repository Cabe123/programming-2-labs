/*
  * File: RandomIntegersMain.java
  * Auther: Caleb Howard
  * Date: 2/4/2018
  * The following program writes and sorts 100 random integers to a file. 
It then reads the integers from the file and prints them.
*/

package Lab3;

import java.util.Scanner;

public class RandomIntegersMain {
 
  public static void main(String[] args){
    // introduction
    System.out.println("=============================================");
    System.out.println("The following program will write 100 random integers \n" + 
            "to a file then read and print the integers from the file.");
    System.out.println("=============================================");
    pressEnter();// waits for user to press enter
    
    WriteToFile.write();// writes 100 random ints to file
    
    // prompts user that the file has been added to 
    System.out.println("===================================");
    System.out.println("The file now has the numbers.\n"+
    "Continue to read and print the file.");
    System.out.println("===================================");
    
    pressEnter();// waits for user to press enter
    
    ReadFromFile.read();// reads and prints data from file
  
  }
  
  
  // the following method prompts and waits for the user to press enter
  private static void pressEnter(){
    Scanner input = new Scanner(System.in);
    System.out.println("Press enter to continue");
    input.nextLine();
  }
}

