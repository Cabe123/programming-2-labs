/*
  * File: TeamLeader.java
  * Auther: Caleb Howard
  * Date: 2/4/2018
  * The following class contains the necessary method to create a
TeamLeader object used in EmployeeMainGUI.java
*/
package Lab3;

import java.text.NumberFormat;

public class TeamLeader extends ProductionWorker {
  
  NumberFormat fmt = NumberFormat.getCurrencyInstance();
  // constant for the number of required training hours
  protected final int REQUIRED_TRAINING_HOURS = 200;
  
  protected double bonus = 0.0; // monthy bonus
  protected int trainingHours = 0; //  training hours attended
  
  // no arg contructor
  public TeamLeader(){
    super();
  }
  // set name constructor
  public TeamLeader(String fName, String lName){
   super(fName, lName);
  }
  // set bonus
  public void setBonus(double bonus){
    this.bonus = bonus;
  }
  // get bonus
  public double getBonus(){
    return bonus;
  }
  // set training hours
  public void setTrainingHours(int trainingHours){
    this.trainingHours = trainingHours;
  }
  // get training hours
  public int getTrainingHours(){
    return trainingHours;
  }
  // get required training hours
  public int getRequiredTrainingHours(){
    return REQUIRED_TRAINING_HOURS;
  }
  // this method returns all the info stored in a TeamLeader object 
  public String getTeamLeaderInfo(){
    String teamLeaderInfo = super.productionWorkerInfo() +
                          "Monthly Bonus: " + fmt.format(getBonus()) + "\n" +
                "Training Hours Attended: " + getTrainingHours() + "\n" +
                "Training Hours Required: " + getRequiredTrainingHours() + "\n";
    
    return teamLeaderInfo;
  }
  
  
}
