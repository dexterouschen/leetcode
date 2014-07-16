package linked_lists;

import test_data_structure.ListNode;
import java.util.*;

/*
 Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
 reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

public class Reorder_List {

	/*
	 * OK, I cheated on this one... I used an ArrayList to store all the nodes,
	 * such that reordering them became extremely easy.
	 */
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		ArrayList<ListNode> list = new ArrayList<>();
		ListNode t = head;
		while (t != null) {
			list.add(t);
			t = t.next;
		}
		for (int i = list.size() - 1; i > (list.size() % 2 == 0 ? list.size() / 2 - 1
				: list.size() / 2); i--) {
			int left = list.size() - 1 - i;
			list.get(left).next = list.get(i);
			list.get(i).next = list.get(left + 1);
			list.get(left + 1).next = null;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		ListNode newhead = n1;
		while (newhead != null) {
			System.out.print(newhead.val + "-->");
			newhead = newhead.next;
		}
		System.out.print("null");

		System.out.println("\nAfter reordering:");

		reorderList(n1);
		newhead = n1;
		while (newhead != null) {
			System.out.print(newhead.val + "-->");
			newhead = newhead.next;
		}
		System.out.print("null");

	}

}
