package dynamic_programming;

/*
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps.
 In how many distinct ways can you climb to the top?
 */
public class Climbing_Stairs {

	public Climbing_Stairs() {
		// TODO Auto-generated constructor stub
	}

	public int climbStairs(int n) {
		int[] dpMap = new int[n + 1];
		if (n <= 2) {
			return n;
		}
		return climbStairsDP(n, dpMap);
		// return climbStairsMemor(n, dpMap);
	}

	// Dynamic programming
	public static int climbStairsDP(int n, int[] dpMap) {
		for (int i = 0; i <= 2; i++) {
			dpMap[i] = i;
		}
		for (int i = 3; i < n + 1; i++) {
			dpMap[i] = dpMap[i - 1] + dpMap[i - 2];
		}
		return dpMap[n];
	}

	// Memorization:
	public static int climbStairsMemor(int n, int[] map) {
		if (map[n] != -1) {
			return map[n];
		}
		if (n <= 2) {
			map[n] = n;
		} else {
			map[n] = climbStairsMemor(n - 1, map)
					+ climbStairsMemor(n - 2, map);
		}
		return map[n];
	}

	public static void main(String[] args) {
		int n = 6;

		int[] dpMap = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			dpMap[i] = -1;
		}
		System.out.println(climbStairsDP(n, dpMap));

		int[] map = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			map[i] = -1;
		}
		System.out.println(climbStairsMemor(n, map));
	}
}
