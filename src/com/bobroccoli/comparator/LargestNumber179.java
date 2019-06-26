package com.bobroccoli.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber179 {
	public String largestNumber(int[] nums) {
		List<String> list = new ArrayList<String>();
		for (int i : nums) {
			list.add(i + "");
		}
		Collections.sort(list, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);//Desending order
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}
		if (sb.charAt(0) == '0')
			return "0";
		return sb.toString();
	}
}
