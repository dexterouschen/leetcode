package linked_lists;

import test_data_structure.ListNode;

/*
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Linked_List_Cycle {

	public Linked_List_Cycle() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * if runner2 proceeds two nodes at a time, while runner1 proceeds one node
	 * at a time, they will encounter after n steps (n is the number of nodes
	 * involved in a cycle). They will not encounter if there is no cycle.
	 * 
	 * To find out whether or not there is a cycle, simply set up two runners
	 * and test if they would ever encounter.
	 */
	public static boolean hasCycle(ListNode head) {
		ListNode runner1 = head;
		ListNode runner2 = head;
		try {
			while (runner1.next != null && runner2.next.next != null) {
				runner1 = runner1.next;
				runner2 = runner2.next.next;
				if (runner1.equals(runner2))
					return true;
			}
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		// a linked list with cycle
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n5;

		if (hasCycle(n1)) {
			System.out.println("Has cycle.");
		} else {
			System.out.println("No cycle.");
		}

	}
}
