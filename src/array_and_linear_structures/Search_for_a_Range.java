package array_and_linear_structures;

import java.util.*;

/*
 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */

public class Search_for_a_Range {
	/**
	 * Use binary search to solve this problem. First check if target can be
	 * found in this array. Once it's found, run binary search for its left side
	 * and right side to find out if there is any elements that are the same as
	 * the target.
	 */
	public static int[] searchRange(int[] A, int target) {
		int[] range = new int[2];
		Arrays.fill(range, -1);
		if (A == null || A.length == 0) {
			return range;
		}
		int left = 0, right = A.length - 1;
		int leftBound = -1, rightBound = -1;
		// find first mid point that's equal to target
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == target) {
				leftBound = mid;
				rightBound = mid;
				break;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (left > right) { // if not found
			return range;
		}
		// search/update leftBound between left and mid
		int start = left, end = leftBound - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target) {
				leftBound = Math.min(leftBound, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		// search/update rightBound between mid and right
		start = rightBound + 1;
		end = right;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target) {
				rightBound = Math.max(rightBound, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		range[0] = leftBound;
		range[1] = rightBound;
		return range;
	}

	public static void main(String[] args) {
		int[] A = { 1, 5 };
		int target = 4;
		System.out.println(searchRange(A, target)[0] + " " + searchRange(A, target)[1]);
	}

}
