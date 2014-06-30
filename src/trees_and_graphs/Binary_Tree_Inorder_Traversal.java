package trees_and_graphs;

import java.util.ArrayList;
import java.util.Stack;

import test_data_structure.Tree;
import test_data_structure.TreeNode;

/*
 Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Binary_Tree_Inorder_Traversal {

	public Binary_Tree_Inorder_Traversal() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeNode node = null;
		System.out.println(inorderTraversal(tree.root));
		System.out.println(inorderTraversal(node));
	}

}
