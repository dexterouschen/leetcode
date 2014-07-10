package N_sum_questions;

import java.util.*;

/*
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, 
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */

public class Two_sum {

	/*
	 * Be careful if there are duplicates in such number array.
	 */

	public static int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;
		}
		int[] ans = new int[2];
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < numbers.length; i++) {
			if (!map.containsKey(numbers[i])) {
				ArrayList<Integer> indexList = new ArrayList<>();
				map.put(numbers[i], indexList);
			}
			ArrayList<Integer> nlist = map.get(numbers[i]);
			nlist.add(i);
			map.put(numbers[i], nlist);
		}
//		for (int a : map.keySet()) {
//			System.out.println("key: " + a + "; val: " + map.get(a));
//		}
		Arrays.sort(numbers);
		int left = 0, right = numbers.length - 1;
		while (left < right) {
			if (numbers[left] + numbers[right] == target) {
				int x1 = map.get(numbers[left]).get(0);
				int x2;
				if (numbers[right] != numbers[left]) {
					x2 = map.get(numbers[right]).get(0);
				} else {
					x2 = map.get(numbers[right]).get(1);
				}
				ans[0] = Math.min(x1, x2) + 1;
				ans[1] = Math.max(x1, x2) + 1;
				break;
			} else if (numbers[left] + numbers[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] numbers = { 7, 2, 11, 15, 2 };
		int[] ans = twoSum(numbers, 4);
		System.out.println(ans[0] + " " + ans[1]);
	}

}
