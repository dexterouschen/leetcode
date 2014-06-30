package arrays;

/*
 Given a sorted array and a target value, return the index if the target is found.
 If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 �� 2
 [1,3,5,6], 2 �� 1
 [1,3,5,6], 7 �� 4
 [1,3,5,6], 0 �� 0
 */
public class Search_Insert_Position {

	public static int[] copyArray(int[] array, int start, int end) {
		int len = end - start + 1;
		int[] na = new int[len];
		for (int i = start; i < end + 1; i++) {
			na[i - start] = array[i];
		}
		return na;
	}

	public static int searchInsert(int[] A, int target) {
		int len = A.length;
		if (target < A[0] || len == 0) {
			return 0;
		}
		// iterative
		int i = 0;
		try {
			while (A[i] < target && i < len) {
				i++;
			}
			return i;
		} catch (ArrayIndexOutOfBoundsException e) {
			return i;
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 };
		System.out.println(searchInsert(A, 0)); // should output '0'
		System.out.println(searchInsert(A, 3)); // should output '1'
		System.out.println(searchInsert(A, 2)); // should output '1'
		System.out.println(searchInsert(A, 22)); // should output '11'
	}

}
