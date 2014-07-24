package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 Given n pairs of parentheses,
 write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Generate_Parentheses {

	/*
	 * Use deep-search algorithm to traverse through all possible combinations
	 * of left and right parenthesis.
	 */

	public final static char LEFT = '(';
	public final static char RIGHT = ')';

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		if (n <= 0) {
			return list;
		}
		StringBuffer sb = new StringBuffer();
		Set<String> set = new HashSet<String>();
		deepBuild(set, sb, n);
		for (String s : set) {
			list.add(s);
		}
		return list;
	}

	public static void deepBuild(Set<String> set, StringBuffer sb, int n) {
		if (sb.length() == n * 2 - 1 && isValidForRIGHT(sb)) {
			StringBuffer nsb = new StringBuffer(sb);
			nsb.append(RIGHT);
			set.add(nsb.toString());
			return;
		}
		if (isValidForLEFT(sb, n)) {
			StringBuffer lsb = new StringBuffer(sb);
			lsb.append(LEFT);
			deepBuild(set, lsb, n);
		}
		if (isValidForRIGHT(sb)) {
			StringBuffer rsb = new StringBuffer(sb);
			rsb.append(RIGHT);
			deepBuild(set, rsb, n);
		}
	}

	// if in sb, # of LEFT is larger than # of RIGHT
	public static boolean isValidForRIGHT(StringBuffer sb) {
		int l = 0, r = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == LEFT)
				l++;
			else
				r++;
		}
		return l > r ? true : false;
	}

	// if in sb, # of LEFT is smaller than n
	public static boolean isValidForLEFT(StringBuffer sb, int n) {
		int l = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == LEFT)
				l++;
		}
		return l < n ? true : false;
	}

	public static void main(String[] args) {
		List<String> list = generateParenthesis(3);
		System.out.println("Size: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
