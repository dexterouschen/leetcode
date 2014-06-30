package arrays;

import java.util.ArrayList;

/*
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 More practice:
 If you have figured out the O(n) solution,
 try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Maximum_Subarray {

	public Maximum_Subarray() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * This problem can be solved by greedily looking for the maximum of local
	 * sum.
	 */
	/*
	 * To solve this problem in O(n), two varibles are needed: (1) curSum: the
	 * sum of subarray while traverse through the array; (2) maxSum: the max of
	 * all sums of subarrays.
	 */
	public static int maxSubArray(int[] A) {
		int len = A.length;
		if (len <= 0) {
			return 0;
		}
		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;
		for (int i = 0; i < len; i++) {
			curSum += A[i];
			if (A[i] > curSum) {
				curSum = A[i];
			}
			if (curSum > maxSum) {
				maxSum = curSum;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] B = { -2, 0, -3, -4, -1, -2, -1, -5, -4 };
		int[] C = { -2, -1, -3, -4, -1, -2, -1, -5, -4 };
		int[] D = { 1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4 };
		System.out.println(maxSubArray(A)); // should be 6
		System.out.println(maxSubArray(B));// should be 0
		System.out.println(maxSubArray(C));// should be -1
		System.out.println(maxSubArray(D)); // should be 6
	}

}
