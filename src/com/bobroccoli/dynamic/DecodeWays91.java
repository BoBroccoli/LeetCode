package com.bobroccoli.dynamic;

public class DecodeWays91 {
	public int numDecodings(String s) {
		if (s == null)
			return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		for (int i = 1; i <= s.length(); i++) {
			if (i == 1) {
				if (s.charAt(i - 1) - '0' > 0 && s.charAt(i - 1) - '0' <= 9)
					dp[i] = 1;
				else {
					dp[i] = 0;
					dp[i - 1] = 0;
				}
			} else {
				if (s.charAt(i - 2) == 0) {
					dp[i] = 0;
					continue;
				}
				if (s.charAt(i - 1) - '0' > 0 && s.charAt(i - 1) - '0' <= 9)
					dp[i] += dp[i - 1];
				StringBuilder sb = new StringBuilder();
				sb.append(s.charAt(i - 2));
				sb.append(s.charAt(i - 1));
				if (Integer.parseInt(sb.toString()) >= 10 && Integer.parseInt(sb.toString()) <= 26)
					dp[i] += dp[i - 2];
			}
			// System.out.println(dp[i]);
		}
		return dp[s.length()];
	}
}
