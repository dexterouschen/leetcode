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
	/*
	 * pointer operations.
	 */
	public static ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;
		ListNode fakeHead1 = new ListNode(0);
		ListNode fakeHead2 = new ListNode(0);
		fakeHead1.next = head;
		ListNode p = head;
		ListNode prev = fakeHead1;
		ListNode p2 = fakeHead2;
		while (p != null) {
			if (p.val < x) {
				p = p.next;
				prev = prev.next;
			} else {
				p2.next = p;
				prev.next = p.next;

				p = prev.next;
				p2 = p2.next;
			}
		}
		// close the list
		p2.next = null;
		prev.next = fakeHead2.next;
		return fakeHead1.next;
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
