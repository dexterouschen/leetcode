package deep_search;

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

import java.util.*;

public class Combination_Sum_II {
	/**
	 * Run a deep-search algorithm that traverses through all possible
	 * combinations and return the result if target is found accumulatively.
	 */
	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
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
			deepSearch(set, nlist, candidates, target - candidates[i], i + 1);
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4, 5, 6 };
		int target = 7;
		System.out.println(combinationSum2(num, target));
	}

}
