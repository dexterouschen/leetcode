package linked_lists;

import test_data_structure.ListNode;

/*
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Follow up:
 Can you solve it without using extra space?
 */
public class Linked_List_Cycle_II {

	/*
	 * First set runner1 moving one node at a time and runner2 two nodes at a
	 * time. When they meet, reset runner1 to the head and keep runner2 at its
	 * current position. Change the pace of two runners to one node at a time.
	 * When they meet again, the node is the starting of the cycle.
	 */
	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		ListNode r1 = head.next, r2 = head.next.next;
		while (!r1.equals(r2)) {
			if (r2.next == null || r2.next.next == null) {
				return null;
			}
			r1 = r1.next;
			r2 = r2.next.next;
		}
		r1 = head;
		while (!r1.equals(r2)) {
			r1 = r1.next;
			r2 = r2.next;
		}
		return r1;
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
		n7.next = n3;

		System.out.println(detectCycle(n1).val);
	}

}
