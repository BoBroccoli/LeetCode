package com.bobroccoli.substring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
	public String minWindow(String s, String t) {
		if (t == null)
			return "";
		int left = 0, minLeft = 0, minRight = 0, minLength = s.length() + 1, counter = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		}
		for (int right = 0; right < s.length(); right++) {
			if (map.containsKey(s.charAt(right))) {
				map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
				if (map.get(s.charAt(right)) >= 0)
					counter++;
				while (counter == t.length()) {
					if (map.containsKey(s.charAt(left))) {
						if (right - left + 1 < minLength) {
							minLeft = left;
							minRight = right;
							minLength = right - left + 1;
						}
						map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
						if(map.get(s.charAt(left)) > 0)
							counter--;
					}
					left++;
				}
			}
		}
		return minLength <= s.length() ? s.substring(minLeft, minRight + 1) : "";
	}
}