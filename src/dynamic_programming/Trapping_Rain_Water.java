package dynamic_programming;

/*
 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.

 For example, 
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class Trapping_Rain_Water {
	/*
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
		leftMax[A.length - 1] = 0;
		rightMax[0] = 0;
		rightMax[A.length - 1] = 0;
		// build the list for each element's left-side maximum
		for (int i = 1; i < A.length - 1; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], A[i - 1]);
		}
		// build the list for each element's right-side maximum
		for (int i = A.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], A[i + 1]);
		}
		// figure out the volume that each element can hold
		int vol = 0;
		for (int i = 0; i < A.length; i++) {
			vol += (Math.min(leftMax[i], rightMax[i]) - A[i] > 0) ? Math.min(leftMax[i],
					rightMax[i]) - A[i] : 0;
		}
		return vol;
	}

	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(A)); // should be 6
	}

}
