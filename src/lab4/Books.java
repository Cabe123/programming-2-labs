/*
  * File: Books.java
  * Auther: Caleb Howard
  * Date: 29/4/2018
  * The following class contains a method to read book names and prices from
a file that is used in the program BookStore.java
*/

package lab4;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.text.NumberFormat;


public class Books {
 // arrayList used to store book information
 static ArrayList<Double> bookPrice = new ArrayList<Double>();
 static ArrayList<String> bookName = new ArrayList<String>();
 static ArrayList<String> bookNameAndPrice = new ArrayList<String>();
 
 // this method reads book information from a file and stores it
 public static void setBooks(File bookFile) {
   NumberFormat fmt = NumberFormat.getCurrencyInstance();// currency formatter
   String bookString = "";// string used to hold book info
    try{
      Scanner read = new Scanner(bookFile);//scanner used to read info from file
      
      while(read.hasNext()){
        
        bookString += read.next() + " ";// adds words from file
        // if it hits a double
        if(read.hasNextDouble()){
          double price = read.nextDouble();// reads book prices
          bookPrice.add(price);// adds book price to arraylist
          bookName.add(bookString);// add book name to arraylist
          // adds book name and price to array list
          bookNameAndPrice.add(bookString + " " + fmt.format(price));
          ;
          // resets string
          bookString = "";
        }
      }
      // closes file    
      read.close();
   }catch(FileNotFoundException e){
      System.out.println("Error: The file was not found");
   }
    
 }  
  
}
