package linked_lists;

import test_data_structure.ListNode;

/*
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */

public class Rotate_List {
	/**
	 * A smart way to solve this problem is by connecting the tail and the head,
	 * which makes this list into a circle. Then rotate the circle clock-wise
	 * for n positions. Then disconnect the node between new head and new tail.
	 * Please be careful when "n" is larger than the size of the list.
	 */
	public static ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null || n == 0) {
			return head;
		}
		ListNode trav = head;
		int length = 1; // find out the length of this list
		while (trav.next != null) {
			trav = trav.next;
			length++;
		}
		// update the effective number of nodes that need to be rotated
		int rotate = n % length;
		if (rotate == 0) {
			return head;
		}
		trav.next = head; // connect head and tail
		int move = length - rotate, i = 1; // moves pointer to the new tail
		ListNode ntail = head;
		while (i < move) {
			ntail = ntail.next;
			i++;
		}
		ListNode nhead = ntail.next;
		ntail.next = null;
		return nhead;
	}

	public static void print(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + "->");
			cur = cur.next;
		}
		System.out.print("null");
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode n = rotateRight(n1, 2);
		print(n);
	}

}
