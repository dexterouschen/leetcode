package linked_lists;

import java.util.ArrayList;

import test_data_structure.ListNode;

/*
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class Remove_Dups_from_Sorted_List {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode trav = head;
		ListNode newHead = trav;
		while (trav != null) {
			ListNode cur = trav;
			while (cur != null && cur.val == trav.val) {
				cur = cur.next;
			}
			trav.next = cur;
			trav = trav.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		ListNode n = deleteDuplicates(node1);
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}

}
