/**
 * @author Ahnaf Ahmed
 * Lab Section: 22D (Instructor: Fei Zhai)
 * CSCI 212 Fall 2022
 * WordLine.java
 */

public class WordLine {

   /** data members */
   String word;
   int line;
   
   /**
    * 2 parameter constructor for WordLine class
    * @param w      provides the word for the instance object
    * @param l      provides the line for the instance object
    */
   public WordLine (String w, int l) {
      word = w;
      // Exception checking
      if (l >= 1) line = l;
      else throw new InvalidWordLineException("Invalid input! The line number cannot be less than 1!");
   } // constructor
} // class WordLine
