/* Name: Ahnaf Ahmed
 * Lab Section: 22D (Instructor: Fei Zhai)
 * CSCI 212 Fall 2022
 * Project2.java
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Project2 {

   public static void main(String[] args) throws IOException {
      
      // Linked Lists
      UnsortedWordList Unsorted = new UnsortedWordList();
      SortedWordList Sorted = new SortedWordList();
      
      // scanning input file
      Scanner myScanner = new Scanner(new File("input.txt"));

      String inputText = "";
      String line = "";
      String word = "";
      
      while (myScanner.hasNext()) {
         line = myScanner.nextLine();
         inputText += line + "\n";
         
         // using StringTokenizer to separate each word from the text
         StringTokenizer myTokens = new StringTokenizer(line, " .,\"()':");
         
         while (myTokens.hasMoreTokens()) {
            word = myTokens.nextToken(); // storing current string token into word
            Unsorted.append(word); // appending word in unsorted linked list
            Sorted.add(word); // adding word in sorted linked list
         } // while
      } // while
      
      myScanner.close();
   
      // initializing WordGUI with inputText, Unsorted, and Sorted as arguments
      WordGUI.initialize(inputText, Unsorted, Sorted);
   
   } // main
   
} // Project2 class
