package trees_and_graphs;

import test_data_structure.Tree;
import test_data_structure.TreeNode;
import java.util.ArrayList;

/*
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */

public class Sum_Root_to_Leaf_Numbers {
	/*
	 * Using DFS algorithm to find out all the paths from leaf to root. Then
	 * convert the path into values and sum them up.
	 */
	public static int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		ArrayList<ArrayList<TreeNode>> lists = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		dfs(lists, list, root);
		// // for check purposes
		// for (ArrayList<TreeNode> a : lists) {
		// for (TreeNode t : a) {
		// System.out.println(t.val);
		// }
		// System.out.println("   ");
		// }
		int sum = toSum(lists);
		return sum;
	}

	public static void dfs(ArrayList<ArrayList<TreeNode>> lists,
			ArrayList<TreeNode> list, TreeNode root) {
		if (root.left == null && root.right == null) {
			list.add(root);
			lists.add(new ArrayList<TreeNode>(list));
			return;
		}
		list.add(root);
		if (root.left != null) {
			ArrayList<TreeNode> l = new ArrayList<TreeNode>(list);
			dfs(lists, l, root.left);
		}
		if (root.right != null) {
			ArrayList<TreeNode> r = new ArrayList<TreeNode>(list);
			dfs(lists, r, root.right);
		}
	}

	public static int toSum(ArrayList<ArrayList<TreeNode>> lists) {
		int sum = 0;
		for (ArrayList<TreeNode> a : lists) {
			int subSum = 0;
			for (TreeNode t : a) {
				subSum += t.val * Math.pow(10, a.size() - 1 - a.indexOf(t));
			}
			sum += subSum;
		}
		return sum;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;
		System.out.println(sumNumbers(n1)); // should be 1
		 System.out.println(sumNumbers(tree.root)); // should be 1776
	}

}
