package unanswered;

/*
 You are given a string, S, and a list of words, L,
 that are all of the same length. Find all starting indices of substring(s) in S
 that is a concatenation of each word in L exactly once and without any intervening characters.

 For example, given:
 S: "barfoothefoobarman"
 L: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter). 
 */

import java.util.*;

public class Substring_with_Concatenation_of_All_Words {
	/**
	 * Iterate through String s, check if S.substring(i) has all the strings in L. 
	 * Remember the sum of all strings in L is known (because they're in the 
	 * same length). So each time we just need to check whether 
	 * S.substring(i, i + totalLen + 1) has all the strings in L. Use a hash-map 
	 * to expedite this process.
	 */
	public static List<Integer> findSubstring(String S, String[] L) {
		List<Integer> list = new ArrayList<Integer>();
		int len = L.length;
		if (len == 0) {
			return list;
		}
		int wordLen = L[0].length();
		Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		for (int i = 0; i < len; i++) {
			int num = 1;
			if (wordsMap.get(L[i]) != null) {
				num += wordsMap.get(L[i]);
			}
			wordsMap.put(L[i], num);
		}
		int slen = S.length();
		int max = slen - len * wordLen + 1;
		for (int i = 0; i < max; i++) {
			Map<String, Integer> numMap = new HashMap<String, Integer>();
			int j = 0;
			for (; j < len; j++) {
				int start = i + j * wordLen;
				int end = start + wordLen;
				String tempStr = S.substring(start, end);
				if (!wordsMap.containsKey(tempStr)) {
					break;
				}
				int num = 1;
				if (numMap.get(tempStr) != null) {
					num += numMap.get(tempStr);
				}
				if (num > wordsMap.get(tempStr)) {
					break;
				}
				numMap.put(tempStr, num);
			}
			if (j == len) {
				list.add(i);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		String[] L = { "foo", "bar" };
		System.out.println(findSubstring(S, L));
	}

}
