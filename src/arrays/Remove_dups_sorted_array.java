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
		if (A == null || A.length == 0)
			return 0;
		int count = 0, mark = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] == mark) {
				count++;
			} else {
				A[i - count] = A[i];
				mark = A[i];
			}
		}
		return A.length - count;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 2, 2, 3, 4, 5, 5, 6, 7, 7, 7, 8 };
		int n = removeDuplicates(A);
		System.out.println("Number of duplicates: " + n);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
}
