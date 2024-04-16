/* Name: Ahnaf Ahmed
 * Lab Section: 22D (Instructor: Fei Zhai)
 * CSCI 212 Fall 2022
 * Project1.java
 */
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Project1 {

   public static void main(String[] args) throws IOException {
      
      // Using File and Scanner to input the original text from "input.txt"
      File fileInput = new File("src/input.txt"); // path might differ in another computer
      Scanner scannerInput = new Scanner(fileInput);
      
      // Declaring an array to store the amount of each vowel (in alphabetic order)
      int[] vowelArray = new int[5];
      
      // Declaring a string to store the original text input from the return value of count
      String textInput = count(scannerInput, vowelArray);
      
      // Closing the scanner before initializing GUI
      scannerInput.close();
      
      // initializing the VowelGUI with inputText and vowelArrays as parameters
      VowelGUI.initialize(textInput, vowelArray);
      
   } // main

   // Separating the count method from the main method
   public static String count(Scanner input, int[] v) { // Parameters: An object of type Scanner, and an array of int values
      
      String text = ""; // Declaring a String to store the text input and return them at the end
      // Using the hasNextLine method to check when to end the loop
      while (input.hasNextLine()) {
         String s = input.nextLine(); // Storing the current line into String 's'
         text+= s + "\n"; // Concatenating the String 'text' with each line of the input gradually
         // Using a for loop to run the following code block for current length of the input times
         for (int j = 0; j < s.length(); j++) {
            // Using a switch to compare each character's value to find the amount of vowels in the text
            switch (Character.toLowerCase(s.charAt(j))) { // Converting all characters to their subsequent lower case value
               case 'a': v[0]++;
               break;
               case 'e': v[1]++;
               break;
               case 'i': v[2]++;
               break;
               case 'o': v[3]++;
               break;
               case 'u': v[4]++;
               break;
            } // switch
         } // for
      } // while
      return text; // returning the String 'text' to the main function
   } // count
} // Project1
