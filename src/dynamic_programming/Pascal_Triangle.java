package dynamic_programming;

import java.util.ArrayList;

/*
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 */
public class Pascal_Triangle {

	public Pascal_Triangle() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<ArrayList<Integer>> generate(int numRows) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0) {
			return list;
		}
		// base cases
		ArrayList<Integer> level0 = new ArrayList<Integer>();
		level0.add(1);
		list.add(level0);
		if (numRows == 1) {
			return list;
		}
		ArrayList<Integer> level1 = new ArrayList<Integer>();
		level1.add(1);
		level1.add(1);
		list.add(level1);
		if (numRows == 2) {
			return list;
		}

		for (int i = 2; i < numRows; i++) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			level.add(1);
			int count = 0;
			while (count < i - 1) {
				count++;
				level.add(list.get(i - 1).get(count - 1)
						+ list.get(i - 1).get(count));
			}
			level.add(1);
			list.add(level);
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(generate(0));

	}

}
