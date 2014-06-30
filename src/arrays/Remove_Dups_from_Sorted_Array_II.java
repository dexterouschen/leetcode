package arrays;

/*
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array A = [1,1,1,2,2,3],

 Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class Remove_Dups_from_Sorted_Array_II {

	public static int removeDuplicates(int[] A) {
		int n = 2;
		int len = A.length;
		if (len<2) return len;
		int newLen = n, itor = n;
		while (itor < len) {
			if (A[itor] != A[newLen - 2])
				A[newLen++] = A[itor];
			itor++;
		}
		return newLen;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4 };
		System.out.println(removeDuplicates(A));
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
	}

}
