package trees_and_graphs;

import java.util.ArrayList;

import test_data_structure.TreeNode;

/*
 Given a binary tree and a sum,
 find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */

public class Path_Sum_II {

	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return lists;
		}
		dfs(lists, list, root, sum);
		return lists;
	}

	public static void dfs(ArrayList<ArrayList<Integer>> lists,
			ArrayList<Integer> list, TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		// check if it traverses to a leaf
		int curVal = root.val;
		if (root.left == null && root.right == null) {
			if (curVal == sum) {
				ArrayList<Integer> aList = new ArrayList<Integer>(list);
				aList.add(curVal);
				lists.add(aList);
			}
			return;
		}
		// else it must have a child
		int curSum = sum - curVal;
		list.add(curVal);
		if (root.left != null) {
			ArrayList<Integer> leftList = new ArrayList<Integer>(list);
			dfs(lists, leftList, root.left, curSum);
		}
		if (root.right != null) {
			ArrayList<Integer> rightList = new ArrayList<Integer>(list);
			dfs(lists, rightList, root.right, curSum);
		}
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(5);
		TreeNode n10 = new TreeNode(1);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n3.right = n6;
		n4.left = n7;
		n4.right = n8;
		n6.left = n9;
		n6.right = n10;

		System.out.println(pathSum(n1, 22));
	}

}
