package arrays;

/*
 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
 to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 */

public class Gas_Station {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0 || cost == null || cost.length == 0
				|| gas.length != cost.length) {
			return -1;
		}
		int len = gas.length;
		for (int i = 0; i < len; i++) { // starting at station i
			if (runAround(gas, cost, i)) {
				return i;
			}
		}
		return -1;
	}

	public static boolean runAround(int[] gas, int[] cost, int index) {
		int len = gas.length, remain = 0;
		for (int i = index; i < len; i++) {
			remain += gas[i] - cost[i];
			if (remain < 0) {
				return false;
			}
		}
		for (int i = 0; i <= index - 1; i++) {
			remain += gas[i] - cost[i];
			if (remain < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] gas = { 2, 4 }, cost = { 3, 4 };
		System.out.println(canCompleteCircuit(gas, cost));
	}

}
