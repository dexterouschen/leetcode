package iteration;

/*
 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 */

public class Count_and_Say {
	/**
	 * The problem statement is vague even it gives out example input and output. 
	 * So I put some explanations below the examples so you understand it better. 
	 * To find out countAndSay(n), one needs to compute countAndSay(n - 1). To 
	 * find out countAndSay(n - 1), one needs to compute countAndSay(n - 2)... 
	 * So this problem can be iterative from countAndSay(1) to countAndSay(n).
	 *  
	 * If you still have any question regarding to question statement as well as the algorithm,
	 * here is the reference: http://blog.csdn.net/fightforyourdream/article/details/12901505
	 */
	public static String countAndSay(int n) {
		n = n - 1;
		if (n == 0) {
			return "1";
		}
		StringBuffer buffer = new StringBuffer();
		String str = "1";
		int curNumber = 1;
		while (curNumber <= n) {
			buffer.delete(0, buffer.length());
			int count = 1;
			int i = 1;
			for (i = 1; i < str.length(); i++) {
				if (str.charAt(i - 1) == str.charAt(i)) {
					count++;
				} else {
					buffer.append(count).append(str.charAt(i - 1));
					count = 1;
				}
			}
			buffer.append(count).append(str.charAt(i - 1));
			str = buffer.toString();
			curNumber++;
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(0)); // should be 1
		System.out.println(countAndSay(1)); // should be 11
		System.out.println(countAndSay(2)); // should be 21
		System.out.println(countAndSay(3)); // should be 1211
		System.out.println(countAndSay(4)); // should be 111221
		System.out.println(countAndSay(5)); // should be 312211
		System.out.println(countAndSay(6)); // should be 13112221
		System.out.println(countAndSay(7)); // should be 1113213211
	}

}
