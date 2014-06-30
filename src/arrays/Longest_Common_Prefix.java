package arrays;

/*
 Write a function to find the longest common prefix string amongst an array of strings.
 */

public class Longest_Common_Prefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		int len = strs.length;
		// find the minimum string length among all strings
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			if (strs[i].length() < minLen) {
				minLen = strs[i].length();
			}
		}
		// find the index till which the prefix is same for all strings
		int index = 0;
		while (index < minLen && areSame(strs, index)) {
			index++;
		}
		char[] list = new char[index];
		for (int i = 0; i < index; i++) {
			list[i] = strs[0].charAt(i);
		}
		String prefix = new String(list);
		return prefix;
	}

	public static boolean areSame(String[] strs, int index) {
		char c = strs[0].charAt(index);
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].charAt(index) != c) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String a = "abcdefg";
		String b = "abcdfg";
		String c = "abcdg";
		String[] strs = new String[3];
		strs[0] = a;
		strs[1] = b;
		strs[2] = c;
		System.out.println(longestCommonPrefix(strs));
		String[] strs2 = new String[1];
		strs2[0] = "a";
		System.out.println(longestCommonPrefix(strs2));
	}

}
