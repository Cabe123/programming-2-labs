/*
  * File: CartPane.java
  * Auther: Caleb Howard
  * Date: 29/4/2018
  * The following class is used to create a shopping cart pane that is 
used in BookStore.java
*/
package lab4;

import java.text.NumberFormat;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CartPane extends VBox{
  
  static ListView cartList = new ListView(); // list view used in cart pane
  // holds prices of items in the cart pane
  static ArrayList<Double> prices = new ArrayList<Double>();
  
  // no arg constructor
  public CartPane(){
    CreatePane();
  
  }
  // creates cart pane
  private void CreatePane(){
    // add cart listview to pane
    getChildren().add(cartList);
    ButtonPane();// calls button pane method
  }
  // this method is used to add items to the cart
  public static void addItem(String item,double price){
    cartList.getItems().add(item);
    prices.add(price);
  }
  // this method creates a button pane used for cart pane
  private void ButtonPane(){
    // creates button pane
    HBox btPane = new HBox();
    btPane.setMinHeight(30);
    btPane.setSpacing(10);
    
    Button clearBt = new Button("Clear");// creates clear button
    
    Button removeBt = new Button("Remove");// creates remove button
   
    Button checkOutBt = new Button("Check Out");// creates check out button
    
    // if the remove button is pressed
    removeBt.setOnAction(e -> {
      // gets the index of the item that is selected and assigns it to index
      int index = cartList.getSelectionModel().getSelectedIndex();
      // checks if an item is selected
      if(index > -1){
        // removes selected item
        cartList.getItems().remove(index);
        prices.remove(index);
      }
     
    });
    // if the clear button is selected
    clearBt.setOnAction(e ->{
      // clears all items from cart
      cartList.getItems().clear();
      prices.clear();
      
    });
    // if the check out button is selected
    checkOutBt.setOnAction(e -> {
      // checks if there are items in the cart
      if(cartList.getItems().size() > 0){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();//currency formatter
        
        double subTotal = 0;// double used to track sub total
        // adds up all the book prices in the cart
        for(double price: prices){
          subTotal += price;
        }
        // calculates taxes
        double tax = subTotal * .09;
        // creates stage used to display the cost
        Stage costStage = new Stage();
        costStage.setMinHeight(200);
        costStage.setMinWidth(200);
        costStage.setMaxHeight(300);
        costStage.setMaxWidth(300);
        // creates pane used to display the cost
        VBox costPane = new VBox();
        costPane.setAlignment(Pos.CENTER);
        // add text to display the sub total, sales tax, and total
        costPane.getChildren().add(new Label("Sub Total: " + fmt.format(subTotal)));
        costPane.getChildren().add(new Label("Sales Tax: " + fmt.format(tax)));
        costPane.getChildren().add(new Label("Total: " + fmt.format(subTotal + tax)));
        // creates panes used to hold buttons
        HBox buttonPane = new HBox();
        buttonPane.setAlignment(Pos.CENTER);
        // adds buttonPane to costPane
        costPane.getChildren().add(buttonPane);
        buttonPane.setSpacing(20);
        // creates purchase and cancel buttons
        Button purchaseButton = new Button("Purchase");
        purchaseButton.setAlignment(Pos.BOTTOM_RIGHT);
        Button cancelButton = new Button("Cancel");
        cancelButton.setAlignment(Pos.BOTTOM_LEFT);
        
        // if the cancel button is pressed
        cancelButton.setOnAction(a -> {
          // closes the costPane  
          costStage.close();
        });
        // if the purchase button is pressed
        purchaseButton.setOnAction(a ->{
          // clears whats displayed on costPane
          costPane.getChildren().clear();
          // creates thank you text
          Text thankLb = new Text("Thank you for \nyour purchase.\n\n");
          thankLb.setFont(new Font(20));
          // creates done button
          Button doneButton = new Button("Done");
          doneButton.setAlignment(Pos.BOTTOM_CENTER);
          // adds the label and button to the costPane
          costPane.getChildren().addAll(thankLb,doneButton);
          
          // if the don button is pressed
          doneButton.setOnAction(b ->{
            // closes the cost pane
            costStage.close();
            // clears out the cart
            cartList.getItems().clear();
            prices.clear();
          });
         
          
        });
        // adds cancel and purchase buttons to buttonPane
        buttonPane.getChildren().addAll(cancelButton, purchaseButton);
        // creates costScene
        Scene costScene = new Scene(costPane);
        // add scene to costStage and shows it
        costStage.setScene(costScene);
        costStage.initModality(Modality.APPLICATION_MODAL);
        costStage.show();
      }
    });
    // adds buttons to button pane
    btPane.getChildren().addAll(clearBt,removeBt,checkOutBt);
    btPane.setAlignment(Pos.BOTTOM_CENTER);
    // add button pane to cart pane
    getChildren().add(btPane);
  }
  
    
  
}
