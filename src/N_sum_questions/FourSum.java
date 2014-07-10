package N_sum_questions;

import java.util.*;

/*
 Given an array S of n integers, are there elements a, b, c,
 and d in S such that a + b + c + d = target? 
 Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 */

public class FourSum {

	/*
	 * To solve this problem, the key step is to find out "two-sum". Once
	 * two-sum was found, the rest is to add other pairs of two number and make
	 * the final list. Another tricky task for this problem is to eliminate the
	 * duplicates. The overall complexity for a k-sum problem is at best:
	 * O(n^(k-1))
	 */

	// http://tech-wonderland.net/blog/summary-of-ksum-problems.html

	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> myLists = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 4) {
			return myLists;
		}
		Set<ArrayList<Integer>> set = new HashSet<>();
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			// Attention! To reduce redundancy j starts at i+1
			for (int j = i + 1; j < num.length; j++) {
				int left = 0, right = num.length - 1;
				while (left < right && left != i && left != j && right != i && right != j) {
					int curSum = num[left] + num[right];
					if (curSum == target - num[i] - num[j]) {
						ArrayList<Integer> nlist = new ArrayList<>();
						nlist.add(num[left]);
						nlist.add(num[right]);
						nlist.add(num[i]);
						nlist.add(num[j]);
						set.add(nlist);
						left++;
						right--;
					} else if (curSum > target - num[i] - num[j]) {
						right--;
					} else {
						left++;
					}
				}
			}
		}
		for (ArrayList<Integer> a : set) {
			Collections.sort(a);
			myLists.add(a);
		}
		return myLists;
	}

	// public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int
	// target) {
	// ArrayList<ArrayList<Integer>> myLists = new
	// ArrayList<ArrayList<Integer>>();
	// Arrays.sort(num); // {-2,-1, 0, 0, 1, 2}
	// Set<ArrayList<Integer>> set = new HashSet<>();
	// Set<Integer> visited = new HashSet<>();
	// ArrayList<Integer> list = new ArrayList<>();
	// search(set, list, visited, num, target);
	// for (ArrayList<Integer> a : set) {
	// myLists.add(a);
	// }
	// return myLists;
	// }
	//
	// private static void search(Set<ArrayList<Integer>> set,
	// ArrayList<Integer> list, Set<Integer> visited, int[] num,
	// int target) {
	// if (list.size() == 4) {
	// ArrayList<Integer> nlist = new ArrayList<Integer>(list);
	// if (getSum(nlist) == target) {
	// Collections.sort(nlist);
	// set.add(nlist);
	// }
	// return;
	// }
	// for (int i = 0; i < num.length && !visited.contains(i) && visited.size()
	// <= 4; i++) {
	// ArrayList<Integer> nlist = new ArrayList<Integer>(list);
	// nlist.add(num[i]);
	// Set<Integer> nvisited = new HashSet<>(visited);
	// nvisited.add(i);
	// search(set, nlist, nvisited, num, target);
	// }
	// }
	//
	// public static int getSum(ArrayList<Integer> list) {
	// int sum = 0;
	// for (int i : list) {
	// sum += i;
	// }
	// return sum;
	// }

	public static void main(String[] args) {
		int[] num1 = { 1, 0, -1, 0, -2, 2 };
		System.out.println(fourSum(num1, 0));
		// int[] num2 = { 1, 2, 0, -1, 3, -2, 2, 4 };
		// System.out.println(fourSum(num2, 3));
		// int[] num3 = { -493, -482, -482, -456, -427, -405, -392, -385, -351,
		// -269, -259, -251,
		// -235, -235, -202, -201, -194, -189, -187, -186, -180, -177, -175,
		// -156, -150, -147,
		// -140, -122, -112, -112, -105, -98, -49, -38, -35, -34, -18, 20, 52,
		// 53, 57, 76,
		// 124, 126, 128, 132, 142, 147, 157, 180, 207, 227, 274, 296, 311, 334,
		// 336, 337,
		// 339, 349, 354, 363, 372, 378, 383, 413, 431, 471, 474, 481, 492 };
		// System.out.println(fourSum(num3, 6189));

	}

}
