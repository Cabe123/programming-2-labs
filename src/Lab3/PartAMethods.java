/*
  * File: PartAMethods.java
  * Auther: Caleb Howard
  * Date: 2/4/2018
  * The following class contains methods used in EmployeeMainGUI.java
*/
package Lab3;

import java.util.ArrayList;

public class PartAMethods {
  // this method creates and add employee information to ArrayList
  public static void employeeDatabase(ArrayList<String> a){
    for(int i = 0; i <= 3; i++){
      switch(i){
        case(0): Employee emp = new Employee("Bob","Parker");
        emp.setEmpNum("334-A");
        emp.setHireDate("25/04/2006");
        a.add(emp.empInfo());
          break;
        case(1): ProductionWorker pw = new ProductionWorker("Casey","Williams");
        pw.setEmpNum("354-L");
        pw.setHireDate("11/02/2004");
        pw.setShift(1);
        pw.setHourlyPay(35.50);
        a.add(pw.productionWorkerInfo());
          break;
        case(2): ShiftSupervisor ss = new ShiftSupervisor("Linda","Morris");
        ss.setEmpNum("109-E");
        ss.setHireDate("13/06/2000");
        ss.setBonus(5999.00);
        ss.setSalary(76000.00);
        a.add(ss.getShiftSupervisorInfo());
          break;
        case(3): TeamLeader tl = new TeamLeader("Alexander", "Rodriguez");
        tl.setEmpNum("831-G");
        tl.setHireDate("01/12/1998");
        tl.setShift(2);
        tl.setBonus(6750.00);
        tl.setHourlyPay(75.89);
        tl.setTrainingHours(182);
        a.add(tl.getTeamLeaderInfo());
      }
    
    }
  }
  
  // employee info needed
  public static String neededEmpInfo(){
   String neededInfo = "*** Information Needed ***\n" +
                       "Name: Jane Doe\n" + 
                       "Employee ID: ###-A\n" +
                       "Date Hired: ##/##/###\n";
                     
    return neededInfo;
  }
  // Production Worker info needed
  public static String neededPWInfo(){
    String neededInfo = neededEmpInfo() + 
                        "Shift: 1 or 2 (Day/Night)\n" + 
                        "Hourly Pay: ##.##\n";
                        
    return neededInfo;
  }
  // Shift Supervisor info needed
  public static String neededSSInfo(){
    String neededInfo = neededEmpInfo() +
                        "Annual Salary: #####.##\n" +
                        "Annual Bonus: ####.##\n";
    return neededInfo;
  
  }
  
  // Team Leader info needed
  public static String neededTLInfo(){
    String neededInfo = neededPWInfo() + 
                        "Monthly Bonus: ####.##\n" +
                        "Training Hours: ###";
    return neededInfo;
  }
  // the following method accepts a boolean array and checks if the whole array
  // is true
  public static boolean validateAllFields(boolean[] a, int empType){
    int loopLength = 0;
    //checks what employee type is entered then assigns necessary length to loop 
    switch(empType){
      case(0): loopLength = 4;
        break;
      case(1): loopLength = 6;
        break;
      case(2): loopLength = 6;
        break;
      case(3): loopLength = 8;
    }
    // loops through boolean to check if all booleans are true
    for(int i = 0; i < loopLength; i++){
      if(a[i] == false){
        return false; // if one if false
      }
    }
    return true; // if all are true
  }
  // returns general info string
  public static String generalInfo(){
     String generalInfo = "// General info\n" +
"This program is an employee database.";
     return generalInfo;
  }
  // returns general instructions string
  public static String generalInstructions(){
    String generalInstruction = "// General Instructions\n" +
"You can cycle through the employees by pressing the “Next” and “Previous” buttons.\n" +
"If you wish to remove an employee, press the “Delete” button. To create an employee,\n" +
"simply press the “Create” button.";
    return generalInstruction;
  
  }
  // returns creating employee info string
  public static String creatingAnEmployee(){
    String create = "// Creating an employee\n" +
"Once you have pressed the “Create” button, you will be brought to a new window.\n" +
"From there, you will be given the choice of which employee you would like to create.\n" +
"You can hover your mouse over the buttons to see the information needed for each \n" +
"employee. After you have selected your desired employee type, you will be brought\n" +
"to the employee creation screen.";
    return create;
  }
  // returns inputting info string
  public static String inputtingData(){
    String inputting = "// Inputting employee data\n" +
"The creation screen will have the input fields that are necessary to create \n" +
"your employee. Simply click on a text field and type in the correctly formatted\n" +
"data. Once you have typed in your data, you can then press the “Add Employee” button.\n" +
"If all the data is in the correct format, a prompt will appear stating that the employee has\n" +
"been added. But if any of the input field’s data is not in the correct format, the text color of \n" +
"the incorrect field will turn red, and the text for the correct ones will turn green.";
    return inputting;
  }
  // returns formatting info string
  public static String formattingIssues(){
    String formatting = "// Formatting issues\n" +
"If you are having trouble with inputting in the correct format, simply hover your mouse\n" +
"over the desired field to get a tool tip that shows the correct format.";
    return formatting;
  }
  
 
}
