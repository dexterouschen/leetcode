package recursion;

/*
 Write an efficient algorithm that searches for a value in an m x n matrix. 
 This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */

public class Search_2D_Matrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}

		int row = matrix.length, col = matrix[0].length;
		// locate target into a row
		int start = 0, end = row - 1;
		int rowPos = getRow(matrix, target, start, end);
		if (rowPos == -2) {
			return true;
		}
		boolean ans = findInRow(matrix[rowPos], target, 0, col - 1);
		return ans;
	}

	private static boolean findInRow(int[] array, int target, int start, int end) {
		int len = array.length;
		if (start < 0 || end >= len || start > end) {
			return false;
		}
		if (start == end) {
			if (target == array[start]) {
				return true;
			} else {
				return false;
			}
		}
		int mid = (start + end) / 2;
		if (array[mid] == target) {
			return true;
		} else {
			if (target < array[mid]) {
				return findInRow(array, target, start, mid - 1);
			} else {
				return findInRow(array, target, mid + 1, end);
			}
		}

	}

	public static int getRow(int[][] matrix, int target, int start, int end) {
		int row = matrix.length;
		int ans = 0;
		if (start < 0) {
			return 0;
		}
		if (end >= row) {
			return end;
		}
		if (start > end) {
			return start;
		}
		int mid = (start + end) / 2;
		if (matrix[mid][0] == target) {
			return -2; // find the result
		}

		if (mid == end) {
			return end;
		} else {
			if (target > matrix[mid][0] && target < matrix[mid + 1][0]) {
				return mid;
			} else if (target < matrix[mid][0]) {
				ans = getRow(matrix, target, 0, mid - 1);
			} else {
				ans = getRow(matrix, target, mid + 1, end);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		// System.out.println(getRow(matrix, 13, 0, 2));
		System.out.println(findInRow(matrix[1], 13, 0, 3));
		// System.out.println(searchMatrix(matrix, 13));
	}

}
