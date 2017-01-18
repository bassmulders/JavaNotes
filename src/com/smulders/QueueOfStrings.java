package com.smulders;

public class QueueOfStrings {
	
	Node front;
	Node back;
	
	public void enqueue(String newItem) {
		// Add new node at the back (end of the tail)
		Node node = new Node(newItem);
		if (back == null) { 
			/* If back is null then front is also null. */
			/* Both back and front point to the new node; the only node in the list. */
			back = node;
			front = node;
		} else {				
			/* Append the new node at the tail of the list. */
			/* Set back pointer to new last item in the list. */
			/* (Front (head) is unaffected.) */
			back.next = node; 	
			back = back.next;   
		}
	}
	
	public String dequeue() {
		if (front == null) {
			throw new IllegalStateException("Can't dequeue from an empty queue.");
		} else {
			Node oldFront = front; // Keep pointer to oldFront to return its value later.
			front = front.next;    // Set front pointer to next item in list.
			if (front == null) {   // If there is no next item both back and front become null.
				back = null;
			}
			return oldFront.item;  // Return the value of the old front.
		}
	}
	
	public boolean isEmpty() {
		return this.back == null;
	}
	
	public void print() {
		Node runner = front;
		while (runner != null) {
			System.out.println(runner.item);
			runner = runner.next;
		}
	}
}
