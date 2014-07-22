package linked_lists;

import test_data_structure.ListNode;

/*
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.
 */

public class Swap_Nodes_in_Pairs {

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode nhead = new ListNode(888);
		nhead.next = head;
		ListNode curhead = nhead, before = head, after = head.next;
		while (after != null) {
			curhead.next = after;
			before.next = after.next;
			after.next = before;
			if (before.next == null || before.next.next == null) {
				break;
			}
			curhead = before;
			after = before.next.next;
			before = before.next;
		}
		return nhead.next;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		ListNode l = swapPairs(node1);
		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}

}
