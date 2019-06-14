/*
  * File: ShiftSupervisor.java
  * Auther: Caleb Howard
  * Date: 2/4/2018
  * The following class contains the necessary methods to create a
ShiftSupervisor object used in EmployeeMainGUI.java
*/
package Lab3;

import java.text.NumberFormat;


public class ShiftSupervisor extends Employee {
  
  NumberFormat fmt = NumberFormat.getCurrencyInstance();
  
  protected double salary = 0.0;
  protected double bonus = 0.0;
  
  
  // no arg constructor
  public ShiftSupervisor(){
  super();
  }
  // set name constructor
  public ShiftSupervisor(String fName, String lName){
  super(fName, lName);
  }
  
  // set salary
  public void setSalary(double salary){
    this.salary = salary;
  }
  
  // get salary
  public double getSalary(){
    return salary;
  }
  
  // set bonus
  public void setBonus(double bonus){
    this.bonus = bonus;
  }
  
  // get bonus
  public double getBonus(){
    return bonus;
  }
  // this method returns all the info stored in a ShiftSupervisor object 
  public String getShiftSupervisorInfo(){
    String shiftSupervisorInfo = super.empInfo() +
                          "Salary: " + fmt.format(getSalary()) + "\n" + 
                    "Annual Bonus: " + fmt.format(getBonus()) + "\n";
    
    return shiftSupervisorInfo;
  }
}
