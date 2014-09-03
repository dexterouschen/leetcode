package array_and_linear_structures;

/*
 Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note:
 You may assume that A has enough space (size that is greater or equal to m + n)
 to hold additional elements from B.
 The number of elements initialized in A and B are m and n respectively.
 */

public class Merge_Sorted_Array {

	/**
	 * Use two pointers 'ia', 'ib' to merge two arrays from end to beginning.
	 */
	public static void merge(int A[], int m, int B[], int n) {
		int ia = m - 1, ib = n - 1;
		while (ia >= 0 && ib >= 0) {
			if (B[ib] > A[ia]) {
				A[ia + ib + 1] = B[ib];
				ib--;
			} else {
				A[ia + ib + 1] = A[ia];
				ia--;
			}
		}
		if (ia < 0) {
			for (int i = ib; i >= 0; i--) {
				A[i] = B[i];
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 5, 7, 9, -1, -1, -1, -1, -1 };
		int[] B = { 2, 4, 6, 8, -1 };
		merge(A, 5, B, 4);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

}
