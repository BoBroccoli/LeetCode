package com.bobroccoli.dynamic;

import java.util.Arrays;

public class CoinChange322 {
	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		for (int i = 0; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i == coins[j])
					dp[i] = 1;
				else {
					if (i - coins[j] > 0)
						dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
