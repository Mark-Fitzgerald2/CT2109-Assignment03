package linkedList;

import javax.swing.JOptionPane;

public class LLQueue implements Queue{

	protected SLinkedList SLlist; //initialises LL
	   
	 public LLQueue() {
		   SLlist = new SLinkedList(); //creates LL
	 }
	 
	 public void enqueue(Object n)
	 {
		 SLlist.gotoTail(); //points the current node at the tail
		 SLlist.insertNext(n); //calls the insert method in the LL class and passes in the object
	 }
	 
	 public Object dequeue()
	 {
		 if (isEmpty()) { //checks if there is any objects in the LL
			JOptionPane.showMessageDialog(null, "Can not dequeue as Linked List is empty."); //tells user you can't dequeue when a LL is empty
			return null; //returns null
		 }
		 
		 SLlist.gotoHead(); //points to the head object
		 Object removed = SLlist.getCurr(); //stores the object so it can be returned
		 
		 SLlist.gotoNext(); //moves pointer to what is going to be the new head
		 SLlist.deleteHead(); //deletes the object at the old head

		 return removed; //returns the removed object
	 }
	 
	 public boolean isEmpty()  {
	     return (SLlist.isEmpty()); //calls the isEmpty() method from the linked list class
	 }
	 
	 public boolean isFull() {
		 return false; //this will never be true as a LL is never full
	 }
	 
	 public Object front()
	 {
		SLlist.gotoHead(); //points current position to the head node
		return SLlist.getCurr(); //returns the object that the curr pointer is at (now the head)
	 }

	public long size() {
		return SLlist.size(); //returns the size of the LL by calling the size method in the LL class
	}
}
