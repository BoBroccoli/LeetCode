package com.bobroccoli.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets983 {
	public int mincostTickets(int[] days, int[] costs) {
		if (days.length == 0)
			return 0;
		int[] dp = new int[days[days.length - 1] + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Set<Integer> set = new HashSet<Integer>();
		for (int i : days)
			set.add(i);
		dp[days[0] - 1] = 0;
		for (int i = days[0]; i < dp.length; i++) {
			if (set.contains(i)) {
				dp[i] = dp[i - 1] + costs[0];
				if (i - 7 < days[0])
					dp[i] = Math.min(dp[i], costs[1]);
				else
					dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
				if (i - 30 < days[0])
					dp[i] = Math.min(dp[i], costs[2]);
				else
					dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);
			} else
				dp[i] = dp[i - 1];
		}
		return dp[days[days.length - 1]];
	}
}
