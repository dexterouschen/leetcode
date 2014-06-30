package arrays;

/*
 Determine whether an integer is a palindrome. Do this without extra space. 
 */

public class Palindrome_Number {

	public static boolean isPalindrome(int x) {
		// find the digit of the index
		if (x < 0) {
			return false;
		}
		long newX = x;
		long digit = 0, base = 1;
		while (newX / base > 0) {
			base *= 10;
			digit++;
		}
		long left = digit - 1, right = 0;
		while (left >= right) {
			if (getValueAt(newX, left) != getValueAt(newX, right)) {
				return false;
			}
			left--;
			right++;
		}
		return true;
	}

	public static int getValueAt(long x, long index) {
		int val = 0;
		val = (int) (x / Math.pow(10, index)) % 10;
		return val;
	}

	public static void main(String[] args) {
		// System.out.println(isPalindrome(-2147483648));
		// System.out.println(isPalindrome(1021201));
		// System.out.println(isPalindrome(1011));
		System.out.println(isPalindrome(1410110141));
	}

}
