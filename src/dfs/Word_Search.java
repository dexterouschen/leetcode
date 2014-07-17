package dfs;

/*
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, 
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 For example,
 Given board =
 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */

public class Word_Search {
	/*
	 * Use recursive search to traverse through the matrix and match the word
	 * with chars on the board one-by-one.
	 */
	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0) {
			return false;
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		boolean result = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					visited[i][j] = true;
					result |= lookup(board, word.substring(1), visited, i, j);
					visited[i][j] = false;
				}
			}
		}
		return result;
	}

	private static boolean lookup(char[][] board, String word, boolean[][] visited, int i, int j) {
		boolean up = false, down = false, left = false, right = false;
		if (word.length() == 0) {
			return true;
		}
		String curWord = word.substring(1);
		if (i - 1 >= 0 && visited[i - 1][j] == false && board[i - 1][j] == word.charAt(0)) {
			visited[i - 1][j] = true;
			up = lookup(board, curWord, visited, i - 1, j);
			visited[i - 1][j] = false;
		}
		if (i + 1 < board.length && visited[i + 1][j] == false && board[i + 1][j] == word.charAt(0)) {
			visited[i + 1][j] = true;
			down = lookup(board, curWord, visited, i + 1, j);
			visited[i + 1][j] = false;
		}
		if (j - 1 >= 0 && visited[i][j - 1] == false && board[i][j - 1] == word.charAt(0)) {
			visited[i][j - 1] = true;
			left = lookup(board, curWord, visited, i, j - 1);
			visited[i][j - 1] = false;
		}
		if (j + 1 < board[0].length && visited[i][j + 1] == false
				&& board[i][j + 1] == word.charAt(0)) {
			visited[i][j + 1] = true;
			right = lookup(board, curWord, visited, i, j + 1);
			visited[i][j + 1] = false;
		}
		return up || down || left || right;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board, "ABCCED")); // true
		System.out.println(exist(board, "SEE")); // true
		System.out.println(exist(board, "ABCB")); // false

		char[][] board2 = { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
		System.out.println(exist(board2, "AAB")); // true

		char[][] board3 = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board3, "ABCESEEEFS")); // true
	}

}
