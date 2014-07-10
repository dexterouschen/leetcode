package N_sum_questions;

import java.util.Arrays;

/*
 Given an array S of n integers,
 find three integers in S such that the sum is closest to a given number, target. 
 Return the sum of the three integers. 
 You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSum_Closest {

	public static int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) {
			return -1;
		}
		int sum = 0, diff = Integer.MAX_VALUE;
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			int[] newNum = getNewArray(num, i);
			int left = 0, right = newNum.length - 1;
			while (left < right) {
				int curDiff = Math.abs(target
						- (newNum[left] + newNum[right] + num[i]));
				if (curDiff < diff) {
					diff = curDiff;
					sum = newNum[left] + newNum[right] + num[i];
				}
				if (newNum[left] + newNum[right] < target - num[i]) {
					left++;
				} else {
					right--;
				}
			}
		}
		return sum;
	}

	private static int[] getNewArray(int[] num, int index) {
		int[] newArray = new int[num.length - 1];
		if (num.length == 1) {
			return newArray;
		}
		for (int i = 0; i < index; i++) {
			newArray[i] = num[i];
		}
		for (int i = index; i < num.length - 1; i++) {
			newArray[i] = num[i + 1];
		}
		return newArray;
	}

	public static void main(String[] args) {
		int[] A = { -1, 2, 1, -4 };
		int[] B = { -100, -5, 12, 2, 3, 4, 20 };
		int[] C = { 1, 1, 1, 0 };
		System.out.println(threeSumClosest(A, 1)); // should be 2
		System.out.println(threeSumClosest(B, 1)); // should be 1
		System.out.println(threeSumClosest(C, 100)); // should be 3
	}
}
