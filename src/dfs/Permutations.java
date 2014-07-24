package dfs;

import java.util.*;

/*
 Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {

	/*
	 * Deep search algorithm solves this problem. Use a set to remove
	 * duplicates.
	 */
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		if (num == null || num.length == 0) {
			return lists;
		}
		ArrayList<Integer> list = new ArrayList<>();
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		HashMap<Integer, Boolean> taken = new HashMap<Integer, Boolean>();
		for (int i = 0; i < num.length; i++) {
			taken.put(i, false);
		}
		deepSearch(set, list, num, taken);
		for (ArrayList<Integer> a : set) {
			lists.add(a);
		}
		return lists;
	}

	public static void deepSearch(HashSet<ArrayList<Integer>> set, ArrayList<Integer> list,
			int[] num, HashMap<Integer, Boolean> taken) {
		if (list.size() == num.length - 1) {
			ArrayList<Integer> nlist = new ArrayList<Integer>(list);
			for (int a : taken.keySet()) {
				if (taken.get(a) == false) {
					nlist.add(num[a]);
				}
			}
			set.add(nlist);
			return;
		}
		for (int a : taken.keySet()) {
			if (taken.get(a) == false) {
				ArrayList<Integer> nlist = new ArrayList<Integer>(list);
				HashMap<Integer, Boolean> ntaken = new HashMap<>(taken);
				nlist.add(num[a]);
				ntaken.put(a, true);
				deepSearch(set, nlist, num, ntaken);
			}
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		ArrayList<ArrayList<Integer>> list = permute(num);
		System.out.println(list);
	}
}
