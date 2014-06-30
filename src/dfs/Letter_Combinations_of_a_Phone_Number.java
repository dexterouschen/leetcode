package dfs;

import java.util.ArrayList;

/*
 Given a digit string, return all possible letter combinations that the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class Letter_Combinations_of_a_Phone_Number {

	public static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> list = new ArrayList<String>();
		String[] dict = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
				"wxyz" }; // starting with "2"="abc", end with "9"="wxyz"
		if (digits == null || digits.length() == 0) {
			list.add("");
			return list;
		}
		StringBuffer strBuff = new StringBuffer();
		dfs(list, strBuff, dict, digits, 0);
		return list;
	}

	private static void dfs(ArrayList<String> list, StringBuffer strBuff,
			String[] dict, String digits, int curNumIndex) {
		if (curNumIndex == digits.length()) {
			list.add(strBuff.toString());
			return;
		}
		int curNum = Character.getNumericValue(digits.charAt(curNumIndex));
		if (curNum < 2) {
			dfs(list, strBuff, dict, digits, curNumIndex + 1);
			return;
		}
		String curDict = dict[curNum - 2];
		for (int i = 0; i < curDict.length(); i++) {
			StringBuffer newStrBuff = new StringBuffer(strBuff);
			newStrBuff.append(curDict.charAt(i));
			dfs(list, newStrBuff, dict, digits, curNumIndex + 1);
		}
	}

	public static void main(String[] args) {
		ArrayList<String> list = letterCombinations("239");
		System.out.println(list); // should be "ad", "ae", "af", "bd", "be",
									// "bf", "cd", "ce", "cf"
		System.out.println(list.size());
	}

}
