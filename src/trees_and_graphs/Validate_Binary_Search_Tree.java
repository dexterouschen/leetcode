package trees_and_graphs;

import java.util.ArrayList;

import test_data_structure.Tree;
import test_data_structure.TreeNode;

/*
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */

public class Validate_Binary_Search_Tree {
	/*
	 * Solution 1: use in-order traversal to print all tree nodes into a list.
	 * Then check if the list is sorted.
	 */
	public static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		ArrayList<Integer> list = toList(root);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Integer> toList(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		list.addAll(toList(root.left));
		list.add(root.val);
		list.addAll(toList(root.right));
		return list;
	}

	/*
	 * Solution 2: "min/max" approach. Starting at root, dynamically update
	 * {min, max} values for each node. For left child, update its max value as
	 * root.val; for right child, update its min value as root.val.
	 */
	public boolean isValidBST2(TreeNode root) {
		if (root == null) {
			return true;
		}
		int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}

	public boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.val >= max || root.val <= min) {
			return false;
		}
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}

	// main
	public static void main(String[] args) {
		Tree tree = new Tree();
		System.out.println(isValidBST(tree.root));

	}
}
