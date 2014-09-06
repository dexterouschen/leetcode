package dynamic_programming;

import java.util.*;

/*
 Given a string s and a dictionary of words dict,
 add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 */

public class Word_Break_II {
	/**
	 * You may easily get to a recursive solution (deep search) and think it as
	 * inefficient. Then you want to find out the DP solution of this problem,
	 * right? The truth is: you are for sure allowed to look for a DP solution,
	 * although this problem is not really a DP-type of problem because you 
	 * must store all the results of wordBreak(s[0, i], dict). When s[i + 1] is
	 * iterated, it must look up ALL results and decide if there are new strings
	 * that are needed to be added. In this way, you may prune the calculations
	 * and space for storage. But you can never get a real DP solution because you
	 * answer(i + 1) is not solely based on answer(i).
	 *
	 * The following calculation is a slightly-better-than-brute-force solution.
	 * It doesn't pass LeetCode OJ. But it is definitely a correct result.
	 */
	public static List<String> wordBreak(String s, Set<String> dict) {
		char SPACE = ' ';
		List<String> slist = new ArrayList<>();
		if (dict == null || dict.isEmpty() || s == null || s.length() == 0) {
			return slist;
		}
		List<StringBuilder> sblist = new ArrayList<>();
		// to store the indexes of previously found strings
		List<Integer> indexList = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			// check if s[0,i] is in dictionary
			if (dict.contains(s.substring(0, i + 1))) {
				StringBuilder sb = new StringBuilder();
				sb.append(s.substring(0, i + 1));
				sblist.add(sb);
				indexList.add(i);
			}
			// check if s[index, i] is in dictionary, index is a set of integers
			// before which substrings are found in dictionary
			for (int k = 0; k < indexList.size(); k++) {
				if (dict.contains(s.substring(indexList.get(k) + 1, i + 1))) {
					StringBuilder nsb = new StringBuilder(sblist.get(k));
					nsb.append(SPACE);
					nsb.append(s.substring(indexList.get(k) + 1, i + 1));
					sblist.add(nsb);
					indexList.add(i);
				}
			}
		}
		// filter from all StringBuilders to find out those which contains all
		// the characters in String s
		for (StringBuilder sb : sblist) {
			// System.out.println(sb.toString()); // testing
			StringBuilder sbCopy = new StringBuilder(sb);
			for (int i = 0; i < sbCopy.length(); i++) {
				if (sbCopy.charAt(i) == SPACE) {
					sbCopy.deleteCharAt(i);
				}
			}
			if (sbCopy.length() == s.length()) {
				slist.add(sb.toString());
			}
		}
		return slist;
	}

	/**
	 * A solution that can pass LeetCode OJ. it uses better pruning.
	 */
	public static ArrayList<String> wordBreak2(String s, Set<String> dict) {
		ArrayList<String> ret = new ArrayList<String>();
		if (s == null || s.length() == 0)
			return ret;
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			if (dict.contains(s.substring(0, i))) {
				dp[i] = true;
				continue;
			}
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
				}
			}
		}
		if (dp[n] == false)
			return ret; // DP? Sounds like a joke, right? It's just pruning.
		StringBuilder cur = new StringBuilder();
		dfs(s, 0, cur, ret, dict);
		return ret;
	}

	public static void dfs(String s, int start, StringBuilder cur, ArrayList<String> ret,
			Set<String> dict) {
		int n = s.length();
		if (start >= n) {
			ret.add(new String(cur));
			return;
		}
		for (int i = start + 1; i <= n; i++) {
			String sub = s.substring(start, i);
			if (dict.contains(sub)) {
				int oldLen = cur.length();
				if (oldLen != 0)
					cur.append(" ");
				cur.append(sub);
				dfs(s, i, cur, ret, dict);
				cur.delete(oldLen, cur.length());
			}
		}
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		dict.add("aaaa");
		dict.add("aaa");
		dict.add("aa");
		dict.add("a");
		System.out.println(wordBreak("catsanddog", dict));
		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", dict));
	}

}
