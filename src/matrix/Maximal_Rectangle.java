package matrix;

/*
 Given a 2D binary matrix filled with 0's and 1's, 
 find the largest rectangle containing all ones and return its area.
 */

/*
 * ����dp��һ���¾���d[i][j]��ʾ��(i, j)��β�м�������1���ڵ�ǰrow)��
 * Ȼ���������¾�����ÿ��cell���������������d[i][j]�ľ���������ж��,
 * Ҳ��������expand����ȱ�խΪֹ������expand����ȱ�խΪֹ,
 * Ȼ���ܸ߶ȡ���ǰ��Ⱦ���d[i][j]�����ڵľ����������������Ǹ�O(M * N) * O(M)��
 */

public class Maximal_Rectangle {

	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int area = 0;
		int row = matrix.length, col = matrix[0].length;
		// build a matrix that record width of '1' of each point in matrix
		int[][] width = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '1') {
					int move = j, len = 0;
					while (move >= 0 && matrix[i][move] == '1') {
						len++;
						move--;
					}
					width[i][j] = len;
				}
			}
		}
		// find out the height of each point in matrix as their upper/lower rows
		// have the same width of '1'
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (width[i][j] != 0) {
					int up = 0, down = 0, move = i - 1;
					while (move >= 0 && isAllOne(matrix, move, j - width[i][j] + 1, j)) {
						up++;
						move--;
					}
					move = i + 1;
					while (move <= row - 1 && isAllOne(matrix, move, j - width[i][j] + 1, j)) {
						down++;
						move++;
					}
					int height = up + down + 1;
					area = Math.max(area, width[i][j] * height);
				}
			}
		}
		return area;
	}

	private static boolean isAllOne(char[][] matrix, int row, int col1, int col2) {
		for (int i = col1; i <= col2; i++) {
			if (matrix[row][i] == '0')
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] matrix = { { '0', '1', '1', '0' }, { '1', '0', '0', '0' }, { '0', '1', '1', '1' },
				{ '0', '1', '1', '0' } };
		System.out.println(maximalRectangle(matrix));
	}

}
