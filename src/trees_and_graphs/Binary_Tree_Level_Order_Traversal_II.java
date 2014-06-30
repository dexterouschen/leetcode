package trees_and_graphs;

/*
 Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7]
 [9,20],
 [3],
 ]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import test_data_structure.TreeNode;

public class Binary_Tree_Level_Order_Traversal_II {

	/*
	 * Using BFS algorithm to build a list of values. The trick is to build
	 * another list simultaneously recording each node's level. In this problem,
	 * two ArrayLists and two Queues are used in implementing such an algorithm.
	 */
	public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {

		ArrayList<ArrayList<Integer>> resultLists = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> valList = new ArrayList<Integer>(); //
		ArrayList<Integer> levelList = new ArrayList<Integer>();

		if (root == null) {
			return resultLists;
		}

		bfs(root, valList, levelList);

		// Traverse levelList from tail to head
		int level = levelList.get(levelList.size() - 1);
		int index = 0;
		ArrayList<Integer> level0 = new ArrayList<Integer>();
		resultLists.add(index, level0);
		for (int i = levelList.size() - 1; i >= 0; i--) {
			if (levelList.get(i) == level) {
				resultLists.get(index).add(valList.get(i));
			} else {
				level--;
				index++;
				ArrayList<Integer> nLevel = new ArrayList<Integer>();
				resultLists.add(index, nLevel);
				resultLists.get(index).add(valList.get(i));
			}
		}
		return resultLists;
	}

	// Using BFS algorithm to update valList and levelList
	public static void bfs(TreeNode root, ArrayList<Integer> valList,
			ArrayList<Integer> levelList) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		Queue<Integer> levelQueue = new LinkedList<Integer>();

		nodeQueue.add(root);
		levelQueue.add(0);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = (TreeNode) nodeQueue.poll();
			int level = levelQueue.poll();
			valList.add(node.val);
			levelList.add(level);

			if (node.right != null) {
				nodeQueue.add(node.right);
				levelQueue.add(level + 1);
			}
			if (node.left != null) {
				nodeQueue.add(node.left);
				levelQueue.add(level + 1);
			}

		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		ArrayList<ArrayList<Integer>> lists = levelOrderBottom(t1);
		System.out.println(lists);
	}

}
