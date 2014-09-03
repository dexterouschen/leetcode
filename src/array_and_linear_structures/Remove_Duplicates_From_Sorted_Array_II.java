package array_and_linear_structures;

/*
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array A = [1,1,1,2,2,3],

 Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class Remove_Duplicates_From_Sorted_Array_II {
	/**
	 * Similar to Remove Duplicates from Sorted Array. Use an additional counter
	 * to record how many duplicates have appeared.
	 */
	public static int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int count = 0, repeat = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1]) {
				repeat++;
				if (repeat >= 2) {
					count++;
				}
			} else {
				repeat = 0;
			}
			A[i - count] = A[i];
		}
		return A.length - count;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4 };
		System.out.println(removeDuplicates(A));
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
	}

}
