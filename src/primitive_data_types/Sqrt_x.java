package primitive_data_types;

/*
 Implement int sqrt(int x).

 Compute and return the square root of x.
 */

public class Sqrt_x {
	/**
	 * Since the result is in the type of integer, an intuitive solution is to
	 * get by approaching to the result. We can start by base == 0, and
	 * increment it by 1 at each iteration. The tricky part of this problem is
	 * to define proper data types.
	 */
	public static int sqrt(int x) {
		if (x <= 1)
			return x;
		long result = 0, base = 0;
		while (base * base <= (long) x) {
			base++;
		}
		result = base - 1;
		return (int) result;
	}

	public static void main(String[] args) {
		System.out.println(sqrt(122));
		System.out.println(sqrt(2147483647));
	}

}
