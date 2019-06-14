/*
  * File: StorePane.java
  * Auther: Caleb Howard
  * Date: 29/4/2018
  * The following class is used to create a store pane that is used in
the program BookStore.java
*/

package lab4;

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StorePane extends VBox{
  
  // ListView used to display books
  ListView storeList = new ListView();
  
  // no arg constructor
  public StorePane(){
    CreatePane();// call CreatePane method
  }
  // this method adds all the nodes to the pane
  private void CreatePane(){
    // gets file named BookPrices.txt from files
    File file = new File("BookPrices.txt");
    // Calls method to add book names and prices from BookPrices.txt
    Books.setBooks(file);
    
    // adds every book name and price from arraylist to store listview
    for(String books: Books.bookNameAndPrice){
      storeList.getItems().add(books);
    }
    // adds store listview to pane
    getChildren().add(storeList);
    ButtonPane();// call ButtonPane method
  }
  
  private void ButtonPane(){
  // creates Hbox pane
    HBox btPane = new HBox();
    btPane.setMinHeight(30);
    btPane.setMaxHeight(30);
    btPane.setSpacing(10);
    // creates new add to cart button
    Button addToCartBt = new Button("Add to Cart");
    addToCartBt.setAlignment(Pos.CENTER);
    
    // when add to cart is push
    addToCartBt.setOnAction(e -> {
      // gets which listview item is selected and assigns to index
      int index = storeList.getSelectionModel().getSelectedIndex();
      // checks if something is selected
      if(index > -1){
      // adds selected item to cart
      CartPane.addItem(Books.bookNameAndPrice.get(index),
              Books.bookPrice.get(index));
      }
    });
    // adds button to button pane
    btPane.getChildren().add(addToCartBt);
    btPane.setAlignment(Pos.BOTTOM_CENTER);
    // adds button pane to store pane
    getChildren().add(btPane);
  }
  
}
