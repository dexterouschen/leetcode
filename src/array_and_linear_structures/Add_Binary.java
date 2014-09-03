package array_and_linear_structures;

/*
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */

public class Add_Binary {
	/**
	 * Similar to "Plus One", we need to reserve enough space for the new string, 
	 * i.e. "11" + "11" = "110".
	 */
	public static String addBinary(String a, String b) {
		if (a.length() == 0) {
			return b;
		}
		if (b.length() == 0) {
			return a;
		}
		StringBuilder sb = new StringBuilder();
		int carry = 0, index = 0;
		while (a.length() - 1 - index >= 0 && b.length() - 1 - index >= 0) {
			int ai = a.charAt(a.length() - 1 - index) == '1' ? 1 : 0;
			int bi = b.charAt(b.length() - 1 - index) == '1' ? 1 : 0;
			sb.append((ai + bi + carry) % 2);
			carry = (ai + bi + carry) / 2;
			index++;
		}
		if (a.length() - 1 - index < 0) { // if b has some left
			while (b.length() - 1 - index >= 0) {
				int bi = b.charAt(b.length() - 1 - index) == '1' ? 1 : 0;
				sb.append((bi + carry) % 2);
				carry = (bi + carry) / 2;
				index++;
			}
		} else { // if a has some left
			while (a.length() - 1 - index >= 0) {
				int ai = a.charAt(a.length() - 1 - index) == '1' ? 1 : 0;
				sb.append((ai + carry) % 2);
				carry = (ai + carry) / 2;
				index++;
			}
		}
		if (carry == 1) { // if carry is left '1'
			sb.append(1);
		}
		// reverse sb
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String a = "11", b = "1";
		System.out.println(addBinary(a, b));
	}

}
