package array_and_linear_structures;

/*
 There are two sorted arrays A and B of size m and n respectively. 
 Find the median of the two sorted arrays. 
 The overall run time complexity should be O(log (m+n)).
 */

import java.util.*;

public class Median_of_Two_Sorted_Arrays {

	/**
	 * FORGET WHATEVER I WROTE DOWN HERE!!!
	 * WILL COME BACK AND WORK ON THEM LATER! 
	 */
	public static double findMedianSortedArrays(int[] A, int[] B) {
		if (A == null || A.length == 0) {
			return B == null || B.length == 0 ? 0
					: (B.length % 2 == 0 ? ((double) (B[B.length / 2] + B[(B.length / 2) - 1])) / 2
							: (double) B[B.length / 2]);
		}
		if (B == null || B.length == 0) {
			return B == null || B.length == 0 ? 0
					: (A.length % 2 == 0 ? ((double) (A[A.length / 2] + A[(A.length / 2) - 1])) / 2
							: (double) A[A.length / 2]);
		}
		if (A.length == 1 && B.length == 1) { // base case 1
			return (double) (A[0] + B[0]) / 2;
		}
		if (A.length == 2 && B.length == 1) { // base case 2
			return B[0] >= A[1] ? A[1] : (B[0] >= A[0] ? B[0] : A[0]);
		}
		if (A.length == 1 && B.length == 2) { // base case 3
			return A[0] >= B[1] ? B[1] : (A[0] >= B[0] ? A[0] : B[0]);
		}
		if (A.length == 2 && B.length == 2) { // base case 4
			return (Math.max(A[0], B[0]) + Math.min(A[1], B[1])) / (double) 2;
		}
		return findMedian(A, 0, A.length - 1, B, 0, B.length - 1);
	}

	public static double findMedian(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd) {
		if (aStart > aEnd && bStart <= bEnd) {
			return (bEnd - bStart) % 2 == 0 ? (B[(bEnd + bStart) / 2] + B[(bEnd + bStart) / 2 + 1]) / 2
					: B[(bEnd + bStart) / 2];
		}
		if (bStart > bEnd && aStart <= aEnd) {
			return (aEnd - aStart) % 2 == 0 ? (A[(aEnd + aStart) / 2] + A[(aEnd + aStart) / 2 + 1]) / 2
					: A[(aEnd + aStart) / 2];
		}
		if (aEnd == aStart && bEnd == bStart) { // base case 1
			return (A[aEnd] + B[bEnd]) / 2;
		}
		if (aEnd == aStart && bEnd == bStart + 1) { // base case 2
			return A[aEnd] <= B[bStart] ? B[bStart] : A[aEnd] <= B[bEnd] ? A[aEnd] : B[bEnd];
		}
		if (aEnd == aStart + 1 && bEnd == bStart) { // base case 3
			return B[bEnd] <= A[aStart] ? A[aStart] : B[bEnd] <= A[aEnd] ? B[bEnd] : A[aEnd];
		}
		if (aEnd == aStart + 1 && bEnd == bStart + 1) { // base case 4
			return (Math.max(A[aStart], B[bStart]) + Math.min(A[aEnd], B[bEnd])) / 2.0;
		}
		double midA = aEnd == aStart ? A[aEnd]
				: (aEnd - aStart) % 2 == 0 ? (A[(aEnd + aStart) / 2] + A[(aEnd + aStart) / 2 + 1]) / 2
						: A[(aEnd + aStart) / 2];
		double midB = bEnd == bStart ? B[bEnd]
				: (bEnd - bStart) % 2 == 0 ? (B[(bEnd + bStart) / 2] + B[(bEnd + bStart) / 2 + 1]) / 2
						: B[(bEnd + bStart) / 2];
		if (Double.compare(midA, midB) == 0) {
			return midA;
		}
		int move = (aEnd - aStart + 1) / 2 > (bEnd - bStart + 1) / 2 ? (bEnd - bStart + 1) / 2
				: (aEnd - aStart + 1) / 2;
		move = move > 1 ? move : 1;
		if (Double.compare(midA, midB) < 0) { // midA < midB
			return findMedian(A, aStart + move, aEnd, B, bStart, bEnd - move);
		} else {
			return findMedian(A, aStart, aEnd - move, B, bStart + move, bEnd);
		}
	}

	/**
	 * (1) Find the median of A and B respectively;
	 * (2) We know that the global median must be between: 
	 *       A.subarray[A(mid), B(mid)] + B.subarray[A(mid), B(mid)], excluding A(mid) and B(mid);
	 * (3) Copy the elements into a new array, find it's median. This value should be the global median.
	 */

	public double findMedianSortedArrays2(int A[], int B[]) {
		int k = A.length + B.length;
		return k % 2 == 0 ? (findK(A, 0, A.length - 1, B, 0, B.length - 1, k / 2 + 1) + findK(A, 0,
				A.length - 1, B, 0, B.length - 1, k / 2)) / 2 : findK(A, 0, A.length - 1, B, 0,
				B.length - 1, k / 2 + 1);
	}

	// 返回两个数组中第k大的元素。
	public double findK(int a[], int s1, int e1, int b[], int s2, int e2, int k) {
		int m = e1 - s1 + 1;
		int n = e2 - s2 + 1;
		if (m > n)
			return findK(b, s2, e2, a, s1, e1, k); // a的长度比b的小。
		if (s1 > e1)
			return b[s2 + k - 1];
		if (s2 > e2)
			return a[s1 + k - 1];
		if (k == 1)
			return Math.min(a[s1], b[s2]);
		int midA = Math.min(k / 2, m), midB = k - midA;
		// 如果a的第midA大的元素比b的第midB大的元素小，
		// 那么删掉a的前midA个元素，在剩余的数中找第k-midA大的。
		if (a[s1 + midA - 1] < b[s2 + midB - 1])
			return findK(a, s1 + midA, e1, b, s2, e2, k - midA);
		else if (a[s1 + midA - 1] > b[s2 + midB - 1])
			return findK(a, s1, e1, b, s2 + midB, e2, k - midB);
		else
			return a[s1 + midA - 1];
	}

	public static void main(String[] args) {
		// int[] A = { 1, 3, 4, 15, 26, 37 };
		// int[] B = { 2, 4, 7, 8, 10, 12, 15, 23 };
		int[] A = { 2 };
		int[] B = { 1, 3, 4 };
		System.out.println(findMedianSortedArrays(A, B));
	}

}
