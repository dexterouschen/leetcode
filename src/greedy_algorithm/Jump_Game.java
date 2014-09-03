package greedy_algorithm;

/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */

public class Jump_Game {
	/**
	 * Be careful with edge conditions in this problem. Implementation of the
	 * answer is straightforward: at each element in this array, update maximum
	 * reach until it can or cannot reaches the last.
	 */
	public static boolean canJump(int[] A) {
		if (A == null || A.length <= 1) {
			return true;
		}
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			if (max < i) {
				return false;
			}
			max = Math.max(max, A[i] + i);
			if (max >= A.length - 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 1, 1, 4 };
		int[] B = { 3, 2, 1, 0, 4 };
		System.out.println(canJump(A));
		System.out.println(canJump(B));
	}

}
