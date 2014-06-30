package dfs;

/*
 Given a collection of candidate numbers (C) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 A solution set is: 
 [1, 7] 
 [1, 2, 5] 
 [2, 6] 
 [1, 1, 6] 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Combination_Sum_II {

	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num,
			int target) {
		ArrayList<ArrayList<Integer>> myLists = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return myLists;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		for (int i = 0; i < num.length; i++) {
			dfs(set, list, num, target, i);
		}
		for (ArrayList<Integer> s : set) {
			myLists.add(s);
		}
		return myLists;
	}

	private static void dfs(Set<ArrayList<Integer>> set,
			ArrayList<Integer> list, int[] num, int target, int index) {
		if (index >= num.length || num[index] > target) {
			return;
		}
		ArrayList<Integer> nlist = new ArrayList<Integer>(list);
		nlist.add(num[index]);
		if (num[index] == target) {
			set.add(nlist);
			return;
		}
		for (int i = index + 1; i < num.length; i++) {
			dfs(set, nlist, num, target - num[index], i);
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4, 5, 6 };
		int target = 7;
		System.out.println(combinationSum2(num, target));
	}

}
