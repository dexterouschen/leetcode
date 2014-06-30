package dfs;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/*
 Given a set of distinct integers, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */

public class Subsets {

	public static List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (S == null || S.length == 0) {
			return lists;
		}
		Arrays.sort(S);
		ArrayList<Integer> list = new ArrayList<Integer>();
		lists.add(list);
		dfs(lists, list, S, 0);
		return lists;
	}

	public static void dfs(List<List<Integer>> lists, List<Integer> list,
			int[] S, int index) {
		int len = S.length;
		if (index == len) {
			return;
		}
		for (int i = index; i < len; i++) {
			ArrayList<Integer> curList = new ArrayList<Integer>(list);
			curList.add(S[i]);
			lists.add(curList);
			dfs(lists, curList, S, i + 1);
		}
	}

	public static void main(String[] args) {
		int[] S = { 1, 2, 3};
		System.out.println(subsets(S));
	}

}
