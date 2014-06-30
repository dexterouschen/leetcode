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

	public static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		traverse(list, root.left);
		list.add(root.val);
		traverse(list, root.right);
		int min = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= min) {
				return false;
			}
			min = list.get(i);
		}
		return true;
	}

	private static void traverse(ArrayList<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		traverse(list, root.left);
		list.add(root.val);
		traverse(list, root.right);
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		System.out.println(isValidBST(tree.root));

	}
}
