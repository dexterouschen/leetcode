package dfs;

/*
 Given a m x n grid filled with non-negative numbers,
 find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class Minimum_Path_Sum {

	public static int minPathSum(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		int[][] table = new int[row][col];
		// make the edges
		table[row - 1][col - 1] = grid[row - 1][col - 1];
		for (int i = row - 2; i >= 0; i--) {
			table[i][col - 1] = table[i + 1][col - 1] + grid[i][col - 1];
		}
		for (int i = col - 2; i >= 0; i--) {
			table[row - 1][i] = table[row - 1][i + 1] + grid[row - 1][i];
		}
		// build the table
		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				table[i][j] = grid[i][j]
						+ Math.min(table[i][j + 1], table[i + 1][j]);
			}
		}
		return table[0][0];
	}

	public static void main(String[] args) {
		// int[][] grid = { { 5, 4, 7, 1 }, { 9, 2, 11, 8 }, { 4, 13, 12, 4 } };
		int[][] grid = { { 1 } };
		System.out.println(minPathSum(grid));
	}

}
