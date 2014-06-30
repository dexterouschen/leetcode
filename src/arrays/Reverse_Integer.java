package arrays;

/*
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 Have you thought about this?
 Here are some good questions to ask before coding.
 Bonus points for you if you have already thought through this!
 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 Did you notice that the reversed integer might overflow?
 Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.
 How should you handle such cases?
 Throw an exception? Good, but what if throwing an exception is not an option?
 You would then have to re-design the function (ie, add an extra parameter).
 */
public class Reverse_Integer {

	public Reverse_Integer() {
		// TODO Auto-generated constructor stub
	}

	public static int reverse(int x) {
		Integer t = x;
		char[] array = t.toString().toCharArray();
		int len = array.length;
		char prefix;
		char[] newArray = new char[len];

		if (array[0] == '-') {
			prefix = array[0];
			for (int i = 0; i < len - 1; i++) {
				newArray[len - i - 1] = array[i + 1];
			}
			newArray[0] = prefix;
		} else {
			for (int i = 0; i < len; i++) {
				newArray[len - i - 1] = array[i];
			}
		}
		String a = new String(newArray);
		int result = Integer.parseInt(a);
		return result;
	}

	public static void main(String[] args) {
		int a = 15102104;
		int b = 95801200;
		int c = -58192;
		System.out.println(reverse(a));
		System.out.println(reverse(b));
		System.out.println(reverse(c));
	}

}
