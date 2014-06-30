package arrays;

/*
 Given a sorted array, remove the duplicates in place such that each element
 appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].
 */
public class Remove_dups_sorted_array {

	public static int removeDuplicates(int[] A) {
		int len = A.length;
		if (len <= 1) {
			return len;
		}
		int count = 0;
		for (int i = 0; i < len - 1; i++) {
			if (A[i] == A[i + 1]) {
				count++;
			} else {
				A[i - count] = A[i];
			}
		}
		// take care of the tail elements
		if (A[len - 1] != A[len - 2]) {
			A[len - count - 1] = A[len - 1];
		}
		return count;
	}

	public static void main(String[] args) {
//		int[] A = { 1, 2, 2, 2, 3, 4, 5, 5, 6, 7, 7, 7, 8 };
		int[] A = { 1, 2 };
		int n = removeDuplicates(A);
		System.out.println("Number of duplicates: " + n);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
}
