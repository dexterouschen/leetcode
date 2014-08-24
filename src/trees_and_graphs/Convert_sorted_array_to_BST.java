package trees_and_graphs;

import java.util.Arrays;

import test_data_structure.TreeNode;

/*
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

public class Convert_sorted_array_to_BST {
	/**
	 * Recursive approach: find the mid point of the array and take it as the
	 * root. Then recursively call sortedArrayBST() to generate its left and
	 * right subtree.
	 */
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		int mid = num.length / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, mid));
		root.right = sortedArrayToBST(Arrays.copyOfRange(num, mid + 1, num.length));
		return root;
	}

	public static void main(String[] args) {
	}

}
