/**
 * @author Ahnaf Ahmed
 * Lab Section: 22D (Instructor: Fei Zhai)
 * CSCI 212 Fall 2022
 * FileMenuHandler.java
 */

// libraries
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class FileMenuHandler implements ActionListener {

   // global objects
   JFrame jframe;
   JTextArea LeftTA = new JTextArea();
   JTextArea RightTA = new JTextArea();
   
   // array lists to store words that start with a specific vowel
   ArrayList<WordLine> listOfAs = new ArrayList<WordLine>();
   ArrayList<WordLine> listOfEs = new ArrayList<WordLine>();
   ArrayList<WordLine> listOfIs = new ArrayList<WordLine>();
   ArrayList<WordLine> listOfOs = new ArrayList<WordLine>();
   ArrayList<WordLine> listOfUs = new ArrayList<WordLine>();
   
   /**
    * constructor
    * @param jf     copies the reference of the the content pane from WordGUI
    */
   public FileMenuHandler(JFrame jf) {
      jframe = jf;
   } // constructor
   
   /**
    * implementation of the actionPerformed method from the ActionListener class
    * @param e      provides the name of the menu item that initiated the action
    */ 
   public void actionPerformed(ActionEvent e) {

      String menuName = e.getActionCommand();
      
      // when menu item "Open" is clicked
      if (menuName.equals("Open")) {
         try {
            openFile();
         } catch (FileNotFoundException e1) {
            e1.printStackTrace(); // exception handling
         }
      } // if
      // when menu item "Quit" is clicked
      else if (menuName.equals("Quit")) System.exit(0); // terminates the program
      
      // when any of the menu item from "List" menu is clicked
      else {
         switch (menuName) { // a switch to call a method that displays the appropriate list of vowels
            case "A": displayWords(listOfAs, menuName);
            break;
            case "E": displayWords(listOfEs, menuName);
            break;
            case "I": displayWords(listOfIs, menuName);
            break;
            case "O": displayWords(listOfOs, menuName);
            break;
            case "U": displayWords(listOfUs, menuName);
            break;
         } // switch
      } // else
         
   } // actionPerformed
   
   /**
    * openFile method to open a file when "Open" menu item is clicked
    * @throws FileNotFoundException
    */
   public void openFile() throws FileNotFoundException {

      // Choosing the file to open using the open dialog
      JFileChooser chooser = new JFileChooser();
      int status = chooser.showOpenDialog(null);
      
      // if a file is opened -> continue, otherwise show the error message
      if (status == JFileChooser.APPROVE_OPTION)
         readSource(chooser.getSelectedFile()); // call the readSource method
      else
         JOptionPane.showMessageDialog(null, "Open File Dialog Canceled");     
   } // openFile
   
   /**
    * readSource method to read the file that has just been opened
    * @param chosenFile     the file that was chosen using the JFileChooser object
    * @throws FileNotFoundException
    */
   public void readSource(File chosenFile) throws FileNotFoundException {

      // a scanner object to read from the opened file
      Scanner scanner = new Scanner(chosenFile);
      
      // content pane setup
      jframe.setLayout(new GridLayout(1,2));
      
      LeftTA.append("Original Text:\n"); // title of column 1
      RightTA.append("Select a vowel from the menu list to see the words!\n"); // initial text of column 2
      
      int lineNum = 1;
      String currentLine;
      
      // appending the lines to the GUI with line numbers
      while (scanner.hasNextLine()) {
         currentLine = scanner.nextLine();
         LeftTA.append("\n" + lineNum + " : " + currentLine);
         
         // calling a method to add the words to the appropriate list
         wordList(currentLine, lineNum);
         lineNum++; // incrementing line number
      } // while

      // sorting each list after they are filled with respective vowels
      sortList(listOfAs);
      sortList(listOfEs);
      sortList(listOfIs);
      sortList(listOfOs);
      sortList(listOfUs);   
      
      LeftTA.setEditable(false);
      RightTA.setEditable(false);
      
      // adding Text Areas to the content pane
      jframe.add(LeftTA);
      jframe.add(RightTA);
      
      // updating the jframe
      jframe.setLocation(200, 0);
      jframe.pack();
      jframe.setVisible(true);
   } // readSource
   
   /**
    * wordList method to add vowels to their respective lists
    * @param line   current line of text from the file
    * @param num    current line number in the file
    */
   public void wordList(String line, int num) {
      // using StringTokenizer to separate each word in the line
      StringTokenizer myTokens = new StringTokenizer(line, " .,\"()':");
      String word = "";
      
      while (myTokens.hasMoreTokens()) {
         word = myTokens.nextToken(); // storing current string token into word
         // comparing the first character of the words with each vowels and adding them to their respective lists
         switch (Character.toLowerCase(word.charAt(0))) {
            case 'a': listOfAs.add(new WordLine(word, num));
            break;
            case 'e': listOfEs.add(new WordLine(word, num));
            break;
            case 'i': listOfIs.add(new WordLine(word, num));
            break;
            case 'o': listOfOs.add(new WordLine(word, num));
            break;
            case 'u': listOfUs.add(new WordLine(word, num));
            break;
         } // switch
      } // while
   } // wordList
   
   /**
    * sortList method to sort the lists in alphabetical order
    * @param vowelList      list to be sorted
    */
   public void sortList(ArrayList<WordLine> vowelList) {
      /**
       *  using collections to sort the list with the help of Comparator class
       */
      Collections.sort(vowelList, new Comparator<WordLine>() {
   
         public int compare(WordLine o1, WordLine o2) {
            int comp = o1.word.compareToIgnoreCase(o2.word);
            
            if (comp != 0)
               return comp;
            
            return(-o1.word.compareTo(o2.word)); // to put lower case words ahead of upper case words if 2 similar words are found
          } // compare
      }); // Comparator
   } // sortList
   
   /**
    * displayWords method to display the words from the list on the right half of the grid in the GUI
    * @param vowelList      list to be displayed
    * @param vowel          the vowel that the list is based on
    */
   public void displayWords(ArrayList<WordLine> vowelList, String vowel) {
      
      // clearing the previous list to display the current list
      RightTA.setText(null);
      RightTA.append("Words starting with vowel '"+vowel+"':\n"); // new title of column 2
      // displaying the list using the append method on the text area
      for (WordLine myWord : vowelList) {
         RightTA.append("\n" + myWord.word + " (line " + myWord.line + ")");
      } // for
   } // displayWords
} // class FileMenuHandler
