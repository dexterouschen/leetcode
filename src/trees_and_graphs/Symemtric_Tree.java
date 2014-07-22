package trees_and_graphs;

import test_data_structure.TreeNode;

/*
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following is not:
 1
 / \
 2   2
 \   \
 3    3

 Note:
 Bonus points if you could solve it both recursively and iteratively.

 */

public class Symemtric_Tree {

	// A wrapper will be greatly helpful in this problem.
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetricTrees(root.left, root.right);
	}

	public static boolean isSymmetricTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if ((root1 == null && root2 != null) || (root1 != null && root2 == null) || (root1.val != root2.val)) {
			return false;
		}
		TreeNode lp1 = root1.left, rp1 = root1.right, lp2 = root2.left, rp2 = root2.right;
		return isSymmetricTrees(lp1, rp2) && isSymmetricTrees(rp1, lp2);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;

		System.out.println(isSymmetric(n1));
	}

}
