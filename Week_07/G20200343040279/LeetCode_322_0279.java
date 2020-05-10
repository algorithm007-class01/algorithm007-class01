/**
 *零钱兑换
 *https://leetcode-cn.com/problems/coin-change/
 *java最优解 14ms
 *
 *
 */
class Solution {
	public int coinChange(int[] coins, int amount) {
		if (amount < 1) return 0;
		int[] dp = new int[amount + 1];
		int sum = 0;

		while (++sum <= amount) {
			int min = -1;
			for (int coin : coins) {
				if (sum >= coin && dp[sum - coin] != -1) {
					int temp = dp[sum - coin] + 1;
					min = min < 0 ? temp :(temp < min ? temp : min);
				}
			}
			dp[sum] = min;
		}
		return dp[amount];
	}
}