package trees_and_graphs;

/*
 Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */

import java.util.*;

import test_data_structure.TreeNode;

public class Recover_Binary_Search_Tree {

	/**
	 * http://yucoding.blogspot.com/2013/03/leetcode-question-75-recover-binary.html
	 * 
	 * O(1) space solution, similar to a normal inorder-traversal. Now how to do
	 * this procedure in O(1)? What we need is actually two pointers, which
	 * point to 2 tree nodes where is incorrect. Therefore, we only need to
	 * store these two pointers, and, we also need another pointer to store the
	 * previous element, in order to compare if the current element is valid or
	 * not.
	 * 
	 * In the code below, you will find, the last step is to replace the wrong
	 * pair's value. And the inOrder function is to search the whole BST and
	 * find the wrong pairs.
	 * 
	 * Note that, (1)the previous element is NOT the root node of the current
	 * element, but the previous element in the "inOrder" order; (2) To store
	 * the wrong pair, the first found wrong element is stored in first pointer,
	 * while the next is stored in the second pointer.
	 */
	TreeNode prev = null;
	TreeNode p1 = null;
	TreeNode p2 = null;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraverse(root);
		int temp = p1.val;
		p1.val = p2.val;
		p2.val = temp;
	}

	public void inorderTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraverse(root.left);
		if (prev == null) { // for the 1st node in inorder-traversal
			prev = root;
		} else {
			if (prev.val >= root.val) {
				if (p1 == null) {
					p1 = prev;
				}
				p2 = root; // trick here! use this to avoid continuous wrong numbers
			}
			prev = root;
		}
		inorderTraverse(root.right);
	}

	/**
	 * O(n) space solution. It converts a tree into a list and then find out the
	 * two elements that are not in-order.
	 */
	public static void recoverTree2(TreeNode root) {
		if (root == null) {
			return;
		}
		ArrayList<TreeNode> list = toNodeArray(root);
		TreeNode[] set = new TreeNode[2];
		int count = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).val < list.get(i - 1).val && count == 0) {
				set[0] = list.get(i - 1);
				count = 1;
			}
			if (list.get(i).val < list.get(i - 1).val && count == 1) {
				set[1] = list.get(i);
			}
		}
		swapNodeNew(set[0], set[1]);
	}

	private static void swapNodeNew(TreeNode n1, TreeNode n2) {
		int t = n1.val;
		n1.val = n2.val;
		n2.val = t;
	}

	public static ArrayList<TreeNode> toNodeArray(TreeNode root) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if (root == null) {
			return list;
		}
		ArrayList<TreeNode> left = toNodeArray(root.left);
		ArrayList<TreeNode> right = toNodeArray(root.right);
		list.addAll(left);
		list.add(root);
		list.addAll(right);
		return list;
	}

	// the purpose of this method is for testing only
	public static ArrayList<Integer> toIntArray(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		ArrayList<Integer> left = toIntArray(root.left);
		ArrayList<Integer> right = toIntArray(root.right);
		list.addAll(left);
		list.add(root.val);
		list.addAll(right);
		return list;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t4.left = t2;
		t4.right = t6;
		t2.left = t1;
		t2.right = t3;
		t6.left = t7;
		t6.right = t5;

		ArrayList<Integer> list1 = toIntArray(t4);
		System.out.println("Before: " + list1);

		recoverTree2(t4);

		ArrayList<Integer> list2 = toIntArray(t4);
		System.out.println("After: " + list2);
	}

}
