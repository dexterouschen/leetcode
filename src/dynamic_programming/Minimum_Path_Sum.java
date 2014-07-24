package dynamic_programming;

/*
 Given a m x n grid filled with non-negative numbers,
 find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class Minimum_Path_Sum {

	public static int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int row = grid.length, col = grid[0].length;
		// sum[i][j] is the min path sum of point grid[i][j]
		// sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1])
		int[][] sum = new int[row][col];
		sum[0][0] = grid[0][0];
		for (int i = 1; i < row; i++) {
			sum[i][0] = sum[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < col; i++) {
			sum[0][i] = sum[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
			}
		}
		return sum[row - 1][col - 1];
	}

	public static void main(String[] args) {
		// int[][] grid = { { 5, 4, 7, 1 }, { 9, 2, 11, 8 }, { 4, 13, 12, 4 } };
		int[][] grid = { { 1 } };
		System.out.println(minPathSum(grid));
	}

}
