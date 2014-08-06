package matrix;

/*
 Given an m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.

 Follow up:
 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?
 */

public class Set_Matrix_Zero {

	/*
	 * To solve this problem WITHOUT using extra space, a good idea is to store
	 * the indexes for "zeroes" at the first row and column of the matrix.
	 * Remember to record if there is any zeroes in first row and/or column
	 * before writing indexes onto them.
	 */
	public static void setZeroes(int[][] matrix) {
		int row = matrix.length, col = matrix[0].length;
		boolean clearFirstRow = false, clearFirstCol = false;
		// check if first row and column need to be cleaned
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0)
				clearFirstCol = true;
		}
		for (int i = 0; i < col; i++) {
			if (matrix[0][i] == 0)
				clearFirstRow = true;
		}
		// scan the rest of matrix, set coordinating elements on first row and
		// col to be zero
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		// set rows and columns to be zeros by using the first row and column
		for (int i = 1; i < row; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < col; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < col; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 1; j < row; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		// finally, set first row/column to be zeroes based on two boolean flags
		if (clearFirstCol == true) {
			for (int i = 0; i < row; i++) {
				matrix[i][0] = 0;
			}
		}
		if (clearFirstRow == true) {
			for (int i = 0; i < col; i++) {
				matrix[0][i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 12, 7 }, { 3, 0, 9, 21 }, { 6, 5, 0, 3 } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.println("Matrix[" + i + "][" + j + "] is: " + matrix[i][j]);
			}
		}
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.println("Matrix[" + i + "][" + j + "] is: " + matrix[i][j]);
			}
		}

	}
}
