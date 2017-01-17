package com.smulders;
import com.smulders.Node;

public class Application {
	
	static RandomStringGenerator rsg;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rsg = new RandomStringGenerator();
		Node ll;
		ll = makeLinkedList(10);
		System.out.println("Unsorted linked list:");
		printLinkedList(ll);
		System.out.println("\nReversed linked list:");
		printLinkedListReversed(ll);
		ll = makeSortedLinkedList(10);
		System.out.println("\nSorted linked list:");
		printLinkedList(ll);
		ll = insertIntoSortedLinkedList(ll, "k");
		System.out.println("\nInserted 'k' into sorted linked list:");
		printLinkedList(ll);
		ll = deleteFromLinkedList(ll, "k");
		System.out.println("\nDeleted 'k' from sorted linked list:");
		printLinkedList(ll);
		ll = appendToLinkedList(ll, "k");
		System.out.println("\nAppended 'k' to sorted linked list:");
		printLinkedList(ll);
		ll = deleteFromLinkedList(ll, "k");
		System.out.println("\nDeleted 'k' from sorted linked list:");
		printLinkedList(ll);
		
	}
	
	private static Node makeSortedLinkedList(int itemCount) {
		Node head = null;
		for (int i = 0; i < itemCount; i++) {
			head = insertIntoSortedLinkedList(head, rsg.nextString());
		}
		return head;
	}
	
	private static Node makeLinkedList(int itemCount) {
		Node head = null;
		if (itemCount > 0) {
			head = new Node(rsg.nextString());
			Node runner = head;
			for (int i = 1; i < itemCount; i++) {
				runner.next = new Node(rsg.nextString());
				runner = runner.next;
			}
		}
		return head;
	}
	
	private static void printLinkedList(Node node) {
		while (node != null) {
			System.out.println(node.item);
			node = node.next;
		}
	}

	private static void printLinkedListReversed(Node node) {
		if (node != null) {
			printLinkedListReversed(node.next);
			System.out.println(node.item);
		}
	}
	
	private static Node appendToLinkedList(Node head, String newItem) {
		if (head == null) {
			return new Node(newItem);
		}
		Node runner = head;
		while (runner.next != null) {
			runner = runner.next;
		}
		runner.next = new Node(newItem);
		return head;
	}
	
	private static Node insertIntoSortedLinkedList(Node head, String newItem) {
		Node newNode, previous;
		newNode = new Node(newItem);
		
		if (head == null) {
			return newNode;
		}
		
		previous = findNodeWithBiggestSmallerValue(head, newItem);
		if (previous == null) {
			newNode.next = head;
			return newNode;
		} else {
			newNode.next = previous.next;
			previous.next = newNode;
			return head;
		}
	}
	
	private static Node deleteFromLinkedList(Node head, String deleteItem) {
		Node runner = head, previous = null;
		while (runner != null) {
			if (runner.item.equals(deleteItem)) {
				if (previous == null) {
					head = runner.next;
				} else {
					previous.next = runner.next;
				}
				runner = null;
				return head;
			}
			previous = runner;
			runner = runner.next;
		}
		return head;
	}
	
	private static Node findNodeWithBiggestSmallerValue(Node node, String searchItem) {
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
	
//	private static Node SortLinkedList(Node node) {
//		Node p, q, e, tail, oldhead;
//		int insize, nmerges, psize, qsize, i;
//		
//		if (node == null) return null;
//		
//		insize=1;
//	}
//	
//	element *listsort(element *list, int is_circular, int is_double) {
//	    element *p, *q, *e, *tail, *oldhead;
//	    int insize, nmerges, psize, qsize, i;
//
//	    /*
//	     * Silly special case: if `list' was passed in as NULL, return
//	     * NULL immediately.
//	     */
//	    if (!list)
//		return NULL;
//
//	    insize = 1;
//
//	    while (1) {
//	        p = list;
//		oldhead = list;		       /* only used for circular linkage */
//	        list = NULL;
//	        tail = NULL;
//
//	        nmerges = 0;  /* count number of merges we do in this pass */
//
//	        while (p) {
//	            nmerges++;  /* there exists a merge to be done */
//	            /* step `insize' places along from p */
//	            q = p;
//	            psize = 0;
//	            for (i = 0; i < insize; i++) {
//	                psize++;
//			if (is_circular)
//			    q = (q->next == oldhead ? NULL : q->next);
//			else
//			    q = q->next;
//	                if (!q) break;
//	            }
//
//	            /* if q hasn't fallen off end, we have two lists to merge */
//	            qsize = insize;
//
//	            /* now we have two lists; merge them */
//	            while (psize > 0 || (qsize > 0 && q)) {
//
//	                /* decide whether next element of merge comes from p or q */
//	                if (psize == 0) {
//			    /* p is empty; e must come from q. */
//			    e = q; q = q->next; qsize--;
//			    if (is_circular && q == oldhead) q = NULL;
//			} else if (qsize == 0 || !q) {
//			    /* q is empty; e must come from p. */
//			    e = p; p = p->next; psize--;
//			    if (is_circular && p == oldhead) p = NULL;
//			} else if (cmp(p,q) <= 0) {
//			    /* First element of p is lower (or same);
//			     * e must come from p. */
//			    e = p; p = p->next; psize--;
//			    if (is_circular && p == oldhead) p = NULL;
//			} else {
//			    /* First element of q is lower; e must come from q. */
//			    e = q; q = q->next; qsize--;
//			    if (is_circular && q == oldhead) q = NULL;
//			}
//
//	                /* add the next element to the merged list */
//			if (tail) {
//			    tail->next = e;
//			} else {
//			    list = e;
//			}
//			if (is_double) {
//			    /* Maintain reverse pointers in a doubly linked list. */
//			    e->prev = tail;
//			}
//			tail = e;
//	            }
//
//	            /* now p has stepped `insize' places along, and q has too */
//	            p = q;
//	        }
//		if (is_circular) {
//		    tail->next = list;
//		    if (is_double)
//			list->prev = tail;
//		} else
//		    tail->next = NULL;
//
//	        /* If we have done only one merge, we're finished. */
//	        if (nmerges <= 1)   /* allow for nmerges==0, the empty list case */
//	            return list;
//
//	        /* Otherwise repeat, merging lists twice the size */
//	        insize *= 2;
//	    }
//	}

}
