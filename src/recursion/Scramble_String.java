package recursion;

import java.util.Arrays;

/**
 Given a string s1, we may represent it as a binary tree by partitioning it to
 two non-empty substrings recursively.

 Below is one possible representation of s1 = "great":

		great
	 	/      \
	 gr       eat
	 / \       /  \
    g   r    e   at
   / \
  a   t
 To scramble the string, we may choose any non-leaf node and swap its two children.

 For example, if we choose the node "gr" and swap its two children,
 it produces a scrambled string "rgeat".

		 rgeat
		 /      \
	   rg      eat
	   / \      /  \
	  r   g   e   at
		       / \
		      a   t
 We say that "rgeat" is a scrambled string of "great".

 Similarly, if we continue to swap the children of nodes "eat" and "at",
 it produces a scrambled string "rgtae".

		 rgtae
		  /     \
		rg     tae
	    / \     /  \
	   r   g  ta  e
		       / \
		      t   a
 We say that "rgtae" is a scrambled string of "great".

 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */

public class Scramble_String {
	/**
	 * The basic idea to solve this problem is that s1 and s2 can be divided
	 * into two sets of substrings: s1a, s1b, s2a, s2b. To satisfy the scramble
	 * rule, it must be "s1a == s2a && s1b == s2b" or
	 * "s1a == s2b && s1b == s2a".
	 * 
	 * http://www.blogjava.net/sandy/archive/2013/05/22/399605.html
	 */
	public static boolean isScrambleRecursion(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 != len2)
			return false;
		if (len1 == 0)
			return true;
		if (len1 == 1) // Base condition for recursion.
			return s1.equals(s2);
		// following codes are used to eliminate part of the recursions
		char[] s1array = s1.toCharArray();
		char[] s2array = s2.toCharArray();
		Arrays.sort(s1array);
		Arrays.sort(s2array);
		for (int i = 0; i < len1; i++) {
			if (s1array[i] != s2array[i])
				return false;
		}
		// main loop in finding a certain break point such that substrings
		// partitioned from this point are scrambled strings. If such break
		// point is found, recursion will dive into the substrings and return
		// the results for their sub-substrings. This will end until recursion
		// reaches substrings that is just one single char.
		boolean result = false;
		for (int i = 1; i < s1.length(); i++) {
			if (result)
				break;
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);
			String s31 = s2.substring(0, s1.length() - i);
			String s32 = s2.substring(s1.length() - i);
			result = isScrambleRecursion(s11, s21) && isScrambleRecursion(s12, s22)
					|| isScrambleRecursion(s11, s32) && isScrambleRecursion(s12, s31);
		}
		return result;
	}

	/**
	 * Recursive solution is straightforward yet expensive. So we may need to
	 * build a DP algorithm to simply computation. Here I used a 3D array of
	 * boolean result[len][len][len], in which 1st dimension is for the length
	 * of substring; 2nd dimension represents the starting index for s1; 3rd
	 * dimension represents the starting index for s2. result[k][i][j] means
	 * whether substring s1[i...i+k] can be scrambled from s2[j...j+k].
	 */
	public static boolean isScrambleDP(String s1, String s2) {
		int len = s1.length();
		if (len != s2.length()) {
			return false;
		}
		if (len == 0) {
			return true;
		}

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		boolean[][][] result = new boolean[len][len][len];
		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < len; ++j) {
				result[0][i][j] = (c1[i] == c2[j]);
			}
		}

		for (int k = 2; k <= len; ++k) {
			for (int i = len - k; i >= 0; --i) {
				for (int j = len - k; j >= 0; --j) {
					boolean r = false;
					for (int m = 1; m < k && !r; ++m) {
						r = (result[m - 1][i][j] && result[k - m - 1][i + m][j + m])
								|| (result[m - 1][i][j + k - m] && result[k - m - 1][i + m][j]);
					}
					result[k - 1][i][j] = r;
				}
			}
		}

		return result[len - 1][0][0];
	}

	public static void main(String[] args) {
		String s1 = "great", s2 = "rgtae";
		System.out.println(isScrambleRecursion(s1, s2));
	}

}
