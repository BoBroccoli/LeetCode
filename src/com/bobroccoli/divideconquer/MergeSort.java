package com.bobroccoli.divideconquer;

import java.util.Arrays;

public class MergeSort {
	public void mergeSort(int[] arr, int l, int r) {
		if(l >= r)
			return;
		int mid = l+(r-l)/2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid+1, r);
		merge(arr, l, r);
	}

	private void merge(int[] arr, int l, int r) {
		int[] temp = new int[arr.length];
		int mid = l+(r-l)/2;
		int left = l, right = mid+1;
		int index = l;
		while(left <= mid && right <= r) {
			temp[index++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
		}
		while (left <= mid) {
			temp[index++] = arr[left++];
		}
		while (right <= r) {
			temp[index++] = arr[right++];
		}
		for(int i = l; i <= r; ++i) {
			arr[i] = temp[i];
		}
	}
}
