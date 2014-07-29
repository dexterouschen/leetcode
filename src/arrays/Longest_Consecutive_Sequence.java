package arrays;

import java.util.HashSet;
import java.util.Set;

/*
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */

public class Longest_Consecutive_Sequence {
	/*
	 * The trick for this problem is how to find out if a number in the array
	 * (x) has consecutive numbers, meaning if there are x-1 or x+1 in the array
	 * as well. To reach a time complexity of O(n), searching for such
	 * neighboring elements must be O(1). One way to implement such search is
	 * through using a set because searching in a set is always O(1). For this
	 * problem, we may push all elements into a set and for each number (x)
	 * contained in, look for x-1 and x+1. Dynamically update the local and
	 * global maximum length.
	 */
	public static int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : num)
			set.add(i);
		int maxLen = 0;
		for (int i = 0; i < num.length; i++) {
			if (set.contains(num[i])) {
				int next = num[i] - 1;
				int count = 1;
				set.remove(num[i]);
				while (set.contains(next)) {
					set.remove(next);
					next--;
					count++;
				}
				next = num[i] + 1;
				while (set.contains(next)) {
					set.remove(next);
					next++;
					count++;
				}
				maxLen = Math.max(maxLen, count);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] A = { 100, 4, 200, 1, 3, 2 };
		int[] B = { 1, 2, 0, 1 };
		int[] C = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
		System.out.println(longestConsecutive(A)); // should be 4
		System.out.println(longestConsecutive(B)); // should be 3
		System.out.println(longestConsecutive(C)); // should be 7
	}

}
