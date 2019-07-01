package com.bobroccoli.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpentheLock752 {
	public int openLock(String[] deadends, String target) {
		int res = 0;
		Set<String> visited = new HashSet<String>();
		for (String s : deadends)
			visited.add(s);
		if (visited.contains("0000"))
			return -1;
		Queue<String> queue = new LinkedList<String>();
		queue.offer("0000");
		visited.add("0000");
		while (!queue.isEmpty()) {
			int size = queue.size();
			++res;
			for (int j = 0; j < size; ++j) {
				String top = queue.poll();
				for (int i = 0; i < 4; ++i) {
					String up = top.substring(0, i) + ((top.charAt(i) - '0' + 1) % 10) + top.substring(i + 1, 4);
					if (!visited.contains(up)) {
						queue.offer(up);
						visited.add(up);
					}
					String down = top.substring(0, i) + ((top.charAt(i) - '0' - 1 + 10) % 10) + top.substring(i + 1, 4);
					if (!visited.contains(down)) {
						queue.offer(down);
						visited.add(down);
					}
					if (visited.contains(target))
						return res;
				}
			}
		}
		return -1;
	}
}
