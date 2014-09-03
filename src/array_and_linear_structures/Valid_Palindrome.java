package array_and_linear_structures;

/*
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */

public class Valid_Palindrome {
	/**
	 * Yes, I know this problem sounds really straightforward and easy. The
	 * basic idea is of course to use two pointers to scan the string from each
	 * end of a string. But how do you do it considering "only alphanumeric
	 * characters"? The trick is shown below, just a single line of code and
	 * that does it.
	 */
	public static boolean isPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int len = str.length();
		int left = 0, right = len - 1;
		while (left <= right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
		System.out.println(isPalindrome("race a car")); // false
	}

}
