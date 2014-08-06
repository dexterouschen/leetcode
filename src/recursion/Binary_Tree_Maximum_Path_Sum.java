package recursion;

import test_data_structure.*;

/*
 Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.
 */

public class Binary_Tree_Maximum_Path_Sum {
	/**
	 * This Problem can be divided into two conditions: at each node in this
	 * tree, the largest sum path can only be (1) this node itself, (2) this
	 * node plus one path on its left and one path on its right. So each time
	 * when visiting a node, record (1) and (2) and update them comparing to
	 * global maximum value. Then pass node.val + Math.max(left_path,
	 * right_path).
	 */
	public static int max;

	public static int maxPathSum(TreeNode root) {
		max = (root == null) ? 0 : root.val;
		findMax(root);
		return max;
	}

	public static int findMax(TreeNode node) {
		if (node == null)
			return 0;
		// recursively get sum of left and right path
		int leftMax = Math.max(findMax(node.left), 0);
		int rightMax = Math.max(findMax(node.right), 0);
		// update maximum here
		max = Math.max(node.val + leftMax + rightMax, max);
		// return sum of largest path of current node
		return node.val + Math.max(leftMax, rightMax);
	}

	public static void main(String[] args) {
		Tree t1 = new Tree();
		System.out.println(maxPathSum(t1.root)); // should be 22
	}

}
