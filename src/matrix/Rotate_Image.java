package matrix;

/*
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 */

public class Rotate_Image {
	/**
	 * One of a Google phone interview questions. Be careful with the sequence
	 * of rotation: four lines below "int temp = matrix[i][j];", as well as the
	 * second for-loop declaration ('j').
	 */
	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length < 2) {
			return;
		}
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			// Here j should be smaller then n/2 or n/2 + 1
			for (int j = 0; j < (n % 2 == 0 ? n / 2 : n / 2 + 1); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}
	}

	// for debugging and testing purposes
	public static void printTable(int[][] newTable) {
		int n = newTable.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(newTable[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		printTable(matrix);
		System.out.println("\n");
		rotate(matrix);
		printTable(matrix);
	}

}
