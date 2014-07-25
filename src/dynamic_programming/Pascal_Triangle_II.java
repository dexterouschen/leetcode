package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/*
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */

public class Pascal_Triangle_II {

	// public static ArrayList<Integer> getRow(int rowIndex) {
	// ArrayList<Integer> list = new ArrayList<Integer>();
	// if (rowIndex < 0) {
	// return list;
	// }
	// if (rowIndex == 0) {
	// list.add(1);
	// return list;
	// }
	// if (rowIndex == 1) {
	// list.add(1);
	// list.add(1);
	// return list;
	// }
	// for (int i = 2; i <= rowIndex + 1; i++) {
	// ArrayList<Integer> lowerList = new ArrayList<Integer>();
	// lowerList.add(1);
	// for (int j = 1; j < list.size(); j++) {
	// lowerList.add(list.get(j - 1) + list.get(j));
	// }
	// lowerList.add(1);
	// list = lowerList;
	// }
	// return list;
	// }
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		if (rowIndex == 0) {
			return list;
		}
		list.add(1);
		if (rowIndex == 1) {
			return list;
		}
		int level = 1;
		while (level < rowIndex) {
			for (int i = 0; i < list.size() - 1; i++) {
				list.set(i, list.get(i) + list.get(i + 1));
			}
			list.add(0, 1);
			level++;
		}
		return list;
	}

	public static void main(String[] args) {
		List<Integer> list = getRow(4);
		System.out.println(list);
	}

}
