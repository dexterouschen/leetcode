package matrix;

import java.util.*;

/*
 Given a matrix of m x n elements (m rows, n columns), 
 return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */

public class Spiral_Matrix {
	/**
	 * Use four indexes to set up the circles of iterations. After each circle,
	 * update indexes. Finally, check if there is one column or row of numbers
	 * that are needed to added into the list.
	 */
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return list;
		}
		// solve this spiral problem by a while loop that travels through the
		// boundary of the matrix clock-wisely, using 4 indexes top, bottom,
		// left, right. Values of these 4 variables changes each time after the
		// while loop goes through the boundary.
		int row = matrix.length, col = matrix[0].length;
		int top = 0, bottom = row - 1, left = 0, right = col - 1;
		while (top < bottom && left < right) {
			for (int i = left; i < right; i++) {
				list.add(matrix[top][i]);
			}
			for (int i = top; i < bottom; i++) {
				list.add(matrix[i][right]);
			}
			for (int i = right; i > left; i--) {
				list.add(matrix[bottom][i]);
			}
			for (int i = bottom; i > top; i--) {
				list.add(matrix[i][left]);
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		// if the number of columns and/or rows is odd
		if (top == bottom) {
			for (int i = left; i <= right; i++) {
				list.add(matrix[top][i]);
			}
		} else if (left == right) {
			for (int i = top; i <= bottom; i++) {
				list.add(matrix[i][left]);
			}
		}
		return list;
	}

	// adjusted solution on 2014-7-24
	public List<Integer> spiralOrder_2nd(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return list;
		}
		int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
		while (left <= right && top <= bottom) {
			for (int i = left; i <= right && (left <= right && top <= bottom); i++) {
				list.add(matrix[top][i]);
			}
			top++;
			for (int i = top; i <= bottom && (left <= right && top <= bottom); i++) {
				list.add(matrix[i][right]);
			}
			right--;
			for (int i = right; i >= left && (left <= right && top <= bottom); i--) {
				list.add(matrix[bottom][i]);
			}
			bottom--;
			for (int i = bottom; i >= top && (left <= right && top <= bottom); i--) {
				list.add(matrix[i][left]);
			}
			left++;
		}
		return list;
	}

	public static void main(String[] args) {
		// int[][] A = { { 1, 2, 3, 4 }, { 10, 11, 12, 5 }, { 9, 8, 7, 6 } };
		int[][] A = { { 2, 5 }, { 8, 4 }, { 0, -1 } };
		System.out.println(spiralOrder(A));
	}

}
