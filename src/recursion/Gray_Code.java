package recursion;

import java.util.ArrayList;

/*
 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */

public class Gray_Code {

	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		for (int i = 0; i < n; i++) {
			int inc = 1 << i;
			for (int j = list.size() - 1; j >= 0; j--) {
				list.add(list.get(j) + inc);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = grayCode(2);
		System.out.println(list);
	}

}
