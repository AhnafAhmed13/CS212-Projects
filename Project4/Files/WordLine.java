/**
 * @author Ahnaf Ahmed
 * Lab Section: 22D (Instructor: Fei Zhai)
 * CSCI 212 Fall 2022
 * WordLine.java
 */

import java.util.ArrayList;

public class WordLine {

   /** data members */
   String word;
   ArrayList<Integer> lines = new ArrayList<Integer>(); // ArrayList of integers to store all the line numbers on which a unique word appears.
   
   /**
    * 2 parameter constructor for WordLine class
    * @param w      provides the word for the instance object
    * @param l      provides the line for the instance object
    */
   public WordLine (String w, int l) {
      word = w;
      // Exception checking
      if (l >= 1) lines.add(l);
      else throw new InvalidWordLineException("Invalid input! The line number cannot be less than 1!");
   } // constructor
} // class WordLine
