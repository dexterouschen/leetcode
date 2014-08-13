package linked_lists;

import test_data_structure.ListNode;

/*
 Sort a linked list in O(n log n) time using constant space complexity.
 */

public class Sort_List {

	/**
	 * This is a normal merge-sort. I'm not sure if it satisfies the requirement
	 * of "constant space complexity". One trick of this problem if how to find
	 * the mid-point of a linked list. Here I used two runners: a slow one and a
	 * fast one.
	 */
	public static ListNode sortList(ListNode head) {
		return sort(head);
	}

	public static ListNode sort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode left = head, right = slow.next;
		slow.next = null;
		left = sort(left);
		right = sort(right);
		return merge(left, right);
	}

	public static ListNode merge(ListNode head1, ListNode head2) {
		ListNode nhead = new ListNode(0);
		ListNode cur = nhead;
		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				cur.next = head1;
				head1 = head1.next;
			} else {
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		if (head1 == null) {
			cur.next = head2;
		} else if (head2 == null) {
			cur.next = head1;
		}
		return nhead.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(9);
		ListNode n4 = new ListNode(6);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(8);
		ListNode n7 = new ListNode(4);
		ListNode n8 = new ListNode(7);
		ListNode n9 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		ListNode nhead = sortList(n1);
		// ListNode nhead = merge(n1, n5);
		while (nhead != null) {
			System.out.print(nhead.val + "-->");
			nhead = nhead.next;
		}
		System.out.println("null");
	}

}
