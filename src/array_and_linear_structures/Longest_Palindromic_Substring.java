package array_and_linear_structures;

/*
 Given a string S, find the longest palindromic substring in S. 
 You may assume that the maximum length of S is 1000, 
 and there exists one unique longest palindromic substring.
 */

public class Longest_Palindromic_Substring {

	/**
	 * Starting at each position in the string, and then look for its largest
	 * palindromic substring. Please be noted that two conditions: palindromic
	 * string with an odd number of central char and even number of central
	 * chars. This algorithm has a complexity of O(n^2). Be noted that using a
	 * stack is not applicable in this problem. You must traverse the
	 * full-length of the string to know if there is palindrome.
	 */
	public static String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		String ans = "";
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) { // for odd
			int extend = 0;
			while (i - extend - 1 >= 0 && i + (extend + 1) < s.length()
					&& s.charAt(i - extend - 1) == s.charAt(i + extend + 1)) {
				extend++;
			}
			if (2 * extend + 1 > maxLen) {
				ans = s.substring(i - extend, i + extend + 1);
				maxLen = 2 * extend + 1;
			}
		}
		for (int i = 0; i < s.length() - 1; i++) { // for even
			if (s.charAt(i) == s.charAt(i + 1)) {
				int extend = 0;
				while (i - extend - 1 >= 0 && i + 2 + extend < s.length()
						&& s.charAt(i - extend - 1) == s.charAt(i + 2 + extend)) {
					extend++;
				}
				if (2 * extend + 2 > maxLen) {
					ans = s.substring(i - extend, i + extend + 2);
					maxLen = 2 * extend + 2;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccb"));
	}

}
