package deep_search;

/*
 Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 */

public class Unique_Paths_II {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}
		int row = obstacleGrid.length, col = obstacleGrid[0].length;
		int[][] path = new int[row][col];
		// initate
		boolean flag = true;
		for (int i = 0; i < row; i++) {
			if (obstacleGrid[i][0] == 1) {
				flag = false;
			}
			if (flag == true) {
				path[i][0] = 1;
			} else {
				path[i][0] = 0;
			}
		}
		flag = true;
		for (int i = 0; i < col; i++) {
			if (obstacleGrid[0][i] == 1) {
				flag = false;
			}
			if (flag == true) {
				path[0][i] = 1;
			} else {
				path[0][i] = 0;
			}
		}
		// build table
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				path[i][j] = obstacleGrid[i][j] == 1 ? 0 : path[i - 1][j] + path[i][j - 1];
			}
		}
		return path[row - 1][col - 1];
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0 }, { 1, 1 }, { 0, 0 } };
		System.out.println(uniquePathsWithObstacles(grid));
	}
}
