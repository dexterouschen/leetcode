package arrays;

/*
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 */
public class Rotate_Image {

	public static void rotate(int[][] matrix) {
		int len = matrix.length;
		if (len == 0) {
			return;
		}
		int[][] newMatrix = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				newMatrix[i][j] = matrix[len - 1 - j][i];
			}
		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				matrix[i][j] = newMatrix[i][j];
			}
		}
	}

	public static void printTable(int[][] newTable) {
		int n = newTable.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("table[" + i + "]" + "[" + j + "] is: "
						+ newTable[i][j]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		printTable(matrix);
		rotate(matrix);
		printTable(matrix);
	}

}
