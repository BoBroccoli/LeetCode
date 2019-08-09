package com.bobroccoli.binarysearch;

public class FindFirstandLastPositionofElementinSortedArray34 {
	public int[] searchRange(int[] nums, int target) {
		int first = findFirst(nums, target);
		int second = findLast(nums, target);
		return new int[] { first, second };
	}

	private int findFirst(int[] nums, int target) {
		int i = 0, j = nums.length - 1, res = -1;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (nums[mid] == target)
				res = mid;
			if (nums[mid] >= target)
				j = mid - 1;
			else
				i = mid + 1;
		}
		return res;
	}

	private int findLast(int[] nums, int target) {
		int i = 0, j = nums.length - 1, res = -1;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (nums[mid] == target)
				res = mid;
			if (nums[mid] <= target)
				i = mid + 1;
			else
				j = mid - 1;
		}
		return res;
	}
}
