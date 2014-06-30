package dynamic_programming;

/*
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */

public class Palindrome_Partitioning_II {

	public static int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		int[] cuts = new int[len + 1];
		for (int i = 0; i < len + 1; i++) {
			cuts[i] = len - i;
		}
		boolean[][] matrix = new boolean[len][len];
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (((s.charAt(i) == s.charAt(j) && (j - i < 2)) || (s
						.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1] == true))) {
					matrix[i][j] = true;
					cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
				}
			}
		}
		return cuts[0] - 1;
	}

	public static void main(String[] args) {
		String s = "efe";
		System.out.println(minCut(s));
	}

}
