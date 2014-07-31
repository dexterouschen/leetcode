package deep_search;

import java.util.*;

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
	/*
	 * Two tricks for reducing redundant calculations: (1) sort the int array
	 * 'S' before running a deep search. This makes the array lists in-order;
	 * (2) pass in an index that tells deep search to search from left to right
	 * without looking at elements that has already been search for each branch.
	 */
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.length == 0)
			return lists;
		Set<ArrayList<Integer>> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		set.add(list);
		Arrays.sort(S); // trick is here!
		int index = 0;
		deepSearch(set, list, S, index); // pass an index into deep search
		for (ArrayList<Integer> l : set)
			lists.add(l);
		return lists;
	}

	public static void deepSearch(Set<ArrayList<Integer>> set, ArrayList<Integer> list, int[] S,
			int index) {
		if (index == S.length || list.size() == S.length)
			return;
		for (int i = index; i < S.length; i++) {
			ArrayList<Integer> alist = new ArrayList<Integer>();
			alist.add(S[i]);
			set.add(alist);
			ArrayList<Integer> nlist = new ArrayList<Integer>(list);
			nlist.add(S[i]);
			set.add(nlist);
			deepSearch(set, nlist, S, i + 1);
		}
	}

	public static void main(String[] args) {
		int[] S = { 1, 2, 3 };
		System.out.println(subsets(S));
	}

}
