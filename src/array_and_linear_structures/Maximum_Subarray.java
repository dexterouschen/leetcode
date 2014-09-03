package array_and_linear_structures;

/*
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 More practice:
 If you have figured out the O(n) solution,
 try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class Maximum_Subarray {
	/**
	 * This problem can be solved by greedily looking for the maximum of local
	 * sum. To solve this problem in O(n), two variables are needed: 
	 * (1) curSum: the sum of sub-array while traverse through the array; 
	 * (2) maxSum: the max of all sums of sub-arrays.
	 */
	public static int maxSubArrayGreedy(int[] A) {
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
			// The above for-loop can be replaced by this simple version
			// if (curSum < 0) {
			// curSum = 0;
			// }
			maxSum = Math.max(maxSum, curSum);
		}
		return maxSum;
	}

	/*
	 * Divide and conquer, O(lgn). The max range can be in the left half, or in
	 * the right half, or across the mid of the array, so we just divide it to
	 * tree parts and recursive until we get the max value of each part, and
	 * then get the largest value.
	 */
	public int maxSubArrayRecussion(int[] A) {
		int maxSum = Integer.MIN_VALUE;
		return findMaxSub(A, 0, A.length - 1, maxSum);
	}

	// recursive to find max sum
	// may appear on the left or right part, or across mid(from left to right)
	public int findMaxSub(int[] A, int left, int right, int maxSum) {
		if (left > right)
			return Integer.MIN_VALUE;
		// get max sub sum from both left and right cases
		int mid = (left + right) / 2;
		int leftMax = findMaxSub(A, left, mid - 1, maxSum);
		int rightMax = findMaxSub(A, mid + 1, right, maxSum);
		maxSum = Math.max(maxSum, Math.max(leftMax, rightMax));
		// get max sum of this range (case: across mid)
		// so need to expend to both left and right using mid as center
		// mid -> left
		int sum = 0, midLeftMax = 0;
		for (int i = mid - 1; i >= left; i--) {
			sum += A[i];
			if (sum > midLeftMax)
				midLeftMax = sum;
		}
		// mid -> right
		int midRightMax = 0;
		sum = 0;
		for (int i = mid + 1; i <= right; i++) {
			sum += A[i];
			if (sum > midRightMax)
				midRightMax = sum;
		}
		// get the max value from the left, right and across mid
		maxSum = Math.max(maxSum, midLeftMax + midRightMax + A[mid]);
		return maxSum;
	}

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] B = { -2, 0, -3, -4, -1, -2, -1, -5, -4 };
		int[] C = { -2, -1, -3, -4, -1, -2, -1, -5, -4 };
		int[] D = { 1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4 };
		System.out.println(maxSubArrayGreedy(A)); // should be 6
		System.out.println(maxSubArrayGreedy(B));// should be 0
		System.out.println(maxSubArrayGreedy(C));// should be -1
		System.out.println(maxSubArrayGreedy(D)); // should be 6
	}

}
