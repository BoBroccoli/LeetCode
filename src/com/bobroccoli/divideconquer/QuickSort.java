package com.bobroccoli.divideconquer;

public class QuickSort {
	public void quickSort(int[] arr, int l, int r) {
		if(l >= r)
			return;
		int partition = partition(arr, l , r);
		quickSort(arr, l, partition-1);
		quickSort(arr, partition+1, r);
	}

	private int partition(int[] arr, int l, int r) {
		int left = l, right = r-1;
		int pivot = arr[r];
		while(left < right) {
			while(left < right && arr[left] < pivot) {
				++left;
			}
			while (right > left && arr[right] > pivot) {
				--right;
			}
			if (left>=right) {
				break;
			}
			else {
				swap(left, right, arr);
				++left;
				--right;
			}
		}
		swap(left, r, arr);
		return left;
	}

	private void swap(int left, int right, int[] arr) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
