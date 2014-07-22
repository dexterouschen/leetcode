package linked_lists;

import test_data_structure.ListNode;

/*
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */

public class Rotate_List {

	public static ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0) {
			return head;
		}
		// r2 runs ahead of r1
		ListNode r1 = head, r2 = head;
		int count = 0;
		// locate r2
		while (r2 != null && count < n) {
			count++;
			r2 = r2.next == null ? head : r2.next;
		}
		while (r2.next != null) {
			r1 = r1.next;
			r2 = r2.next;
		}
		ListNode r3 = r1; // r3 is the new tail;
		r1 = r1.next; // r1 is the new head
		if (r1 == null) {
			return head;
		}
		r2.next = head;
		r3.next = null;
		return r1;
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
