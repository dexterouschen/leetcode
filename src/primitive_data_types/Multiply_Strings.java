package primitive_data_types;

/*
 Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
 */
public class Multiply_Strings {
	/**
	 * Brutal conversion from 'string' to 'long' doesn't work because the
	 * lengths of strings may overwhelm the limit of long's bit. The correct way
	 * to solve this problem is in fact by following the generic rule of
	 * multiplication that we learned in elementary schools. For string1 *
	 * string2, first use each digit in string2 to multiple string1, then
	 * cascade the results to form a final answer. The tricky part of this
	 * problem is: you have to do all multiplications by strings, not integer or
	 * long.
	 * 
	 * @Reference 
	 *            http://leetcodenotes.wordpress.com/2013/10/20/leetcode-multiply
	 *            -strings-%E5%A4%A7%E6%95%B4%E6%95%B0%E7%9A%84%E5%AD%97%E7%AC%
	 *            A6%E4%B8%B2%E4%B9%98%E6%B3%95/comment-page-1/#comment-122
	 */
	public static String multiply(String num1, String num2) {
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		// The multiplication result of num1 * num2 must have a length no larger
		// than num1.length + num2.length.
		int[] d = new int[num1.length() + num2.length()];
		for (int i = 0; i < num1.length(); i++) {
			int a = num1.charAt(i) - '0';
			for (int j = 0; j < num2.length(); j++) {
				int b = num2.charAt(j) - '0';
				d[i + j] += a * b;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < d.length; i++) {
			int digit = d[i] % 10;
			int carry = d[i] / 10;
			sb.insert(0, digit);
			if (i < d.length - 1)
				d[i + 1] += carry;
		}
		// trim starting zeros
		while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(multiply("5213098162151245", "881619085710243"));
	}

}
