package dynamic_programming;

/*
 Given a string S and a string T, count the number of distinct subsequences of S equal to T.

 A subsequence of a string is a new string which is formed from the original string by deleting some
 (can be none) of the characters without disturbing the relative positions of the remaining characters.
 (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"

 Return 3.
 */

public class Distinct_Subsequences {
	/**
	 * Let Table[i][j] stand for the number of subsequences of S(0, i) in T(0,
	 * j). If S.charAt(i) == T.charAt(j), Table[i][j] = Table[i-1][j-1] +
	 * Table[i-1][j]; Otherwise, Table[i][j] = Table[i-1][j].
	 */
	public static int numDistinct(String S, String T) {
		int[][] table = new int[S.length() + 1][T.length() + 1];
		for (int i = 0; i < S.length(); i++) {
			table[i][0] = 1;
		}
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
				} else {
					table[i][j] += table[i - 1][j];
				}
			}
		}
		return table[S.length()][T.length()];
	}

	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit")); // shall return 3
		System.out.println(numDistinct("anacondastreetracecar", "contra")); // 6
		System.out.println(numDistinct("deella", "del")); // shall return 4
	}

}
