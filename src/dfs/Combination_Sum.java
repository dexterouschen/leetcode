package dfs;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Combination_Sum {

	public static ArrayList<ArrayList<Integer>> combinationSum(
			int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (candidates == null
				|| (candidates.length == 1 && candidates[0] > target)) {
			return lists;
		}
		Arrays.sort(candidates);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		dfs(set, solution, candidates, target);
		// copy from set to lists
		for (ArrayList<Integer> a : set) {
			lists.add(a);
		}
		return lists;
	}

	private static void dfs(Set<ArrayList<Integer>> set,
			ArrayList<Integer> solution, int[] candidates, int target) {
		for (int i = 0; i < candidates.length; i++) {
			// no answer if target is larger than the ith element in candidates
			if (target == candidates[i]) {
				ArrayList<Integer> aSolution = new ArrayList<Integer>(solution);
				aSolution.add(candidates[i]);
				Collections.sort(aSolution);
				set.add(aSolution);
				return;
			}
			if (target < candidates[i]) {
				return;
			} else {
				ArrayList<Integer> aSolution = new ArrayList<Integer>(solution);
				aSolution.add(candidates[i]);
				dfs(set, aSolution, candidates, target - candidates[i]);
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		ArrayList<ArrayList<Integer>> lists = combinationSum(candidates, target);
		System.out.println(lists);
	}
}
