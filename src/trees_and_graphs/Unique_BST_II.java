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

import java.util.ArrayList;
import test_data_structure.TreeNode;

public class Unique_BST_II {

	public static ArrayList<TreeNode> generateTrees(int n) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if (n <= 0) {
			list.add(null);
			return list;
		}
		for (int i = 1; i <= n; i++) {
			ArrayList<TreeNode> lList = makeTreeNode(1, i - 1);
			ArrayList<TreeNode> rList = makeTreeNode(i + 1, n);
			for (int x = 0; x < lList.size(); x++) {
				for (int y = 0; y < rList.size(); y++) {
					TreeNode root = new TreeNode(i);
					root.left = lList.get(x);
					root.right = rList.get(y);
					list.add(root);
				}
			}
		}
		return list;
	}

	public static ArrayList<TreeNode> makeTreeNode(int start, int end) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if (start > end) {
			list.add(null);
			return list;
		}
		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> lList = makeTreeNode(start, i - 1);
			ArrayList<TreeNode> rList = makeTreeNode(i + 1, end);
			for (int x = 0; x < lList.size(); x++) {
				for (int y = 0; y < rList.size(); y++) {
					TreeNode root = new TreeNode(i);
					root.left = lList.get(x);
					root.right = rList.get(y);
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
