package trees_and_graphs;

import test_data_structure.TreeNode;

/*
 Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length == 0
				|| inorder.length != postorder.length) {
			return null;
		}
		// find the root
		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		// look it up in inorder list
		int indexInorder = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorder.length - 1]) {
				indexInorder = i;
			}
		}
		// divide inorder and postorder array into left and right
		int[] leftInorder = copyArray(inorder, 0, indexInorder - 1);
		int[] rightInorder = copyArray(inorder, indexInorder + 1,
				inorder.length - 1);
		int[] leftPostorder = copyArray(postorder, 0, indexInorder - 1);
		int[] rightPostorder = copyArray(postorder, indexInorder,
				postorder.length - 2);

		root.left = buildTree(leftInorder, leftPostorder);
		root.right = buildTree(rightInorder, rightPostorder);
		return root;
	}

	private static int[] copyArray(int[] inorder, int start, int end) {
		if (start > end) {
			return null;
		}
		int[] newArr = new int[end - start + 1];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = inorder[start + i];
		}
		return newArr;
	}

	public static void main(String[] args) {
		int[] inorder = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] postorder = { 1, 3, 5, 4, 2, 8, 9, 7, 6 };
		TreeNode root = buildTree(inorder, postorder);
		System.out.println(root.right.val);
	}

}
