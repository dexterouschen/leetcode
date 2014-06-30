package trees_and_graphs;

import java.util.ArrayList;

import test_data_structure.ListNode;
import test_data_structure.TreeNode;

/*
 Given a singly linked list where elements are sorted in ascending order, 
 convert it to a height balanced BST.
 */

public class Convert_Sorted_List_to_BST {

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		// make a linked list into an array list
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode cur = head;
		while (cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}
		// make an array list into a BST
		int len = list.size();
		if (len == 1) {
			return new TreeNode(list.get(0));
		}
		TreeNode root = convertListToBST(list, 0, len - 1);
		return root;
	}

	public static TreeNode convertListToBST(ArrayList<Integer> list, int start,
			int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = convertListToBST(list, start, mid - 1);
		root.right = convertListToBST(list, mid + 1, end);
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
