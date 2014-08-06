package recursion;

import test_data_structure.Tree;
import test_data_structure.TreeNode;

/*
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class Path_Sum {
	/**
	 * Use recursive call to traverse through its left and right sub-trees to
	 * find out if there is a valid path.
	 */
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null || (root.left == null && root.right == null && sum != root.val)) {
			return false;
		}
		if (root.left == null && root.right == null && sum == root.val) {
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		System.out.println(hasPathSum(tree.root, 15)); // should return true
		System.out.println(hasPathSum(tree.root, 9)); // should return true
		System.out.println(hasPathSum(tree.root, 8)); // should return false
		System.out.println(hasPathSum(tree.root, 3)); // should return false
		System.out.println(hasPathSum(tree.root, 25)); // should return true
	}

}
