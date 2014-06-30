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

	public Symemtric_Tree() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		if (root.left != null && root.right != null) {
			TreeNode lp = root.left;
			TreeNode rp = root.right;
			if (lp.val == rp.val) {
				return compareSubTree(lp, rp);
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean compareSubTree(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null) {
			return true;
		}
		if ((r1 == null && r2 != null) || (r1 != null && r2 == null)) {
			return false;
		}
		if (r1.val != r2.val) {
			return false;
		}
		boolean ans1 = compareSubTree(r1.left, r2.right);
		boolean ans2 = compareSubTree(r1.right, r2.left);
		return ans1 && ans2;
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
