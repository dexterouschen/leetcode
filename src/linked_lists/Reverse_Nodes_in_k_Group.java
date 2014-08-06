package linked_lists;

import test_data_structure.ListNode;

/*
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */

public class Reverse_Nodes_in_k_Group {
	/*
	 * A simple method if you want to reverse the entire list.
	 */
	public static ListNode reverseEntireList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode nhead = new ListNode(0);
		nhead.next = head;
		ListNode last = head, cur = head.next;
		while (cur != null) {
			last.next = cur.next;
			cur.next = nhead.next;
			nhead.next = cur;
			cur = last.next;
		}
		return nhead.next;
	}

	/**
	 * Reverse a link list between pre and next exclusively an example: a linked
	 * list: 0->1->2->3->4->5->6 | | pre next after call pre = reverse(pre,
	 * next)
	 * 
	 * 0->3->2->1->4->5->6 | | pre next
	 * 
	 * @param pre
	 * @param next
	 * @return the reversed list's last node, which is the precedence of
	 *         parameter next
	 */
	private static ListNode reverse(ListNode pre, ListNode next) {
		ListNode last = pre.next;// where first will be doomed "last"
		ListNode cur = last.next;
		while (cur != next) {
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		return last;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		int i = 0;
		while (head != null) {
			i++;
			if (i % k == 0) {
				pre = reverse(pre, head.next);
				head = pre.next;
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		ListNode x = reverseKGroup(n1, 3);
		while (x != null) {
			System.out.print(x.val + "->");
			x = x.next;
		}
	}

}
