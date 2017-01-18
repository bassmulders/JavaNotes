package com.smulders;

public class LinkedList {
	
	private Node list;
	
	LinkedList() {
		this.list = null;
	}

	LinkedList(Node head) {
		this.list = head;
	}

	public void append(String newItem) {
		if (this.list == null) {
			this.list = new Node(newItem);
		} else {
			Node node = this.list;
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node(newItem);
		}
	}
	
	public void delete(String deleteItem) {
		Node runner = this.list, previous = null;
		while (runner != null) {
			if (runner.item.equals(deleteItem)) {
				if (previous == null) {
					this.list = runner.next;
				} else {
					previous.next = runner.next;
				}
				runner = null;
				return;
			}
			previous = runner;
			runner = runner.next;
		}
	}
	
	public void insert(String newItem) {
		Node newNode, previous;
		newNode = new Node(newItem);
		
		if (this.list == null) {
			this.list = newNode;
		}
		
		previous = findNodeWithBiggestSmallerValue(this.list, newItem);
		if (previous == null) {
			newNode.next = this.list;
			this.list = newNode;
		} else {
			newNode.next = previous.next;
			previous.next = newNode;
		}
	}

	public int getLength() {
		int count = 0;
		Node node = this.list;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
	
	public int getLength(Node head) {
		int count = 0;
		Node node = head;;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}

	private Node findNodeWithBiggestSmallerValue(Node node, String searchItem) {
		// If the current node is null, or 
		// the item value of the current node is larger than or equal to searchItem, then
		// return null. There is no node in the list with a smaller value than searchItem.
		if (node == null || node.item.compareTo(searchItem) >= 0) {
			return null;
		}
		
		// If we arrive here and there is only one node in the list, the item value
		// of this node must be smaller than searchItem.
		if (node.next == null) {
			return node;
		}
		
		Node runner = node;
		while (runner.next != null) {
			if (runner.next.item.compareTo(searchItem) >= 0) {
				return runner;
			}
			runner = runner.next;
		}
		return runner;
	}
	
	/*
	 * mergeList and mergeSort based on //http://algorithms.tutorialhorizon.com/merge-sort-in-a-linked-list/
	 */
	private Node mergeList(Node a, Node b) {
		Node result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.item.compareTo(b.item) > 0) {
			result = b;
			result.next = mergeList(a, b.next);
		} else {
			result = a;
			result.next = mergeList(a.next, b);
		}
		return result;
	}

	public void mergeSort() {
		this.list = mergeSort(this.list);
	}

	private Node mergeSort(Node a) {
		Node oldHead = a;
		// find the length of the linkedlist
		int mid = this.getLength(a) / 2;
		if (a.next == null)
			return a;
		// set one pointer to the beginning of the list and another at the next
		// element after mid
		while (mid - 1 > 0) {
			oldHead = oldHead.next;
			mid--;
		}
		Node newHead = oldHead.next;// make newHead point to the beginning of
									// the second half of the list
		oldHead.next = null;// break the list
		oldHead = a;// make one pointer point to the beginning of the first
					// half of the list
		Node t1 = mergeSort(oldHead);//make recursive calls 
		Node t2 = mergeSort(newHead);
		return mergeList(t1, t2); // merge the sorted lists
	}
	
	public void print() {
		Node node = this.list;
		while (node != null) {
			System.out.println(node.item);
			node = node.next;
		}
	}
	
	private void printReversedRecursive(Node node) {
		if (node != null) {
			printReversedRecursive(node.next);
			System.out.println(node.item);
		}
	}
	
	public void printReversed() {
		printReversedRecursive(this.list);
	}
}
