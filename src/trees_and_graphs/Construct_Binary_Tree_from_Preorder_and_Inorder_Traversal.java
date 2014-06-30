package trees_and_graphs;

/*
 Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */

import java.util.Arrays;

import test_data_structure.TreeNode;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0
				|| preorder.length != inorder.length) {
			return null;
		}
		int len = preorder.length;
		TreeNode root = new TreeNode(preorder[0]);
		// find pre[0] in inorder
		int ind = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				ind = i;
				break;
			}
		}
		int[] leftInorder = Arrays.copyOfRange(inorder, 0, ind);
		int[] rightInorder = Arrays.copyOfRange(inorder, ind + 1, len);
		int[] leftPreorder = Arrays.copyOfRange(preorder, 1, ind + 1);
		int[] rightPreorder = Arrays.copyOfRange(preorder, ind + 1, len);

		root.left = buildTree(leftPreorder, leftInorder);
		root.right = buildTree(rightPreorder, rightInorder);
		return root;
	}

	public static void main(String[] args) {
		int[] preorder = { 1, 2, 4, 5, 3, 6, 7 }, inorder = { 4, 2, 5, 1, 6, 3,
				7 };
		TreeNode root = buildTree(preorder, inorder);
		System.out.println(root.right.left.val);

		// int[] test = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// int[] a = Arrays.copyOfRange(test, 3,3);
		// for (int x : a) {
		// System.out.println(x);
		// }
	}

}
