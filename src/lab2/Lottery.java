/*
  * File: Lottery.java
  * Auther: Caleb Howard
  * Date: 24/2/2018
  * The following class contains methods used to create a Lottery simulator
object used in LotteryDriver.java
*/

package lab2;
import java.util.Arrays;
import java.util.Random;


public class Lottery {
  
  Random randomNum = new Random();
  
  private int[] lotteryNumbers = new int[5];// array used for random numbers
  private int[] userLotteryNumbers = new int[5]; // array used for user's numbers
  private String matchString = ""; // string used for formating
  private int matchNum = 0; // number to keep track of how many numbers match
  
  char check = '\u2714';// unicode for check mark
  
  // no argument constructor
  public Lottery(){
    // assigns 5 random numbers to lotteryNumbers array
    for (int i = 0; i < lotteryNumbers.length; i++){
      lotteryNumbers[i] = randomNum.nextInt(10);
    }
  }
  /* this method accepts an array and determines how many of the numbers
  match the numbers in the lotteryNumbers array  */
  public int lotteryMatches(int[] array){
    userLotteryNumbers = Arrays.copyOf(array, array.length);
    for (int i = 0; i < lotteryNumbers.length; i++){
      if(lotteryNumbers[i] == userLotteryNumbers[i]){
        matchString += check + "|";
        matchNum++;
      }else{
        matchString += "x|";
      }
    }
    return matchNum;
  }
  
  // this method returns a copy of the lotteryNumbers array
  public int[] copyOfArray(){
    
    return Arrays.copyOf(lotteryNumbers, lotteryNumbers.length);
  
  }
  
  // this method formats and returns a string representation of the objectl
  public String toString(){
    String lotteryNumString = "";
    String userLotteryNumString = "";
    // formats number arrays into strings
    for(int i = 0; i < lotteryNumbers.length; i++){
      lotteryNumString += lotteryNumbers[i] + "|";
      userLotteryNumString += userLotteryNumbers[i] + "|";
    }
    // formats results table
    String formatString = "Lottery Numbers:   |" + lotteryNumString + "\n" +
                 matchNum +" out of 5 matched:|" + matchString + "\n" +
                          "Your Numbers:      |" + userLotteryNumString;
    
    return formatString;
  }
  
  
  
}
  

