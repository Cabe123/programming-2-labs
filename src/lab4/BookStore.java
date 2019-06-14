/*
  * File: BookStore.java
  * Auther: Caleb Howard
  * Date: 29/4/2018
  * This program is an "online" bookstore, which allows the user to add books 
to a cart. After the books have been added to the cart the user can then choose 
to remove, clear, or buy the books.
*/
package lab4;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookStore extends Application{
  @Override
  public void start(Stage primaryStage){
   // creates main pane
    MainPane pane = new MainPane();
    // creates main stage
    Stage mainStage = new Stage();
    // sets title for main stage
    mainStage.setTitle("Bookstore");
    // sets stage size
    mainStage.setMinHeight(505);
    mainStage.setMinWidth(500);
    mainStage.setMaxHeight(505);
    mainStage.setMaxWidth(500);
    // creates scene
    Scene scene = new Scene(pane);
    mainStage.setScene(scene);// add scene to stage
    // displays stage
    mainStage.show();
  }
  
  public static void main(String[] args){
    launch(args);
    
  }
  
}
