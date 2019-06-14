/*
Programmers: Caleb Howard and Derek Giles
*/
package quizzes;

import java.util.Scanner;
public class PasswordDriver {
    public static void main(String[] args){
      boolean exit = false;
        String input;  // To hold input

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
      
        while(!exit){
        // Get a password.
        System.out.print("Enter a password: ");
        input = keyboard.nextLine();

        // Check the password.
    
        
        if (!PasswordVerifier.isValid(input)){  
            System.out.println("Invalid password.");
        }else{
           System.out.println("Valid password.");
           exit = true;
      }       
      }
    }
}


