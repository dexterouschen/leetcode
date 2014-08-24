package recursion;

/*
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */

import java.util.*;

public class Combinations {
	/**
	 * Intuitively, a deep-search can generate the results by traversing through
	 * all situations. But this problem can be solved in a better way: divide it
	 * into two sub problems as combine(n, k) = combine(n-1, k) + combine(n-1,
	 * k-1).addAll(n).
	 */
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		if (n <= 0 || k <= 0 || n < k) {
			ArrayList<Integer> list = new ArrayList<>();
			lists.add(list);
			return lists;
		}
		if (n == k) { // base case
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				list.add(i);
			}
			lists.add(list);
		} else { // recursion
			ArrayList<ArrayList<Integer>> subProblem1 = combine(n - 1, k);
			ArrayList<ArrayList<Integer>> subProblem2 = combine(n - 1, k - 1);
			for (ArrayList<Integer> l : subProblem2) {
				l.add(n);
			}
			lists.addAll(subProblem1);
			lists.addAll(subProblem2);
		}
		return lists;
	}

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
	}

}
