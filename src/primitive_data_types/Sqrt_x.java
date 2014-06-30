package primitive_data_types;

/*
 Implement int sqrt(int x).

 Compute and return the square root of x.
 */

public class Sqrt_x {

	public static int sqrt(int x) {
		if (x <= 1)
			return x;
		long result = 0;
		long base = 0;
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
