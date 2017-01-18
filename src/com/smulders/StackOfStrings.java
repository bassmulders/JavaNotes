package com.smulders;

public class StackOfStrings {

	private Node top;
	
	public void push(String newItem) {
		Node newTop = new Node(newItem);
		newTop.next = this.top;
		this.top = newTop;		
	}

	public String pop() {
		if (this.top == null) {
			throw new IllegalStateException("Can't pop from an empty stack.");
		}
		String strPop = this.top.item;
		this.top = this.top.next;
		return strPop;
	}
	
	public boolean isEmpty() {
		return this.top == null;
	}
}
