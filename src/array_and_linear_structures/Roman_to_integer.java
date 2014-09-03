package array_and_linear_structures;

/*
 Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */

public class Roman_to_integer {

	public static int romanToInt(String s) {
		int len = s.length();
		if (len < 0)
			return -1;
		int ans = 0;
		for (int i = 0; i < len - 1; i++) {
			if (findInt(s.charAt(i)) < findInt(s.charAt(i + 1))) {
				ans -= findInt(s.charAt(i));
			} else {
				ans += findInt(s.charAt(i));
			}
		}
		ans += findInt(s.charAt(len - 1));
		return ans;
	}

	public static int findInt(char s) {
		if (s == 'I') {
			return 1;
		}
		if (s == 'V') {
			return 5;
		}
		if (s == 'X') {
			return 10;
		}
		if (s == 'L') {
			return 50;
		}
		if (s == 'C') {
			return 100;
		}
		if (s == 'D') {
			return 500;
		}
		if (s == 'M') {
			return 1000;
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("MMXIV"));
	}
}
