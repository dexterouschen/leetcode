package matrix;

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
	/*
	 * Use binary search in rows and columns.
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		if (target < matrix[0][0]) {
			return false;
		}
		int row = matrix.length, col = matrix[0].length;
		int up = 0, down = row - 1;
		while (up <= down) {
			int mid = (up + down) / 2;
			if (matrix[mid][0] == target) {
				return true;
			}
			if (target > matrix[mid][0]) {
				up = mid + 1;
			} else {
				down = mid - 1;
			}
		}
		int curRow = down;
		int left = 0, right = col - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (matrix[curRow][mid] == target) {
				return true;
			}
			if (target > matrix[curRow][mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34,
		// 50 } };
		// System.out.println(searchMatrix(matrix, 13));

		int[][] matrix2 = { { 1, 3 } };
		System.out.println(searchMatrix(matrix2, 3));
	}

}
