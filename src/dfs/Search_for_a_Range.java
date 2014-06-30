package dfs;

/*
 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */

public class Search_for_a_Range {
	public static int start = Integer.MAX_VALUE;
	public static int end = Integer.MIN_VALUE;

	public static int[] searchRange(int[] A, int target) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		if (A == null || A.length == 0 || target < A[0]
				|| target > A[A.length - 1]) {
			return result;
		}
		int head = 0, tail = A.length - 1;
		search(A, target, head, tail);
		if (start == Integer.MAX_VALUE) {
			return result;
		}
		result[0] = start;
		result[1] = end;
		return result;
	}

	public static void search(int[] A, int target, int head, int tail) {
		if (head > tail) {
			return;
		} else {
			int mid = (head + tail) / 2;
			if (A[mid] == target) {
				if (mid > end)
					end = mid;
				if (mid < start)
					start = mid;
				search(A, target, head, mid - 1);
				search(A, target, mid + 1, tail);
			} else if (A[mid] < target) {
				search(A, target, mid + 1, tail);
			} else {
				search(A, target, head, mid - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 5 };
		int target = 4;
		System.out.println(searchRange(A, target)[0] + " "
				+ searchRange(A, target)[1]);
	}

}
