package linked_lists;

import test_data_structure.ListNode;

/*
 Sort a linked list using insertion sort.
 */

public class Insertion_Sort_List {

	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = head;
		ListNode cur = null;
		while (node.next != null) {
			cur = node.next;
			if (cur.val >= node.val) {
				node = node.next;
				continue;
			}
			node.next = cur.next; // delete the node
			if (cur.val <= head.val) {
				cur.next = head;
				head = cur;
				continue;
			}
			ListNode pos = findInsertPos(head, cur);
			cur.next = pos.next;
			pos.next = cur;
		}
		return head;
	}

	public static ListNode findInsertPos(ListNode head, ListNode node) {
		ListNode pos = head;
		while (head != null && head.val < node.val) {
			pos = head;
			head = head.next;
		}
		return pos;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n3;
		n3.next = n2;
		n2.next = n5;
		n5.next = n4;
		// 13254

		ListNode newhead = insertionSortList(n1);
		while (newhead != null) {
			System.out.print(newhead.val);
			newhead = newhead.next;
		}
	}
}
