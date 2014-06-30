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
		if (head == null) {
			return null;
		}
		ListNode runner1 = head;
		ListNode runner2 = head;
		while (runner1.next != null && runner2.next != null
				&& runner2.next.next != null) {
			runner1 = runner1.next;
			runner2 = runner2.next.next;
			if (runner1.equals(runner2)) {
				runner1 = head;
				while (!runner1.equals(runner2)) {
					runner1 = runner1.next;
					runner2 = runner2.next;
				}
				return runner1;
			}
		}
		return null;

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
