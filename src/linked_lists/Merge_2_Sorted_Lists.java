package linked_lists;

import test_data_structure.ListNode;

/*
 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists.
 */
public class Merge_2_Sorted_Lists {

	public Merge_2_Sorted_Lists() {
		// TODO Auto-generated constructor stub
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode trav;
		ListNode nl;
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		if (l1.val <= l2.val) {
			trav = l1;
			nl = trav;
			l1 = l1.next;
		} else {
			trav = l2;
			nl = trav;
			l2 = l2.next;
		}

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				trav.next = l1;
				trav = trav.next;
				l1 = l1.next;
			} else {
				trav.next = l2;
				trav = trav.next;
				l2 = l2.next;
			}
		}

		if (l1 == null) {
			trav.next = l2;
		} else if (l2 == null) {
			trav.next = l1;
		}

		return nl;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);

		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(6);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;

		ListNode nl = mergeTwoLists(node1, node5);
		while (nl != null) {
			System.out.println(nl.val);
			nl = nl.next;
		}
	}
}
