package arrays;

/*
 Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Remove_element {

	public static int removeElement(int[] A, int elem) {
        int count = 0;
        for (int i = 0; i < A.length; i++){
            if(A[i] == elem){
                count++;
            }else{
                A[i-count] = A[i];
            }
        }
		return A.length - count;
	}

	public static void main(String[] args) {
		int[] A = { 3, 3 };
		int elem = 3;
		System.out.println(removeElement(A, elem));
	}

}
