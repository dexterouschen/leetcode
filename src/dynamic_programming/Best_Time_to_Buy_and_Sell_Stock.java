package dynamic_programming;

/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction
 (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.
 */

public class Best_Time_to_Buy_and_Sell_Stock {
	/**
	 * 1D DP problem. Assume max[i] is the maximum profit for prices[0...i],
	 * max[i+1] must be Math.max(max[i], prices[i+1] - "smallest value in prices[0..i]").
	 */
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int[] max = new int[prices.length];
		max[0] = 0;
		int curMin = prices[0];
		for (int i = 1; i < prices.length; i++) {
			curMin = Math.min(curMin, prices[i]);
			max[i] = Math.max(max[i - 1], prices[i] - curMin);
		}
		return max[prices.length - 1];
	}

	public static void main(String[] args) {
		int[] fb = { 2, 6, 4, 1, 7, 9, 8, 5, 1 }; // should return 8;
		int[] fb1 = { 3, 3, 5, 0, 0, 3, 1, 4 }; // should return 4
		System.out.println(maxProfit(fb));
		System.out.println(maxProfit(fb1));
	}

}
