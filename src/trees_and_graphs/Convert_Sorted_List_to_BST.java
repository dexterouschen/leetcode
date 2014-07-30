package trees_and_graphs;

import test_data_structure.ListNode;
import test_data_structure.TreeNode;

/*
 Given a singly linked list where elements are sorted in ascending order, 
 convert it to a height balanced BST.
 */

public class Convert_Sorted_List_to_BST {

	/*
	 * Since a list is used in this problem, O(1) access for each element is no
	 * longer available. To solve it, we need to find out the middle element of
	 * the list, and then recursively generate left tree and right tree for
	 * [start to mid - 1] and [mid + 1 to end]. To find out a middle element for
	 * each recursion, we can use two runners (fast and slow) to figure out
	 * where the middle position is.
	 */
	public static TreeNode sortedListToBST(ListNode head) {
		return recursion(head, null);
	}

	public static TreeNode recursion(ListNode start, ListNode end) {
		if (start == end) {
			return null;
		}
		ListNode p = start, q = start;
		while (q != end && q.next != end) { // to find out middle position
			p = p.next;
			q = q.next.next;
		}
		TreeNode root = new TreeNode(p.val);
		root.left = recursion(start, p);
		root.right = recursion(p.next, end);
		return root;
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

		TreeNode root = sortedListToBST(n1);
		System.out.println(root.left.val);
	}

}
