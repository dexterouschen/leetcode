package arrays;

import java.util.Arrays;

/*
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */

public class Plus_One {
	/*
	 * Be careful when new array is one digit longer than original array.
	 */
	public static int[] plusOne(int[] digits) {
		int[] A = new int[digits.length + 1];
		int carry = 1, index = digits.length - 1;
		while (carry == 1 && index >= 0) {
			A[index + 1] = digits[index] + carry == 10 ? 0 : digits[index] + 1;
			carry = digits[index] + 1 == 10 ? 1 : 0;
			index--;
		}
		if (index < 0) {
			A[0] = 1;
			return A;
		} else {
			for (int i = index; i >= 0; i--) {
				A[index + 1] = digits[i];
			}
			return Arrays.copyOfRange(A, 1, A.length);
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
