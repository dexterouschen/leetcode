package matrix;

import java.util.Arrays;

/*
 Given an integer n, generate a square matrix filled with elements from n1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */

public class Spiral_Matrix_II {
	/**
	 * Similar approach to "Spiral Matrix". 
	 */
	public static int[][] generateMatrix(int n) {
		if (n == 0) {
			return new int[0][0];
		}
		int[][] matrix = new int[n][n];
		int up = 0, down = n - 1, left = 0, right = n - 1;
		int num = 1;
		while (left <= right && up <= down) {
			for (int i = left; i <= right; i++) {
				matrix[up][i] = num;
				num++;
			}
			up++;
			for (int i = up; i <= down; i++) {
				matrix[i][right] = num;
				num++;
			}
			right--;
			for (int i = right; i >= left; i--) {
				matrix[down][i] = num;
				num++;
			}
			down--;
			for (int i = down; i >= up; i--) {
				matrix[i][left] = num;
				num++;
			}
			left++;
		}
		return matrix;
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] A = generateMatrix(n);
		if (A != null) {
			for (int i = 0; i < n; i++) {
				System.out.println(Arrays.toString(A[i]));
			}
		}
	}

}
