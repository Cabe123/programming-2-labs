/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validatedata;

import javax.swing.JOptionPane;

/**
 *
 * @author caleb
 */



public class RegxValidation {
   
  
  // regx for first name
  public static boolean validateFName(String name){

    return name.matches("[A-Z][a-zA-Z]*");
  }
  // regx for last name
  public static boolean validateLName(String name){

    return name.matches("[A-Z][a-zA-Z]*");
  }
  // regx for emp number
  public static boolean validateEmpNum(String empNum){

    return empNum.matches("[0-9]{3}-[A-M]");
  }
  // regx for hire date
  public static boolean validateHireDate(String date){

    return date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}");
  }
  
  public static boolean validateShift(String shift){
  
    return shift.matches("[1-2]");
  }
  // regx for double or curreny
  public static boolean validatePay(String pay){
    return pay.matches("[1-9][0-9]*\\.[0-9]{2}");
  }
  // regx for int
  public static boolean validateInt(String i){
    
    return i.matches("[1-9][0-9]*");
    
  }
  
  
  // receives input and validates if it's first name
  public static String validateFirstName(){
    boolean exit = false;
    String input = "";
    
    while(!exit){
      
      try{
        input = JOptionPane.showInputDialog("Please enter the employee's first name");
        if(validateFName(input)){
         exit = true;
        }else{
          JOptionPane.showMessageDialog(null, "That is an incorrect input");
        }
      }catch(Exception e){
      
        JOptionPane.showMessageDialog(null, "That is an incorrect input");
      }
      
    }
    return input;
  }

}

