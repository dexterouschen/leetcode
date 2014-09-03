package deep_search;

import java.util.*;

/*
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */

public class Permutations_II {

	public static List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> myLists = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		List<Integer> list = new ArrayList<Integer>();
		if (num == null || num.length == 0) {
			return myLists;
		}
		Arrays.sort(num); // sort the array to help handle duplicated elements
		dfs(set, list, num);
		for (List<Integer> x : set) {
			myLists.add(x);
		}
		return myLists;
	}

	private static void dfs(Set<List<Integer>> set, List<Integer> list, int[] num) {
		if (num == null) {
			set.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			List<Integer> newList = new ArrayList<Integer>(list);
			newList.add(num[i]);
			int[] newNum = toSubArray(num, i);
			dfs(set, newList, newNum);
		}
	}

	private static int[] toSubArray(int[] original, int index) {
		if (original == null || original.length <= 1) {
			return null;
		}
		int[] newArray = new int[original.length - 1];
		for (int i = 0; i < index; i++) {
			newArray[i] = original[i];
		}
		for (int i = index; i < newArray.length; i++) {
			newArray[i] = original[i + 1];
		}
		return newArray;
	}

	public static void main(String[] args) {
		int[] num = { 3, 3, 0, 0, 2, 3, 2 };
		List<List<Integer>> myLists = permuteUnique(num);
		for (List<Integer> x : myLists) {
			System.out.println(x);
		}
		System.out.println(myLists.size());
	}

}
