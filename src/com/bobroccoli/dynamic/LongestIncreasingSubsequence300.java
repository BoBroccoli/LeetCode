package com.bobroccoli.dynamic;

public class LongestIncreasingSubsequence300 {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = nums.length, res = 1;
		int[] dp = new int[len];
		for (int i = 0; i < len; ++i) {
			dp[i] = 1;
			for (int j = 0; j < i; ++j) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					res = Math.max(res, dp[i]);
				}
			}
		}
		return res;
	}
}
