/* Name: Ahnaf Ahmed
 * Lab Section: 22D (Instructor: Fei Zhai)
 * CSCI 212 Fall 2022
 * WordGUI.java
 */
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.TextArea;

public class WordGUI extends JFrame { // Inheriting JFrame's properties to WordGUI class

   // Declaring a new WordGUI object
   static WordGUI myWordGUI = new WordGUI();
   
   // Initialize these properties upon call from the GUI object
   public static void initialize(String s, UnsortedWordList unsort, SortedWordList sort) {
      myWordGUI.setSize(2000, 1600);
      myWordGUI.setLocation(100, 100);
      myWordGUI.setTitle("Word GUI");
      myWordGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Creating a container for the GUI
      Container myContentPane = myWordGUI.getContentPane();
      // Setting the layout to grid with 1 row and 3 columns
      myContentPane.setLayout(new GridLayout(1,3));
      
      // Creating a text area for the GUI (Column 1)
      TextArea TA1 = new TextArea();
      // Appending the following values to the empty text area
      TA1.append("Original text: \n\n"); // title
      TA1.append(s);
      TA1.setEditable(false);
      // Adding the text area to the 1st column of the grid
      myContentPane.add(TA1);
      
      // Creating a second text area (Column 2)
      TextArea TA2 = new TextArea();
      // Appending the following values to the empty text area
      TA2.append("Unsorted words:\n\n"); // title

      WordNode Itr = unsort.first.next;
      String unSortList = "";
      
      // Storing data of all unsorted list nodes into unSortList String
      while (Itr != null) {
         unSortList += Itr.data + "\n";
         Itr = Itr.next;
      } // while
      TA2.append(unSortList);
      TA2.setEditable(false);
      // Adding the text area to the 2nd column of the grid
      myContentPane.add(TA2);
      
      // Creating a third text area (column 3)
      TextArea TA3 = new TextArea();
      // Appending the following values to the empty text area
      TA3.append("Sorted words:\n\n"); // title

      Itr = sort.first.next;
      String sortList = "";

      // Storing data of all sorted list nodes into sortList String
      while (Itr != null) {
         sortList += Itr.data + "\n";
         Itr = Itr.next;
      } // while
      TA3.append(sortList);
      TA3.setEditable(false);
      // Adding the text area to the 3rd column of the grid
      myContentPane.add(TA3);
      
      myWordGUI.setVisible(true);
   } // initialize
} // WordGUI
