/*
Programmers: Caleb Howard and Derek Giles
*/
package quizzes;

/**
 * Description of program here
 * @author Your name here
 */
public class PasswordVerifier {

// Constant for minimum password length
   public static final int MIN_PASSWORD_LENGTH = 8;
   
   /**
        isValid method
    */
   public static boolean isValid(String str)
   {
      boolean status = false; // Validity status
    if(hasUpperCase(str) && hasLowerCase(str) && hasDigit(str) && hasEightOrMore(str)){
        status = true;
    }
    //Check to see if password is valid(contains one digit, one lowercase, one uppercase, and 8 character
    // may use if statement
      return status;
   }

   /**
        hasUpperCase method
    */
   private static boolean hasUpperCase(String str)
   {
      boolean status = false; // Validity status
      if(str.matches(".*[A-Z].*")){
          status = true;
      }
      
   // check to see if password contains at least one uppercase
   // may use a loop to check each character
      return status;
   }

   /**
        hasLowerCase method
    */
   private static boolean hasLowerCase(String str)
   {
      boolean status = false; // Validity status
      if(str.matches(".*[a-z].*")){
          status = true;
      }
     //check to see if password contains at least one lowercase
    //may use a loop to check each character 
      return status;
   }

   /**
        hasDigit method
    */
   private static boolean hasDigit(String str)
   {
      boolean status = false; // Validity status
    
      if(str.matches(".*\\d.*")){
          status = true;
      }

    //check to see if password contains at least one digit
   //may use a loop to check each character 
      return status;
}
   public static boolean hasEightOrMore(String str){
       boolean status  = false;
       
       if(str.length() >=  MIN_PASSWORD_LENGTH){
           status = true;
       }
       
      return status;
   }
   
}