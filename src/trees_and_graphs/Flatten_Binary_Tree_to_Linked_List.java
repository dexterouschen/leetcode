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
	/*
	 * Use preorder traversal to record all tree nodes into a list, then use
	 * this list to generate a linked-list. Notice: you may use recursion
	 * instead of pre-order traversal, but the complexity becomes O(n^2) instead
	 * of O(n).
	 */
	public static void flatten(TreeNode root) {
		if (root == null)
			return;
		ArrayList<TreeNode> list = preorderTraverse(root);
		for (int i = 0; i < list.size() - 1; i++) {
			list.get(i).left = null;
			list.get(i).right = list.get(i + 1);
		}
		list.get(list.size() - 1).left = null;
		list.get(list.size() - 1).right = null;
	}

	public static ArrayList<TreeNode> preorderTraverse(TreeNode root) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if (root == null) {
			return list;
		}
		list.add(root);
		list.addAll(preorderTraverse(root.left));
		list.addAll(preorderTraverse(root.right));
		return list;
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
