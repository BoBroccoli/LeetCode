package com.bobroccoli.partition;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAdresses93 {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12)
			return res;
		helper(res, s, "", 0, 0);
		return res;
	}

	private void helper(List<String> res, String s, String candi, int start, int dots) {
		if (dots > 4)
			return;
		if (dots == 4 && start == candi.length())
			res.add(candi);
		//here remember is start + !!!
		for (int i = start; i < start + 3; ++i) {
			// remember to check boundury before use substring!!!!
			if (i + 1 <= s.length()) {
				String sub = s.substring(start, i + 1);
				if (Integer.parseInt(sub) > 255 || (sub.startsWith("0") && sub.length() > 1))
					continue;
				String newCandi = dots == 3 ? candi + sub : candi + sub + ".";
				helper(res, s, newCandi, i + 1, dots + 1);
			}
		}
	}
}
