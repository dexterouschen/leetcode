package arrays;

import java.util.Arrays;

/*
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */

public class Plus_One {

	public static int[] plusOne(int[] digits) {
		int[] array = new int[digits.length + 1];
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			array[i + 1] = (digits[i] + carry) % 10;
			carry = (digits[i] + carry) / 10;
		}
		if (carry == 1) {
			array[0] = 1;
			return array;
		} else {
			return Arrays.copyOfRange(array, 1, array.length);
		}

	}

	public static void main(String[] args) {
		int[] digits = { 9, 8, 9 };
		int[] array = plusOne(digits);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
}
