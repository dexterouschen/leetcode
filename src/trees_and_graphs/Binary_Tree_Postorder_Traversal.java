package trees_and_graphs;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

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

	public enum State {
		VISITED, UNVISITTED
	}

	public static void setVisit(Hashtable<TreeNode, State> visitTable,
			TreeNode node) {
		State state = State.VISITED;
		visitTable.put(node, state);
	}

	public static boolean isVisited(Hashtable<TreeNode, State> visitTable,
			TreeNode node) {
		if (visitTable.get(node) == State.VISITED) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Post-order traversal is the reserved version of standard DFS. Please go
	 * the dfs() at Line 67: the order in push child nodes must be changed from
	 * standard DFS
	 */
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Hashtable<TreeNode, State> visitTable = new Hashtable<TreeNode, State>();
		dfs(list, visitTable, root);
		// reverse the result from DFS to get the post-order traversal
		ArrayList<Integer> newList = new ArrayList<Integer>(list);
		int len = list.size();
		for (int i = 0; i < len; i++) {
			newList.set(i, list.get(len - i - 1));
		}
		return newList;
	}

	public static void dfs(ArrayList<Integer> list,
			Hashtable<TreeNode, State> visitTable, TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (isVisited(visitTable, node) == false) {
				setVisit(visitTable, node);
				// in standard dfs, check node.right before node.left
				// in post-order traversal, check node.left before node.right
				if (node.left != null)
					stack.push(node.left);
				if (node.right != null)
					stack.push(node.right);
			}
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		System.out.println(postorderTraversal(tree.root));
	}

}
