package linked_lists;

import test_data_structure.ListNode;

/*
 Given a linked list and a value x, 
 partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */

public class Partition_List {

	public static ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}

		ListNode cur = head;
		ListNode small = new ListNode(999999), large = new ListNode(999999);
		ListNode sHead = small, lHead = large;

		while (cur != null) {
			if (cur.val < x) {
				small.next = new ListNode(cur.val);
				small = small.next;
			} else {
				large.next = new ListNode(cur.val);
				large = large.next;
			}
			cur = cur.next;
		}

		if (sHead.next == null) {
			return lHead.next;
		} else if (lHead.next == null) {
			return sHead.next;
		} else {
			sHead = sHead.next;
			lHead = lHead.next;
			small.next = lHead;
		}

		return sHead;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		ListNode n7 = new ListNode(1);
		ListNode n8 = new ListNode(1);
		n7.next = n8;
		ListNode n = partition(n1, 3);

		while (n != null) { // should return 122435.
			System.out.print(n.val);
			n = n.next;
		}
	}

}
