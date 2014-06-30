package dynamic_programming;

import java.util.HashSet;
import java.util.Set;

/*
 Given a string, find the length of the longest substring without repeating characters. 

 For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 which the length is 3.

 For "bbbbb" the longest substring is "b", with the length of 1.
 */
import java.util.*;

public class Longest_Substring_Without_Repeating_Characters {

	/*
	 * http://blog.csdn.net/likecool21/article/details/10858799
	 */

	public static int len = 0;

	public static int lengthOfLongestSubString_Leetcode(String s) {
		int length = s.length();
		if (length == 0) {
			return 0;
		}
		int[] countTable = new int[256];
		Arrays.fill(countTable, -1);
		int max = 1;
		int start = 0;
		int end = 1;

		countTable[s.charAt(0)] = 0;
		while (end < length) {
			// Has not reached a duplicate char
			if (countTable[s.charAt(end)] >= start) {
				start = countTable[s.charAt(end)] + 1;
			}
			max = Math.max(max, end - start + 1);
			countTable[s.charAt(end)] = end;
			end++;
		}
		return max;
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<Character>();
		HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (!map.containsKey(s.charAt(i))) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(s.charAt(i), list);
			} else {
				map.get(s.charAt(i)).add(i);
			}
		}
		int max = 0;
		for (int i = 0; i < len; i++) {
			if (set.contains(s.charAt(i))) {
				if (set.size() > max) {
					max = set.size();
				}
				set.clear();
				i = map.get(s.charAt(i)).get(
						map.get(s.charAt(i)).indexOf(i) - 1);
				continue;
			} else {
				set.add(s.charAt(i));
			}
		}
		return max;
	}

	// ================= Old Codes =================
	public static int lengthOfLongestSubstringRecurssion(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<Character>();
		dfs(s, set, 0);
		return len;
	}

	public static void dfs(String str, Set<Character> set, int index) {
		if (index >= str.length() - 1) {
			return;
		}
		if (set.size() > len) {
			len = set.size();
		}
		for (int i = index; i < str.length(); i++) {
			if (!set.contains(str.charAt(i))) {
				set.add(str.charAt(i));
				dfs(str, set, i + 1);
			} else {
				set = new HashSet<Character>(str.charAt(i));
				dfs(str, set, i + 1);
			}
		}
	}

	// ============================================

	public static void main(String[] args) {
		// String s1 = "abcabcbb";
		// System.out.println(lengthOfLongestSubstringRecurssion(s1)); // should
		// be 3
		//
		// String s2 =
		// "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		// System.out.println(lengthOfLongestSubstringRecurssion(s2)); // should
		// be 12

		// String s1 = "abcabcbb";
		// System.out.println(lengthOfLongestSubstring(s1)); // should be 3

		String s2 = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(lengthOfLongestSubstring(s2)); // should be 12

	}

}
