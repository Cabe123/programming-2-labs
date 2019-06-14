/*
  * File: LetterCounter.java
  * Auther: Caleb Howard
  * Date: 28/2/2018
  * The following class contains methods to created a LetterCounter object
used in LetterCounterDriver.java
*/

package lab2;

public class LetterCounter {
  
  // array used to store the letters in the alphabet
  private char[] letters = new char[26]; 
  // array used to store how many time a letter occurs in a string
  private int[] letterCount = new int[26];
 
 
  // no argument constructor
  public LetterCounter(){
    for (int i = 0; i < letters.length; i++){
      letters[i] = (char)(97 + i);
    }
  }
 
  // this method accepts a string and counts how many times each letter of the
  //alphabet appears
  public void countLetters(String input){
    String inputString = input.toLowerCase();// makes string lowercase
    for(int i = 0; i< inputString.length(); i++){
        
      for(int j = 0; j < 26; j++){
        // checks if each character matches the ascii code of each letter.
        if (inputString.charAt(i) == 97 + j){
          letterCount[j]++;
        
        }
      }
    }
  } 

  // this method formats the letters and count of each letter in a column table
  public String toString(){
    String format = "";
    
    for(int i = 0; i < 5; i++){
      int x = i;
      format += "| ";// adds "bar" at the beginning of each line
      
      for(int j = 0; j < 5; j++){
        // adds letter from index i then every 5th letter
        format += letters[x] + " = " + letterCount[x] + " | ";
        
        x += 5;
      }
      
      // adds z to the end of the first line
      if (x == 25){
        format += letters[x] + " = " + letterCount[x] + " | ";
      }
      
      x = 0;// resets x
      
      format += "\n";// starts new line
    
    }
    return format;
   }
   
}
