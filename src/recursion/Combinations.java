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

import java.util.ArrayList;

public class Combinations {

	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (n < k || n < 1 || k < 1) {
			return null;
		}
		if (n == k) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++) {
				list.add(i);
			}
			lists.add(list);
			return lists;
		}
		if (k == 1) {
			for (int i = 1; i <= n; i++) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				lists.add(list);
			}
			return lists;
		}
		ArrayList<ArrayList<Integer>> listOfLessBase = combine(n - 1, k);
		ArrayList<ArrayList<Integer>> listOfLessPick = combine(n - 1, k - 1);
		for (ArrayList<Integer> a : listOfLessPick) {
			a.add(n);
		}
		lists.addAll(listOfLessBase);
		lists.addAll(listOfLessPick);
		return lists;
	}

	public static void main(String[] args) {
		System.out.println(combine(1, 1));
	}

}
