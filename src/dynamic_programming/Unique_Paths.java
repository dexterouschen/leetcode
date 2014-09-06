package dynamic_programming;

/*
 A robot is located at the top-left corner of a m x n grid.

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid.

 How many possible unique paths are there?

 Note: m and n will be at most 100.
 */

public class Unique_Paths {
	/**
	 * This problem can be solved using a DP algorithm. Let path[i][j] be the 
	 * number of paths to get to grid[i][j]. Then we can find that:
	 * path[i][j] = path[i - 1][j] + path[i][j - 1].
	 */
	public static int uniquePaths(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		int[][] path = new int[m][n];
		for (int i = 0; i < m; i++)
			path[i][0] = 1;
		for (int i = 1; i < n; i++)
			path[0][i] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				path[i][j] = path[i - 1][j] + path[i][j - 1];
			}
		}
		return path[m - 1][n - 1];
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(2, 3));// should be 3
		System.out.println(uniquePaths(2, 2));// should be 1
		System.out.println(uniquePaths(5, 6));// should be 126
	}

}
