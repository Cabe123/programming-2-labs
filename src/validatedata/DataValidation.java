/*
 * Auther: Caleb Howard
 *
 The following class contains methods used for data validation.
*/
package validatedata;

import java.util.Scanner;

public class DataValidation {
    
  // the following method accepts user input and validates if it's an integer
  public static int inputInteger(int example){
    Scanner input = new Scanner(System.in);
    while(!input.hasNextInt()){
      input.next();
      System.out.println("Error: that is not a whole number\n" +
              "Example: " + example);
    }
    int inputInt = input.nextInt();
    return inputInt;
  }
  
  // the following method determines if an integer is between 2 numbers
  public static int inputInteger(int lower,int upper, int example){
      boolean exit = false;
      int inputInt = 0;
     
      while(!exit){
              
        inputInt = inputInteger(example);
        if (inputInt < lower || inputInt > upper){
          System.out.println("Error: that integer is out of bounds");
          System.out.println("Please enter a number between " + lower + 
                     " and " + upper);
          System.out.println("Example: " + example);
        }else{
            exit = true;
        } 
      }
      return inputInt;
  }
  
  // the following method determines if an integer is greater than a number
  public static int inputIntegerGreaterThan(int greaterThan, int example){
    boolean exit = false;
    int inputInt = 0;
    
    while(!exit){
      
      inputInt = inputInteger(example);
      if (inputInt <= greaterThan){
        System.out.println("Error: that integer is out of bounds");
        System.out.println("Please enter a number greater than " + greaterThan);
        System.out.println("Example: " + example);
      }else{
        exit = true;
      
      }
    }
    return inputInt;
  }
  
  
  // the following method accepts user input and validates if it's a double
  public static double inputDouble(double example){
    Scanner input = new Scanner(System.in);
    while(!input.hasNextDouble()){
      input.next();
      System.out.println("Error: please enter numbers only\n" + 
              "Example: " + example);
    }
    double inputDouble = input.nextDouble();
    return inputDouble;
  
  }
  
  
  // the following method determines if a double is greater than a number
  public static double inputDoubleGreaterThan(double greaterThan, double example){
    boolean exit = false;
    double inputDouble = 0.0;
    
    while(!exit){
      
      inputDouble = inputDouble(example);
      if (inputDouble <= greaterThan){
          System.out.println("Error: that number is out of bounds");
          System.out.println("Please enter a number greater than " + 
                  greaterThan);
          System.out.println("Example: " + example);
        
      }else {
        exit = true;
      }
    }
     return inputDouble;
  }
  
  /*
  public static String inputString(){
    Scanner input = new Scanner(System.in);
      while(!input.hasNextLine()){
      input.next();
      System.out.println("Error: enter a string");
      
      }
    String inputString = input.nextLine();
    return inputString;
  
  
  }
*/
  // the following method accepts a string input and validates that it
  // does not begin with a space or is longer than a given number of chars
  public static String inputStringLessThanEqualTo(int max){
    Scanner input = new Scanner(System.in);
    boolean exit = false;
    String inputString = " ";
    
    while(!exit){
      
      inputString = input.nextLine();
      
      if(inputString.isEmpty() || inputString.charAt(0) == ' '){
        
        System.out.println("Error: the first Character can't be a space");
      }else if(inputString.length() > max){
        System.out.println("Error; your input cannot be more than " + max + 
                " characters");
        
        
      }else{
        
        exit = true;
      
      }
    }
    return inputString;
  }
  
  public static String inputString(){
    
    Scanner input = new Scanner(System.in);
    boolean exit = false;
    String inputString = " ";
    
    while(!exit){
      
      inputString = input.nextLine();
      
      if(inputString.trim().isEmpty()){
        
        System.out.println("Error: The String cannot be empty");
        System.out.println("Please enter a string of characters");
      }else{
        
        exit = true;
      
      }
    }
  
    return inputString;
  }
  
  
  
    
    
}
