package dynamic_programming;

public class Best_Time_to_Buy_Sell_Stock {

	public static int maxProfit(int[] prices) {
		int len = prices.length;
		if (len <= 0) {
			return 0;
		}
		int profit = 0;
		int max = 0;
		int min = prices[0];
		for (int i = 1; i < len; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else if (prices[i] >= max || prices[i] - min > profit) {
				max = prices[i];
				int diff = max - min;
				if (diff > profit) {
					profit = diff;
				}
			}
		}
		if (profit <= 0) {
			return 0;
		} else {
			return profit;
		}
	}

	public static void main(String[] args) {
		int[] fb = { 2, 6, 4, 1, 7, 9, 8, 5, 1 }; // should return 8;
		int[] fb1 = { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println(maxProfit(fb));
		System.out.println(maxProfit(fb1));
	}

}
