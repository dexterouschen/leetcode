package matrix;

import java.util.Arrays;

/*
 Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

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

	public static int[][] generateMatrix(int n) {
		if (n < 1) {
			return new int[0][0];
		}
		// solve this spiral problem by a while loop that travels through the
		// boundary of the matrix clock-wisely, using 4 indexes top, bottom,
		// left, right. Values of these 4 variables changes each time after the
		// while loop goes through the boundary.
		int row = n, col = n;
		int[][] newMatrix = new int[row][col];
		int itr = 1;
		int top = 0, bottom = row - 1, left = 0, right = col - 1;
		while (top < bottom && left < right) {
			for (int i = left; i < right; i++) {
				newMatrix[top][i] = itr;
				itr++;
			}
			for (int i = top; i < bottom; i++) {
				newMatrix[i][right] = itr;
				itr++;
			}
			for (int i = right; i > left; i--) {
				newMatrix[bottom][i] = itr;
				itr++;
			}
			for (int i = bottom; i > top; i--) {
				newMatrix[i][left] = itr;
				itr++;
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		// if the number of columns and/or rows is odd
		if (top == bottom) {
			for (int i = left; i <= right; i++) {
				newMatrix[top][i] = itr;
				itr++;
			}
		} else if (left == right) {
			for (int i = top; i <= bottom; i++) {
				newMatrix[i][left] = itr;
				itr++;
			}
		}
		return newMatrix;
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
