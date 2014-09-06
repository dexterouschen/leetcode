package dynamic_programming;

/*
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */

public class Interleaving_String {
	/**
	 * Most times when you see a problem with strings comparison or iteration, 
	 * the most efficient algorithm should be a DP rather than a recursion. 
	 * 
	 * To think in a "DP" kind of way, the first challenge is to find out how a result 
	 * is constructed. In most cases, it means "think from bottom to top". So let's 
	 * think this way: if s3 is the interleave of s1 and s2, what can we learn from 
	 * the last char of s3? It must belong to s1 or s2 or both!
	 * 
	 * Let's build a boolean[][] result, such that result[i][j] represent if s3[0, i + j] is 
	 * the interleave of s1[0, i] and s2[0, j]. From what we found about the last char 
	 * of s3, we can get:
	 * 
	 *     if s3[i + j] equal to both s1[i] and s2[j]:
	 *         result[i][j] = result[i - 1][j] || result[i][j - 1];
	 *     if s3[i + j] == s1[i]:
	 *         result[i][j] = result[i - 1][j];
	 *     if s3[i + j] == s2[j]:
	 *         result[i][j] = result[i][j - 1];
	 *     if s3[i + j] doesn't equal to neither s1[i] nor s2[j]:
	 *         result[i][j] = false;
	 * 
	 * Now it's obvious how to run the DP iteration.
	 * 
	 * Reference:
	 * http://fisherlei.blogspot.com/2012/12/leetcode-interleaving-string.html
	 */
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		boolean[][] matched = new boolean[s1.length() + 1][s2.length() + 1];
		matched[0][0] = true;
		for (int i1 = 1; i1 <= s1.length(); i1++) { // build edge
			if (s3.charAt(i1 - 1) == s1.charAt(i1 - 1)) {
				matched[i1][0] = true;
			} else
				break;
		}
		for (int i2 = 1; i2 <= s2.length(); i2++) { // build edge
			if (s3.charAt(i2 - 1) == s2.charAt(i2 - 1)) {
				matched[0][i2] = true;
			} else
				break;
		}
		for (int i1 = 1; i1 <= s1.length(); i1++) { // DP iteration
			char c1 = s1.charAt(i1 - 1);
			for (int i2 = 1; i2 <= s2.length(); i2++) {
				int i3 = i1 + i2;
				char c2 = s2.charAt(i2 - 1);
				char c3 = s3.charAt(i3 - 1);
				if (c1 == c3) {
					matched[i1][i2] |= matched[i1 - 1][i2];
				}
				if (c2 == c3) {
					matched[i1][i2] |= matched[i1][i2 - 1];
				}
			}
		}
		return matched[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		System.out.println(isInterleave(s1, s2, "aadbbcbcac")); // true
		System.out.println(isInterleave(s1, s2, "aadbbbaccc")); // false
	}

}
