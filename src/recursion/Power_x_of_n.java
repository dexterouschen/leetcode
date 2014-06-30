package recursion;

/*
 Implement pow(x, n).
 */

public class Power_x_of_n {

	public static double pow(double x, int n) {
		if (n == 0)
			return 1.;
		if (x == 0.)
			return 0.;
		if (n < 0) {
			n = -n;
			x = 1. / x;
		}
		double temp = pow(x, n / 2);
		return n % 2 == 0 ? temp * temp : temp * temp * x;
	}

	public static void main(String[] args) {
		System.out.println(pow(1.23, 2));

	}

}
