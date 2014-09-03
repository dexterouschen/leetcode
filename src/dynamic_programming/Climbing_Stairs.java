package dynamic_programming;

/*
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps.
 In how many distinct ways can you climb to the top?
 */
public class Climbing_Stairs {
	/**
	 * DP: waysOfClimb[i] = waysOfClimb[i - 1] + waysOfClimb[i -2]
	 */
	public static int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int[] step = new int[n + 1];
		step[1] = 1;
		step[2] = 2;
		for (int i = 3; i <= n; i++) {
			step[i] = step[i - 1] + step[i - 2];
		}
		return step[n];
	}

	// Memorization:
	public static int climbStairsMemor(int n, int[] map) {
		if (map[n] != -1) {
			return map[n];
		}
		if (n <= 2) {
			map[n] = n;
		} else {
			map[n] = climbStairsMemor(n - 1, map) + climbStairsMemor(n - 2, map);
		}
		return map[n];
	}

	public static void main(String[] args) {
		int n = 6;
		System.out.println(climbStairs(n));
		int[] map = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			map[i] = -1;
		}
		System.out.println(climbStairsMemor(n, map));
	}
}
