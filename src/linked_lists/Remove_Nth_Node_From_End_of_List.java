package linked_lists;

import test_data_structure.ListNode;

/*
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */

public class Remove_Nth_Node_From_End_of_List {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head, second = head;
		int count = 0;
		while (count < n + 1) {
			if (first == null) {
				head = head.next;
				return head;
			}
			first = first.next;
			count++;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return head;
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

		ListNode res = removeNthFromEnd(n1, 5);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
