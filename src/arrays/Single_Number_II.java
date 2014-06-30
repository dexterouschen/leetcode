package arrays;

/*
 Given an array of integers, every element appears three times except for one.
 Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity.
 Could you implement it without using extra memory?
 */
public class Single_Number_II {

	public Single_Number_II() {
		// TODO Auto-generated constructor stub
	}

	public static int singleNumber(int[] A) {
		if (A == null)
			return 0;
		int x0 = ~0, x1 = 0, x2 = 0, t;
		for (int i = 0; i < A.length; i++) {
			t = x2;
			x2 = (x1 & A[i]) | (x2 & ~A[i]);
			x1 = (x0 & A[i]) | (x1 & ~A[i]);
			x0 = (t & A[i]) | (x0 & ~A[i]);
		}
		return x1;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4 };
		System.out.println(singleNumber(A));
	}

}
