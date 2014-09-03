package array_and_linear_structures;

/*
 Given a string S and a string T, find the minimum window in S
 which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always 
 be only one unique minimum window in S. 
 */

import java.util.*;

public class Minimum_Window_Substring {
	/**
	 * The main idea is to maintain two pointers which are called begin and end, 
	 * then use two HashMap to record current status, one record what char need to find,
	 * another used to record what has found. If the two HashMaps show current substring
	 * of S has contain all of the chars in T, then we try to shrink our start and end pointer.
	 */
	public static String minWindow(String S, String T) {
		if (S == null || T == null) {
			return null;
		}
		if ((S.length() == 0 && T.length() == 0) || (S.length() < T.length())) {
			return "";
		}
		HashMap<Character, Integer> needFind = new HashMap<Character, Integer>();
		HashMap<Character, Integer> alreadyFind = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			alreadyFind.put(T.charAt(i), 0);
			if (needFind.containsKey(T.charAt(i))) {
				needFind.put(T.charAt(i), needFind.get(T.charAt(i)) + 1);
			} else {
				needFind.put(T.charAt(i), 1);
			}
		}
		int minStart = -1;
		int minEnd = S.length();
		int start = 0, len = 0;
		for (int i = 0; i < S.length(); i++) {
			if (alreadyFind.containsKey(S.charAt(i))) {
				alreadyFind.put(S.charAt(i), alreadyFind.get(S.charAt(i)) + 1);
				if (alreadyFind.get(S.charAt(i)) <= needFind.get(S.charAt(i))) {
					len++;
				}
				if (len == T.length()) {
					while (!needFind.containsKey(S.charAt(start))
							|| alreadyFind.get(S.charAt(start)) > needFind.get(S.charAt(start))) {
						if (needFind.containsKey(S.charAt(start))) {
							alreadyFind.put(S.charAt(start), alreadyFind.get(S.charAt(start)) - 1);
						}
						start++;
					}
					if (i - start < minEnd - minStart) {
						minStart = start;
						minEnd = i;
					}
				}
			}
		}
		if (minStart == -1) {
			return "";
		}
		return S.substring(minStart, minEnd + 1);
	}

	/**
	 * Here is my O(n) strategy. 
	 * (1) Use two queues: charQ stores the first char in a window; indexQ stores the index of such char;
	 *     Be aware that queues are implemented as List for simplifying operations;
	 * (2) Iterate through String S, whenever a char that is in T is found, enqueue it into the two queues:
	 * (3) When charQ has all chars that are in T,
	 *     the length of a window is indexQ.lastElement() - indexQ.firstElement();
	 * (4) Remove (dequeue) the first elements of two queues;
	 * (5) Dynamically update the queues and hence update the length whenever a window is found.
	 *     Record at each update the minimum window's length, start and end.
	 * (6) As iteration is complete, find the minimum window's start and end and output the result.
	 */
	public static String minWindow2(String S, String T) {
		if (S == null || S.length() == 0 || S.length() < T.length()) {
			return "";
		}
		List<Integer> indexQ = new ArrayList<>();
		List<Character> charQ = new ArrayList<>();
		// build a table of T
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {
			if (!map.containsKey(T.charAt(i))) {
				map.put(T.charAt(i), 1);
			} else {
				map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
			}
		}
		int minLen = Integer.MAX_VALUE, minStart = -1, minEnd = -1;
		// main iteration loop
		for (int i = 0; i < S.length(); i++) {
			if (T.indexOf(S.charAt(i)) != -1) {
				indexQ.add(i);
				charQ.add(S.charAt(i));
			}
			if (hasAllChars(charQ, map, T)) {
				int start = indexQ.get(0), end = indexQ.size() == 1 ? start : indexQ.get(indexQ
						.size() - 1);
				indexQ.remove(0);
				charQ.remove(0);
				if (end - start + 1 < minLen) {
					minLen = end - start + 1;
					minStart = start;
					minEnd = end;
				}
			}
		}
		if (minStart == -1) {
			return "";
		}
		return S.substring(minStart, minEnd + 1);
	}

	public static boolean hasAllChars(List<Character> charQ, Map<Character, Integer> map, String T) {
		if (charQ.size() < T.length()) {
			return false;
		}
		Map<Character, Integer> nmap = new HashMap<>(map);
		for (int i = 0; i < charQ.size(); i++) {
			nmap.put(charQ.get(i), nmap.get(charQ.get(i)) - 1);
			if (nmap.get(charQ.get(i)) < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		// String S = "AA";
		// String T = "AA";
		System.out.println(minWindow(S, T));
	}

}
