package dynamic_programming;

/*
 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.

 For example, 
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class Trapping_Rain_Water {
	/**
	 * The trick of solving this problem is to keep two lists that stores in the
	 * ith element's the left-side maximum and right-side maximum. The volume of
	 * water that can be held at the ith element in the input array is then
	 * found as Math.min(leftMax[i], rightMax[i]) - A[i] (accumulate only if
	 * it's a positive value).
	 */
	public static int trap(int[] A) {
		if (A == null || A.length < 3)
			return 0;
		int[] leftMax = new int[A.length], rightMax = new int[A.length];
		leftMax[0] = 0;
		rightMax[A.length - 1] = 0;
		int water = 0;
		// build the list for each element's dual-side maximum
		for (int i = 1; i < A.length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], A[i - 1]);
			rightMax[A.length - 1 - i] = Math.max(rightMax[A.length - i], A[A.length - i]);
		}
		// figure out the volume that each element can hold
		for (int i = 0; i < A.length; i++) {
			water += Math.max(0, Math.min(leftMax[i], rightMax[i]) - A[i]);
		}
		return water;
	}

	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(A)); // should be 6
	}

}
