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
	 * found as Math.min(maxL[i], maxR[i]) - A[i] (accumulate only if it's a
	 * positive value).
	 */
	public static int trap(int[] A) {
		if (A == null || A.length < 2) {
			return 0;
		}
		int len = A.length;
		int[] maxL = new int[len], maxR = new int[len];
		// build the list for each element's left-side maximum
		int max = A[0];
		maxL[0] = 0;
		for (int i = 1; i < len - 1; i++) {
			maxL[i] = max;
			if (max < A[i]) {
				max = A[i];
			}
		}
		// build the list for each element's right-side maximum
		max = A[len - 1];
		maxR[len - 1] = 0;
		for (int i = len - 2; i > 0; i--) {
			maxR[i] = max;
			if (max < A[i]) {
				max = A[i];
			}
		}
		// for(int i=0;i<len;i++){
		// System.out.println(maxL[i]);
		// System.out.println(maxR[i]);
		// }
		// figure out the volume that each element can hold
		int curTrap, totalTrap = 0;
		for (int i = 1; i < len - 1; i++) {
			curTrap = Math.min(maxL[i], maxR[i]) - A[i];
			if (curTrap > 0) {
				totalTrap += curTrap;
			}
		}
		return totalTrap;
	}

	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] B = { 2, 0, 2 };
		System.out.println(trap(A)); // should be 6
	}

}
