package recursion;

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

	/*
	 * Recursively dive into children of root until it finds a leaf. Similar to
	 * a normal deep-search algorithm.
	 */
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		if (root == null) {
			return lists;
		}
		ArrayList<Integer> list = new ArrayList<>();
		deepSearch(lists, list, root, sum);
		return lists;
	}

	public static void deepSearch(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list,
			TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			ArrayList<Integer> nlist = new ArrayList<Integer>(list);
			nlist.add(root.val);
			lists.add(nlist);
			return;
		}
		int remain = sum - root.val;
		if (root.left != null) {
			ArrayList<Integer> nlist = new ArrayList<Integer>(list);
			nlist.add(root.val);
			deepSearch(lists, nlist, root.left, remain);
		}
		if (root.right != null) {
			ArrayList<Integer> nlist = new ArrayList<Integer>(list);
			nlist.add(root.val);
			deepSearch(lists, nlist, root.right, remain);
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
