package trees_and_graphs;

import test_data_structure.Tree;
import test_data_structure.TreeNode;

/*
 Given a binary tree, find its maximum depth.
 The maximum depth is the number of nodes along the longest path from the root node
 down to the farthest leaf node.
 */

public class Max_Dept_Binary_Tree {

	public Max_Dept_Binary_Tree() {
		// TODO Auto-generated constructor stub
	}

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		int leftDep = maxDepth(root.left);
		int rightDep = maxDepth(root.right);

		return Math.max(leftDep, rightDep) + 1;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		System.out.println(maxDepth(tree.root));

	}

}
