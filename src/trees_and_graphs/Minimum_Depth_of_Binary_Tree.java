package trees_and_graphs;

/*
 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node
 down to the nearest leaf node.
 */

import test_data_structure.Tree;
import test_data_structure.TreeNode;

public class Minimum_Depth_of_Binary_Tree {
	/*
	 * A normal recursion problem. Be careful of the conditions where a node has
	 * just one child.
	 */
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		System.out.println(minDepth(tree.root)); // should be 3
		System.out.println(minDepth(n1)); // should be 2
	}

}
