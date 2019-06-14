/*
  * File: PaintJobEstimator.java
  * Auther: Caleb Howard
  * Date: 2/3/18
  * The following class contains methods that are used in 
PaintJobEstimatoDriver.Java
*/
package lab1;

import validatedata.DataValidation;


public class PaintJobEstimator {
  // constants for company hourly rate and square footage used for estimation
  private final static double COMPANY_RATE = 18.00;
  private final static int PER_SQUARE_FEET = 115;
  
 
  // the following method promts and get user input for number of rooms
  public static int getRooms(){
    
   System.out.println("=================================================");
   System.out.println("Please enter the number of rooms you want painted");
   System.out.println("=================================================");
   int rooms = DataValidation.inputIntegerGreaterThan(0 , 4);
   
    return rooms;
  }
 
  // the following method promts and gets user input for square footage of each room
  public static int getSquareFeet(int rooms){
    int squareFeet = 0;
    for(int i = 0; i < rooms; i++){
      System.out.println("=============================================");
      System.out.println("Please enter the Square footage for room" +
              " #" + (i + 1));
      System.out.println("=============================================");
      
      squareFeet += DataValidation.inputIntegerGreaterThan(0 , 150);
    
    }
    return squareFeet;
  }
  // the following method promts and gets user input for price per gallon of paint
  public static double getPricePerGallon(){
    System.out.println("=================================================");
    System.out.println("Please enter the price per gallon your paint cost");
    System.out.println("=================================================");
    double pricePerGallon = DataValidation.inputDoubleGreaterThan(0.0 , 4.50);
    
    return pricePerGallon;
  }
  // the following method calls getPricePerGallon() and other methods to
  // compute the total cost of the job
  public static double getTotal(int squareFeet){
   double pricePerGallon = getPricePerGallon();
   
   double hoursRequired = getHoursRequired(squareFeet);
   
   double laborCosts = getLaborCost(hoursRequired);
   double totalPaintCost = getTotalPaintCost(squareFeet, pricePerGallon);
   
   double total = laborCosts + totalPaintCost;
   
   return total;
  
  }
  
  
  
  
  
 // the following method computes the gallons of needed paint needed
  public static double getGallonsOfPaintNeeded(int squareFeet){
  
    double gallonsNeeded = (double)squareFeet / PER_SQUARE_FEET;
    
    return gallonsNeeded;

  }
  // the following method computes the hours it would take to do the job
  public static double getHoursRequired(int squareFeet){
    double hoursRequired = ((double)squareFeet / PER_SQUARE_FEET) * 8;
    
    return hoursRequired;
  
  }
  // the following method computes the cost in labor it would take to do the job
  public static double getLaborCost(double hours){;
    double jobCost = hours * COMPANY_RATE;
  
  
    return jobCost;
  }
  // the following method computes the total cost of paint to do the job
  public static double getTotalPaintCost(int squareFeet, double paintPrice){
    double gallonsNeeded = getGallonsOfPaintNeeded(squareFeet);
    double totalPaintCost = gallonsNeeded * paintPrice;
    
    return totalPaintCost;
  
  }
  
 



}

