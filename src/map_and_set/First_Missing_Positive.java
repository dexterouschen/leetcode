package map_and_set;

import java.util.*;

/*
 Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */

public class First_Missing_Positive {
	/**
	  * Build a map that contains all values of "A". Positive elements that
	  * appear in A will be counted as 1 or more in map. Each element's
	  * neighbors (+/-1) are counted as 0. The answer will be the smallest
	  * element in this map that are mapped as 0.
	  */
	public static int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (!map.containsKey(A[i])) { // map doesn't have A[i]
				map.put(A[i], 1);
				if (A[i] - 1 > 0 && !map.containsKey(A[i] - 1)) {
					map.put(A[i] - 1, 0);
				}
				if (A[i] + 1 > 0 && !map.containsKey(A[i] + 1)) {
					map.put(A[i] + 1, 0);
				}
			} else { // map has A[i] already
				int nVal = map.get(A[i]) + 1;
				map.put(A[i], nVal);
				if (A[i] - 1 > 0 && !map.containsKey(A[i] - 1)) {
					map.put(A[i] - 1, 0);
				}
				if (A[i] + 1 > 0 && !map.containsKey(A[i] + 1)) {
					map.put(A[i] + 1, 0);
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i : map.keySet()) {
			if (i < result && map.get(i) == 0) {
				result = i;
			}
		}
		if (map.containsKey(1)) {
			return result;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		int[] A1 = { 1, 2, 3, 4, 5, 7, 8, 9 };
		System.out.println(firstMissingPositive(A1)); // should be 6
		int[] A2 = { 4, 100 };
		System.out.println(firstMissingPositive(A2)); // should be 1
		int[] A3 = { 1, 1000 };
		System.out.println(firstMissingPositive(A3)); // should be 2
		int[] A4 = { 1, 2 };
		System.out.println(firstMissingPositive(A4)); // should be 3
	}

}
