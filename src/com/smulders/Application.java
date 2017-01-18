package com.smulders;
import com.smulders.Node;
import com.smulders.LinkedList;
//import java.util.logging.Logger;

public class Application {
	
	static RandomStringGenerator rsg;

	public static void main(String[] args) {
	
		rsg = new RandomStringGenerator();
		LinkedList ll;// = new LinkedList(head);
		try {
			ll = makeLinkedList(17);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("Unsorted linked list:");
		ll.print();

		System.out.println("\nSorted linked list:");
		ll.mergeSort();
		ll.print();
		
		System.out.println("\nReversed linked list:");
		ll.printReversed();
		
		System.out.println("\nInserted 'k' into sorted linked list:");
		ll.insert("k");
		ll.print();

		System.out.println("\nDeleted 'k' from sorted linked list:");
		ll.delete("k");
		ll.print();

		System.out.println("\nAppended '<appended string>' to sorted linked list:");
		ll.append("<appended string>");
		ll.print();

		System.out.println("\nDeleted '<appended string>' from sorted linked list:");
		ll.delete("<appended string>");
		ll.print();
		
	}
	
	private static LinkedList makeLinkedList(int itemCount) throws IllegalArgumentException {
		if (itemCount < 0) throw new IllegalArgumentException("LinkedList cannot have negative number of elements.");
		LinkedList ll = new LinkedList();
		for (int i = 1; i <= itemCount; i++) {
			ll.append(rsg.nextString());;
		}
		return ll;
	}
	
//	private static void printLinkedList(Node node) {
//		while (node != null) {
//			System.out.println(node.item);
//			node = node.next;
//		}
//	}
//
//	private static void printLinkedListReversed(Node node) {
//		if (node != null) {
//			printLinkedListReversed(node.next);
//			System.out.println(node.item);
//		}
//	}
//	
//	private static Node appendToLinkedList(Node head, String newItem) {
//		if (head == null) {
//			return new Node(newItem);
//		}
//		Node runner = head;
//		while (runner.next != null) {
//			runner = runner.next;
//		}
//		runner.next = new Node(newItem);
//		return head;
//	}
//
//	private static Node deleteFromLinkedList(Node head, String deleteItem) {
//		Node runner = head, previous = null;
//		while (runner != null) {
//			if (runner.item.equals(deleteItem)) {
//				if (previous == null) {
//					head = runner.next;
//				} else {
//					previous.next = runner.next;
//				}
//				runner = null;
//				return head;
//			}
//			previous = runner;
//			runner = runner.next;
//		}
//		return head;
//	}

}
