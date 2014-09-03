package deep_search;

import java.util.*;

/*
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */

public class Palindrome_Partitioning {
	/**
	 * Deep search through all possible combinations of palindromes. Add
	 * substrings that are palindromes. Be careful with the parameters you pass
	 * into 'deepSearch()'. You may use indexes to reduce memory use, but simply
	 * passing in strings is easier for implementation and debug.
	 */
	public static List<List<String>> partition(String s) {
		List<List<String>> lists = new ArrayList<>();
		if (s == null || s.isEmpty()) {
			return lists;
		}
		List<String> list = new ArrayList<>();
		deepSearch(lists, list, s);
		return lists;
	}

	public static void deepSearch(List<List<String>> lists, List<String> list, String s) {
		if (s == null) {
			lists.add(list);
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String left = s.substring(0, i);
			String right = i == s.length() ? null : s.substring(i);
			if (isPalindrome(left)) {
				List<String> nlist = new ArrayList<String>(list);
				nlist.add(left);
				deepSearch(lists, nlist, right);
			}
		}
	}

	public static boolean isPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		int start = 0, end = s.length() - 1;
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			} else {
				start++;
				end--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		List<List<String>> myLists = partition("aab");
		System.out.println(myLists);
		System.out.println(myLists.size());
		// System.out.println(System.getProperty("java.runtime.version"));
	}

}
