package deep_search;

import java.util.*;

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
	/*
	 * Two tricks for reducing redundant calculations: (1) sort the int array
	 * 'S' before running a deep search. This makes the array lists in-order;
	 * (2) pass in an index that tells deep search to search from left to right
	 * without looking at elements that has already been search for each branch.
	 */
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0)
			return lists;
		Set<ArrayList<Integer>> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		set.add(list);
		Arrays.sort(num); // trick is here!
		int index = 0;
		deepSearch(set, list, num, index); // pass an index into deep search
		for (ArrayList<Integer> l : set)
			lists.add(l);
		return lists;
	}

	public static void deepSearch(Set<ArrayList<Integer>> set, ArrayList<Integer> list, int[] num,
			int index) {
		if (index == num.length || list.size() == num.length)
			return;
		for (int i = index; i < num.length; i++) {
			ArrayList<Integer> alist = new ArrayList<Integer>();
			alist.add(num[i]);
			set.add(alist);
			ArrayList<Integer> nlist = new ArrayList<Integer>(list);
			nlist.add(num[i]);
			set.add(nlist);
			deepSearch(set, nlist, num, i + 1);
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
