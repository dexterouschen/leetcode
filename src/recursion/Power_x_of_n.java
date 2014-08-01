package recursion;

/*
 Implement pow(x, n).
 */

public class Power_x_of_n {
	/*
	 * Use recursion to reduce complexity from O(n) to O(log n).
	 */
	public static double power(double x, int n) {
		if (n == 0)
			return 1;
		double val = power(x, n / 2);
		if (n % 2 == 0) {
			return val * val;
		} else {
			return val * val * x;
		}
	}

	public static double pow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}

	public static void main(String[] args) {
		System.out.println(pow(1.23, 2));

	}

}
