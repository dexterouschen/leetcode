package dfs;

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
		int ways = 0;
		if (obstacleGrid == null
				|| obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
			return ways;
		}

		int row = obstacleGrid.length, col = obstacleGrid[0].length;
		int[][] map = new int[row][col];
		// initiate the edges
		int p = row - 1;
		while (p >= 0 && obstacleGrid[p][col - 1] != 1) {
			map[p][col - 1] = 1;
			p--;
		}
		for (int i = p; i >= 0; i--) {
			map[p][col - 1] = 0;
		}
		p = col - 1;
		while (p >= 0 && obstacleGrid[row - 1][p] != 1) {
			map[row - 1][p] = 1;
			p--;
		}
		for (int i = p; i >= 0; i--) {
			map[row - 1][p] = 0;
		}
		// dp building
		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				if (obstacleGrid[i][j] != 1) {
					map[i][j] = map[i][j + 1] + map[i + 1][j];
				} else {
					map[i][j] = 0;
				}
			}
		}
		ways = map[0][0];
		return ways;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0 }, { 1, 1 }, { 0, 0 } };
		System.out.println(uniquePathsWithObstacles(grid));
	}
}
