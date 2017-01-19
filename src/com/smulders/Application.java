package com.smulders;
//import java.util.logging.Logger;

public class Application {
	
	static RandomStringGenerator rsg;

	public static void main(String[] args) {
		//doStuffWithALinkedList();
		//doStuffWithAQueue();
		doStuffWithABinaryTree();
	}
	
	private static void doStuffWithABinaryTree() {
		BinaryTreeOfInts b = new BinaryTreeOfInts();
		b.insert(5); System.out.println(5);
		b.insert(6); System.out.println(6);
		b.insert(3); System.out.println(3);
		b.insert(19); System.out.println(19);
		b.insert(1); System.out.println(1);
		b.insert(25); System.out.println(25);
		b.insert(9); System.out.println(9);
		b.print();
		System.out.println("Tree contains 17? " + b.contains(17));
	}
	
//	level: 4; value: 1
//	level: 3; value: 3
//	level: 2; value: 6
//	level: 1; value: 5
//	level: 4; value: 9
//	level: 3; value: 25
//	level: 2; value: 19


	private static void doStuffWithAQueue() {
		QueueOfStrings q = new QueueOfStrings();
		q.enqueue("Klant 1");
		q.enqueue("Klant 2");
		q.enqueue("Klant 3");
		q.enqueue("Klant 4");
		q.enqueue("Klant 5");
		System.out.println("In de rij staan de volgende klanten: ");
		q.print();
		System.out.println("De volgende klant is nu aan de beurt: " + q.dequeue());
		q.enqueue("Klant 6");
		System.out.println("In de rij staan de volgende klanten: ");
		q.print();
		System.out.println("De volgende klant is nu aan de beurt: " + q.dequeue());
		System.out.println("In de rij staan de volgende klanten: ");
		q.print();
	}
	
	private static void doStuffWithALinkedList() {
		rsg = new RandomStringGenerator();
		LinkedList ll;
		try {
			ll = makeLinkedList(8);
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
			ll.append(rsg.nextString());
		}
		return ll;
	}

}
