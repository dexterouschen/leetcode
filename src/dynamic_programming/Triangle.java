package dynamic_programming;

import java.util.ArrayList;

/*
 Given a triangle, find the minimum path sum from top to bottom. 
 Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space,
 where n is the total number of rows in the triangle. 
 */

public class Triangle {
	/*
	 * DP solution: there are i elements at level "i", and i - 1 elements at
	 * level "i - 1". To map the min paths from "i" to "i-1" level, do this: for
	 * an element "j" at level "i-1", its min_path_level_i-1[j] =
	 * Math.min(min_path_level_i[j], min_path_level_i[j+1]). From this
	 * relationship, we can build a DP solution from the last level to the top.
	 * The value for min_path at the top element is therefore the answer.
	 */
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		int length = triangle.size();
		int[] cLine = new int[length];
		// Initial value is the last line
		ArrayList<Integer> lastLine = triangle.get(length - 1);
		for (int j = 0; j < length; j++) {
			cLine[j] = lastLine.get(j);
		}
		// Updating from bottom up
		for (int i = length - 2; i >= 0; i--) {
			ArrayList<Integer> line = triangle.get(i);
			for (int j = 0; j < i + 1; j++) {
				cLine[j] = line.get(j) + Math.min(cLine[j], cLine[j + 1]); // DP
			}
		}
		return cLine[0];
	}

	public static void main(String[] args) {
	}

}