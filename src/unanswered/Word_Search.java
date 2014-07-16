package unanswered;

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

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0) {
			return false;
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean[][] curVisited = visited.clone();
					curVisited[i][j] = true;
					String curWord = word.substring(1);
					if (curWord.length() == 0) {
						return true;
					}
					return lookup(board, curWord, curVisited, i, j);
				}
			}
		}
		return false;
	}

	private static boolean lookup(char[][] board, String word, boolean[][] visited, int i, int j) {
		boolean up = false, down = false, left = false, right = false;
		if (i - 1 >= 0 && visited[i - 1][j] == false && board[i - 1][j] == word.charAt(0)) {
			boolean[][] curVisited = visited.clone();
			curVisited[i - 1][j] = true;
			String curWord = word.substring(1);
			if (curWord.length() == 0) {
				return true;
			}
			up = lookup(board, curWord, curVisited, i - 1, j);
		}
		if (i + 1 < board.length && visited[i + 1][j] == false && board[i + 1][j] == word.charAt(0)) {
			boolean[][] curVisited = visited.clone();
			curVisited[i + 1][j] = true;
			String curWord = word.substring(1);
			if (curWord.length() == 0) {
				return true;
			}
			down = lookup(board, curWord, curVisited, i + 1, j);
		}
		if (j - 1 >= 0 && visited[i][j - 1] == false && board[i][j - 1] == word.charAt(0)) {
			boolean[][] curVisited = visited.clone();
			curVisited[i][j - 1] = true;
			String curWord = word.substring(1);
			if (curWord.length() == 0) {
				return true;
			}
			left = lookup(board, curWord, curVisited, i, j - 1);
		}
		if (j + 1 < board[0].length && visited[i][j + 1] == false
				&& board[i][j + 1] == word.charAt(0)) {
			boolean[][] curVisited = visited.clone();
			curVisited[i][j + 1] = true;
			String curWord = word.substring(1);
			if (curWord.length() == 0) {
				return true;
			}
			right = lookup(board, curWord, curVisited, i, j + 1);
		}
		return up || down || left || right;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board, "ABCCED")); // true
		System.out.println(exist(board, "SEE")); // true
		System.out.println(exist(board, "ABCB")); // false
String a = "a";
String b = a.substring(1);
System.out.println(b.length());
	}
}
