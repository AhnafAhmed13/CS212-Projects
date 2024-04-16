/** 
 * This is the SortedWordList which contains the add method
 * @author Ahnaf Ahmed
 */

public class SortedWordList extends WordList {
   
   /** @param newWord   the String to be inserted as data to the newly added WordNode */
   
   public void add(String newWord) {
      
      WordNode newNode = new WordNode(newWord); // new node (not sorted yet)
      
      // if the list is empty
      if (first.next == null) {
         first.next = newNode;
         last = newNode;
      } // if
      else {
         WordNode temp = find(newWord); // search position
         newNode.next = temp.next;
         temp.next = newNode;
      } // else
   } // add
   
   /** @param  word         the data String of the newly created WordNode "newNode"
    *  @return WordNode     the position of the node where the newNode should be added
    */
   
   public WordNode find(String word) {
      WordNode Itr = first;
      while (Itr.next != null) { // traversing the list
         if (word.compareToIgnoreCase(Itr.next.data) > 0) Itr = Itr.next; // comparing if the current node's data is alphabetically greater than the newNode's data
         else return Itr;
      }
      return last; // if no position within the list is found for the newNode, add it to the end of the list
   } // find
   
} // SortedWordList class
