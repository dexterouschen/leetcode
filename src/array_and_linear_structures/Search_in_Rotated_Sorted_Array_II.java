package array_and_linear_structures;

/*
 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */

public class Search_in_Rotated_Sorted_Array_II {
	/**
	 * Because the sorted array was rotated at an unknown pivot, it is
	 * impossible to find out where exactly is the pivot without an O(n) search.
	 * However, you can always find out that by dividing the array in half, one
	 * side must be sorted. Therefore, you can always do a binary search in the
	 * sorted half. To figure out which half is sorted, you only need to compare
	 * your A[mid] to A[start] or A[end].
	 *
	 * Here you may have duplicates. In case if A[start] == A[mid], skip
	 * duplicate one by "start++;". You may use "end--;" if you use
	 * "A[mid] >= A[end]" to find sorted half.
	 */
	public static boolean search(int[] A, int target) {
		int len = A.length;
		int start = 0, end = len - 1;
		if (len < 1) {
			return false;
		}
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target) {
				return true;
			}
			if (A[mid] > A[start]) { // left sub array must be sorted
				if (target < A[start] || target > A[mid]) {
					start = mid + 1; // search in right sub array
				} else {
					end = mid - 1; // search in left sub array
				}
			} else if (A[mid] < A[start]) { // right sub array must be sorted
				if (target < A[mid] || target > A[end]) {
					end = mid - 1; // search in left sub array
				} else {
					start = mid + 1; // search in right sub array
				}
			} else { // in case if A[start] == A[mid], skip duplicate one (here
						// is the first one considered as a duplicate). This
						// gives a worst complexity as O(N).
				start++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// int[] A = { 4, 4, 5, 6, 0, 1, 1, 2, 3, 4 };
		int[] A = { 1, 3, 1, 1, 1 };
		// System.out.println(findBreakPoint(A, 0, 6));
		// System.out.println(binarySearch(A, 3, 6, 2));
		System.out.println(search(A, 3));
	}

}
