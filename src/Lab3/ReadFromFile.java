/*
  * File: ReadFromFile.java
  * Auther: Caleb Howard
  * Date: 2/4/2018
  * the following class contains methods used in RandomIntegersMain.java
*/
package Lab3;
import java.io.*;
import java.util.Scanner;
public class ReadFromFile {
  // this method reads numbers from a file
  public static void read(){
    
    File intFile = new File("MyFile.txt");
    
   try{
      Scanner read = new Scanner(intFile);
      
      while(read.hasNextInt()){
        
        System.out.print(read.nextInt());
        
      }
   
   }catch(FileNotFoundException e){
   
      System.out.println("Error");
   }
 
  }
  
}
