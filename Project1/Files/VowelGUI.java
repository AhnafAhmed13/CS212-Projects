/* Name: Ahnaf Ahmed
 * Lab Section: 22D (Instructor: Fei Zhai)
 * CSCI 212 Fall 2022
 * VowelGUI.java
 */
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.TextArea;

public class VowelGUI extends JFrame { // Inheriting JFrame's properties to VowelGUI class

   // Declaring a new VowelGUI object
   static VowelGUI myVowelGUI = new VowelGUI();
   
   // Initialize these properties upon call from the GUI object
   public static void initialize(String s, int[] v) { // Parameters: a String, and an array of int values
      myVowelGUI.setSize(1000, 600);
      myVowelGUI.setLocation(200, 200);
      myVowelGUI.setTitle("Vowel GUI");
      myVowelGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Creating a container for the GUI
      Container myContentPane = myVowelGUI.getContentPane();
      // Setting the layout to grid with 1 row and 2 columns
      myContentPane.setLayout(new GridLayout(1,2));
      
      // Creating a text area for the GUI
      TextArea myTextAreaLeft = new TextArea();
      // Appending the following values to the empty text area
      myTextAreaLeft.append("Column 0\n");
      myTextAreaLeft.append(s);
      // Adding the text area to the container at the left column's position
      myContentPane.add(myTextAreaLeft);
      
      // Creating a second text area
      TextArea myTextAreaRight = new TextArea();
      // Appending the following values to the empty text area
      myTextAreaRight.append("Column 1\n");
      int i = 0; // Creating a counter for traversing the array
      myTextAreaRight.append("A: "+v[i]+"\n"+
                             "E: "+v[++i]+"\n"+
                             "I: "+v[++i]+"\n"+
                             "O: "+v[++i]+"\n"+
                             "U: "+v[++i]);
      // Adding the text area to the container at the right column's position
      myContentPane.add(myTextAreaRight);
      
      myVowelGUI.setVisible(true);
   } // initialize
} // VowelGUI
