package matrix;

/*
 Given a 2D binary matrix filled with 0's and 1's, 
 find the largest rectangle containing all ones and return its area.
 */

public class Maximal_Rectangle {
	/**
	 * I don't know if there is a better way to solve this problem. My solution
	 * is of O(N * M^2). First build a new matrix M such that M[i][j] represents
	 * the length of continuous "1"s in current row. After building this matrix,
	 * for each cell M[i][j] that is not "0", do this: expand up and down until
	 * M[i +/- x][j] < M[i][j]. Then calculate the value of area by following:
	 * "area = M[i][j] * (up - down)". Dynamically update the maximum.
	 */
	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int area = 0;
		int row = matrix.length, col = matrix[0].length;
		// build a matrix that record width of '1' of each point in matrix
		int[][] width = new int[row][col];
		for (int i = 0; i < row; i++) { // building the width matrix
			int curLen = 0;
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '1') {
					curLen++;
				} else {
					curLen = 0;
				}
				width[i][j] = curLen;
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (width[i][j] > 0) {
					int up = i, down = i;
					while (up - 1 >= 0 && width[up - 1][j] >= width[i][j]) {
						up--;
					}
					while (down + 1 < row && width[down + 1][j] >= width[i][j]) {
						down++;
					}
					area = Math.max(area, (down - up + 1) * width[i][j]);
				}
			}
		}
		return area;
	}

	public static void main(String[] args) {
		char[][] matrix = { { '0', '1', '1', '0' }, { '1', '0', '0', '0' }, { '0', '1', '1', '1' },
				{ '0', '1', '1', '0' } };
		System.out.println(maximalRectangle(matrix));
	}

}
