package trees_and_graphs;

import test_data_structure.TreeNode;

/*
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

public class Convert_sorted_array_to_BST {

	public Convert_sorted_array_to_BST() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null) {
			return null;
		}
		int len = num.length;
		if (len == 0) {
			return null;
		}
		if (len == 1) {
			return new TreeNode(num[0]);
		}
		int mid = (int) len / 2;
		TreeNode root = new TreeNode(num[mid]);
		int[] left = toSubArray(num, 0, mid - 1);
		int[] right = toSubArray(num, mid + 1, len - 1);
		root.left = sortedArrayToBST(left);
		root.right = sortedArrayToBST(right);
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
