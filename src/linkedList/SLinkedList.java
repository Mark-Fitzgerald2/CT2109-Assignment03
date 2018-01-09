package linkedList;

public class SLinkedList {
	protected Node head;	 // head node of the list
	  protected Node tail;	 // tail node of the list
	  protected Node curr;	 // node referencing current position in the list  
	  protected long size;	 // number of nodes in the list
	  
	  /** Default constructor that creates an empty list. */
	  public SLinkedList() {
	    tail = curr = head = null; //all nodes point to null as no object is in the LL 
	    size = 0; //no objects are currently in the LL
	  }

	  public long size() { 
		  return size; //returns the size variable
	  }
	  
	  public boolean isEmpty() { 
		  return (head == null); //the LL is empty if there is no head
	  }

	  public Object getCurr() {
		  if (curr == null)   // Verify that there is a current node
			  return null; //if there is not return null
		  return curr.getElement();	//otherwise return the current node
	  }
	  
	  public boolean gotoHead() {
		  if (isEmpty()) 
			  return false; //if it is empty it can't go to the head
		  curr = head; //otherwise the current node will now point at the head
		  return true; //says that it has updated the position of the current node
	  }
	  
	  /** this is the only modification to this class */
	  public boolean gotoTail() {
		  if (isEmpty()) 
			  return false; //if it is empty there is no tail
		  curr = tail; //otherwise the current node will now point at the tail
		  return true; //says that it has updated the position of the current node
	  }

	  public boolean gotoNext() {
		  if (curr == null) return false; // should only arise when list is empty
		  if (curr.getNext() == null) return false;  // no next node: at end
		  curr = curr.getNext(); //moves the current node to the next node
		  return true; //says that it has updated the position of the current node
	  }

	  public void insertNext(Object el) {
		  if (head == null) { 
	         insertHead(el);  // If haven't inserted a head, do so now (for convenience)
	   	     return;
		  }
		  
		  Node newnode = new Node(el, curr.getNext());  // create new node with its next node equal to curr's next node	  
		  curr.setNext(newnode); // update the next node of the current node to point to the new one
		  size++;

		  // Modification for tail 
	      if (tail == curr) tail = newnode;

		  // make this new node the current one
		  curr = newnode;	  
	  }
	  
	  public void deleteNext() {
		  if (curr == null || curr.getNext() == null) return; // no next: list empty or already at end

		  curr.setNext(curr.getNext().getNext());  // set curr's next equal to the next node's next
		  // Note: Garbage collector will automatically clear up the node no longer referenced

		  if (curr.getNext() == null) tail = curr; // We just removed the tail, so update with new tail
		  
		  size--;
	  }

	  public void insertHead(Object el) {
		  Node oldhead = head;
		  head = new Node(el, oldhead);
		  size++;	  
		  curr = head;
		  if (tail == null) tail = curr; // if list was empty, update tail
	}
	  
	  public void deleteHead() {
		  if (head == null) return; // list already empty
		  
		  head = head.getNext(); // New head is next node
		  size--;
		  curr = head;
		  
		  if (size == 1) tail = curr;
	  }
}
