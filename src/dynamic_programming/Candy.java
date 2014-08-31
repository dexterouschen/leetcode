package dynamic_programming;

/*
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */

public class Candy {
	/**
	* I call it a "pseudo-DP problem". Let integer array "candies[]" representing the
	*  minimum number of candies that satisfies the requirements from the problem. 
	*  Then candies[i + 1] has a following relationship with candies[i]:
	* (1) if ratings[i + 1] > ratings[i], then candies[i + 1] = candies[i] + 1;
	* (2) if ratings[i + 1] == ratings[i], then candies[i + 1] = 1;
	*      (!!! Many people may think candies[i + 1] = candies[i]!!!)
	* (3) if ratings[i + 1] < ratings[i], then it is complicated:
	* You may find a problem that your candies[i] = 3 but there are 4 continues 
	* decreasing neighbors, in which case you don't have enough room to make sure 
	* the minimum in the decreasing array to be '1'.
	* My strategy is as such, assuming ratings[i + 1] < ratings[i] for the first time:
	* (1) find where a decreasing sub-array starts, in this case it's "i + 1"th element in "candies";
	* (2) no matter how long the decreasing sub-array is, set candies[i + 1] = 1;
	* (3) set a start index that marks the beginning of the decreasing sub-array: int start = i;
	* (4) iterate through the entire decreasing sub-array, set candies[i + 1] = candies[i] - 1; i++;
	* (5) while at the last element of the decreasing sub-array, find out the deficit of number of candies.
	*     For example, if candies[i] = -3, then int deficit = 1 - (-3) = 4;
	* (6) go back to the SECOND element in the decreasing sub-array, add deficit as: candies[i] += deficit;
	* (7) the last and also a trick task is to take care of candies[start]. Be careful because we don't 
	* want to overwhelm its value. For example, when candies[start] = 8 and after-adjusted 
	* candies[start + 1] = 6. In this case we don't need candies[start] += deficit.
	*/
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] candies = new int[ratings.length];
		candies[0] = 1;
		for (int i = 1; i < candies.length; i++) {
			if (ratings[i] > ratings[i - 1]) { // condition (1)
				candies[i] = candies[i - 1] + 1;
			} else if (ratings[i] == ratings[i - 1]) { // condition (2)
				candies[i] = 1;
			} else { // condition (3)
				candies[i] = 1;
				int start = i - 1; // indexes of values that need to be adjusted
				while (i + 1 < candies.length && ratings[i + 1] < ratings[i]) {
					candies[i + 1] = candies[i] - 1;
					i++;
				}
				int deficit = 1 - candies[i];
				for (int j = start + 1; j <= i; j++) {
					candies[j] += deficit;
				}
				// take care of the starting element of decreasing sub-array
				candies[start] = candies[start] > candies[start + 1] ? candies[start]
						: candies[start + 1] + 1;
			}
		}
		int ans = 0;
		for (int i = 0; i < candies.length; i++) {
			ans += candies[i];
		}
		return ans;
	}

	public static void main(String[] args) {

	}

}
