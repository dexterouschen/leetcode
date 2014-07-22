package matrix;

import java.util.HashMap;

/*
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable.
 Only the filled cells need to be validated.
 */

public class Valid_Sudoku {

	public static boolean isValidSudoku(char[][] board) {
		if (board == null || board.length < 9 || board[0].length < 9) {
			return false;
		}
		// check lines
		boolean res = true;
		for (int i = 0; i < 9; i++) {
			char[] hor = new char[9];
			char[] vert = new char[9];
			for (int j = 0; j < 9; j++) {
				hor[j] = board[i][j];
				vert[j] = board[j][i];
			}
			// check if it satisfies Sudoku rules
			res &= isValidLine(hor);
			res &= isValidLine(vert);
		}
		// check boxes
		for (int n = 0; n < 9; n++) {
			char[][] box = new char[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					box[i][j] = board[3 * (n / 3) + i][3 * (n % 3) + j];
				}
			}
			res &= isValidBox(box);
		}
		return res;
	}

	public static boolean isValidLine(char[] line) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < line.length; i++) {
			if (map.containsKey(line[i]) && line[i] != '.') {
				return false;
			} else {
				map.put(line[i], line[i]);
			}
		}
		return true;
	}

	public static boolean isValidBox(char[][] box) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if (map.containsKey(box[i][j]) && box[i][j] != '.') {
					return false;
				} else {
					map.put(box[i][j], box[i][j]);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[] A = { '9', '8', '7', '6', '6', '.', '.', '.', '.' };
		char[] B = { '.', '8', '.', '.', '6', '.', '.', '.', '.' };
		char[] C = { '.', '.', '.', '.', '.', '.', '.', '.', '.' };
		System.out.println(isValidLine(A));
		System.out.println(isValidLine(B));
		System.out.println(isValidLine(C));
		char[][] boxA = { { '.', '5', '.' }, { '3', '.', '.' }, { '.', '.', '3' } };
		char[][] boxB = { { '.', '1', '.' }, { '.', '.', '.' }, { '.', '.', '1' } };
		System.out.println(isValidBox(boxA));
		System.out.println(isValidBox(boxB));

	}
}
