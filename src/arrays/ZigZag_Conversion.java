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
