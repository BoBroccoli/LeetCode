package com.bobroccoli;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {
	public boolean isHappy(int n) {
		Set<Integer> seen = new HashSet<Integer>();
		while(true) {
			n = cal(n);
			if(n == 1)
				return true;
			else if (seen.contains(n)) {
				return false;
			}
			else {
				seen.add(n);
			}
		}
	}

	private int cal(int n) {
		int res = 0;
		while(n > 0) {
			res += (n%10) * (n%10);
			n = n/10;
		}
		return res;
	}
}
