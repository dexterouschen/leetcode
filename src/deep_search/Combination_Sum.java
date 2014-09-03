package deep_search;

/*
 Given a set of candidate numbers (C) and a target number (T), 
 find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7, 
 A solution set is: 
 [7] 
 [2, 2, 3] 
 */

import java.util.*;

public class Combination_Sum {
	/**
	 * Run a deep-search algorithm that traverses through all possible
	 * combinations and return the result if target is found accumulatively.
	 */
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return lists;
		}
		Arrays.sort(candidates);
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int index = 0;
		deepSearch(set, list, candidates, target, index);
		for (ArrayList<Integer> l : set) {
			lists.add(l);
		}
		return lists;
	}

	public static void deepSearch(Set<ArrayList<Integer>> set, ArrayList<Integer> list,
			int[] candidates, int target, int index) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			ArrayList<Integer> nlist = new ArrayList<Integer>(list);
			set.add(nlist);
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			ArrayList<Integer> nlist = new ArrayList<Integer>(list);
			nlist.add(candidates[i]);
			deepSearch(set, nlist, candidates, target - candidates[i], i);
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		ArrayList<ArrayList<Integer>> lists = combinationSum(candidates, target);
		System.out.println(lists);
	}
}
