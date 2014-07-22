package trees_and_graphs;

import java.util.Arrays;

import test_data_structure.TreeNode;

/*
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

public class Convert_sorted_array_to_BST {

	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		if (num.length == 1) {
			return new TreeNode(num[0]);
		}
		int mid = num.length / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, mid));
		root.right = sortedArrayToBST(Arrays.copyOfRange(num, mid + 1, num.length));
		return root;
	}

	public int[] toSubArray(int[] A, int start, int end) {
		if (A.length <= 0 || start > end) {
			return null;
		}
		int[] ans = new int[end - start + 1];
		for (int i = start; i <= end; i++) {
			ans[i - start] = A[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
