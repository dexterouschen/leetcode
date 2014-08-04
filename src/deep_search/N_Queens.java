package deep_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {

	public static List<String[]> solveNQueens(int n) {
		ArrayList<String[]> list = new ArrayList<String[]>();
		if (n == 0) {
			return null;
		}
		String[] rowStrings = new String[n];
		dfs(0, n, rowStrings, list);
		return list;
	}

	// DFS solve question
	public static void dfs(int row, int n, String[] rowStrings, ArrayList<String[]> result) {
		// "row==n" meaning that rowStrings has already been filled up with Qs
		// at each row, therefore it's a valid solution and can be add to result
		if (row == n) {
			// VERY IMPORTANT HRER!! Need to use clone() to add into list;
			result.add(rowStrings.clone());
			return;
		}
		// Else since rowStrings has not been filled up, iterate through all
		// columns at this row. For each case that a Q can be fit into a column,
		// update rowStrings and recursively call dfs on the next row.
		for (int col = 0; col < n; col++) {
			if (isValid(row, col, rowStrings)) { // if a Q can be put down here
				// create a new row with Q put in this position
				char[] chars = new char[n];
				Arrays.fill(chars, '.');
				chars[col] = 'Q';
				// update rowStrings with this new row
				rowStrings[row] = String.copyValueOf(chars);
				// recursion to look into the next row
				dfs(row + 1, n, rowStrings, result);
			}
		}

	}

	// check the result as if a Q is put in a position [row][col], is there
	// any conflict with other Qs that have been put in previous rows.
	public static boolean isValid(int row, int col, String[] rowStrings) {
		for (int i = 0; i < row; i++) { // iterate per each previous row
			// check if current Q is in the same column
			int qCol = rowStrings[i].indexOf("Q");
			if (qCol == col) {
				return false;
			}
			// check if current Q is in its diagonal
			int rowDistance = Math.abs(row - i);
			int colDistance = Math.abs(col - qCol);
			if (rowDistance == colDistance) {
				return false;
			}
		}
		return true;
	}

//	public static List<String[]> solveNQueens(int n) {
//		List<String[]> list = new ArrayList<String[]>();
//		String[] strArray = new String[4];
//		if (n <= 0) {
//			return list;
//		}
//		char[] line = new char[n];
//		for (int i = 0; i < n; i++) {
//			line[i] = '.';
//		}
//		boolean[][] occupied = new boolean[n][n];
//		dfs(list, strArray, occupied, n, 0, line);
//		return list;
//	}
//
//	public static void dfs(List<String[]> list, String[] strArray, boolean[][] occupied, int n, int curRow, char[] line) {
//		if (curRow == n - 1) {
//			for (int i = 0; i < n; i++) {
//				if (occupied[n - 1][i] == false) {
//					char[] nline = Arrays.copyOf(line, n);
//					String[] nStrArray = Arrays.copyOf(strArray, n);
//					nline[i] = 'Q';
//					nStrArray[curRow] = nline.toString();
//					list.add(nStrArray);
//				}
//			}
//			return;
//		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n && occupied[curRow][j] == false; j++) {
//				char[] nline = Arrays.copyOf(line, n);
//				String[] nStrArray = Arrays.copyOf(strArray, n);
//				nline[i] = 'Q';
//				nStrArray[curRow] = nline.toString();
//				dfs(list, nStrArray, setInvalid(occupied, curRow, j), n, curRow + 1, line);
//			}
//		}
//	}
//
//	public static boolean[][] setInvalid(boolean[][] occupied, int row, int col) {
//		boolean[][] no = occupied.clone();
//		int len = no.length;
//		for (int i = 0; i < len; i++) {
//			for (int j = 0; j < len; j++) {
//				if (i == row || j == col || Math.abs(i - row) == Math.abs(j - col)) {
//					no[i][j] = true;
//				}
//			}
//		}
//		return no;
//	}

	public static void main(String[] args) {
		List<String[]> list = solveNQueens(4);
		for (int i = 0; i < list.size(); i++) {
			String[] strArr = list.get(i);
			System.out.println("\nSolution " + i + " is:");
			for (int j = 0; j < strArr.length; j++) {
				System.out.println(strArr[j]);
			}
		}
	}

}