package dynamic_programming;

import java.util.*;

/*
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 */
public class Pascal_Triangle {
	/**
	 * DP approach. Build solution from top to bottom.
	 */
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lists = new ArrayList<>();
		if (numRows <= 0) {
			return lists;
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		lists.add(list);
		for (int i = 2; i <= numRows; i++) {
			List<Integer> curList = new ArrayList<>();
			curList.add(1);
			List<Integer> prevList = lists.get(lists.size() - 1);
			for (int j = 1; j < prevList.size(); j++) {
				curList.add(prevList.get(j) + prevList.get(j - 1));
			}
			curList.add(1);
			lists.add(curList);
		}
		return lists;
	}

	public static void main(String[] args) {
		System.out.println(generate(0));

	}

}
