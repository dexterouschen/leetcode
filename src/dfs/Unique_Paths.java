package dfs;

/*
 A robot is located at the top-left corner of a m x n grid.

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid.

 How many possible unique paths are there?

 Note: m and n will be at most 100.
 */

public class Unique_Paths {

	// Using DP to build a table
	public static int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] table = new int[m][n];
		// initiate the edges
		for (int i = 0; i < m; i++) {
			table[i][n - 1] = 1;
		}
		for (int i = 0; i < n; i++) {
			table[m - 1][i] = 1;
		}
		// build the table
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				table[i][j] = table[i][j + 1] + table[i + 1][j];
			}
		}
		// return the value at the starting point
		return table[0][0];
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(2, 3));// should be 3
		System.out.println(uniquePaths(2, 2));// should be 1
		System.out.println(uniquePaths(5, 6));// should be 126
	}

}
