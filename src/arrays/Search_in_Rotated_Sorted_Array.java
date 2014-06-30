package arrays;

/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class Search_in_Rotated_Sorted_Array {

	public static int search(int[] A, int target) {
		int len = A.length;
		int start = 0, end = len - 1;
		if (len < 1) {
			return -1;
		}
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[mid] >= A[start]) { // left sub array must be sorted
				if (target < A[start] || target > A[mid]) {
					start = mid + 1; // search in right sub array
				} else {
					end = mid - 1; // search in left sub array
				}
			} else { // right sub array must be sorted
				if (target < A[mid] || target > A[end]) {
					end = mid - 1; // search in left sub array
				} else {
					start = mid + 1; // search in right sub array
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// int[] A = { 4, 5, 6, 0, 1, 2, 3 };
		int[] A = { 1, 3 };
		// System.out.println(findBreakPoint(A, 0, 6));
		// System.out.println(binarySearch(A, 3, 6, 2));
		System.out.println(search(A, 3));

	}

}
