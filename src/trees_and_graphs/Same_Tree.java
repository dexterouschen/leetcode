package trees_and_graphs;

import test_data_structure.Tree;
import test_data_structure.TreeNode;

/*
 Given two binary trees, write a function to check if they are equal or not.
 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */

public class Same_Tree {

	public Same_Tree() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if ((p == null && q != null) || (p != null && q == null))
			return false;
		if (p == null && q == null)
			return true;
		if (p.val != q.val)
			return false;

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		Tree tree1 = new Tree();
		Tree tree2 = new Tree();
		Tree tree3 = new Tree();
		tree3.root.left = tree2.root;
		tree3.root.right = null;

		System.out.println(isSameTree(tree1.root, tree3.root));
	}
}
