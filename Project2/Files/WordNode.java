/** 
 * This is the WordNode class which contains the constructors and instance variables of the list
 * @author Ahnaf Ahmed
 */

public class WordNode {

   // instance variables
   String data;
   WordNode next;
   
   /** default constructor */
   public WordNode() {}

   /**
    * 1 parameter constructor
    * @param s  the String to be inserted as the data of the node
    */
   public WordNode(String s) {
      data = s;
   } // WordNode
   
   /** 
    * 2 parameter constructor
    * @param s  the String to be inserted as the data of the node
    * @param wn the node to be assigned as the next node
    */
   public WordNode(String s, WordNode wn) {
      data = s;
      next = wn;
   } // WordNode
   
} // WordNode class
