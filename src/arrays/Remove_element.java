package arrays;

/*
 Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Remove_element {

	public Remove_element() {
		// TODO Auto-generated constructor stub
	}

	public static int removeElement(int[] A, int elem) {
		int count = 0;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] == elem) {
				count++;
			} else if (count > 0) {
				A[i - count] = A[i];
			}
		}
		return A.length - count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 3, 3 };
		int elem = 3;
		System.out.println(removeElement(A, elem));
	}

}
