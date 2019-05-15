package com.bobroccoli;

public class MaximumProductSubarray152 {
	public int maxProduct(int[] nums) {
		if (nums.length == 0)
			return 0;
		int res = nums[0];
		int maxCur = nums[0];
		int minCur = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < 0) {
				/*
				 * The swap function doesn't work!!!!
				 * For primitive objects, Java pass by
				 * value, make copy in stack.
				 * */
				int temp = maxCur;
				maxCur = minCur;
				minCur = temp;
			}
			maxCur = Math.max(nums[i], maxCur * nums[i]);
			minCur = Math.min(nums[i], minCur * nums[i]);
			res = Math.max(maxCur, res);
		}
		return res;
	}
}
