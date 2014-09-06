package bit_manipulation;

public class Divide_Two_Integers {
	/**
	 * Intuitively, it is easy to come up with an O(n) solution in which divisor is taken off in every iteration.
	 * However, division in this problem can achieve better  performance by manipulating bits.
	 * All integers can be represented as the linear combination of a series of 2's exponential. 
	 * In this case, we can shift the bits towards left to find the maximum base. Then, iterate the integer 
	 * towards right (extraction of root "2") until the base becomes "0". Time complexity: O(logn).
	 * 
	 *  Be careful with the overflow of the primitive "int" in Java. 
	 *  
	 *  Reference: http://blog.csdn.net/linhuanmars/article/details/20024907
	 */
	public static int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		int res = 0;
		if (dividend == Integer.MIN_VALUE) {
			res = 1;
			dividend += Math.abs(divisor);
		}
		if (divisor == Integer.MIN_VALUE)
			return res;
		boolean isNeg = ((dividend ^ divisor) >>> 31 == 1) ? true : false;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int digit = 0;
		while (divisor <= (dividend >> 1)) {
			divisor <<= 1;
			digit++;
		}
		while (digit >= 0) {
			if (dividend >= divisor) {
				dividend -= divisor;
				res += 1 << digit;
			}
			divisor >>= 1;
			digit--;
		}
		return isNeg ? -res : res;
	}

	public static void main(String[] args) {
		System.out.println(divide(2147483647, 1));
	}

}
