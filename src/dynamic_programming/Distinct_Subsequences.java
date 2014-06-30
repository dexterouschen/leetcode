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

	public static int numDistinct(String S, String T) {
		int[] match = new int[S.length()];
		if (S.length() < T.length())
			return 0;
		match[0] = 1;
		for (int i = 1; i <= T.length(); i++)
			match[i] = 0;
		for (int i = 1; i <= S.length(); i++)
			for (int j = T.length(); j >= 1; j--)
				if (S.charAt(i - 1) == T.charAt(j - 1))
					match[j] += match[j - 1];
		return match[T.length()];
	}

	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit")); // shall return 3
		System.out.println(numDistinct("anacondastreetracecar", "contra")); // 6
		System.out.println(numDistinct("deella", "del")); // shall return 4
	}

}
