package com.bobroccoli.twopointer;

public class MinimumSizeSubarraySum209 {
	public int minSubArrayLen(int s, int[] nums) {
		int res = Integer.MAX_VALUE, left = 0, right = 0, curSum = 0;
		while (right < nums.length) {
			curSum += nums[right];
			while (curSum >= s) {
				res = Math.min(res, right - left + 1);
				curSum -= nums[left++];
			}
			++right;
		}
		if (res == Integer.MAX_VALUE)
			return 0;
		return res;
	}
}
