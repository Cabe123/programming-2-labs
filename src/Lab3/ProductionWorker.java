/*
  * File: ProductionWorker.java
  * Auther: Caleb Howard
  * Date: 2/4/2018
  * The following class contains the necessary methods to create a
ProductionWorker object used in EmployeeMainGUI.java
*/
package Lab3;
import java.text.NumberFormat;

public class ProductionWorker extends Employee {
  
  protected String shiftString = "";
  protected int shift = 0;
  protected double hourlyPay = 0.0;
  
  NumberFormat fmt = NumberFormat.getCurrencyInstance();
  // no arg constructor
  public ProductionWorker(){
  super();
  }
  // set name contructor
  public ProductionWorker(String fName, String lName){
    super(fName,lName);
  }
  // set shift
  public void setShift(int shift){
    this.shift = shift;
  }
  // get shift
  public int getShift(){
    return shift;
  }
  // set hourly pay
  public void setHourlyPay(double hourlyPay){
    this.hourlyPay = hourlyPay;
  }
  // get hourly pay
  public double getHourlyPay(){
    return hourlyPay;
  }
  
 // this method returns all the info stored in a ProductionWorker object 
  public String productionWorkerInfo(){
    shiftString = (shift == 1) ? "Day" : "Night";
    
    String productionWorkerInfo = super.empInfo() + 
                            "Shift: " + shiftString + "\n" +
                       "Hourly Pay: " + fmt.format(getHourlyPay()) + "\n";
    return productionWorkerInfo;
  }
  
  
  
  
}
