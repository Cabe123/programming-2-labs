/*
  * File: MainPane.java
  * Auther: Caleb Howard
  * Date: 29/4/2018
  * The following class combines several panes into one to make
the main pane used in BookStore.java
*/
package lab4;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author caleb
 */
public class MainPane extends BorderPane{
  // no arg constructor
  public MainPane(){
   CreatePane();
  
  }
  // creates pane
  private void CreatePane(){
    
    this.setTop(new MenuPane());// adds menu pane to the top
    this.setRight(new CartPane());// adds cart pane to the right
    this.setCenter(new StorePane());// adds store pane to the center
   
  
  }
}
