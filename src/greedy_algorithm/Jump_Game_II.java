package greedy_algorithm;

/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. 
 Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */

public class Jump_Game_II {

	public static int jump(int[] A) {
		int minStep = 0, reach = 0, maxDistance = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > reach) {
				reach = maxDistance;
				minStep++;
			}
			maxDistance = Math.max(maxDistance, i + A[i]);
		}
		return minStep;
	}

	public static void main(String[] args) {
		int[] A = { 3, 1, 2, 1, 4 };
		int[] B = { 2, 1, 1, 0, 4 };
		int[] C = { 1, 2 };
		int[] D = { 1, 2, 3 };
		System.out.println(jump(A)); // should return 2
		System.out.println(jump(B)); // should return 0
		System.out.println(jump(C)); // should return 1
		System.out.println(jump(D)); // should return 2
	}

}
