package arrays;

/*
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?
 */
public class Sort_Colors {

	public Sort_Colors() {
		// TODO Auto-generated constructor stub
	}

	public static void sortColors(int[] A) {
		if (A == null || A.length <= 0) {
			return;
		}
		int a = 0;
		int b = 0;
		int c = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0)
				a++;
			if (A[i] == 1)
				b++;
			if (A[i] == 2)
				c++;
		}
		for (int i = 0; i < A.length; i++) {
			if (i < a)
				A[i] = 0;
			if (i >= a && i < a + b)
				A[i] = 1;
			if (i >= a + b && i < a + b + c)
				A[i] = 2;
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 0, 2, 1, 2, 0, 1, 2, 1, 1, 0, 2, 0, 2, 1 };
		sortColors(A);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

}
