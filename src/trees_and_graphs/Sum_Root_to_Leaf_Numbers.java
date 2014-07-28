package trees_and_graphs;

import test_data_structure.Tree;
import test_data_structure.TreeNode;

import java.util.*;

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
	 * Using deep search algorithm to find out all the paths from leaf to root.
	 * Then convert the path into values and sum them up.
	 */
	public static int sum = 0;

	public static int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		ArrayList<Integer> list = new ArrayList<>();
		deepSearch(root, list);
		return sum;
	}

	public static void deepSearch(TreeNode root, ArrayList<Integer> list) {
		if (root.left == null && root.right == null) {
			ArrayList<Integer> nlist = new ArrayList<Integer>(list);
			nlist.add(root.val);
			int x = toInt(nlist);
			sum += x;
			return;
		}
		if (root.left != null) {
			ArrayList<Integer> nlist = new ArrayList<Integer>(list);
			nlist.add(root.val);
			deepSearch(root.left, nlist);
		}
		if (root.right != null) {
			ArrayList<Integer> nlist = new ArrayList<Integer>(list);
			nlist.add(root.val);
			deepSearch(root.right, nlist);
		}
	}

	private static int toInt(ArrayList<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
			sum += Math.pow(10, i) * list.get(i);
		return sum;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;
		// System.out.println(sumNumbers(n1)); // should be 1
		System.out.println(sumNumbers(tree.root)); // should be 1776
	}

}
