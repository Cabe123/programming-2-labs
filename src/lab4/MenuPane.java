/*
  * File: MenuPane.java
  * Auther: Caleb Howard
  * Date: 29/4/2018
  * The following class creates a menu pane that contains various menu items
used in BookStore.java
*/
package lab4;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author caleb
 */
public class MenuPane extends HBox{
  // no arg constructor
  public MenuPane(){
   CreatePane();
  }
 // creates pane
 private void CreatePane(){
   // creates menu bar
   MenuBar menuBar = new MenuBar();
   // creates menus
   Menu fileMenu = new Menu("File");
   Menu helpMenu = new Menu("Help");
   // add menus to menu bar
   menuBar.getMenus().addAll(fileMenu, helpMenu);
   // creates exit menu item and adds it to file menu
   MenuItem exitItem = new MenuItem("Exit");
   fileMenu.getItems().add(exitItem);
   // if the exit item is pressed
   exitItem.setOnAction(e -> {
    // Close program
     Platform.exit();
   });
   
   //creates about menu item and adds it to help menu
   MenuItem aboutItem = new MenuItem("About");
   helpMenu.getItems().add(aboutItem);
   
   // if about item is pressed
   aboutItem.setOnAction(e -> {
     // creates and sets size for about stage
     Stage aboutStage = new Stage();
     aboutStage.setMinHeight(400);
     aboutStage.setMinWidth(400);
     aboutStage.setMaxHeight(400);
     aboutStage.setMaxWidth(400);
     // creates pane used for about menu
     VBox aboutPane = new VBox();
     aboutPane.setAlignment(Pos.CENTER);
     
     // creates text with text from AboutText()
     Text text = new Text(AboutText());
     Button doneButton = new Button("Done");// creates button
     //creates icon imgage 
     Image img = new Image("https://png.pngtree.com/element_origin_min_pic/16/11/06/b018978995324d2b64160a62514a7970.jpg");
     // add image to imageview
     ImageView iv = new ImageView(img);
     iv.setFitHeight(64);
     iv.setFitWidth(64);
     // adds text, image and button to pane
     aboutPane.getChildren().addAll(text,iv,doneButton);
     
     // if the done button is pressed
     doneButton.setOnAction(a ->{
       // closes about stage
       aboutStage.close();
     });
     // sets scene to stage and shows it
     Scene aboutScene = new Scene(aboutPane);
     aboutStage.setScene(aboutScene);
     aboutStage.initModality(Modality.APPLICATION_MODAL);
     aboutStage.show();
     
   });
   // add menubar to pane
   getChildren().add(menuBar);
 }
 
 // this method returns text containing information about the program
 private String AboutText(){
    String aboutString = "Program Name: Bookstore\n\n" + 
            "Description: This program is an \"online\" bookstore, which\n" +
            "allows the user to add books to a cart. After the books\n" +
            "have been added the user can then choose\n" + 
            "to remove, clear, or buy the books.\n\n" +
            "Version: 1.0\n";
    
    return aboutString;
 }

}
