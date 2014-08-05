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
		if (head == null || n == 0) {
			return head;
		}
		ListNode fast = head, slow = head;
		int count = 1;
		while (count < n) {
			fast = fast.next;
			count++;
		}
		if (fast == null) { // check if head needs to be removed
			return head.next;
		}
		fast = fast.next;
		if (fast == null) {
			return head.next;
		}
		// locate slow to the previous node of the one that needs to be removed
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next; // if slow is the head
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
