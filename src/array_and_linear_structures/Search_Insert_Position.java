package array_and_linear_structures;

/*
 Given a sorted array and a target value, return the index if the target is found.
 If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 -> 2
 [1,3,5,6], 2 -> 1
 [1,3,5,6], 7 -> 4
 [1,3,5,6], 0 -> 0
 */
public class Search_Insert_Position {
	/**
	 * O(logn) complexity: divide and conquer. Be careful with the boundaries
	 * when divide into sub-problems.
	 */
	public static int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int left = 0, right = A.length - 1;
		if (target > A[A.length - 1])
			return A.length;
		if (target < A[0])
			return 0;
		while (left < right) {
			if (right == left + 1) {
				return A[left] == target ? left : right;
			}
			int mid = (left + right) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (target < A[mid]) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right;
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 5, 7, 9, 11, 15, 17, 19, 21 };
		System.out.println(searchInsert(A, 0)); // should output '0'
		System.out.println(searchInsert(A, 3)); // should output '1'
		System.out.println(searchInsert(A, 2)); // should output '1'
		System.out.println(searchInsert(A, 16)); // should output '7'
		System.out.println(searchInsert(A, 22)); // should output '10'
	}

}
