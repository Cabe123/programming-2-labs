/*
  * File: Employee.java
  * Auther: Caleb Howard
  * Date: 2/4/2018
  * The following class contains the necessary methods to create an
Employee object used in EmployeeMainGUI.java
*/
package Lab3;

import validatedata.RegxValidation;
public class Employee {


  protected String empLName = "";
  protected String empFName = "";
  
  
  protected String empNum = "###-A";
  protected String empHireDate = "DD/MM/YYYY";
  
  // no arg constructor 
  public Employee(){
    
  } 
  // set name constructor
  public Employee(String empFName, String empLName){
   this.empFName = empFName;
   this.empLName = empLName;
  }
  
  
  // set First Name
  public void setFName(String fName){
    if(RegxValidation.validateFName(fName)){  
      empFName = fName;
    }
  }
  
  // get First Name
  public String getFName(){
    return empFName;
  }
  
  // set Last Name
  public void setLName(String lName){
    if(RegxValidation.validateLName(lName)){
    empLName = lName;
    }
  }
  
  // get Last Name
  public String getLName(){
    return empLName;
  }
  
    
  // set Employee Number
  public void setEmpNum(String empNum){
    if(RegxValidation.validateEmpNum(empNum)){
    this.empNum = empNum;
    }
  }
  
  // get Employee Number
  public String getEmpNum(){
    return empNum;
  }
  
  // set Hire Date
  public void setHireDate(String hireDate){
    if(RegxValidation.validateHireDate(hireDate)){
    empHireDate = hireDate;
    }
  }
  
  // get Hire Date
  public String getHireDate(){
    return empHireDate;
  }
  
  // this method returns all the info stored in a Employee object 
  public String empInfo(){
    String employeeInfo = "Name: " + getFName() + " " + getLName() + "\n" +
               "Employee Number: " + getEmpNum() + "\n" + 
                    "Date Hired: " + getHireDate() + "\n";
    return employeeInfo;
  }
  
  
  
  
  
}

