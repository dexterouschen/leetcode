package arrays;

/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class Search_in_Rotated_Sorted_Array {
	/*
	 * Because the sorted array was rotated at an unknown pivot, it is
	 * impossible to find out where exactly is the pivot without an O(n) search.
	 * However, you can always find out that by dividing the array in half, one
	 * side must be sorted. Therefore, you can always do a binary search in the
	 * sorted half. To figure out which half is sorted, you only need to compare
	 * your A[mid] to A[start] to figure out which side is sorted. Comparing
	 * A[mid] to A[end] will NOT always get your correct answer of which side is
	 * sorted. Also be careful of the equal signs: you may have a situation
	 * where you have a sorted array or sub array. In this case, "<" or ">" may
	 * not work, you need to use "<=" or ">=" instead.
	 */
	public static int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == target) {
				return mid;
			}
			// find out which side is sorted
			if (A[mid] >= A[left]) { // left side is sorted
				if (target >= A[left] && target <= A[mid]) {// must be in left
					right = mid - 1;
				} else { // target must be in right side
					left = mid + 1;
				}
			} else { // right side is sorted
				if (target >= A[mid] && target <= A[right]) {// must be in right
					left = mid + 1;
				} else { // target must be in left
					right = mid - 1;
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
