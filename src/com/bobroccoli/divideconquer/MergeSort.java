package com.bobroccoli.divideconquer;

public class MergeSort {
	public void mergeSort(int[] array, int left, int right) {
		if (left >= right)
			return;
		int mid = left + (right - left) / 2;
		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);
		merge(array, left, right);
	}

	private void merge(int[] array, int left, int right) {
		int[] temp = new int[array.length];
		int mid = left + (right - left) / 2;
		int l = left, r = mid + 1, index = left;//careful about the index here! 
		while (l < mid + 1 && r <= right) {
			if (array[l] < array[r]) {
				temp[index++] = array[l++];
			} else {
				temp[index++] = array[r++];
			}
		}
		while (l <= mid) {
			temp[index++] = array[l++];
		}
		while (r <= right) {
			temp[index++] = array[r++];
		}
		for(int i = left; i <= right; ++i) {
			array[i] = temp[i];
		}
	}
}
