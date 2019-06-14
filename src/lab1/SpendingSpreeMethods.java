/*
  * File: SpendingSpree.java
  * Auther: Caleb Howard
  * Date: 1/31/18
  * the following class contains print methods used in SpendingSpree.java
*/
package lab1;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author caleb
 */
public class SpendingSpreeMethods {
  // the following method prints the intro
  public static void intro(){
    System.out.println("=================================================");
    System.out.println("Welcome to my store. It appears you have won a\n"
              + "$200 gift card. Why don't you look at my selection, "
              + "and \nsee if you like anything? We "
              + "have a 3 item per person rule around here\n"
              + "so keep that in mind.\n" + "\nPress enter to continue.");
    System.out.println("=================================================");
  
  }
  // The following method prints what the user bought  
  public static void itemBought(String item){
    System.out.println("=============================");
    System.out.println("Here's your " + item);
    System.out.println("Thank you for your purchase.");
    System.out.println("=============================");
  }
  // the following method prints that the user does have enough money
  public static void insufficientFunds(){
    System.out.println("====================================");
    System.out.println("Sorry you don't have enough " + 
            " money to purchase this item.");
    System.out.println("====================================");
  }
  
  

}
