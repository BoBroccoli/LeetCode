package com.bobroccoli.twopointer;

public class SubarrayProductLessThanK713 {
	public static int res = 0;

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		res = 0;
		if (nums == null || nums.length == 0 || k <= 1)
			return res;
		int left = 0, right = 0, product = 1, res = 0;
		while (right < nums.length) {
			product *= nums[right];
			while (product >= k) {
				product /= nums[left];
				++left;
			}
			res += right - left + 1;
			++right;
		}
		return res;
	}
}
