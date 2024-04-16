/** 
 * This is the UnsortedWordList class which contains the append method
 * @author Ahnaf Ahmed
 */

public class UnsortedWordList extends WordList {
   
   /** @param newWord  the String to be inserted as data to the newly appended WordNode */
   
   public void append(String newWord) {
      WordNode n = new WordNode(newWord);
      last.next = n;
      last = n;
   } // append

} // UnsortedWordList class
