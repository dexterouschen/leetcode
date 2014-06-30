package dfs;

import java.util.ArrayList;

/*
 Given n pairs of parentheses,
 write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Generate_Parentheses {
	public static final char LEFT = '(';
	public static final char RIGHT = ')';

	public static ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> list = new ArrayList<String>();
		if (n == 0) {
			return list;
		}
		String str = "";
		dfs(list, str, n);
		return list;
	}

	public static void dfs(ArrayList<String> list, String str, int n) {
		if (str.length() == n * 2) {
			// String nStr = new String(str);
			list.add(str);
			return;
		}
		if (isValid(str, LEFT, n)) {
			String nStr = str + LEFT;
			dfs(list, nStr, n);
		}
		if (isValid(str, RIGHT, n)) {
			String nStr = str + RIGHT;
			dfs(list, nStr, n);
		}
	}

	// check is a parenthesis can be added
	private static boolean isValid(String str, char p, int n) {
		int leftCounter = 0;
		int rightCounter = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == LEFT) {
				leftCounter++;
			}
			if (str.charAt(i) == RIGHT) {
				rightCounter++;
			}
		}
		if (p == LEFT) {
			// make sure the number of left is less than n
			if (leftCounter < n && leftCounter >= rightCounter) {
				return true;
			} else {
				return false;
			}
		} else if (p == RIGHT) {
			if (rightCounter < n && rightCounter < leftCounter) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ArrayList<String> list = generateParenthesis(3);

		System.out.println("Size: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
