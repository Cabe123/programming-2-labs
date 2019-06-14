/*
  * File: EmployeeMainGUI.java
  * Auther: Caleb Howard
  * Date: 2/4/2018
  * The following program is an employee database where the user can cycle 
through employees in the database. Also, employees can be created and deleted 
by the user. 
*/
package Lab3;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import validatedata.RegxValidation;

public class EmployeeMainGUI extends Application {
  
  int index = 0;// array index tracker
  
  // arraylist that store employee info
  ArrayList<String> employeeInfo = new ArrayList<String>();
  
  // stage to tell user that a employee has been added
  Stage successStage = new Stage();
  
  Label mainText = new Label(); // main program label
  // number of employees and position string
  String tracker = (index + 1) + "/" + employeeInfo.size();
  // label used for tracker
  Label indexTracker = new Label(tracker);  
  
  
  // Next/Previous employee buttons
  Button nextButton = new Button("Next");
  Button prevButton = new Button("Previous");
  
  // Help/More info button
  Button helpButton1 = new Button("Help");
  Button helpButton2 = new Button("Help");
  HelpHandler helpHandle = new HelpHandler();
  

  
  // Start method
  @Override
  public void start(Stage primaryStage){
    // calls method to 
    PartAMethods.employeeDatabase(employeeInfo);
    tracker = (index + 1) + "/" + employeeInfo.size();

    // Setting main appliction title
    primaryStage.setTitle("Employee Database");
    
    // Setting min height/width for Stage
    primaryStage.setMinHeight(425);
    primaryStage.setMinWidth(450);
    
    // Setting max height/width for Stage
    primaryStage.setMaxHeight(600);
    primaryStage.setMaxWidth(800);
    
    // main Application pane
    GridPane mainPane = new GridPane();
    // scene assigning pane properties
    mainPane.setAlignment(Pos.CENTER);
    mainPane.setVgap(7.5);
    mainPane.setHgap(7.5);
   // mainPane.setGridLinesVisible(true);
    
    // Main text properties
    mainText.setText(employeeInfo.get(0));
    mainText.setFont(new Font(20));
    mainText.setMinSize(300, 225);
    mainText.setMaxSize(300, 225);
    
   
    // Next/Previous button handler
    PrevNextHandler handler1 = new PrevNextHandler();
    // Next/Priveous button handler onAction assigning
    nextButton.setOnAction(handler1);
    nextButton.setMinSize(100, 40);
    nextButton.setMaxSize(100, 40);
    prevButton.setOnAction(handler1);
    prevButton.setMinSize(100, 40);
    prevButton.setMaxSize(100, 40);
    
    
    // Create/Delete employee buttons
    Button createButton = new Button("Create");
    createButton.setMinSize(100, 40);
    createButton.setMaxSize(100, 40);
    // Create button Handler
    CreateHandler createHandle = new CreateHandler();
    createButton.setOnAction(createHandle);
    
    // delete button
    Button deleteButton = new Button("Delete");
    deleteButton.setMinSize(100, 40);
    deleteButton.setMaxSize(100, 40);
    //create and assigning delete handler
    DeleteHandler deleteHandle = new DeleteHandler();
    deleteButton.setOnAction(deleteHandle);
    // assigning Help Handler
    helpButton1.setOnAction(helpHandle);
    
    //Adding Text to pane
    mainPane.add(mainText, 0, 1);
    
    mainPane.add(indexTracker, 0, 0);
    indexTracker.setFont(new Font(15));
    indexTracker.setText(tracker);
    GridPane.setHalignment(indexTracker, HPos.RIGHT);
   
    // Adding buttons to pane
    mainPane.add(prevButton, 0, 2);
    mainPane.add(nextButton, 0, 2);
    mainPane.add(deleteButton, 0, 3);
    mainPane.add(createButton, 0, 3);
    mainPane.add(helpButton1, 0, 4);
    
    // Setting button alignment
    GridPane.setHalignment(nextButton, HPos.RIGHT);
    GridPane.setHalignment(prevButton, HPos.LEFT);
    GridPane.setHalignment(helpButton1, HPos.CENTER);
    GridPane.setHalignment(createButton, HPos.RIGHT);
    GridPane.setHalignment(deleteButton, HPos.LEFT);
    
    // creating and setting scene to stage
    Scene mainScene = new Scene(mainPane);
    primaryStage.setScene(mainScene);
    primaryStage.show();
  
  }
  // main
  public static void main(String[] args){
    launch(args);
  
  }
  
  
  // Previous/Next Button event handler
  class PrevNextHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
      // checks if next button was hit
      if(e.getSource() == nextButton){
        // checks if index is less than array size - 1
        if(index < (employeeInfo.size() -1)){
          index++;
          mainText.setText(employeeInfo.get(index));
          tracker = (index + 1) + "/" + employeeInfo.size();
          indexTracker.setText(tracker);
        }
      // checks if previous button was hit  
      }else if(e.getSource() == prevButton){
        // checks if index in greater than 0
        if(index > 0){
          index--;
          mainText.setText(employeeInfo.get(index));
          tracker = (index + 1) + "/" + employeeInfo.size();
          indexTracker.setText(tracker);
        }
      }
      
    }
  
  }
  // Create button handler
  class CreateHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
    
      Stage empTypeStage = new Stage();
      empTypeStage.setTitle("Employee Types");
      // Setting Stage min size
      empTypeStage.setMinHeight(275);
      empTypeStage.setMinWidth(325);
      // Setting stage max size
      empTypeStage.setMaxHeight(500);
      empTypeStage.setMaxWidth(600);
      
      // employee selection type pane
      GridPane empTypePane = new GridPane();
      // employee type pane properties
      empTypePane.setAlignment(Pos.CENTER);
      empTypePane.setVgap(3);
      empTypePane.setHgap(3);
      empTypePane.setMinSize(400, 400);
      //empTypePane.setGridLinesVisible(true);
      
      // create and setting size of employee button
      Button empButton = new Button("Employee");
      empButton.setTooltip(new Tooltip(PartAMethods.neededEmpInfo()));
      empButton.setMinSize(150, 50);
      empButton.setMaxSize(150, 50);
      
      
      // create and setting size of production worker button
      Button pwButton = new Button("Production Worker");
      pwButton.setTooltip(new Tooltip(PartAMethods.neededPWInfo()));
      pwButton.setMinSize(150, 50);
      pwButton.setMaxSize(150, 50);
      
      // create and setting size of shift supervisor button
      Button ssButton = new Button("Shift Supervisor");
      ssButton.setTooltip(new Tooltip(PartAMethods.neededSSInfo()));
      ssButton.setMinSize(150, 50);
      ssButton.setMaxSize(150, 50);
      
      // create and setting size of team leader button
      Button tlButton = new Button("Team Leader");
      tlButton.setTooltip(new Tooltip(PartAMethods.neededTLInfo()));
      tlButton.setMinSize(150, 50);
      tlButton.setMaxSize(150, 50);
      
      
      // Adding buttons gridpane
      empTypePane.add(empButton, 0, 2);
      empTypePane.add(pwButton, 0, 2);
      empTypePane.add(ssButton, 0, 3);
      empTypePane.add(tlButton, 0, 3);
      
      // Information Label
      String info = "Please choose the type of employee you would\n"+ 
              "like to create. Hover over each button for\n" + 
              "additional information";
      Label infoLabel = new Label(info);
      infoLabel.setMaxSize(300, 75);
      infoLabel.setMinSize(300, 75);
      
      empTypePane.add(infoLabel, 0, 1);
      // setting label and button alignment
      GridPane.setHalignment(infoLabel, HPos.CENTER);
      GridPane.setHalignment(empButton, HPos.LEFT);
      GridPane.setHalignment(pwButton, HPos.RIGHT);
      GridPane.setHalignment(ssButton, HPos.LEFT);
      GridPane.setHalignment(tlButton, HPos.RIGHT);
      
      // setting scene
      Scene empTypeScene = new Scene(empTypePane);
      empTypeStage.initModality(Modality.APPLICATION_MODAL);
      empTypeStage.setScene(empTypeScene);
      empTypeStage.show();
      
      // Employee type button handler
      class EmpTypeHandler implements EventHandler<ActionEvent>{
        int empTypeNum = 0;
        @Override
        public void handle(ActionEvent e){
           empTypeNum = 0;
          // sets employee type number depending on which button is pressed
          if(e.getSource() == empButton){
            empTypeNum = 0;
          }else if(e.getSource() == ssButton){
            empTypeNum = 1;
          }else if(e.getSource() == pwButton){
            empTypeNum = 2;
          } else if(e.getSource() == tlButton){
            empTypeNum = 3;
          }
          // Creating create menu stage
          Stage createEmpStage = new Stage();
          createEmpStage.setTitle("Create Employee");
          // Setting Stage min size
          createEmpStage.setMinHeight(350);
          createEmpStage.setMinWidth(300);
          // Setting stage max size
          createEmpStage.setMaxHeight(600);
          createEmpStage.setMaxWidth(500);
          // creating and setting create pane properties
          GridPane createPane = new GridPane();
          createPane.setAlignment(Pos.CENTER);
          createPane.setVgap(5);
          createPane.setHgap(5);
          createPane.setMinSize(400, 600);
          
          // create employee menu text fields
          TextField fName = new TextField();
          TextField lName = new TextField();
          TextField empNum = new TextField();
          TextField hireDate = new TextField();
          TextField shift = new TextField();
          TextField hourlyPay = new TextField();
          TextField monthlyBonus = new TextField();
          TextField trainingHours = new TextField();
          TextField annualPay = new TextField();
          TextField annualBonus = new TextField();
          
          // setting tool tips for text fields
          fName.setTooltip(new Tooltip("e.g. Jane"));
          lName.setTooltip(new Tooltip("e.g. Doe"));
          empNum.setTooltip(new Tooltip("###-L\n(L can be A-M)\ne.g. 123-D"));
          hireDate.setTooltip(new Tooltip("DD/MM/YYYY\ne.g. 25/04/2014"));
          shift.setTooltip(new Tooltip("enter 1 for Day\nenter 2 for Night"));
          String currency = "##.##\n(any number with 2 decimal places)";
          hourlyPay.setTooltip(new Tooltip(currency + "\ne.g. 45.55"));
          monthlyBonus.setTooltip(new Tooltip(currency + "\ne.g. 2499.00"));
          trainingHours.setTooltip(new Tooltip("###\n(any integer)"));
          annualPay.setTooltip(new Tooltip(currency + "\ne.g. 75000.00"));
          annualBonus.setTooltip(new Tooltip(currency + "\ne.g. 8999.75"));
          
          //loop and switch statement to set up menu layout depending on empType          
          for(int i = 0; i <= empTypeNum; i++){
            switch(i){
              case(0):
                // label and text field for first name
                createPane.add(new Label("First Name:"), 0, 0);
                createPane.add(fName, 1, 0);
                // label and text field for last name
                createPane.add(new Label("Last Name:"), 0, 1);
                createPane.add(lName, 1, 1);
                // label and text field for Employee number
                createPane.add(new Label("Employee Number:"), 0, 2);
                createPane.add(empNum, 1, 2);
                // label and text field for hire date
                createPane.add(new Label("Date Hired:"), 0, 3);
                createPane.add(hireDate, 1, 3);
                break;
              case(2):
                // label and text for shift
                createPane.add(new Label("Shift:"), 0, 4);
                createPane.add(shift, 1, 4);
                // label and text field for hourly pay
                createPane.add(new Label("Hourly Pay"), 0, 5);
                createPane.add(hourlyPay, 1, 5);
                break;
              case(3):
                // label and text field for monthly bonus
                createPane.add(new Label("Monthly Bonus:"), 0, 6);
                createPane.add(monthlyBonus, 1, 6);
                // label and text field for training hours
                createPane.add(new Label("Training Houres:"), 0, 7);
                createPane.add(trainingHours, 1, 7);
            }
          }
          
          // if user chooses to create a Shift Supervisor
          if(empTypeNum == 1){
            // label and text field for annual salary
            createPane.add(new Label("Annual Salary:"), 0, 4);
            createPane.add(annualPay, 1, 4);
            // label and text field for annual bonus
            createPane.add(new Label("Annual Bonus:"),  0, 5);
            createPane.add(annualBonus, 1, 5);
            
          }
          
          
          // add employee button
          Button addEmp = new Button("Add Employee");
          // adding button to pane
          createPane.add(addEmp, 0, 8);
          helpButton2.setOnAction(helpHandle);
          createPane.add(helpButton2, 1, 8);
          GridPane.setHalignment(helpButton2, HPos.RIGHT);
          GridPane.setHalignment(addEmp, HPos.RIGHT);
          // creating scene and assigning to stage
          Scene createScene = new Scene(createPane);
          createEmpStage.setScene(createScene);
          createEmpStage.initModality(Modality.APPLICATION_MODAL);
          createEmpStage.show();
          
          class ValidateTextHandler implements EventHandler<ActionEvent>{
            @Override
            public void handle(ActionEvent e){
              // holds booleans to later determine if all
              boolean[] validateText = new boolean[8];
              
              // first name
              if(RegxValidation.validateFName(fName.getText())){
              fName.setStyle("-fx-text-fill: green");
              validateText[0] = true;
              }else{
              fName.setStyle("-fx-text-fill: red");
              validateText[0] = false;
              }
              
              // last name
              if(RegxValidation.validateLName(lName.getText())){
              lName.setStyle("-fx-text-fill: green");
              validateText[1] = true;
              }else{
              lName.setStyle("-fx-text-fill: red");
              validateText[1] = false;
              }
              // emp number
              if(RegxValidation.validateEmpNum(empNum.getText())){
              empNum.setStyle("-fx-text-fill: green");
              validateText[2] = true;
              }else{
              empNum.setStyle("-fx-text-fill: red");
              validateText[2] = false;
              }
              
              // hire date
              if(RegxValidation.validateHireDate(hireDate.getText())){
                hireDate.setStyle("-fx-text-fill: green");
                validateText[3] = true;
              }else{
                hireDate.setStyle("-fx-text-fill: red");
                validateText[3] = false;
              }
              // if Production worker or Team leader
              if(empTypeNum == 2 || empTypeNum == 3){
                // shift
                if(RegxValidation.validateShift(shift.getText())){
                  shift.setStyle("-fx-text-fill: green");
                  validateText[4] = true;
                }else{
                  shift.setStyle("-fx-text-fill: red");
                  validateText[4] = false;
                }
                // hourly pay
                if(RegxValidation.validatePay(hourlyPay.getText())){
                  hourlyPay.setStyle("-fx-text-fill: green");
                  validateText[5] = true;
                }else{
                  hourlyPay.setStyle("-fx-text-fill: red");
                  validateText[5] = false;
                }
                // if Team leader
                if(empTypeNum == 3){
                  // monthly bonus
                  if(RegxValidation.validatePay(monthlyBonus.getText())){
                    monthlyBonus.setStyle("-fx-text-fill: green");
                    validateText[6] = true;
                  }else{
                    monthlyBonus.setStyle("-fx-text-fill: red");
                    validateText[6] = false;
                  }
                  // training hours
                  if(RegxValidation.validateInt(trainingHours.getText())){
                    trainingHours.setStyle("-fx-text-fill: green");
                    validateText[7] = true;
                  }else{
                    trainingHours.setStyle("-fx-text-fill: red");
                    validateText[7] = false;
                  }
                 
               
               
                }   
              
              }
              // if Shift Supervisor
              if(empTypeNum == 1){
                // Salary
                if(RegxValidation.validatePay(annualPay.getText())){
                  annualPay.setStyle("-fx-text-fill: green");
                  validateText[4] = true;
                }else{
                  annualPay.setStyle("-fx-text-fill: red");
                  validateText[4] = false;
                }
                // annual bonus
                if(RegxValidation.validatePay(annualBonus.getText())){
                  annualBonus.setStyle("-fx-text-fill: green");
                  validateText[5] = true;
                }else{
                  annualBonus.setStyle("-fx-text-fill: red");
                  validateText[5] = false;
                  
                }
              
              }
              
              
              // setting success stage title
              successStage.setTitle("Employee Created");
              // Setting Stage min size
              successStage.setMinHeight(250);
              successStage.setMinWidth(250);
              // Setting stage max size
              successStage.setMaxHeight(500);
              successStage.setMaxWidth(500);
              
              
              // gridpane for successfully adding a employee
              GridPane successPane = new GridPane();
              successPane.setAlignment(Pos.CENTER);
              successPane.setVgap(5);
              successPane.setHgap(5);
              successPane.setMinSize(250, 250);
              
              // employee added text
              Label success = new Label("Employee has been\nsuccesfully added");
              success.setFont(new Font(15));
              successPane.add(success, 0, 0);
              GridPane.setHalignment(success, HPos.CENTER);
              // okay button
              Button okay = new Button("Okay");
              OkayHandler okayHandle = new OkayHandler();
              okay.setOnAction(okayHandle);
              // adding okay button to pane
              successPane.add(okay, 0, 1);
              GridPane.setHalignment(okay, HPos.CENTER);
              
              Scene successScene = new Scene(successPane);
              successStage.setScene(successScene);
              
              
              
              // employee
              if(empTypeNum == 0){
                // checks if all text fields are true/validated info
                if(PartAMethods.validateAllFields(validateText, empTypeNum)){
                  // creates and sets employee
                  Employee userEmp = new Employee();
                  userEmp.setFName(fName.getText());
                  userEmp.setLName(lName.getText());
                  userEmp.setEmpNum(empNum.getText());
                  userEmp.setHireDate(hireDate.getText());
                  // adds employee to employeeInfo array
                  employeeInfo.add(userEmp.empInfo());
                  // closing and showing windows
                  createEmpStage.close();
                  empTypeStage.close();
                  successStage.show();
                  
                  tracker = (index + 1) + "/" + employeeInfo.size();
                  indexTracker.setText(tracker);
                }
              //Shift Supervisor
              }else if(empTypeNum == 1){
                // checks if all text fields are true/validated
                if(PartAMethods.validateAllFields(validateText, empTypeNum)){
                  // creates and sets Shift SuperVisors info
                  ShiftSupervisor userSS = new ShiftSupervisor();
                  userSS.setFName(fName.getText());
                  userSS.setLName(lName.getText());
                  userSS.setEmpNum(empNum.getText());
                  userSS.setHireDate(hireDate.getText());
                  userSS.setSalary(Double.parseDouble(annualPay.getText()));
                  userSS.setBonus(Double.parseDouble(annualBonus.getText()));
                  // add shift supervisor to employeeInfo array
                  employeeInfo.add(userSS.getShiftSupervisorInfo());
                  //closing and show windows
                  createEmpStage.close();
                  empTypeStage.close();
                  successStage.show();
                  
                  tracker = (index + 1) + "/" + employeeInfo.size();
                  indexTracker.setText(tracker);
                }
              //Production Worker
              }else if(empTypeNum == 2){
                if(PartAMethods.validateAllFields(validateText, empTypeNum)){
                  // creates and set production worker info
                  ProductionWorker userPW = new ProductionWorker();
                  userPW.setFName(fName.getText());
                  userPW.setLName(lName.getText());
                  userPW.setEmpNum(empNum.getText());
                  userPW.setHireDate(hireDate.getText());
                  userPW.setShift(Integer.parseInt(shift.getText()));
                  userPW.setHourlyPay(Double.parseDouble(hourlyPay.getText()));
                  // add production worker info to employeeInfo array
                  employeeInfo.add(userPW.productionWorkerInfo());
                  //closing and showing windows
                  createEmpStage.close();
                  empTypeStage.close();
                  successStage.show();
                  
                  tracker = (index + 1) + "/" + employeeInfo.size();
                  indexTracker.setText(tracker);
                }
              // team leader
              }else if(empTypeNum == 3){
                if(PartAMethods.validateAllFields(validateText, empTypeNum)){
                  // creates and set team leader info
                  TeamLeader userTL = new TeamLeader();
                  userTL.setFName(fName.getText());
                  userTL.setLName(lName.getText());
                  userTL.setEmpNum(empNum.getText());
                  userTL.setHireDate(hireDate.getText());
                  userTL.setShift(Integer.parseInt(shift.getText()));
                  userTL.setHourlyPay(Double.parseDouble(hourlyPay.getText()));
                  userTL.setBonus(Double.parseDouble(monthlyBonus.getText()));
                  userTL.setTrainingHours(Integer.parseInt(trainingHours.getText()));
                  // add team leader info to employeeInfo array
                  employeeInfo.add(userTL.getTeamLeaderInfo());
                  // closing and show windows
                  createEmpStage.close();
                  empTypeStage.close();
                  successStage.show();
                  
                  tracker = (index + 1) + "/" + employeeInfo.size();
                  indexTracker.setText(tracker);
                }
              
              }
              
            }
          
          }
          // creating ValidateTextHandler and assign it to addEmp button
          ValidateTextHandler textHandler = new ValidateTextHandler();
          addEmp.setOnAction(textHandler);
          
        }
      
      }
      
      // employee type button handler
      EmpTypeHandler typeHandler = new EmpTypeHandler();
      
      // assigning buttons to handler
      empButton.setOnAction(typeHandler);
      pwButton.setOnAction(typeHandler);
      ssButton.setOnAction(typeHandler);
      tlButton.setOnAction(typeHandler);
       
    
    
    }
  
  }
  //  handler for okay button in succesPane
  class OkayHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
      successStage.close();
    
    }
  
  }
  // hanlder for delete button
  class DeleteHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
      if(employeeInfo.size() > 1){
        employeeInfo.remove(index);
        if(index > 0){
        index--;
        }
        mainText.setText(employeeInfo.get(index));
        tracker = (index + 1) + "/" + employeeInfo.size();
        indexTracker.setText(tracker);
      }
    }
  
  }
  // help button handler
  class HelpHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
      Stage helpStage = new Stage();
      helpStage.setTitle("Help");
      // Setting Stage min size
      helpStage.setMinHeight(600);
      helpStage.setMinWidth(600);
      // Setting stage max size
      helpStage.setMaxHeight(900);
      helpStage.setMaxWidth(900);
      
      // creating help pane
      GridPane helpPane = new GridPane();
      helpPane.setAlignment(Pos.CENTER);
      helpPane.setVgap(5);
      helpPane.setHgap(5);
      helpPane.setMinSize(250, 250);
      
      // instruction text
      Text generalInfo = new Text(PartAMethods.generalInfo());
      Text generalInstructions = new Text(PartAMethods.generalInstructions());
      Text creatingEmpInfo = new Text(PartAMethods.creatingAnEmployee());
      Text inputtingInfo = new Text(PartAMethods.inputtingData());
      Text formattingIssues = new Text(PartAMethods.formattingIssues());
      
      // adding text to scene
      helpPane.add(generalInfo, 0, 0);
      helpPane.add(generalInstructions, 0, 1);
      helpPane.add(creatingEmpInfo, 0, 2);
      helpPane.add(inputtingInfo, 0, 3);
      helpPane.add(formattingIssues, 0, 4);
    
      Scene helpScene = new Scene(helpPane);
      
      helpStage.initModality(Modality.APPLICATION_MODAL);
      helpStage.setScene(helpScene);
      helpStage.show();
      
    }
  }
  
  
}
