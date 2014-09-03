package array_and_linear_structures;

/*
 Given n non-negative integers a1, a2, ..., an, 
 where each represents a point at coordinate (i, ai). 
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 Find two lines, which together with x-axis forms a container, 
 such that the container contains the most water.

 Note: You may not slant the container.
 */

public class Container_With_Most_Water {
	/**
	 * There is an O(n) way to solve this problem: starting from the entire
	 * array, shrink the array but either taking one point off from the head or
	 * taking one point off from the tail. Every time doing such, update the max
	 * area. The tricky part is how to shrink the array, or, should the head or
	 * the tail point being taken off. The rule is: height[head] < height[tail],
	 * take off head; else take off tail. Keep looping until there is nothing
	 * left in this array (head == tail). The max are should then be found.
	 * Detailed proof can be seen at:
	 * http://oj.leetcode.com/discuss/1074/anyone-who-has-a-o-n-algorithm
	 * 
	 * A little update on why should the shorter height being taken away:
	 * Assume there are two height h1 and h2 (h1 comes before h2 and h1 > h2).
	 * If we take away h1, then the newly formed rectangle can not be larger than 
	 * the original one built by (h1, h2). Or to say, area(h1+1, h2) < area(h1, h2);
	 * If we take away h2, then the newly formed rectangle may be larger than the 
	 * original one: area(h1 + 1, h2) may> area(h1, h2).
	 * In other words, if what we are looking for is the maximum, then we should 
	 * move the SHORTER height instead of moving the longer one.
	 */
	public static int maxArea(int[] height) {
		int len = height.length;
		int head = 0, tail = len - 1; // using two indices at head and tail
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
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
