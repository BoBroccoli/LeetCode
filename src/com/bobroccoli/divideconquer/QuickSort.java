package com.bobroccoli.divideconquer;

public class QuickSort {
	public void quickSort(int[] array, int left, int right) {
		if (left >= right)
			return;
		int pivot = partition(array, left, right);
		quickSort(array, left, pivot - 1);
		quickSort(array, pivot + 1, right);
	}

	private int partition(int[] array, int left, int right) {
		int value = array[left];
		int j = left;
		for (int i = left + 1; i <= right; ++i) {
			if (array[i] < value) {
				++j;
				swap(array, i, j);
			}
		}
		swap(array, left, j);
		return j;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
