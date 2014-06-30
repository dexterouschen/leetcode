package arrays;

/*
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */

public class Plus_One {

	public static int[] plusOne(int[] digits) {
		int carry = 0, i = digits.length - 1;
		digits[i] += 1;
		while (digits[i] >= 10) {
			digits[i] = 0;
			i--;
			if (i >= 0)
				digits[i] += 1;
			else {
				carry = 1;
				break;
			}
		}
		if (carry == 0)
			return digits;
		int[] res = new int[digits.length + 1];
		for (i = 0; i < digits.length; i++) {
			res[i + 1] = digits[i];
		}
		res[0] = 1;
		return res;
	}

	public static void main(String[] args) {
		int[] digits = { 9, 8, 9 };
		int[] array = plusOne(digits);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
}
