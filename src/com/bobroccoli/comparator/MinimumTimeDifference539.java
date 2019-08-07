package com.bobroccoli.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumTimeDifference539 {
	public int findMinDifference(List<String> timePoints) {
		Collections.sort(timePoints, new Comparator<String>() {
			public int compare(String a, String b) {
				for (int i = 0; i < a.length(); ++i) {
					char ca = a.charAt(i), cb = b.charAt(i);
					if (ca != cb)
						return ca - cb;
				}
				return 0;
			}
		});
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < timePoints.size(); ++i) {
			int first = toInt(timePoints.get(i - 1));
			int second = toInt(timePoints.get(i));
			min = Math.min(second - first, min);
		}
		return Math.min(min, 24 * 60 - toInt(timePoints.get(timePoints.size() - 1)) + toInt(timePoints.get(0)));
	}

	private int toInt(String s) {
		int res = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
		return res;
	}
}
