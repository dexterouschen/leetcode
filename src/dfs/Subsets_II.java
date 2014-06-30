package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */

public class Subsets_II {

	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return lists;
		}
		Arrays.sort(num);
		ArrayList<Integer> list = new ArrayList<Integer>();

		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		set.add(list);
		dfs(set, list, num, 0);
		for (ArrayList<Integer> a : set) {
			lists.add(a);
		}
		return lists;
	}

	public static void dfs(Set<ArrayList<Integer>> lists,
			ArrayList<Integer> list, int[] num, int index) {
		int len = num.length;
		if (index == len) {
			return;
		}
		for (int i = index; i < len; i++) {
			ArrayList<Integer> curList = new ArrayList<Integer>(list);
			curList.add(num[i]);
			lists.add(curList);
			dfs(lists, curList, num, i + 1);
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 2 };
		ArrayList<ArrayList<Integer>> listA = subsetsWithDup(A);
		for (int i = 0; i < listA.size(); i++) {
			System.out.println(listA.get(i));
		}
	}
}
