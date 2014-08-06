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
