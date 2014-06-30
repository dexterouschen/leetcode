package trees_and_graphs;

/*
 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */

import java.util.ArrayList;

import test_data_structure.Tree;
import test_data_structure.TreeNode;

public class Flatten_Binary_Tree_to_Linked_List {

	public static void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		poTraverse(root, list);
		for (int i = 0; i < list.size() - 1; i++) {
			// remember to set all tree nodes' left to null
			list.get(i).left = null;
			list.get(i).right = list.get(i + 1);
		}
	}

	public static void poTraverse(TreeNode root, ArrayList<TreeNode> list) {
		if (root.left == null && root.right == null) {
			list.add(root);
			return;
		}
		list.add(root);
		if (root.left != null) {
			poTraverse(root.left, list);
		}
		if (root.right != null) {
			poTraverse(root.right, list);
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		flatten(tree.root);
		TreeNode cur = tree.root;
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.right;
		}
	}

}
