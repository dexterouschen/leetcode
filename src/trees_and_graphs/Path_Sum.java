package trees_and_graphs;

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

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) { // check at a leaf node
			if (root.val != sum) {
				return false;
			} else {
				return true;
			}
		}

		sum -= root.val;
		boolean result = false;
		if (root.left != null) {
			result = result || hasPathSum(root.left, sum);
		}
		if (root.right != null) {
			result = result || hasPathSum(root.right, sum);
		}
		return result;
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
