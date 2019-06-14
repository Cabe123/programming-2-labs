/*
  * File: SpendingSpree.java
  * Auther: Caleb Howard
  * Date: 1/31/18
  * The following program promts the user that they have won a $200 gift card
to a store. The user then chooses items from a list. If they have bought
less than three items and have enough money they can then purchase the item.
*/
package lab1;

import java.util.Scanner;
import java.text.NumberFormat;
import validatedata.DataValidation;

public class SpendingSpree {


  
  public static void main(String[] args) {
    
    final int GIFT_CARD_AMOUNT = 200; // the amount of money on the gift card.
    final int MAX_ITEMS = 3; // the maximum items the user can buy
    
    // variables
    String itemsBoughtList = "";
    String itemList = "======================\n";
    boolean exit = false;
    double amountLeft = GIFT_CARD_AMOUNT;
    int itemsBought = 0;
    int itemNum = 1;
    
    // Scanner Declaration
    Scanner input = new Scanner(System.in); 
    // formatter used for item prices
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    
    // arrays used for items
    String[] itemNames = {"T-Shirt","Sun Glasses","Wooden Chair","Necklace",
      "Stereo Speakers","Golf Club","Computer"};
    double[] itemPrices = {9.99, 24.99, 39.99, 74.99, 89.99, 149.99, 179.99};
    
    // loop that create the list of items
    for(int i = 0; i < itemNames.length; i++){  
      itemList += (i + 1) + ") " + itemNames[i] + ": " +
              fmt.format(itemPrices[i]) + "\n";
      if ((i + 1) == itemNames.length){
        itemList += "\nenter the number next to \n" + 
                "the item you want purchase.\n";
        itemList += "======================";
      }
    }
    
 
    // calls intro message
    SpendingSpreeMethods.intro();
    input.nextLine();
    
    // main program loop
    do{
      // checks if there's more money than the cheapest item price
      if (amountLeft > itemPrices[0]){
        // checks if the user has bought fewer then the maximum number items 
        if(itemsBought < MAX_ITEMS){
         
          // prints item list and how much money the user has left
          System.out.println(itemList);
          System.out.println();
          System.out.println("You have " + fmt.format(amountLeft) + 
                    " left of your gift card." );
          // call method to get user input of type int between 1 and array length
          itemNum = DataValidation.inputInteger(1, itemNames.length, 4);
          
          // checks if the user has enough money to buy selected item
          if (amountLeft >= itemPrices[itemNum - 1]){ 
            // calls method that prints user item bought
            SpendingSpreeMethods.itemBought(itemNames[itemNum - 1]);
            // takes away item price from the amount left on card
            amountLeft -= itemPrices[itemNum - 1];
            
            itemsBought++;
            // creates a list of what the user has bought
            itemsBoughtList += "\t" + itemsBought + ") " + 
                    itemNames[itemNum -1] + "\n";
            System.out.println();
            
          
          }else{
            // call method that prints that the does have enough money
            SpendingSpreeMethods.insufficientFunds();
          }
        
        }else{
          exit = true;// changes exit to true so it will exit the loop
          
          // prints if the user has to many items
          System.out.println("===================================");
          System.out.println("Sorry you have bought to many items.");
          System.out.println("You still have " + fmt.format(amountLeft) +
                  " on your card. Maybe comeback another day.");
          System.out.println("===================================");
        }
      }else{
        exit = true;// exit to true so it will exit the loop
        // prints if the user does have enough money to buy any of the items
        System.out.println("===============================================");
        System.out.println("It seems you don't have enough money to buy any " + 
                "of the items.");
        System.out.println("You still have " + fmt.format(amountLeft) + 
                " on your card. Maybe comeback when you have more money.");
        System.out.println("===============================================\n");
      }
      
      // hold program until user is ready to continue
      System.out.println("Press enter to continue.");
      input.nextLine();
      
    }while(!exit);
    // prints the list of items the user bought
    System.out.println("============================");
    System.out.println("You bought the following.");
    System.out.println(itemsBoughtList);
    System.out.println("============================");
    
  }
  
}
