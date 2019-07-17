package com.bobroccoli.binarysearch;

public class SearchforARangeLint61 {
	public int[] searchRange(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) {
				return helper(A, target, mid);
			} else if (A[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return new int[] { -1, -1 };
	}

	private int[] helper(int[] A, int target, int index) {
		int left = 0, right = index - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) {
				right = mid - 1;
			} else
				left = mid + 1;
		}
		int indexL = left;
		left = index + 1;
		right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) {
				left = mid + 1;
			} else
				right = mid - 1;
		}
		int indexR = right;
		return new int[] { indexL, indexR };
	}
}
