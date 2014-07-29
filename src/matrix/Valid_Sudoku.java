package matrix;

import java.util.*;

/*
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable.
 Only the filled cells need to be validated.
 */

public class Valid_Sudoku {
	/*
	 * Iteratively implement Sudoku rules by using hash set in examing if each
	 * row, column and box is valid.
	 */
	public static boolean isValidSudoku(char[][] board) {
		// check row
		for (int i = 0; i < board.length; i++) {
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.' && set.contains(board[i][j])) {
					return false;
				} else {
					set.add(board[i][j]);
				}
			}
		}
		// check column
		for (int i = 0; i < board[0].length; i++) {
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] != '.' && set.contains(board[j][i])) {
					return false;
				} else {
					set.add(board[j][i]);
				}
			}
		}
		// check box
		for (int m = 0; m < 3; m++) {
			for (int n = 0; n < 3; n++) {
				Set<Character> set = new HashSet<>();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (board[i + m * 3][j + n * 3] != '.'
								&& set.contains(board[i + m * 3][j + n * 3])) {
							return false;
						} else {
							set.add(board[i + m * 3][j + n * 3]);
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
	}
}
