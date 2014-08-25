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

	/**
	 * Any N-sum problem is essentially a "two-sum" problem. First let's take a
	 * look at how to solve a "two-sum" problem. The optimal way to solve it is
	 * by sorting the array in O(nlogn) complexity. Then we can use two pointers
	 * moving from the start and the end of the array to search for the target
	 * by comparing array[left-pointer] + array[right-pointer] with target. This
	 * method has been proven mathematically optimal. For any other N-sum, for
	 * example "3-sum", can be seen as for each element "i" in the array, do a
	 * two sum with the target value = target - array[i]. This gives a
	 * complexity of O(n^(k-1) logn), k is the number of elements the problem
	 * asks to sum up. Be careful if there are duplicates in such number array.
	 */
	public static int[] twoSum(int[] numbers, int target) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		// record each element's index
		for (int i = 0; i < numbers.length; i++) {
			if (!map.containsKey(numbers[i])) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i + 1);
				map.put(numbers[i], list);
			} else {
				ArrayList<Integer> list = map.get(numbers[i]);
				list.add(i + 1);
				map.put(numbers[i], list);
			}
		}
		Arrays.sort(numbers); // sort the array
		int left = 0, right = numbers.length - 1;
		while (left < right) { // use two pointers to find the target
			if (numbers[left] + numbers[right] == target) {
				break;
			}
			if (numbers[left] + numbers[right] < target) {
				left++;
			}
			if (numbers[left] + numbers[right] > target) {
				right--;
			}
		}
		int[] ans = new int[2];
		int ans1 = map.get(numbers[left]).get(0);
		map.get(numbers[left]).remove(0); // in case there are duplicates
		int ans2 = map.get(numbers[right]).get(0);
		ans[0] = ans1 > ans2 ? ans2 : ans1;
		ans[1] = ans1 < ans2 ? ans2 : ans1;
		return ans;
	}

	public static void main(String[] args) {
		int[] numbers = { 7, 2, 11, 15, 2 };
		int[] ans = twoSum(numbers, 4);
		System.out.println(ans[0] + " " + ans[1]);
	}

}
