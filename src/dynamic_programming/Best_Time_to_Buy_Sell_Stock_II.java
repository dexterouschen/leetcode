package dynamic_programming;

import java.util.ArrayList;

/*
 Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).
 */

public class Best_Time_to_Buy_Sell_Stock_II {

	/*
	 * the general strategy: buy when the next day is higher; sell when the next
	 * day is lower; hold if enum is hold and next day is higher;
	 */
	public enum State {
		HOLD, EMPTY
	}

	public static int maxProfit(int[] prices) {
		State state = State.EMPTY;
		int len = prices.length;
		int profit = 0;
		int cost = 0;
		int gain = 0;

		if (len < 2) {
			return 0;
		}
		int lastBuy = 0;
		for (int i = 0; i < len - 1; i++) {
			if (prices[i] < prices[i + 1] && state == State.EMPTY) { // buy
				state = State.HOLD;
				cost = prices[i];
				lastBuy = i;
			} else if (prices[i] > prices[i + 1] && state == State.HOLD) { // sell
				state = State.EMPTY;
				gain = prices[i];
				profit += gain - cost;
			}
		}
		// check the last day
		if (prices[len - 1] > prices[lastBuy] && state == State.HOLD) {
			profit += prices[len - 1] - prices[lastBuy];
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] fb = { 5612, 5731, 5721, 5709, 5809, 6014, 6483, 6402, 5982,
				5872, 5532, 5587 };
		// correct answer should be 948
		int[] fb1 = { 1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9 };
		System.out.println(maxProfit(fb));
	}

}
