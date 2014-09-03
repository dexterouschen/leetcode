package linked_lists;

import test_data_structure.ListNode;

/*
 Sort a linked list using insertion sort.
 */

public class Insertion_Sort_List {
	/**
	 * Typical listNode operations: insert a node to its correct position.
	 * 
	 * Note: what is "insertion sort"?
	 * Insertion sort iterates, consuming one input element each repetition, 
	 * and growing a sorted output list. Each iteration, insertion sort removes 
	 * one element from the input data, finds the location it belongs within the 
	 * sorted list, and inserts it there. It repeats until no input elements remain.
	 * 
	 * Complexity:
	 * Time O(n^2)
	 * Space O(n)
	 */
	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = head, trav = null;
		while (node.next != null) {
			trav = node.next;
			if (trav.val >= node.val) {
				node = node.next;
				continue;
			}
			node.next = trav.next; // delete the node
			if (trav.val <= head.val) { // if trav is inserted to head position
				trav.next = head;
				head = trav;
				continue;
			}
			// find correct position for trav
			ListNode pos = head;
			while (head != null && head.val < node.val) {
				pos = head;
				head = head.next;
			}
			trav.next = pos.next;
			pos.next = trav;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n3;
		n3.next = n2;
		n2.next = n5;
		n5.next = n4;
		// 13254

		ListNode newhead = insertionSortList(n1);
		while (newhead != null) {
			System.out.print(newhead.val);
			newhead = newhead.next;
		}
	}
}
