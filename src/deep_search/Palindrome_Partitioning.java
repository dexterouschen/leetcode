package deep_search;

import java.util.ArrayList;

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

	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> myLists = new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			list.add("");
			myLists.add(list);
			return myLists;
		}
		dfs(myLists, list, s);
		return myLists;
	}

	private static void dfs(ArrayList<ArrayList<String>> myLists, ArrayList<String> list, String str) {
		// ������������ַ������ȵ���0,���������list�������������뵽�������
		if (str.length() == 0)
			myLists.add(new ArrayList<String>(list));
		int len = str.length();
		// �ݹ����
		// �ַ�����ǰ�������ж�str.substring(0, i)�Ƿ��ǻ����ַ���
		// ����ǵĻ����������ú���calResult����str.substring(i)�ַ�������������
		for (int i = 1; i <= len; ++i) {
			String subStr = str.substring(0, i);
			if (isPalindrome(subStr)) {
				list.add(subStr);
				String restSubStr = str.substring(i);
				dfs(myLists, list, restSubStr);
				list.remove(list.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String str) {
		if (str.length() == 1) {
			return true;
		}
		int start = 0, end = str.length() - 1;
		while (start <= end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> myLists = partition("aab");
		System.out.println(myLists);
		System.out.println(myLists.size());
		// System.out.println(System.getProperty("java.runtime.version"));
	}

}
