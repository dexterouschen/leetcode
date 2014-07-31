package trees_and_graphs;

import java.util.*;
import test_data_structure.TreeNode;

/*
 Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	/*
	 * Three fundamental types of tree traversal can be illustrated better with
	 * visual aid from wikipedia: http://en.wikipedia.org/wiki/Tree_traversal
	 */
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length == 0 || postorder.length <= 0
				|| inorder.length != postorder.length) {
			return null;
		}
		int len = postorder.length;
		TreeNode root = new TreeNode(postorder[len - 1]);
		if (len == 1) {
			return root;
		}
		// find root in inorder array
		int rootIndex = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorder.length - 1]) {
				rootIndex = i;
			}
		}
		// build sub-arrays
		int[] leftInorder = 0 < rootIndex ? Arrays.copyOfRange(inorder, 0, rootIndex) : null;
		int[] leftPostorder = 0 < rootIndex ? Arrays.copyOfRange(postorder, 0, rootIndex) : null;
		int[] rightInorder = rootIndex + 1 < len ? Arrays.copyOfRange(inorder, rootIndex + 1, len)
				: null;
		int[] rightPostorder = rootIndex < len - 1 ? Arrays.copyOfRange(postorder, rootIndex,
				len - 1) : null;
		// recursion
		root.left = buildTree(leftInorder, leftPostorder);
		root.right = buildTree(rightInorder, rightPostorder);
		return root;
	}

	public static void main(String[] args) {
		int[] inorder = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] postorder = { 1, 3, 5, 4, 2, 8, 9, 7, 6 };
		TreeNode root = buildTree(inorder, postorder);
		System.out.println(root.right.val);
	}

}
