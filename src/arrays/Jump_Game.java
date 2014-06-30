package arrays;

/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */

public class Jump_Game {

	public static boolean canJump(int[] A) {
		int canReach = 0;
		for (int i = 0; i < A.length && i <= canReach; i++) {
			if (i + A[i] > canReach) {
				canReach = i + A[i];
			}
			if (canReach >= A.length - 1) {
				return true;
			}
		}
		return (canReach >= A.length - 1);
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 1, 1, 4 };
		int[] B = { 3, 2, 1, 0, 4 };
		System.out.println(canJump(A));
		System.out.println(canJump(B));
	}

}
