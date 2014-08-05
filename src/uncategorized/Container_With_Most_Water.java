package uncategorized;

public class Container_With_Most_Water {

	/*
	 * There is an O(n) way to solve this problem: starting from the entire
	 * array, shrink the array by either taking one point off from the head or
	 * taking one point off from the tail. Every time doing such, update the max
	 * area. The tricky part is how to shrink the array, or, should the head or
	 * the tail point being taken off. The rule is: height[head] < height[tail],
	 * take off head; else take off tail. Keep looping until there is nothing
	 * left in this array (head == tail). The max are should then be found.
	 * Detailed proof can be seen at:
	 * http://oj.leetcode.com/discuss/1074/anyone-who-has-a-o-n-algorithm
	 */
	public static int maxArea(int[] height) {
		int len = height.length;
		int head = 0, tail = len - 1; // using two indices at head and tail
		int maxArea = 0;
		while (head < tail) {
			maxArea = Math.max(maxArea, (tail - head) * Math.min(height[head], height[tail]));
			if (height[head] < height[tail]) {
				head++;
			} else {
				tail--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] height = { 1, 2, 3, 2, 4, 5, 2, 1 };
		System.out.println(maxArea(height)); // should be 10
	}

}
