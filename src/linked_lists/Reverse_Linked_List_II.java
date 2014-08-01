package linked_lists;

import test_data_structure.ListNode;

/*
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 <= m <= n <= length of list.
 */

public class Reverse_Linked_List_II {
	/*
	 * Pointers operations. Attention if m == 1.
	 */
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		// initiate m node and n node
		ListNode mNode = head;
		ListNode nNode = head;
		// previous node of node m
		ListNode mPreNode = new ListNode(0);
		mPreNode.next = head;
		// set up the distance between node m and node n
		for (int i = 0; i < n - m; i++) {
			nNode = nNode.next;
		}
		// locate node m and node n
		for (int i = 0; i < m - 1; i++) {
			mPreNode = mNode;
			mNode = mNode.next;
			nNode = nNode.next;
		}
		// check in case reversing from head
		boolean fromHead = false;
		if (mNode == head) {
			fromHead = true;
		}
		// reverse node range
		while (mNode != nNode) {
			ListNode temp = nNode.next;
			nNode.next = mNode;
			mPreNode.next = mNode.next;
			mNode.next = temp;
			mNode = mPreNode.next;
		}
		// case of reverse started from head
		if (fromHead == true) {
			return nNode;
		}
		// other cases
		return head;
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
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		ListNode n = reverseBetween(n1, 1, 5);
		ListNode t = n;

		while (t != null) {
			System.out.print(t.val);
			t = t.next;
		}

	}

}
