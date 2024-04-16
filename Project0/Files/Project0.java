/* Name: Ahnaf Ahmed
 * Lab Section: 22D (Mon-Wed 5:00PM-5:50PM, Instructor: Fei Zhai)
 * CSCI 212 Fall 2022
 */

import javax.swing.*;

public class Project0 {
   
   public static void main(String[] args) {
      
      // a while loop that repeats the user prompt until the user decides to exit the program
      while (true) {
         
         // assigning the value of the user's input to the object userInput
         String userInput = JOptionPane.showInputDialog(null, "Please enter a sentence.");
         
         // a conditional statement that checks if the user has decided to exit the program
         if (userInput.equalsIgnoreCase("Stop")) System.exit(0);
         
         int e = 0; // an integer primitive to count the number of lower case e's
         int E = 0; // an integer primitive to count the number of upper case e's
         
         // a for loop that runs the following code block for 'the number of characters in the user input' times
         for (int i = 0; i < userInput.length(); i++) {
            
            char c = userInput.charAt(i); // a character primitive that stores the value of the current index of the user input
            
            // an if conditional statement that checks if the current index value of the user input equals to lower case e character; if true, it'll increment the value of the primitive 'e' by 1
            if (c == 'e') e++;
            
            // an if conditional statement that checks if the current index value of the user input equals to upper case e character; if true, it'll increment the value of the primitive 'E' by 1
            if (c == 'E') E++;
         } // for
         
         String output = "Number of lower case e's: " + e + "\n" + "Number of upper case e's: " + E; // a string object that concatenates the output of the program
         
         JOptionPane.showMessageDialog(null, output); // a dialog box that prints the output to the display of the user
      } // while
   } // main
} // Project0