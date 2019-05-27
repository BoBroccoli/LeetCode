package com.bobroccoli;

public class GrumpyBookstoreOwner1052 {
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int base = 0, window = 0, maxwindow = 0;
		for(int i = 0; i < customers.length; i++) {
			base += grumpy[i] == 0 ? customers[i] : 0;
			window += grumpy[i] == 1 ? customers[i] : 0;
			if(i >= X) {
				window -= grumpy[i - X] == 1 ? customers[i - X] : 0;
			}
			maxwindow = Math.max(window, maxwindow);
		}
		return base+maxwindow;
	}
}
