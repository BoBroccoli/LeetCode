package com.bobroccoli.dynamic;

public class ArithmeticSlices413 {
	public int numberOfArithmeticSlices(int[] A) {
		if (A == null || A.length < 3)
			return 0;
		int[] dp = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (i == 0 || i == 1)
				dp[i] = 0;
			else {
				int j = i;
				int valid = 0;
				while (j > 1) {
					if (A[j] - A[j - 1] == A[j - 1] - A[j - 2])
						valid++;
					else
						break;
					j--;
				}
				dp[i] = dp[i - 1] + valid;
			}
		}
		return dp[dp.length - 1];
	}
}
