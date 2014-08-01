package deep_search;

/*
 Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.
 */

public class N_Queens_II {

	public static int totalNQueens(int n) {
		if (n < 2) {
			return n;
		}
		if (n == 2 || n == 3) {
			return 0;
		}
		boolean[][] table = new boolean[n][n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			boolean[][] newTable = block(table, i, 0);
			count += countNQueens(i, 0, newTable);
		}
		return count;
	}

	// count the number of queens at a given row, col and block table
	public static int countNQueens(int row, int col, boolean[][] table) {
		// check is the last row of table is all blocked
		boolean ans = true;
		int lastRowCount = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i][table.length - 1] == false) {
				ans = false;
				lastRowCount++;
			}
		}
		if (ans == true) { // if all blocked, return 0
			return 0;
		} else if (col == table.length - 2) { // if not all blocked
			return lastRowCount;
		} else { // the last column is not blocked and we haven't get to the
					// last column yet
			int count = 0;
			for (int i = 0; i < table.length; i++) {
				if (table[i][col + 1] == false) {
					boolean[][] newTable = block(table, i, col + 1);
					count += countNQueens(i, col + 1, newTable);
				}
			}
			return count;
		}

	}

	public static boolean[][] block(boolean[][] table, int row, int col) {
		int len = table.length;
		boolean[][] newTable = new boolean[len][len];
		// printTable(newTable);
		for (int i = 0; i < len; i++) { // blocked == true
			newTable[row][i] = true;
			newTable[i][col] = true;
			if (row + i < len && row + i >= 0 && col + i < len && col + 1 >= 0) {
				newTable[row + i][col + i] = true;
			}
			if (row - i < len && row - i >= 0 && col + i < len && col + 1 >= 0) {
				newTable[row - i][col + i] = true;
			}
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (table[i][j] == true) {
					newTable[i][j] = true;
				}
			}
		}
		return newTable;
	}

	// for debugging
	public static void printTable(boolean[][] newTable) {
		int n = newTable.length;
		for (int m = 0; m < n; m++) {
			for (int l = 0; l < n; l++) {
				System.out.println("table[" + m + "]" + "[" + l + "] is: " + newTable[m][l]);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(totalNQueens(4));
	}

}
