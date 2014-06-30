package dynamic_programming;

import java.util.ArrayList;

/*
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */

public class Pascal_Triangle_II {

	public static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (rowIndex < 0) {
			return list;
		}
		if (rowIndex == 0) {
			list.add(1);
			return list;
		}
		if (rowIndex == 1) {
			list.add(1);
			list.add(1);
			return list;
		}
		for (int i = 2; i <= rowIndex + 1; i++) {
			ArrayList<Integer> lowerList = new ArrayList<Integer>();
			lowerList.add(1);
			for (int j = 1; j < list.size(); j++) {
				lowerList.add(list.get(j - 1) + list.get(j));
			}
			lowerList.add(1);
			list = lowerList;
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = getRow(5);
		System.out.println(list);
	}

}
