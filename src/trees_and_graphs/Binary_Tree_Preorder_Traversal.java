package trees_and_graphs;

import java.util.ArrayList;
import java.util.Hashtable;
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
	private static Hashtable<TreeNode, State> visitTable = new Hashtable<TreeNode, State>();

	public enum State {
		VISITED, UNVISITTED
	}

	public static void setVisit(TreeNode node) {
		State state = State.VISITED;
		visitTable.put(node, state);
	}

	public static boolean isVisited(TreeNode node) {
		if (visitTable.get(node) == State.VISITED) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * DFS algorithm
	 */
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (isVisited(node) == false) {
				setVisit(node);
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		System.out.println(preorderTraversal(tree.root));
	}
}
