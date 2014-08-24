package uncategorized;

import java.util.*;

/*
 The set [1,2,3,бн,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 */

public class Permutation_Sequence {

	/**
	 * This problem can be solved by a deep-search algorithm with a time
	 * complexity of O(n!). A better solution can be reached iteratively as
	 * following: let the final answer of (n, k) be a number with each digit as:
	 * a1a2a3a4...an. What's the number that should be picked at a1 position?
	 * Think this way: if a1 is picked, then there are (n-1)! different
	 * combinations of a2 to an. According to the question, k must be a number
	 * between 0 and (n-1)! (you may prove this by taking a contradiction).
	 * Hence, the number at a1 position should be equal to the "k/(n-1)!"th
	 * number in array {1, 2, 3 ... n}. Then what should be picked at the second
	 * position a2? Let k2 = k % (n-1)!, it should be the "k2/(n-2)!"th number
	 * in array {1, 2, 3 ... n} (without the number picked at a1 position). Keep
	 * doing this operation until the remain of kx/(n-x)! == 0, in which case
	 * the remain of array is taken to fill up ax to an positions.
	 */
	public static String getPermutation(int n, int k) {
		if (n == 0 || k == 0 || k > factorial(n)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int remain = k - 1, count = 1; // remain = k - 1
		while (remain != 0 && count <= n) {
			int take = remain / factorial(n - count);
			remain = remain % factorial(n - count);
			sb.append(list.get(take));
			list.remove(take);
			count++;
		}
		if (!list.isEmpty()) { // if there are remaining elements in array
			for (int x : list) {
				sb.append(x);
			}
		}
		return sb.toString();
	}

	public static int factorial(int n) {
		int ans = 1;
		for (int i = n; i > 1; i--) {
			ans = ans * i;
		}
		return ans;
	}

	/**
	 * Deep search approach, O(n!) complexity. You may not want to use it.
	 */
	public static String getPermutationRecursion(int n, int k) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<Integer>();
		int[] narray = new int[n];
		for (int i = 0; i < n; i++) {
			narray[i] = i + 1;
		}
		permute(lists, list, n, narray, set);
		ArrayList<Integer> numList = new ArrayList<>();
		for (ArrayList<Integer> l : lists) {
			int ans = 0;
			for (int i = l.size() - 1; i >= 0; i--) {
				ans += (int) (l.get(i) * Math.pow(10, (l.size() - 1 - i)));
			}
			numList.add(ans);
		}
		int[] array = new int[numList.size()];
		for (int i = 0; i < numList.size(); i++) {
			array[i] = numList.get(i);
		}
		Arrays.sort(array);
		return String.valueOf(array[k - 1]);
	}

	public static void permute(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list, int n,
			int[] narray, Set<Integer> set) {
		if (list.size() == n) {
			ArrayList<Integer> nList = new ArrayList<Integer>(list);
			lists.add(nList);
			return;
		}
		for (int i : narray) {
			if (!set.contains(i)) {
				Set<Integer> nset = new HashSet<Integer>(set);
				ArrayList<Integer> nList = new ArrayList<Integer>(list);
				nList.add(i);
				nset.add(i);
				permute(lists, nList, n, narray, nset);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(getPermutation(3, 4)); // return "231"
		System.out.println(getPermutation(4, 11)); // return "2413"
	}

}
