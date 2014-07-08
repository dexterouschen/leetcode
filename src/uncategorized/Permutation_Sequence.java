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

	/*
	 * Solve this problem by using induction method. Otherwise you may end up
	 * with a O(n!) time/space complexity.
	 */
	// 1st pick of number: index = k/(n-1)!, remain = k%(n-1)!
	// select the element at the index of the list of remaining numbers;
	// 2nd pick of number: index = remain/(n-2)!, remain = remain%(n-2)!
	// select the element at the index of the list of remaining numbers
	// ... 'i'th pick of number: index = (previous pick's remain)/(n-i)!
	// select the element at the index of the list of remaining numbers
	// ... stop when i == n
	public static String getPermutation(int n, int k) {
		int index = 1, remain = k - 1;
		StringBuffer sb = new StringBuffer();
		ArrayList<Integer> unUsedNums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			unUsedNums.add(i + 1);
		}
		while (index <= n) {
			int curTake = remain / getFactorial(n - index);
			sb.append(unUsedNums.get(curTake));
			unUsedNums.remove(curTake);
			remain = remain % getFactorial(n - index);
			index++;
		}
		return sb.toString();
	}

	public static int getFactorial(int x) {
		int factValue = 1;
		for (int i = 2; i <= x; i++) {
			factValue = factValue * i;
		}
		return factValue;
	}

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
