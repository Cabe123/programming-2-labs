/*
  * File: RetailItem.java
  * Auther: Caleb Howard
  * Date: 2/5/18
  * The following class contains methods for creating a retail item object
used in RetailItemTest.java
*/

package lab1;



public class RetailItem {
  
  // object data field
  String itemDescription;
  double itemPrice;
  int unitsInStock;
  
  // no argument constructor
  public RetailItem(){
    itemDescription = "Unknown";
    unitsInStock = 0;
    itemPrice = 0.0;
    }
  
  // argument constructor
  public RetailItem(String description, double price, int inStock){
    setItemDescription(description);
    setItemPrice(price);
    setUnitsInStock(inStock);
  }
  
  // this method sets the discription for the item
  public void setItemDescription(String itemDescription){
  
    this.itemDescription = itemDescription;
    
  }
  // this method sets the price of the item
  public void setItemPrice(double itemPrice){
    
    this.itemPrice = itemPrice;
  
  }
  
  // this method sets the units in stock of th item
  public void setUnitsInStock(int unitsInStock){
  
    this.unitsInStock = unitsInStock;
  }
  
  // this method gets the description of the item
  public String getItemDescription(){
    return itemDescription;
  }
  
  // this method gets the price of the item
  public double getItemPrice(){
    return itemPrice;
  }
  
  // this method gets the number of units in stock of the item
  public int getUnitsInStock(){
    return unitsInStock;
  }
  
  // this method formats the items data into a string
  public String toString(){
  
    String descriptFormatString = itemDescription;
    String priceFormatString = Double.toString(itemPrice);
    String inStockFormatString = Integer.toString(unitsInStock);
    

    // 
    for(int i = descriptFormatString.length(); i < 20; i++){
      descriptFormatString += " ";
    }
    for(int i = priceFormatString.length(); i < 20; i++){
      priceFormatString += " ";
    }
    for(int i = inStockFormatString.length(); i < 20; i++){
      inStockFormatString += " ";
    }
    
    String itemString = descriptFormatString + inStockFormatString + 
              priceFormatString;
    
    return itemString;
  
  }
  
  
  
}
