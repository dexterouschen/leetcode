package bit_manipulation;

import java.util.ArrayList;
import java.util.Hashtable;

/*
 Given an array of integers, every element appears twice except for one. Find that single one.
 Note:
 Your algorithm should have a linear runtime complexity.
 Could you implement it without using extra memory?
 */

public class Single_Number {

	public Single_Number() {
		// TODO Auto-generated constructor stub
	}

	public static int singleNumber(int[] A) {
		int result = 0;
		int size = A.length;
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			if (!table.contains(A[i])) {
				table.put(A[i], A[i]);
				list.add(A[i]);
			} else {
				list.remove((Integer) A[i]);
			}
		}
		result = list.get(0);
		return result;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 3, 2, 3, 4, 5, 6, 5, 6, 7, 7 };
		System.out.println(singleNumber(A));
	}
}
