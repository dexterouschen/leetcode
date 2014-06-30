package arrays;

import java.util.ArrayList;

/*
 Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.
 */

public class Integer_to_roman {

	public Integer_to_roman() {
		// TODO Auto-generated constructor stub
	}

	public static String intToRoman(int num) {
		ArrayList<Character> list = new ArrayList<Character>();

		while ((int) num / 1000 > 0) {
			num -= 1000;
			list.add('M');
		}
		while ((int) num / 500 > 0) {
			num -= 500;
			list.add('D');
		}
		while ((int) num / 100 > 0) {
			num -= 100;
			list.add('C');
		}
		while ((int) num / 50 > 0) {
			num -= 50;
			list.add('L');
		}
		while ((int) num / 10 > 0) {
			num -= 10;
			list.add('X');
		}
		while ((int) num / 5 > 0) {
			num -= 5;
			list.add('V');
		}
		while ((int) num / 1 > 0) {
			num -= 1;
			list.add('I');
		}

		// check if any char appears 4 times

		System.out.println(list);

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(2014));
		System.out.println(intToRoman(1999));
	}

}
