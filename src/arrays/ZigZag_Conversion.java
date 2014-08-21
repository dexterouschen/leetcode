package arrays;

import java.util.ArrayList;

/*
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

public class ZigZag_Conversion {
	/**
	 * Algorithm:
	 * 
	 * Maintain down boolean which tells whether you are going up or down in zig
	 * zag order.
	 * 
	 * As soon as rows = 0 means you need to go down now and as soon as rows =
	 * nRows - 1 you need to go up now
	 * 
	 * Just keep on doing this until whole string is exhausted
	 * 
	 * Using StringBuilder list/array to store elements in zig zag order and in
	 * the end just append all characters from each StringBuilder to return
	 * output.
	 */
	public static String convert(String s, int nRows) {
		if (s == null || s.length() <= 1 || nRows <= 1) {
			return s;
		}
		ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
		for (int i = 0; i < nRows; i++) {
			list.add(new StringBuilder());
		}
		int i = 0;
		boolean down = false;
		int row = 0;
		while (i < s.length()) {
			list.get(row).append(s.charAt(i));
			if (row == 0) {
				down = true;
			} else if (row == nRows - 1) {
				down = false;
			}
			if (down) {
				row++;
			} else {
				row--;
			}
			i++;
		}
		i = 0;
		StringBuilder output = new StringBuilder();
		while (i < list.size()) {
			output.append(list.get(i).toString());
			i++;
		}
		return output.toString();
	}

	public static void main(String[] args) {
		// should return "PAHNAPLSIIGYIR"
		System.out.println(convert("PAYPALISHIRING", 3));
	}

}
