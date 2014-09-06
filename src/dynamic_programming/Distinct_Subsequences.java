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
	 * Let Table[i][j] stand for the number of subsequences of S(0, i) in T(0, j). 
	 * If S.charAt(i) == T.charAt(j), Table[i][j] = Table[i - 1][ j - 1] + Table[i - 1][j]; 
	 * Otherwise, Table[i][j] = Table[i - 1][j].
	 * 
	 * Why is this?
	 * 
	 * Spoiler alert: the key is to identify whether or not the last char in S(0, i), 
	 * which is S[i], is in the common subsequence between S(0, i) and T(0, j). 
	 * And remember, if S[i] does belong to the common subsequence, it must 
	 * be the LAST char in such subsequence.
	 * 
	 * First, when S[i] != T[j], which means S[i] can't be the last char in the common 
	 * subsequence between S(0, i) and T(0, j). As a result the number of distinct 
	 * subsequences numDistinct(S(0, i), T(0, j)) = numDistinct(S(0, i - 1), T(0, j)).
	 * 
	 * Second, when S[i] == T[j], there are two sub-cases:
	 * (1) S[i] is in the common subsequence between S(0, i) and T(0, j): 
	 *       In this case, the number of distinct subsequences numDistinct(S(0, i), T(0, j)) 
	 *       should be equal to numDistinct(S(0, i - 1), T(0, i - 1)).
	 * (2) S[i] is NOT in the common subsequence between S(0, i) and T(0, j):
	 *       In this case, which is similar to "First" case described above, we can get: 
	 *       numDistinct(S(0, i), T(0, j)) = numDistinct(S(0, i - 1), T(0, j))
	 *       
	 * Therefore, we reach a full mathematical expression of DP.
	 * 
	 */
	public static int numDistinct(String S, String T) {
		int[][] table = new int[S.length() + 1][T.length() + 1];
		for (int i = 0; i < S.length(); i++) { // base case
			table[i][0] = 1;
		}
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) != T.charAt(j - 1)) { // FIRST condition
					table[i][j] += table[i - 1][j];
				} else { // SECOND condition
					table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
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
