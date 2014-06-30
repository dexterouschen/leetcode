package arrays;

/*
 Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note:
 You may assume that A has enough space (size that is greater or equal to m + n)
 to hold additional elements from B.
 The number of elements initialized in A and B are m and n respectively.
 */

public class Merge_Sorted_Array {

	public Merge_Sorted_Array() {
		// TODO Auto-generated constructor stub
	}

	public static void merge(int A[], int m, int B[], int n) {
		int[] array = new int[m + n];
		int lp = 0;
		int rp = 0;
		int ap = 0;
		if (n == 0) {
			return;
		}
		if (m == 0 && n != 0) {
			for (int i = 0; i < n; i++) {
				A[i] = B[i];
			}
		}
		if (m == 0 && n == 0) {
			return;
		}
		while (lp < m && rp < n) {
			if (A[lp] <= B[rp]) {
				array[ap] = A[lp];
				lp++;
			} else {
				array[ap] = B[rp];
				rp++;
			}
			ap++;
		}
		if (lp == m) {
			for (int i = rp; i < n; i++) {
				array[ap] = B[i];
				ap++;
			}
		} else {
			for (int i = lp; i < m; i++) {
				array[ap] = A[i];
				ap++;
			}
		}
		for (int i = 0; i < m + n; i++) {
			A[i] = array[i];
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
