package trees_and_graphs;

/*
 Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */

import java.util.*;
import test_data_structure.TreeNode;

public class Unique_BST_II {
	/*
	 * Similar to "Unique_BST", we need to build a list of trees whose roots are
	 * from 1 to n. Then recursively build each root's left and right sub-trees
	 * by calling generateTrees().
	 */
	public static ArrayList<TreeNode> generateTrees(int n) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if (n <= 0) {
			list.add(null);
			return list;
		}
		for (int i = 1; i <= n; i++) {
			for (TreeNode l : generateTrees(1, i - 1)) {
				for (TreeNode r : generateTrees(i + 1, n)) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					list.add(root);
				}
			}
		}
		return list;
	}

	public static ArrayList<TreeNode> generateTrees(int start, int end) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if (start > end) {
			list.add(null);
			return list;
		}
		if (start == end) {
			list.add(new TreeNode(start));
			return list;
		}
		for (int i = start; i <= end; i++) {
			for (TreeNode l : generateTrees(start, i - 1)) {
				for (TreeNode r : generateTrees(i + 1, end)) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					list.add(root);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<TreeNode> list = generateTrees(4);
		for (TreeNode n : list) {
			System.out.println(n.val);
		}
	}

}
