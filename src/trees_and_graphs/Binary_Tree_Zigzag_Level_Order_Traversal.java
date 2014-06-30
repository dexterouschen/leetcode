package trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import test_data_structure.TreeNode;

/*
 Given a binary tree, return the zigzag level order traversal of its nodes' values.
 (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 */

public class Binary_Tree_Zigzag_Level_Order_Traversal {

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return lists;
		}
		ArrayList<Integer> vList = new ArrayList<Integer>();
		ArrayList<Integer> lList = new ArrayList<Integer>();
		Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
		Queue<Integer> levelQ = new LinkedList<Integer>();
		int level = 0;
		nodeQ.add(root);
		levelQ.add(level);
		while (!nodeQ.isEmpty()) {
			TreeNode node = nodeQ.poll();
			vList.add(node.val);
			int curLevel = levelQ.poll();
			lList.add(curLevel);
			if (node.left != null) {
				nodeQ.add(node.left);
				levelQ.add(curLevel + 1);
			}
			if (node.right != null) {
				nodeQ.add(node.right);
				levelQ.add(curLevel + 1);
			}
		}
		// System.out.println(vList);
		// System.out.println(lList);
		mergeLists(lists, vList, lList);
		return lists;
	}

	private static void mergeLists(ArrayList<ArrayList<Integer>> lists,
			ArrayList<Integer> vList, ArrayList<Integer> lList) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		int level = 0;
		for (int i = 0; i < vList.size(); i++) {
			if (lList.get(i) == level) {
				myList.add(vList.get(i));
			} else {
				lists.add(myList);
				myList = new ArrayList<Integer>();
				myList.add(vList.get(i));
				level++;
			}
		}
		if (!myList.isEmpty()) {
			lists.add(myList);
		}
		int odd = 1;
		while (odd < lists.size()) {
			ArrayList<Integer> original = lists.get(odd), reverse = new ArrayList<Integer>();
			int len = original.size();
			for (int i = len - 1; i >= 0; i--) {
				reverse.add(original.get(i));
			}
			lists.set(odd, reverse);
			odd += 2;
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
		ArrayList<ArrayList<Integer>> lists = zigzagLevelOrder(t1);
		System.out.println(lists);
	}

}
