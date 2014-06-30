package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */

public class Longest_Consecutive_Sequence {

	public static int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>();

		for (int i : num) {
			set.add(i);
		}
		int max = 0;

		for (int i = 0; i < num.length; i++) {
			if (set.contains(num[i])) {
				int next = num[i] - 1; // �ұ�num[i]Сһ����ֵ
				int count = 1;
				set.remove(num[i]); // ��ʱ���Ƴ�������֮��Ĳ���ʱ��?
				while (set.contains(next)) {
					set.remove(next);
					next--;
					count++;
				}
				next = num[i] + 1; // �ұ�num[i]��һ����ֵ
				while (set.contains(next)) {
					set.remove(next);
					next++;
					count++;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = { 100, 4, 200, 1, 3, 2 };
		int[] B = { 1, 2, 0, 1 };
		int[] C = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
		System.out.println(longestConsecutive(A)); // should be 4
		System.out.println(longestConsecutive(B)); // should be 3
		System.out.println(longestConsecutive(C)); // should be 7
	}

}
