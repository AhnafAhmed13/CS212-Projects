/**
 * @author Ahnaf Ahmed
 * Lab Section: 22D (Instructor: Fei Zhai)
 * CSCI 212 Fall 2022
 * WordGUI.java
 */

// libraries
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class WordGUI extends JFrame {

   /** constructor */
   public WordGUI() {
      // GUI setup
      this.setTitle("WordGUI: List of Vowels");
      this.setSize(800, 600);
      this.setLocation(200, 200);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      // action listener
      FileMenuHandler fmh = new FileMenuHandler(this);
      
      // menu bar setup
      JMenuBar menuBar = new JMenuBar();
      
      // file menu setup
      JMenu fileMenu = new JMenu("File");
      JMenuItem item = new JMenuItem("Open");
      item.addActionListener(fmh);
      fileMenu.add(item);
      //--------------------
      fileMenu.addSeparator();
      
      item = new JMenuItem("Quit");
      item.addActionListener(fmh);
      fileMenu.add(item);
      
      menuBar.add(fileMenu);
      //--------------------
      // list menu setup
      //--------------------
      JMenu listMenu = new JMenu("List");
      item = new JMenuItem("A");
      item.addActionListener(fmh);
      listMenu.add(item);
      //--------------------
      listMenu.addSeparator();
      
      item = new JMenuItem("E");
      item.addActionListener(fmh);
      listMenu.add(item);
      //--------------------
      listMenu.addSeparator();
      
      item = new JMenuItem("I");
      item.addActionListener(fmh);
      listMenu.add(item);
      //--------------------
      listMenu.addSeparator();
      
      item = new JMenuItem("O");
      item.addActionListener(fmh);
      listMenu.add(item);
      //--------------------
      listMenu.addSeparator();
      
      item = new JMenuItem("U");
      item.addActionListener(fmh);
      listMenu.add(item);
      
      menuBar.add(listMenu);
      
      this.setJMenuBar(menuBar);
      
      this.setVisible(true);
   } // constructor
} // class WordGUI
