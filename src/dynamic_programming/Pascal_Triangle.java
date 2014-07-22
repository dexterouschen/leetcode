package dynamic_programming;

import java.util.ArrayList;

/*
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 */
public class Pascal_Triangle {

	/*
	 * DP solution. Build solution from top to bottom.
	 */
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0) {
			return lists;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		lists.add(list);
		for (int i = 2; i <= numRows; i++) {
			ArrayList<Integer> curList = new ArrayList<>();
			curList.add(1);
			ArrayList<Integer> prevList = lists.get(lists.size() - 1);
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
