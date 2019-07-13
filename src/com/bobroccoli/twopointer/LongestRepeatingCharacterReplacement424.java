package com.bobroccoli.substring;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement424 {
	public int characterReplacement(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int res = 0, left = 0, majorCount = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int right = 0; right < s.length(); right++) {
			Character cur = s.charAt(right);
			map.put(cur, map.getOrDefault(cur, 0) + 1);
			majorCount = majorCount > map.get(cur) ? majorCount : map.get(cur);
			if (right - left + 1 - majorCount > k) {
				Character charLeft = s.charAt(left);
				map.put(charLeft, map.get(charLeft) - 1);
				if (map.get(charLeft) == 0)
					map.remove(charLeft);
				left++;
			}
			res = Math.max(res, right - left + 1);
		}
		return res;
	}
}
