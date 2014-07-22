package trees_and_graphs;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

import test_data_structure.Tree;
import test_data_structure.TreeNode;

/*
 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?
 */

public class Binary_Tree_Preorder_Traversal {

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		list.add(root.val);
		list.addAll(preorderTraversal(root.left));
		list.addAll(preorderTraversal(root.right));
		return list;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		System.out.println(preorderTraversal(tree.root));
	}
}
