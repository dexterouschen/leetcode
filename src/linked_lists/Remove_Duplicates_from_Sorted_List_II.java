package linked_lists;

import test_data_structure.ListNode;

/*
 Given a sorted linked list, delete all nodes that have duplicate numbers,
 leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */

public class Remove_Duplicates_from_Sorted_List_II {

	/*
	 * Linked list operations. Use a dummy head to handle the situation in which
	 * duplicates exist at the beginning of the list.
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode nhead = new ListNode(0);
		nhead.next = head;
		ListNode last = nhead, trav = last.next;
		while (trav != null) {
			// if duplicate found, traverse until diff or null
			if (trav.next != null && trav.next.val == trav.val) {
				ListNode cur = trav;
				while (cur.next != null && cur.next.val == trav.val) {
					cur = cur.next;
				}
				last.next = cur.next;
				trav = last.next;
			} else {
				last = trav;
				trav = trav.next;
			}
		}
		return nhead.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(5);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(8);
		ListNode n10 = new ListNode(9);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		ListNode c = n1;
		System.out.println("Before deletion:");
		while (c != null) {
			System.out.print(c.val + "->");
			c = c.next;
		}
		System.out.println("\nAfter deletion:");
		ListNode n = deleteDuplicates(n1);
		c = n;
		while (c != null) {
			System.out.print(c.val + "->");
			c = c.next;
		}
	}

}
