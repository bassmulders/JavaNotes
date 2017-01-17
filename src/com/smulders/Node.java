package com.smulders;

public class Node {
	public String item;
	public Node next;
	
	Node() {
		this.item = "";
		this.next = null;
	}
	
	Node(String str) {
		this.item = str;
		this.next = null;
	}
	
}
