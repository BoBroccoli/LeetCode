package com.bobroccoli;

public class PerfectSquares279 {
    public int numSquares(int n) {
    	if(n <= 0)
    		return 0;
    	int[] dp = new int[n+1];
    	dp[0] = 0;
    	dp[1] = 1;
    	for(int i = 0; i < n+1; i++) {
    		dp[i] = dp[i-1] + 1;
    		int j = 1;
    		while(j * j <= i) {
    			dp[i] = Math.min(dp[i - j*j] + 1, dp[i]);
    			j++;
    		}
    	}
    	return dp[n];
    }
}
