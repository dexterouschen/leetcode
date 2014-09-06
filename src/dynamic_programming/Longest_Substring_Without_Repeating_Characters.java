package dynamic_programming;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*
 Given a string, find the length of the longest substring without repeating characters. 

 For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 which the length is 3.

 For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class Longest_Substring_Without_Repeating_Characters {
	/**
	 * Solution 1: DP approach.
	 * To be honest I'm not sure how it does the work.
	 * Here is the reference:
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

	/**
	 * Solution 2. The basic idea is as following: use a hashmap (must be a
	 * concurrent hashmap!!) to store continuous chars and their indexes in the
	 * string. If a conflict takes place, update global maximum length as the
	 * number of chars within the map. Then remove the chars whose indexes are
	 * smaller than the conflicting char's. Keep running this algorithm until
	 * all the chars in the string are visited.
	 */
	public static int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new ConcurrentHashMap<>();
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), i);
			} else { // conflict occurs
				maxLen = Math.max(maxLen, map.keySet().size());
				// remove chars whose indexes are smaller
				int curIndex = map.get(s.charAt(i));
				for (char c : map.keySet()) {
					if (map.get(c) < curIndex) {
						map.remove(c);
					}
				}
				map.put(s.charAt(i), i);// update conflicting char
			}
		}
		return Math.max(maxLen, map.keySet().size());
	}

	public static void main(String[] args) {
		String s1 = "qopubjguxhxdipfzwswybgfylqvjzhar";
		String s2 = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(lengthOfLongestSubstring2(s1)); // should be 12
		System.out.println(lengthOfLongestSubstring2(s2)); // should be 12
	}

}
