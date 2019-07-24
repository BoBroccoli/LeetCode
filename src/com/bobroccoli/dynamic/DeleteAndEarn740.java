package com.bobroccoli.dynamic;

public class DeleteAndEarn740 {
	public int deleteAndEarn(int[] nums) {
		int n = 10001;
		int[] bucket = new int[n];
		for (int num : nums)
			bucket[num] += num;

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = bucket[0];
		for (int i = 2; i <= n; ++i) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + bucket[i - 1]);
		}
		return dp[n];
	}
}
