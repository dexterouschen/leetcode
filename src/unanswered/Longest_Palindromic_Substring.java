package unanswered;

/*
 Given a string S, find the longest palindromic substring in S. 
 You may assume that the maximum length of S is 1000, 
 and there exists one unique longest palindromic substring.
 */

public class Longest_Palindromic_Substring {

	public static String longestPalindrome(String s) {
		int maxLength = 0;
		String longest = "";
		for (int i = 0; i < s.length(); i++) {
			// odd condition
			int left = i, right = i;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				if (maxLength < right - left + 1) {
					maxLength = right - left + 1;
					longest = s.substring(left, right + 1);
				}
				left--;
				right++;
			}
			// even condition
			left = i;
			right = i + 1;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				if (maxLength < right - left + 1) {
					maxLength = right - left + 1;
					longest = s.substring(left, right + 1);
				}
				left--;
				right++;
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccb"));
	}

}
