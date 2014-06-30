package matrix;

import java.util.HashSet;
import java.util.Set;

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

	public static void setZeroes(int[][] matrix) {
		int row = matrix.length, col = matrix[0].length;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < row; i++) {
			boolean hasZero = false;
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					set.add(j);
					hasZero = true;
				}
			}
			if (hasZero == true) {
				setRowToZeroes(matrix, i);
			}
		}
		for (int x : set) {
			setColToZeroes(matrix, x);
		}
	}

	public static void setRowToZeroes(int[][] matrix, int row) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}

	public static void setColToZeroes(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 12, 7 }, { 3, 0, 9, 21 }, { 6, 5, 0, 3 } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.println("Matrix[" + i + "][" + j + "] is: "
						+ matrix[i][j]);
			}
		}
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.println("Matrix[" + i + "][" + j + "] is: "
						+ matrix[i][j]);
			}
		}

	}
}
