/*
  * File: WriteToFile.java
  * Auther: Caleb Howard
  * Date: 2/4/2018
  * the following class contains methods used in RandomIntegersMain.java
*/
package Lab3;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
public class WriteToFile {
  
  // this method writes 100 random integers to a file name "MyFile.txt"
  public static void write(){
    int[] integers = new int[100]; // int array
    randomIntegers(integers);// adds randoms ints
    Arrays.sort(integers);// sorts ints
    
    File intFile = new File("MyFile.txt");// creates new file name
   
   try{
     PrintWriter write = new PrintWriter(intFile); // creates PrintWriter
     
     for(int i = 0; i < integers.length; i++){
       write.print(integers[i]+ " ");// add ints to file
     }
     // closes and prompts user of successful write
     write.close();
     System.out.println("Data has been successfully added");
     
   }catch(FileNotFoundException e){
    System.out.println("error");
   }
  }
  
  
  // this method accepts an int array and adds random ints to it
  private static void randomIntegers(int[] a){
    Random randomInt = new Random();
    
    for(int i = 0; i < a.length; i++){
      a[i] = randomInt.nextInt(10);
    }
  }
}
