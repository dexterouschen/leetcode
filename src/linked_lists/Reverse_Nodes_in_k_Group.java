package linked_lists;

import java.util.Stack;

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

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode trav = head;
		Stack<ListNode> stack = new Stack<ListNode>();
		stack.add(trav);
		int count = 1;
		while (trav != null && count < k) {
			trav = trav.next;
			stack.add(trav);
			count++;
		} // now trav is at the last element of the reverse list
//		System.out.println(trav + "   " + count);
		if (trav == null) {
			if (count <= k) {
				return head;
			} else {
				return null;
			}
		}
		ListNode remain = trav.next; // get the remain list
		ListNode reverse = stack.pop(); // get the reverse list
		ListNode nhead = reverse;
		while (!stack.isEmpty()) {
			reverse.next = stack.pop();
			reverse = reverse.next;
		}
		reverse.next = reverseKGroup(remain, k);
		return nhead;
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

		ListNode x = n1;
		while (x != null) {
			System.out.print(x.val + "->");
			x = x.next;
		}
		System.out.println("\nAfter reverse: ");
		ListNode y = reverseKGroup(n1, 3);
		while (y != null) {
			System.out.print(y.val + "->");
			y = y.next;
		}
	}

}
