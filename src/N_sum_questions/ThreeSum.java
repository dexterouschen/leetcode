package N_sum_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */

public class ThreeSum {

	/*
	 * Please check the answer for "Two Sum" for more detailed explanation. To
	 * solve this problem, start with a typical 2-sum algorithm (the "while"
	 * loop below). First sort the int[] num, then look for a 2-sum that have a
	 * sum equal to the negative of num[i].
	 */
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		Set<ArrayList<Integer>> set = new HashSet<>();
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			// running a two-sum algorithm
			int left = 0, right = num.length - 1;
			while (left < right) {
				if (left == i) {
					left++;
					continue;
				} else if (right == i) {
					right--;
					continue;
				}
				if (num[left] + num[right] == 0 - num[i]) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(num[left]);
					list.add(num[right]);
					list.add(num[i]);
					Collections.sort(list);
					set.add(list);
					left++;
					right--;
				} else if (num[left] + num[right] < 0 - num[i]) {
					left++;
				} else {
					right--;
				}
			}
		}
		for (ArrayList<Integer> list : set) {
			ans.add(list);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] C = { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1,
				-14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1,
				4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0,
				-4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8,
				10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6 };

		long startTime = System.currentTimeMillis();
		ArrayList<ArrayList<Integer>> listsC = threeSum(C);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;

		int count = 0;
		for (ArrayList<Integer> a : listsC) {
			System.out.println(a);
			count++;
		}
		System.out.println("\nNumber of answers: " + count);
		System.out.println("Runtime is: " + totalTime);
	}
}
