package trees_and_graphs;

import test_data_structure.Tree;
import test_data_structure.TreeNode;

/*
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which
 the depth of the two subtrees of every node never differ by more than 1.
 */
public class Balanced_Binary_Tree {

	public Balanced_Binary_Tree() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int h = 1;
		h += Math.max(getHeight(root.left), getHeight(root.right));
		return h;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		// System.out.println(getHeight(tree.root));
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.right = t5;
		t4.left = t6;
		t5.right = t7;

		System.out.println(isBalanced(tree.root));
		System.out.println(isBalanced(t1));
	}

}
