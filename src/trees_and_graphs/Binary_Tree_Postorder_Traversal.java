package trees_and_graphs;

import java.util.*;

import test_data_structure.Tree;
import test_data_structure.TreeNode;

/*
 Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Binary_Tree_Postorder_Traversal {
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		list.addAll(postorderTraversal(root.left));
		list.addAll(postorderTraversal(root.right));
		list.add(root.val);
		return list;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		System.out.println(postorderTraversal(tree.root));
	}

}
