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

	/*
	 * Use two pointers for 0s and 2s. For detailed operations please see below.
	 */
	public static void sortColors(int[] A) {
		int p0 = 0, p2 = A.length - 1;
		int i = 0;
		while (i <= p2) {
			if (A[i] == 0) {
				swap(A, i, p0);
				p0++;
				i++;
				continue;
			} else if (A[i] == 2) {
				swap(A, i, p2);
				p2--;
				continue;
			}
			i++;
		}
	}

	public static void swap(int[] num, int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}

	public static void main(String[] args) {
		int[] A = { 1, 0, 2, 1, 2, 0, 1, 2, 1, 1, 0, 2, 0, 2, 1 };
		sortColors(A);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

}
